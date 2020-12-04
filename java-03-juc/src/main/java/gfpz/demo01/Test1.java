package gfpz.demo01;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
//        new Thread().start();
        //获取cpu核数
        //CPU密集型，IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());

        Test1 test1 = new Test1();
        test1.wait();

        Thread.sleep(2000);
    }
}
