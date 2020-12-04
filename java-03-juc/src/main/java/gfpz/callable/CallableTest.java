package gfpz.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //FutureTask 实现了runnable接口，又可以通过callable进行构造
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();//只会打印1个call，结果会被缓存
        Integer ret = (Integer) futureTask.get();//这个方法可能产生阻塞，要放到最后，或者异步通信
        System.out.println(ret);
    }
}

//泛型对应call方法的返回值
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call执行了");
        return 1024;
    }
}
