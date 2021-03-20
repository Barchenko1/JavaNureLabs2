package com.barchenko.labs.lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task14 {
    //демострация работы программы
    public static void main(String[] args) {
        File file = new File("fileTask13.txt");
        List<String> list = toListElement(listFromFile(file));
        Map<Object, Long> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);
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

    //подсчет количества слов в файле
    private static List<String> toListElement(List<String> list) {
        List<String> newList = new ArrayList<>();
        list.forEach(line -> {
            String[] words = line.split(" ");
            for (String word : words) {
                newList.add(word.toLowerCase());
            }
        });
        return newList;
    }
}
