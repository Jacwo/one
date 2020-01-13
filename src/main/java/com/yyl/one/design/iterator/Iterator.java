package com.yyl.one.design.iterator;

/**
 * author:yangyuanliang Date:2020-01-10 Time:16:46
 **/
public interface Iterator<Item> {
    Item next();
    boolean hasNext();
}
