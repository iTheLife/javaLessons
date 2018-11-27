package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < 1_000_000; i++) {
            hm.put("Entry #" + i, i);
        }
        long time = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            hm.get("Entry #" + i);
        }

        System.out.println(System.currentTimeMillis() - time);
//        List<String> als = new ArrayList<>(Arrays.asList("A", "@", "Core", "Java", "Home"));
//        als.remove("@");
//        als.remove(2);
//        als.set(0,"Q");
//        System.out.println(als);
    }
}
