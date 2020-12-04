package com.hello.singleton;

import java.lang.reflect.Constructor;

/**
 * 枚举避免破坏单例模式
 * enum 本身也是一个class类
 */
public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}

class Test {
    //Cannot reflectively create enum objects 结论：枚举可以防止反射破坏单例
    public static void main(String[] args) throws Exception {
//        EnumSingle instance1 = EnumSingle.INSTANCE;
//        EnumSingle instance2 = EnumSingle.INSTANCE;
//        System.out.println(instance1);
//        System.out.println(instance2);

        EnumSingle instance1 = EnumSingle.INSTANCE;
        //Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle instance2 = declaredConstructor.newInstance();
        //NoSuchMethodException
        System.out.println(instance1);
        System.out.println(instance2);
    }
}