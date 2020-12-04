package gfpz.function;

import java.util.function.Function;

/**
 * Function 函数型接口，有一个输入参数，有一个输出
 * 只要是 函数型接口，就可以用 lambda 表达式简化
 */
public class Demo01 {
    public static void main(String[] args) {
        //创建匿名内部类
        /*Function function = new Function<String, String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        };*/
//        Function<String, String> function = (str)->{return str;};
        Function<String, String> function = str->{return str;};
        System.out.println(function.apply("test"));
    }
}
