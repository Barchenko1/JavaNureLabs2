package com.barchenko.labs.lab2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task11 {
    public static void main(String[] args) {
        //демострация работы сортировки слов из файла
        List<String> list = new ArrayList<>();
        File file = new File("file.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.sort(Comparator.reverseOrder());
        list.forEach(System.out::println);
    }
}
