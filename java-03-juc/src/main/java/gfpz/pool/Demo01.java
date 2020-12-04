package gfpz.pool;

import java.util.concurrent.*;

public class Demo01 {
    public static void main(String[] args) {
        //自定义线程池
        System.out.println(Runtime.getRuntime().availableProcessors());
        int heShu = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = new ThreadPoolExecutor(2//银行柜台平时开两个窗口
                , heShu//,5最多开5个窗口
                , 3//等3
                , TimeUnit.SECONDS//秒钟
                , new LinkedBlockingQueue<>(3)//3把等待办理业务的椅子
                , Executors.defaultThreadFactory()//线程工厂
                //4种拒绝策略（银行满了，还有人进来）
                //,new ThreadPoolExecutor.AbortPolicy()//抛出异常：java.util.concurrent.RejectedExecutionException
                //,new ThreadPoolExecutor.CallerRunsPolicy()//哪来的去哪里，main线程调用的，main线程自行处理业务
                //,new ThreadPoolExecutor.DiscardPolicy()//不抛出异常，丢掉任务
                ,new ThreadPoolExecutor.DiscardOldestPolicy()//队列满了，尝试去和最早的竞争，不抛出异常
        );

        try {
            for (int i = 1; i <= 9; i++) {
                //使用线程池创建线程
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "  0k");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }
}
