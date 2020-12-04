package com.hello.singleton;

/**
 * 静态内部类玩法
 */
public class Holder {
    private Holder() {
    }

    public static Holder getInstance() {
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}