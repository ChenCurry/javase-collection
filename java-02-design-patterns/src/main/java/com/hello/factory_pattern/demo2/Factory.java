package com.hello.factory_pattern.demo2;

import com.hello.factory_pattern.demo1.Circle;
import com.hello.factory_pattern.demo1.Rectangle;
import com.hello.factory_pattern.demo1.Shape;
import com.hello.factory_pattern.demo1.Square;

public enum Factory {
    CIRCLE(new Circle(),"CIRCLE"),
    RECTANGLE(new Rectangle(),"RECTANGLE"),
    SQUARE(new Square(),"SQUARE");
    
    // 成员变量  
    private Shape shape;
    private String name;  
    
    // 普通方法  
    public static Shape getShape(String name) {  
        for (Factory c : Factory.values()) {  
            if (c.name == name) {  
                return c.shape;  
            }  
        }  
        return null;  
    } 
    // 构造方法  
    private Factory(Shape shape, String name) {  
        this.shape = shape;  
        this.name = name;  
    } 
    public String getName() {
        return name;
    }
    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setName(String name) {
        this.name = name;
    } 
}
