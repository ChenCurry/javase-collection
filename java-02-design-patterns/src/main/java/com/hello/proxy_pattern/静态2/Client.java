package com.hello.proxy_pattern.静态2;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        //service.add();//不使用代理时
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(service);
        proxy.add();
    }
}