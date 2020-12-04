package gfpz.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();
        test2();
    }

    //没有返回值的 异步回调
    public static void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" runAsync=>Void");
        });
        System.out.println("sad");
        completableFuture.get();//阻塞获取执行结果
    }

    //有返回值的异步回调
    public static void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+" supplyAsync=>Integer");
            int a = 1/0;
            return 1024;
        });
        int b = integerCompletableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t);//正常的返回结果
            System.out.println("u=>" + u);//错误信息
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 2333;//类似404
        }).get();
        System.out.println(b);
    }
}
