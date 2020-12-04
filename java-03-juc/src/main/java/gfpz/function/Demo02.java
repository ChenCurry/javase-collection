package gfpz.function;

import java.util.function.Predicate;

/**
 * 断定型接口
 */
public class Demo02 {
    public static void main(String[] args) {
        //判断字符串是否为空
        /*Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.isEmpty();
            }
        };*/
        Predicate<String> predicate = str->{return str.isEmpty();};
        System.out.println(predicate.test(""));
    }
}
