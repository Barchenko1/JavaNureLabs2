package com.barchenko.labs.lab2;

public class Task23 {
    public static void main(String[] args) {

        ParkingPlace.setUpParkingPlace();
        ParkingPlace parkingPlace = new ParkingPlace();
        parkingPlace.takeThePlace();
        parkingPlace.takeThePlace();
        parkingPlace.takeThePlace();
        parkingPlace.leaveThePlace(1);
        parkingPlace.takeThePlace();
        parkingPlace.takeThePlace();

    }
}
