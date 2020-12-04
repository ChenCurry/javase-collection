package com.hello.singleton;

/**
 * 饱汉模式
 */
public class SingletonFull {

    private static SingletonFull instance = null;

    private SingletonFull() {
    }

    public static synchronized SingletonFull getInstance(){
        if(null==instance)
            instance = new SingletonFull();
        return instance;
    }
}