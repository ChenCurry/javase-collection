package gfpz.function;

import java.util.function.Consumer;

/**
 * 消费型接口，只有输入没有输出
 */
public class Demo03 {
    public static void main(String[] args) {
        /*Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };*/
        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        consumer.accept("sad");
    }
}
