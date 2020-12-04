package com.hello.proxy_pattern.静态1;

//中介（代理角色：代理真实角色，通常会做一些附加操作）
public class Proxy implements Rent {

    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {//或使用set方式注入
        this.host = host;
    }

    public void rent() {
        hetong();
        host.rent();
        jiaoqian();
    }

    public void hetong() {
        System.out.println("链家：你们两方签合同");
    }

    public void jiaoqian() {
        System.out.println("链家：这边把费用算一下");
    }
}