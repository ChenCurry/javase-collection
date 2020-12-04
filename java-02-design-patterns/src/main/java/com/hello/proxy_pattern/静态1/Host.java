package com.hello.proxy_pattern.静态1;

//房东（真实角色：被代理的角色）
public class Host implements Rent {
    public void rent() {
        System.out.println("本房东要出租房子了");
    }
}