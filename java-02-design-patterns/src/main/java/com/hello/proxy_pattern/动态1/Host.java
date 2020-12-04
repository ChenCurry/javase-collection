package com.hello.proxy_pattern.动态1;

//房东
public class Host implements Rent {
    public void rent() {
        System.out.println("本房东要出租房子了");
    }
}