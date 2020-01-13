package com.yyl.one.design.iterator;

/**
 * author:yangyuanliang Date:2020-01-10 Time:16:48
 **/
public class ConcreteIterator<Item> implements Iterator {
    private Item[] items;
    private int position=0;

    public ConcreteIterator(Item[] items) {
        this.items = items;
    }
    @Override
    public Object next() {
        return items[position++];
    }

    @Override
    public boolean hasNext() {
        return position<items.length;
    }
}
