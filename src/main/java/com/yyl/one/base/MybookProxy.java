package com.yyl.one.base;

public class MybookProxy {

    public static void main(String[] args) {
        MybookJdkProxy mybookJdkProxy = new MybookJdkProxy();
        BookFacade bookFacadeImpl = (BookFacade)mybookJdkProxy.bind(new BookFacadeImpl());
        bookFacadeImpl.addBook();
    }
}
