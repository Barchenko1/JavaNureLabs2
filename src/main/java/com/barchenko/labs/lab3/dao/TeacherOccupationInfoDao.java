package com.barchenko.labs.lab3.dao;

import com.barchenko.labs.lab3.dto.OccupationCounterDto;
import com.barchenko.labs.lab3.dto.TeacherOccupationDto;
import com.barchenko.labs.lab3.entity.WeekDay;

import java.util.List;
import java.util.Optional;

//интерфейс для определения методов работы с таблицей teacher
public interface TeacherOccupationInfoDao {
    Optional<List<TeacherOccupationDto>> findTeachersByWeekDayAndRoomNumber(String weekDay, int roomNumber);
    Optional<List<OccupationCounterDto>> findWeekDayByCounter(int count);
    void updateTeacherOccupationDto(List<WeekDay> weekDays);
}
