package gfpz.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 打电话 （关注第二个方法调用处是否需要等待第一个方法释放锁）
 */
public class Test5 {
    public static void main(String[] args) {
        Phone5 phone = new Phone5();
        Phone5 phone2 = new Phone5();
        new Thread(()->{phone.sendSms();},"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{phone.call();},"B").start();
    }
}

class Phone5 {
    //静态
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    //普通
    public synchronized void call() {
        System.out.println("打电话");
    }

}
