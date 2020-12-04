package gfpz.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger证原子性
 */
public class VDemo03 {
    private static AtomicInteger num = new AtomicInteger();

    public static void add(){
        num.getAndIncrement();//底层用的CAS
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {//main gc
            Thread.yield();//线程礼让
        }

        System.out.println(Thread.currentThread().getName()+" "+num);
    }
}
