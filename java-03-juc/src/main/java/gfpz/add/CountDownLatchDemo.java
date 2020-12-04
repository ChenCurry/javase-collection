package gfpz.add;

import java.util.concurrent.CountDownLatch;

//计数器
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go out");
                countDownLatch.countDown();//数量-1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//阻塞，等待计数器归零，然后再向下执行
        System.out.println("Close door");
    }
}
