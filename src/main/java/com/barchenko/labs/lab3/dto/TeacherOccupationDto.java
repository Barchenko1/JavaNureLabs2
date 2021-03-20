package com.barchenko.labs.lab3.dto;

import com.barchenko.labs.lab3.entity.WeekDay;

//обьект для мапинга запросов с джоином
public class TeacherOccupationDto {
    private String first_name;
    private String middle_name;
    private String last_name;

    private int countOfLessonsPerWeek;
    private int studentCount;

    private String occupationName;
    private WeekDay weekDay;
    private int room;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getCountOfLessonsPerWeek() {
        return countOfLessonsPerWeek;
    }

    public void setCountOfLessonsPerWeek(int countOfLessonsPerWeek) {
        this.countOfLessonsPerWeek = countOfLessonsPerWeek;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
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

    @Override
    public String toString() {
        return "TeacherOccupationDto{" +
                "first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", countOfLessonsPerWeek=" + countOfLessonsPerWeek +
                ", studentCount=" + studentCount +
                ", occupationName='" + occupationName + '\'' +
                ", weekDay=" + weekDay +
                ", room=" + room +
                '}';
    }
}
