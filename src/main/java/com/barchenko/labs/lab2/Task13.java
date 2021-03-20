package com.barchenko.labs.lab2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task13 {
    //демострация работы программы
    public static void main(String[] args) {
        File file = new File("fileTask13.txt");
        List<String> list = listFromFile(file);
        Set<String> set = toSet(list);
        set.forEach(System.out::println);
    }

    //фильтрация слов из файла
    private static List<String> listFromFile(File file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String filteredWord = line.replaceAll("[^a-zA-Z\\s]", "");
                list.add(filteredWord.toLowerCase());
                line = reader.readLine();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    //добавление в сет слов с файла
    private static Set<String> toSet(List<String> list) {
        Set<String> set = new HashSet<>();
        list.forEach(line -> {
            String[] words = line.split(" ");
            for (String word : words) {
                set.add(word.toLowerCase());
            }
        });
        return set;
    }
}
