package com.barchenko.labs.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice1 {
    public static void main(String[] args) {
        List<String> list = getDataFromFile();
        writeStringsToFile(list);
    }

    private static List<String> getDataFromFile() {
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
        Collections.reverse(list);
        return list;
    }

    private static void writeStringsToFile(List<String> strings) {
        File file = new File("file2.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            strings.forEach(line -> {
                try {
                    writer.write(line + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
