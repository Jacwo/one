package com.yyl.one

/**
 * @author yangyuanliang
 * @date 2025/3/8 11:46
 * @version 1.9
 */
class ClassLoaderTest extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name)
    }

    static void main(String[] args) {

    }
}
