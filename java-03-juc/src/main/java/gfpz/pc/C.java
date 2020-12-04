package gfpz.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A执行完调用B，B执行完调用C，C执行完调用A
 */
public class C {
    public static void main(String[] args) {
        Data3 data = new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        },"C").start();
    }
}

class Data3 {
    private int number = 1;//1A 2B 3C
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printA() {
        lock.lock();try{
            while (number != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAA");
            number = 2;
            //唤醒B
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{lock.unlock();}
    }
    public void printB() {
        lock.lock();try{
            while (number != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>BBB");
            number = 3;
            //唤醒C
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{lock.unlock();}
    }
    public void printC() {
        lock.lock();try{
            while (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>CCC");
            number = 1;
            //唤醒A
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{lock.unlock();}
    }
}
