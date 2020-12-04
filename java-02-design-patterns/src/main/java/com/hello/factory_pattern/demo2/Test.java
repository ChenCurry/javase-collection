package com.hello.factory_pattern.demo2;

public class Test {
    public static void main(String[] args) {
        /*使用枚举类*/
        Factory.getShape("CIRCLE").draw();
        Factory.getShape("RECTANGLE").draw();
        Factory.getShape("SQUARE").draw();
    }
}
