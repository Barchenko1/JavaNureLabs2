package com.barchenko.labs.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ParkingPlace {

    private int numberOfFreePlaces;
    private static int numberOfPlaces;
    private List<String> arrayListStation;

    public ParkingPlace() {
        this.arrayListStation = new ArrayList<>(Collections.nCopies(numberOfPlaces, "Место свободно"));
        this.numberOfFreePlaces = numberOfPlaces;
    }

    //создание парковки
    public static void setUpParkingPlace() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Введите число мест в автостоянке");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести положительное целое число");
                sc.next();
            }
            numberOfPlaces = sc.nextInt();
        } while (numberOfPlaces <= 0);
    }

    //метод для занимания места на парковке
    public void takeThePlace() {
        for (int i = 0; i <= arrayListStation.size() - 1; i++) {
            if (this.numberOfFreePlaces > 0) {
                if (arrayListStation.get(i).equals("Место свободно")) {
                    arrayListStation.set(i, "Место занято");
                    this.numberOfFreePlaces--;
                    System.out.println("Вы заняли место № " + (i) +
                            "\n" + arrayListStation.toString());
                    break;
                }
            } else {
                System.out.println("Свободных мест нет, дождитесь выезда машин");
                break;
            }
        }
    }

    //метод для освобождения места на порковке
    public void leaveThePlace(int parkingPlace) {
        arrayListStation.set(parkingPlace, "Место свободно");
        this.numberOfFreePlaces++;
        System.out.println("Вы покинули парковочное место № " + parkingPlace +
                "\n" + arrayListStation.toString());
    }
}
