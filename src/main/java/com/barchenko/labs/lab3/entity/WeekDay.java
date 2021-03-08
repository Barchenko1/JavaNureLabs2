package com.barchenko.labs.lab3.entity;

public enum WeekDay {
    SUNDAY("sunday"),
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday");

    private final String value;

    WeekDay(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
