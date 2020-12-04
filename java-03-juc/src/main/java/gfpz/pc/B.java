package gfpz.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程之间操作同一个资源，通过等待和唤醒机制进行通信
 */
public class B {
    public static void main(String[] args) {
        Data2 data = new Data2();
        //生产
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        //消费
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        //生产
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        //消费
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}

//生产者消费者：等待 业务 通知  面试手写（单例模式、排序算法、生产者消费者、死锁）
class Data2 {
    private int number;
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {//等于0才进行+1，不等于0等着
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            //通知其他线程，我+1完了
            condition.signalAll();
        } finally {lock.unlock();}
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) {//不等于0才进行-1，等于0等着
                //等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            //通知其他线程，我-1完了
            condition.signalAll();
        } finally {lock.unlock();}
    }
}
