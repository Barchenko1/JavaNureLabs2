package com.barchenko.labs.lab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderSwing implements ActionListener {

    JFrame frame = new JFrame("Fetch text from file");
    JButton addTest = new JButton("Add Text");
    JTextField textField = new JTextField();
    File file = new File("file.txt");
    List<String> list = new ArrayList<>();
    private int counter;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileReaderSwing();
            }
        });
    }

    //конструктор для создания кликера
    public FileReaderSwing() {
        frame.setSize(500, 150);
        frame.setVisible(true);

        //создание кнопки открытия файла
        addTest.setLocation(10,10);
        addTest.setSize(300,20);
        addTestToInput();

        textField.setLocation(50, 70);
        textField.setSize(300, 20);
        frame.add(addTest);
        frame.add(textField);
        frame.add(new JLabel());
    }

    //метод добавления текста по клику
    private void addTestToInput() {
        addTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedReader bfReader = new BufferedReader(new FileReader(file))){
                    String line = bfReader.readLine();
                    while (line != null) {
                        list.add(line);
                        line = bfReader.readLine();
                    }
                    counter++;
                    List<String> filteredList = new ArrayList<>();
                    for (int i = 0; i < counter; i++) {
                        filteredList.add(list.get(i));
                    }
                    textField.setText(String.join("", filteredList));
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
