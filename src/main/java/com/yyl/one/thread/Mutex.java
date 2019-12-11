package com.yyl.one.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * author:yangyuanliang Date:2019-12-11 Time:19:47
 **/
public class Mutex implements Lock {
    private final Sync sync=new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        sync.tryAcquireNanos(1,unit.toNanos(time));
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    private static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            if(super.compareAndSetState(0,1)){
                super.setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        @Override
        protected boolean isHeldExclusively() {
            return super.getState() == 1;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
        @Override
        protected boolean tryRelease(int arg) {
            if(super.getState()==0){
                throw new IllegalMonitorStateException();

            }
            super.setExclusiveOwnerThread(null);
            super.setState(0);
            return true;
        }
    }
}
