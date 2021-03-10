package com.barchenko.labs.lab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor implements ActionListener {

    JFrame frame = new JFrame("Text Editor");
    JButton buttonOpen = new JButton("Open");
    JButton buttonSave = new JButton("Save");
    JButton buttonNew = new JButton("New File");
    JTextArea area = new JTextArea();
    File file = new File("");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextEditor();
            }
        });
    }

    public TextEditor() {
        frame.setSize(800, 600);
        frame.setVisible(true);

        buttonOpen.setLocation(10,10);
        buttonOpen.setSize(80,20);
        openButtonListener();

        buttonSave.setLocation(120,10);
        buttonSave.setSize(80,20);
        saveButtonListener();

        buttonNew.setLocation(230,10);
        buttonNew.setSize(100,20);
        newFileButtonListener();

        area.setLocation(50, 70);
        area.setSize(500, 200);

        frame.add(buttonOpen);
        frame.add(buttonSave);
        frame.add(buttonNew);
        frame.add(area);
        frame.add(new JLabel());
    }

    private void openButtonListener() {
        buttonOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(frame);
                file = chooser.getSelectedFile();

                try (BufferedReader bf = new BufferedReader(new FileReader(file))){
                    char[] buf = new char[(int) file.length()];
                    bf.read(buf);
                    area.setText(new String(buf));

                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
    }

    private void saveButtonListener() {
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
                    bw.write(area.getText());
                    bw.flush();

                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
    }

    private void newFileButtonListener() {
        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
                        bw.write("");
                        bw.flush();

                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
