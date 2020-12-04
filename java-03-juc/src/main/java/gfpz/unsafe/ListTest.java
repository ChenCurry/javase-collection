package gfpz.unsafe;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("1", "2", "3");
//        list.forEach(System.out::println);

        /**
         * 并发下 ArrayList 是不安全的
         * 方案1：安全list：List<String> list = new Vector<>();
         * 方案2：用工具类让它变得安全：List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 方案3：JUC写入时复制：List<String> list = new CopyOnWriteArrayList<>();
         */
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
