package com.yyl.one.current;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        /*AtomicInteger atomicInteger=new AtomicInteger();
        atomicInteger.incrementAndGet();
        atomicInteger.set(2222);
        boolean b = atomicInteger.compareAndSet(2222, 2);
        System.out.println(b);
        int i = atomicInteger.get();
        System.out.println(i);*/
        BigDecimal bigDecimal=new BigDecimal( 3.184545445);


        System.out.println( bigDecimal.setScale(8,BigDecimal.ROUND_HALF_DOWN).
                setScale(2,BigDecimal.ROUND_DOWN));
    }
}
