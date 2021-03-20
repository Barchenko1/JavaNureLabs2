package com.barchenko.labs.lab3.dao.mapper;

import com.barchenko.labs.lab3.dao.EntityMapper;
import com.barchenko.labs.lab3.dto.OccupationCounterDto;
import com.barchenko.labs.lab3.entity.WeekDay;

import java.sql.ResultSet;
import java.sql.SQLException;

//реализация интерфейса для мапинга полей с бд в java class
public class OccupationCounterMapper implements EntityMapper<OccupationCounterDto> {

    @Override
    public OccupationCounterDto mapRow(ResultSet rs) {
        OccupationCounterDto occupationCounterDto = new OccupationCounterDto();
        try {
            occupationCounterDto.setWeekDay(WeekDay.valueOf(rs.getString("weekDay").toUpperCase()));
            occupationCounterDto.setCounter(rs.getInt("counter"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return occupationCounterDto;
    }
}
