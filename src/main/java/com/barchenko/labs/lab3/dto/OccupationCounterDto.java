package com.barchenko.labs.lab3.dto;

import com.barchenko.labs.lab3.entity.WeekDay;

public class OccupationCounterDto {
    private WeekDay weekDay;
    private int counter;

    public OccupationCounterDto() {
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "OccupationCounterDto{" +
                "weekDay=" + weekDay +
                ", counter=" + counter +
                '}';
    }
}
