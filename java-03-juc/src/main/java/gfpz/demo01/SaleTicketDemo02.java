package gfpz.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {
    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();
        new Thread(() -> {for (int i = 0; i < 100; i++) ticket2.sale();}, "A").start();
        new Thread(() -> {for (int i = 0; i < 100; i++) ticket2.sale();}, "B").start();
        new Thread(() -> {for (int i = 0; i < 100; i++) ticket2.sale();}, "C").start();
    }
}

class Ticket2 {

    private int number = 60;

    Lock l = new ReentrantLock();

    public void sale() {
        l.lock();
        try { // 业务代码
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第：" + (60 - number--) + "张票，剩余：" + number + "张票");
            }
        } finally {
            l.unlock();
        }
    }
}
