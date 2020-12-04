package gfpz.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 求和计算
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;
    //临界值
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    //计算方法
    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else{//像递归
            long middle = (start + end) / 2;//中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task2.fork();
            return task1.join() + task2.join();//合并
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();//365
//        test2();//818
        test3();//706
    }

    //月薪3k
    public static void test1() {
        long sum = 0L;
        long startTime = System.currentTimeMillis();
        for (long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("sum="+sum+",时间："+(endTime-startTime));
    }

    //月薪6k:ForkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);//直观上看就是起多线程来完成一堆任务
        Long sum = submit.get();

        long endTime = System.currentTimeMillis();
        System.out.println("sum="+sum+",时间："+(endTime-startTime));
    }

    //月薪9k:Stream并行流
    public static void test3() {
        long startTime = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("sum="+sum+",时间："+(endTime-startTime));
    }
}
