package gfpz.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 这个需要记住！关注 synchronized 是不是加了static，所以出现 synchronized 就要关注它锁的是什么
 */
public class Test4 {
    public static void main(String[] args) {
        Phone4 phone = new Phone4();
        Phone4 phone2 = new Phone4();
        new Thread(()->{phone.sendSms();},"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{phone2.call();},"B").start();
    }
}

class Phone4 {
    //锁的是 Phone4的Class对象
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }

}
