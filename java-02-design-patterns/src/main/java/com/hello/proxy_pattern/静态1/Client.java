package com.hello.proxy_pattern.静态1;

//租客（访问代理对象的人）
public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        //host.rent();//如果我们能直接联系到房东，就可以不通过中介
        //通过代理的方式，找专业的房屋中介
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}