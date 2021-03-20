package com.barchenko.labs.lab3.entity;

import java.util.List;

//сущьность таблицы учитель
public class Teacher {
    private long id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private List<Occupation> occupationList;
    private int countOfLessonsPerWeek;
    private int studentsCount;

    public Teacher() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<Occupation> getOccupationList() {
        return occupationList;
    }

    public void setOccupationList(List<Occupation> occupationList) {
        this.occupationList = occupationList;
    }

    public int getCountOfLessonsPerWeek() {
        return countOfLessonsPerWeek;
    }

    public void setCountOfLessonsPerWeek(int countOfLessonsPerWeek) {
        this.countOfLessonsPerWeek = countOfLessonsPerWeek;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", occupationList=" + occupationList +
                ", countOfLessonsPerWeek=" + countOfLessonsPerWeek +
                ", studentsCount=" + studentsCount +
                '}';
    }
}
