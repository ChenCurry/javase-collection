package gfpz.demo01;

//基本的卖票例子

/**
 * 公司中的开发，降低耦合性
 * 线程就是一个单独的资源类，它没有任何附属操作
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {for (int i = 0; i < 60; i++) ticket.sale();}, "A").start();
        new Thread(() -> {for (int i = 0; i < 60; i++) ticket.sale();}, "B").start();
        new Thread(() -> {for (int i = 0; i < 60; i++) ticket.sale();}, "C").start();
    }
}

//资源类 OOP
class Ticket {

    private int number = 50;

    //synchronized 本质是 队列/锁
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第：" + (50 - number--) + "张票，剩余：" + number + "张票");
        }
    }
}
