package com.barchenko.labs.lab3.dao.mapper;

import com.barchenko.labs.lab3.dao.EntityMapper;
import com.barchenko.labs.lab3.dto.TeacherOccupationDto;
import com.barchenko.labs.lab3.entity.WeekDay;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherOccupationDtoMapper implements EntityMapper<TeacherOccupationDto> {

    @Override
    public TeacherOccupationDto mapRow(ResultSet rs) {
        TeacherOccupationDto teacherOccupationDto = new TeacherOccupationDto();
        try {
            teacherOccupationDto.setFirst_name(rs.getString("first_name"));
            teacherOccupationDto.setMiddle_name(rs.getString("middle_name"));
            teacherOccupationDto.setLast_name(rs.getString("last_name"));
            teacherOccupationDto.setCountOfLessonsPerWeek(rs.getInt("lessons_count"));
            teacherOccupationDto.setStudentCount(rs.getInt("students_count"));
            teacherOccupationDto.setOccupationName(rs.getString("name"));
            teacherOccupationDto.setWeekDay(WeekDay.valueOf(rs.getString("weekDay").toUpperCase()));
            teacherOccupationDto.setRoom(rs.getInt("room"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return teacherOccupationDto;
    }
}
