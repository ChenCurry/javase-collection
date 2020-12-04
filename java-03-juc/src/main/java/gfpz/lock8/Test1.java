package gfpz.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 先打印啥？发短信还是打电话
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{phone.sendSms();},"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{phone.call();},"B").start();
    }
}

class Phone{
    //synchronized 锁的是方法的调用者，就是上面new的phone对象，先调用的哪个就执行哪个
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}
