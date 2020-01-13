package com.yyl.one.design.iterator;

/**
 * author:yangyuanliang Date:2020-01-10 Time:16:50
 **/
public class ConcreteAggregate implements Aggregate {

    private Integer[] items;
    public ConcreteAggregate() {
        items = new Integer[10];
        for (int i = 0; i < items.length; i++) {
            items[i] = i;
        }
    }
    @Override
    public Iterator createInterator() {
        return new ConcreteIterator<Integer>(items);
    }
}
