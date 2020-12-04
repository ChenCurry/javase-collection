package gfpz.tvolatile;

import java.util.concurrent.TimeUnit;

public class JMMDemo {
    //不加 volatile 的话，线程1的死循环结束不了
    //加了 volatile 可以保证可见性
    private volatile static int num = 0;
    public static void main(String[] args) {//main线程

        new Thread(() -> {//线程1对主内存种num已经变化了毫不知情，所以一直不停下来
            while (num == 0) {

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;

        System.out.println(num);
    }
}
