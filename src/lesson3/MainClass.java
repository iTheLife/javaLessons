package lesson3;

import lesson1.example.SOuter;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {

        ArrayList<String> arrayWord = new ArrayList<>(Arrays.asList("A", "Life", "Core", "Java", "Home", "Java", "Java", "B", "E", "Life", "Sport"));

        Map<String, Integer> countWord = new HashMap<>();

        for (String word : arrayWord) {
            countWord.put(word, countWord.containsKey(word)?countWord.get(word)+1 : 1);
        }

        System.out.println("Список уникальных слов и их количество:");

        for (Map.Entry<String, Integer> word : countWord.entrySet()) {
            System.out.println("Слово: " + word.getKey() + " количество: " + word.getValue());
        }


        System.out.println("=================================================");
        System.out.println("Справочник телефонов");

        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add("Кузнецов", "123456");
        phoneDirectory.add("Савченко", "321456");
        phoneDirectory.add("Моисеев", "777777");
        phoneDirectory.add("Кузнецов", "88005553535");
        phoneDirectory.add("Бастрыгина", "9751576132");
        phoneDirectory.add("Григоренко", "1234567854");

        phoneDirectory.get("Кузнецов");
        phoneDirectory.get("Григоренко");
        phoneDirectory.get("123");


//        HashMap<String, Integer> hm = new HashMap<>();
//        for (int i = 0; i < 1_000_000; i++) {
//            hm.put("Entry #" + i, i);
//        }
//        long time = System.currentTimeMillis();
//
//        for (int i = 0; i < 1_000_000; i++) {
//            hm.get("Entry #" + i);
//        }

        //System.out.println(System.currentTimeMillis() - time);
//        List<String> als = new ArrayList<>(Arrays.asList("A", "@", "Core", "Java", "Home"));
//        als.remove("@");
//        als.remove(2);
//        als.set(0,"Q");
//        System.out.println(als);
    }
}
