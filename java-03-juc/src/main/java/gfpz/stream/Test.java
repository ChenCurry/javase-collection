package gfpz.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * 要求：一分钟内完成，一行代码实现筛选
 * 1、id为偶数
 * 2、年龄大于23
 * 3、用户名转为大写字母
 * 4、用户名倒着排序
 * 5、只输出一个用户名
 */
public class Test {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 22);
        User u3 = new User(3, "c", 23);
        User u4 = new User(4, "d", 24);
        User u5 = new User(6, "e", 25);
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        list.stream()
                .filter(u->{return u.getId()%2==0;})
                .filter(u->{return u.getAge() > 23;})
                .map(u->{return u.getName().toUpperCase();})
                .sorted((uu1,uu2)->{return uu2.compareTo(uu1);})
                .limit(1)
                .forEach(System.out::println);
    }
}

@Data//get set toString
@NoArgsConstructor
@AllArgsConstructor
class User {
    private int id;
    private String name;
    private int age;
}
