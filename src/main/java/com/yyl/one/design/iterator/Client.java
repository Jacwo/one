package com.yyl.one.design.iterator;

/**
 * author:yangyuanliang Date:2020-01-10 Time:16:53
 **/
public class Client {
    public static void main(String[] args) {
        Aggregate aggregate=new ConcreteAggregate();
        Iterator<Integer> iterator=aggregate.createInterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
