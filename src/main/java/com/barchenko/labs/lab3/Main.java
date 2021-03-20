package com.barchenko.labs.lab3;

import com.barchenko.labs.lab3.dao.OccupationDao;
import com.barchenko.labs.lab3.dao.TeacherOccupationInfoDao;
import com.barchenko.labs.lab3.dao.impl.OccupationDaoImpl;
import com.barchenko.labs.lab3.dao.impl.TeacherOccupationInfoDaoImpl;
import com.barchenko.labs.lab3.entity.WeekDay;

import java.util.ArrayList;
import java.util.List;

public class Main {

//    метод для демонстрации работы программы
    public static void main(String[] args) {
        TeacherOccupationInfoDao teacherOccupationInfoDao = new TeacherOccupationInfoDaoImpl();
        System.out.println(teacherOccupationInfoDao.findTeachersByWeekDayAndRoomNumber("friday", 111));
        System.out.println();
        System.out.println(teacherOccupationInfoDao.findWeekDayByCounter(1));
        System.out.println();
        OccupationDao occupationDao = new OccupationDaoImpl();
        System.out.println(occupationDao.findAllOccupation());
        List<WeekDay> weekDayList = new ArrayList<>();
        weekDayList.add(WeekDay.MONDAY);
        teacherOccupationInfoDao.updateTeacherOccupationDto(weekDayList);
        System.out.println(occupationDao.findAllOccupation());
    }
}
