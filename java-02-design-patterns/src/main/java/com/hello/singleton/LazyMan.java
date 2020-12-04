package com.hello.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * DCL懒（饱）汉式（双重检测锁+volatile禁止指令重排）（也可能被反射破坏）
 */
public class LazyMan {
    /*public LazyMan() {
        System.out.println(Thread.currentThread().getName()+" ok");
    }*/

    private static boolean xiaoming = false;

    public LazyMan() {
        synchronized (LazyMan.class) {
            /*
            if (lazyMan != null) {//第三重检测
                throw new RuntimeException("不要试图使用反射破坏单例");
            }
            */
            if (!xiaoming){
                xiaoming = true;
            }else{
                throw new RuntimeException("不要试图使用反射破坏单例");
            }
        }
    }

    /*
    private static LazyMan lazyMan;
    //单线程下单例ok  多线程下有问题
    public static LazyMan getInstance() {
        if(null ==lazyMan){
            lazyMan = new LazyMan();
        }
        return lazyMan;
    }*/

    private volatile static LazyMan lazyMan;//volatile
    //双重检测锁模式+volatile禁止指令重排 DCL懒汉！！！！！！！！！！！！！！！！
    public static LazyMan getInstance() {
        if(null ==lazyMan){
            synchronized (LazyMan.class) {
                if(null ==lazyMan){
                    lazyMan = new LazyMan();//不是原子性操作，极端情况下也是有问题得
                    /**
                     * 1分配内存空间
                     * 2执行构造方法，初始化对象
                     * 3把对象指向这个空间
                     * 可能因指令重排产生问题
                     */
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws Exception {
        /*
        //测试
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                LazyMan.getInstance();
            }).start();
        }*/

        //反射破坏单例模式
        //LazyMan instance = LazyMan.getInstance();

        Field xiaoming = LazyMan.class.getDeclaredField("xiaoming");
        xiaoming.setAccessible(true);

        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);

        LazyMan instance = declaredConstructor.newInstance();
        xiaoming.set(instance,false);
        LazyMan instance2 = declaredConstructor.newInstance();

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}