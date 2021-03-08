package com.barchenko.labs.lab3.entity;


public class Occupation {
    private long id;
    private String name;
    private WeekDay weekDay;
    private int room;
    private long teacherId;

    public Occupation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weekDay=" + weekDay +
                ", room=" + room +
                ", teacherId=" + teacherId +
                '}';
    }
}
