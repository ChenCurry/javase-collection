package com.hello.singleton;

//饿汉式单例
public class SingletonHungry {
    //会浪费空间，所以应该是需要用得时候才创建Hungry对象 即用懒汉模式
    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    private byte[] data4 = new byte[1024*1024];

    private SingletonHungry() {
    }

    private final static SingletonHungry HUNGRY = new SingletonHungry();

    public static SingletonHungry getInstance() {
        return HUNGRY;
    }
}