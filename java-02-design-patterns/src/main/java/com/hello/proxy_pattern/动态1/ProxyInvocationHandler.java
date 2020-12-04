package com.hello.proxy_pattern.动态1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口（写成Object就通用了）
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    //处理代理实例 并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        hetong();
        //动态代理的本质就是使用反射机制
        Object object = method.invoke(rent, args);
        jiaoqian();
        return object;
    }

    public void hetong() {
        System.out.println("链家：你们两方签合同");
    }

    public void jiaoqian() {
        System.out.println("链家：这边把费用算一下");
    }
}