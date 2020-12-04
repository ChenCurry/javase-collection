package gfpz.unsafe;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 同理
 * java.util.ConcurrentModificationException
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new hashset<>());
//        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }

    }
}
