package gfpz.unsafe;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

//ConcurrentModificationException
public class MapTest {
    public static void main(String[] args) {
        //Map 是这样用的吗？不是，工作中不用 HashMap
        //Map 默认等价于什么 new HashMap<>(16,0.75);//加载因子、初始容量
//        Map<String, String> map = new HashMap<>();
//        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

    }
}
