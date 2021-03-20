package com.barchenko.labs.lab3.dao.impl;

import com.barchenko.labs.lab3.dao.AbstractJdbcDao;
import com.barchenko.labs.lab3.dao.EntityMapper;
import com.barchenko.labs.lab3.dao.OccupationDao;
import com.barchenko.labs.lab3.dao.TeacherOccupationInfoDao;
import com.barchenko.labs.lab3.dao.mapper.OccupationCounterMapper;
import com.barchenko.labs.lab3.dao.mapper.TeacherOccupationDtoMapper;
import com.barchenko.labs.lab3.dto.OccupationCounterDto;
import com.barchenko.labs.lab3.dto.TeacherOccupationDto;
import com.barchenko.labs.lab3.entity.Occupation;
import com.barchenko.labs.lab3.entity.WeekDay;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.barchenko.labs.lab3.query.Constants.FIND_TEACHERS_BY_WEEKDAY_AND_ROOM;
import static com.barchenko.labs.lab3.query.Constants.FIND_WEEKDAYS_BY_ROOMS_COUNT;

//реализация интерфейса для работы с таблицей teacher
public class TeacherOccupationInfoDaoImpl extends AbstractJdbcDao implements TeacherOccupationInfoDao {

//    метод для нахождения учителя по дню недели и номеру комнаты
    @Override
    public Optional<List<TeacherOccupationDto>> findTeachersByWeekDayAndRoomNumber(String weekDay, int roomNumber) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        EntityMapper<TeacherOccupationDto> teacherOccupationDtoMapper = new TeacherOccupationDtoMapper();
        List<TeacherOccupationDto> teacherOccupationDtoList = new ArrayList<>();
        try {
            connection = createConnection();
            ps = connection.prepareStatement(FIND_TEACHERS_BY_WEEKDAY_AND_ROOM);
            ps.setString(1, weekDay);
            ps.setInt(2, roomNumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                teacherOccupationDtoList.add(teacherOccupationDtoMapper.mapRow(rs));
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex2) {
                ex2.addSuppressed(ex);
                throw new RuntimeException(
                        "findOccupationById rollback occupation failed ", ex2);
            }
        } finally {
            closeResource(connection, ps, null, rs);
        }
        return Optional.of(teacherOccupationDtoList);
    }

    //    метод для нахождения учителя по количеству дней
    @Override
    public Optional<List<OccupationCounterDto>> findWeekDayByCounter(int count) {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        EntityMapper<OccupationCounterDto> occupationCounterDtoEntityMapper = new OccupationCounterMapper();
        List<OccupationCounterDto> teacherOccupationDtoList = new ArrayList<>();
        try {
            connection = createConnection();
            st = connection.createStatement();
            rs = st.executeQuery(FIND_WEEKDAYS_BY_ROOMS_COUNT);
            while (rs.next()) {
                teacherOccupationDtoList.add(occupationCounterDtoEntityMapper.mapRow(rs));
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex2) {
                ex2.addSuppressed(ex);
                throw new RuntimeException(
                        "findOccupationById rollback occupation failed ", ex2);
            }
        } finally {
            closeResource(connection, null, st, rs);
        }
        teacherOccupationDtoList = teacherOccupationDtoList.stream()
                .filter(o -> o.getCounter() == count).collect(Collectors.toList());
        return Optional.of(teacherOccupationDtoList);
    }

    //    метод для удаления первого предмета по дню недели и добавление в конец таблицы
    @Override
    public void updateTeacherOccupationDto(List<WeekDay> weekDays) {
        OccupationDao occupationDao = new OccupationDaoImpl();
        List<Occupation> occupationList = new ArrayList<>();
        Connection connection = createConnection();
        Savepoint savepoint = null;
        try {
            savepoint = connection.setSavepoint("SavepointOne");
            for (WeekDay wd:weekDays) {
                occupationList.add(occupationDao.findOccupationByWeekDay(connection, wd.getValue()).get());
            }
            for (Occupation oc:occupationList) {
                occupationDao.removeOccupation(connection, oc);
                occupationDao.creteOccupation(connection, oc);
            }
        connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                e1.addSuppressed(e1);
                throw new RuntimeException("updateTeacherOccupationDto rollback fail ", e1);
            }
            throw new RuntimeException("updateTeacherOccupationDto user fail ", ex);
        } finally {
            closeResource(connection, null, null, null);
        }
    }
}
