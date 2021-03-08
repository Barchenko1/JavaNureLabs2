package com.barchenko.labs.lab3.dao.mapper;

import com.barchenko.labs.lab3.dao.EntityMapper;
import com.barchenko.labs.lab3.entity.Occupation;
import com.barchenko.labs.lab3.entity.WeekDay;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OccupationMapper implements EntityMapper<Occupation> {

    @Override
    public Occupation mapRow(ResultSet rs) {
        Occupation occupation = new Occupation();
        try {
            occupation.setId(rs.getLong("id"));
            occupation.setName(rs.getString("name"));
            occupation.setWeekDay(WeekDay.valueOf(rs.getString("weekDay").toUpperCase()));
            occupation.setRoom(rs.getInt("room"));
            occupation.setTeacherId(rs.getLong("teacher_id"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return occupation;
    }
}
