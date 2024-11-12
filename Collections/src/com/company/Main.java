package com.company;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // List
        ArrayList<String> list1 = new ArrayList<>();

        String[] arr1 = new String[]{"123", "Kostia", "Kocherga", "ШАГ"};

        for(int i = 0; i < arr1.length; i++){
            list1.add(arr1[i]);
        }

        ArrayList<String> list2 = new ArrayList<>(list1);

        List<String> list3 = Arrays.asList("Apple", "Banana", "Cherry");

        int middleIndex = list2.size() / 2;
        list2.addAll(middleIndex, list3);

        list2.sort(Collections.reverseOrder());

        ListIterator<String> iterator = list2.listIterator();

        int index = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if (index % 2 != 0) {
                iterator.remove();
            }
            index++;
        }

        //Set

        HashSet<String> set1 = new HashSet<>();

        set1.add("Hello");
        set1.add("World");

        set1.addAll(list1);
        set1.addAll(list2);

        System.out.println("set1: " + set1);

        LinkedHashSet<String> set2 = new LinkedHashSet<>();

        set2.addAll(list1);
        set2.addAll(list2);

        System.out.println("set2: " + set2);

        //Map

        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();

        map1.put(1, "January");
        map1.put(2, "February");
        map1.put(3, "March");
        map1.put(4, "April");
        map1.put(5, "May");
        map1.put(6, "June");
        map1.put(7, "July");
        map1.put(8, "August");
        map1.put(9, "September");
        map1.put(10, "October");
        map1.put(11, "November");
        map1.put(12, "December");

        System.out.println("First month: " + map1.get(1));
        System.out.println("Last month: " + map1.get(12));

        map1.put(6, "ОТПУСК");
        System.out.println(map1.get(6));

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.putAll(map1);

        printMap(map1);
        System.out.println(" ");
        printMap(map2);

        HashMap<String, Set<String>> map3 = new HashMap<>();

        //User

        HashSet<User> userSet = new HashSet<>();

        User user1 = new User("Kostia", 19, "123");
        User user2 = new User("Kostia", 15, "133");
        User user3 = new User("Vasya", 39, "321");

        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);

        System.out.println("Users: ");
        for (User user : userSet) {
            System.out.println(user);
        }


    }

    public static void printMap(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Month " + entry.getKey() + ": " + entry.getValue());
        }
    }
}