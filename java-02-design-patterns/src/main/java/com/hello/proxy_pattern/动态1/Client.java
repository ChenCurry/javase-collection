package com.hello.proxy_pattern.动态1;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //创建代理角色
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        handler.setRent(host);
        Rent proxy = (Rent) handler.getProxy();
        proxy.rent();
    }
}