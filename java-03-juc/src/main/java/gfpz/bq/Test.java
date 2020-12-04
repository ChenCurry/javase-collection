package gfpz.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);//参数为队列的大小
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("d"));//抛出异常 IllegalStateException: Queue full
        System.out.println("队首元素："+blockingQueue.element());//
        System.out.println("-------------------------");
        System.out.println(blockingQueue.remove());//FIFO 先进先出
        System.out.println("队首元素："+blockingQueue.element());//
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());//NoSuchElementException
    }

    /**
     * 不抛出异常，有返回值
     */
    public static void test2() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);//参数为队列的大小
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));//返回 false 不抛出异常
        System.out.println("队首元素："+blockingQueue.peek());
        System.out.println("-------------------------");
        System.out.println(blockingQueue.poll());
        System.out.println("队首元素："+blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//返回一个null，没有异常
    }

    /**
     * 等待 阻塞（一直阻塞）
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);//参数为队列的大小
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d");//队列里没有椅子了，会一直阻塞
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());//取不到，一直阻塞
    }

    /**
     * 等待 阻塞（等待超时）
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);//参数为队列的大小
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        //blockingQueue.offer("d", 2, TimeUnit.SECONDS);//超时时间 单位
        System.out.println("-------------------------");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));//2秒拿不到就不拿了 返回个null
    }
}
