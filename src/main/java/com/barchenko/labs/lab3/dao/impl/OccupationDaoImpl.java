package com.barchenko.labs.lab3.dao.impl;

import com.barchenko.labs.lab3.dao.AbstractJdbcDao;
import com.barchenko.labs.lab3.dao.EntityMapper;
import com.barchenko.labs.lab3.dao.OccupationDao;
import com.barchenko.labs.lab3.dao.mapper.OccupationMapper;
import com.barchenko.labs.lab3.entity.Occupation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.barchenko.labs.lab3.query.Constants.*;

//реализация интерфейса для работы с таблицей occupation
public class OccupationDaoImpl extends AbstractJdbcDao implements OccupationDao {

//    метод для нахождения всех предметов
    @Override
    public Optional<List<Occupation>> findAllOccupation() {
        Connection con = null;
        List<Occupation> occupationList = new ArrayList<>();
        EntityMapper<Occupation> occupationMapper = new OccupationMapper();
        Statement st = null;
        ResultSet rs = null;
        try {
            con = createConnection();
            st = con.createStatement();
            rs = st.executeQuery(SHOW_ALL_OCCUPATION);
            while (rs.next()) {
                occupationList.add(occupationMapper.mapRow(rs));
            }
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.addSuppressed(e);
                throw new RuntimeException("findAll rollback user fail ", e1);
            }
            throw new RuntimeException("findAll user fail ", e);
        } finally {
            closeResource(con, null, st, rs);
        }
        return Optional.of(occupationList);
    }

//    метод для нахождения предмета по дню недели
    @Override
    public Optional<Occupation> findOccupationByWeekDay(Connection connection, String weekDay) throws SQLException {
        EntityMapper<Occupation> occupationMapper = new OccupationMapper();
        Occupation occupation = null;
        PreparedStatement ps = connection.prepareStatement(FIND_OCCUPATION_BY_WEEKDAY);
        ps.setString(1, weekDay);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            occupation = occupationMapper.mapRow(rs);
        }
        closeResource(null, ps, null, null);
        return Optional.of(occupation);
    }

    //    метод для удаления предмета
    @Override
    public void removeOccupation(Connection connection, Occupation occupation) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SQL_OCCUPATION_REMOVE);
        ps.setLong(1, occupation.getId());
        ps.executeUpdate();
        closeResource(null, ps, null, null);
    }

    //    метод для создания предмета
    @Override
    public void creteOccupation(Connection connection, Occupation occupation) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(CREATE_OCCUPATION_UPDATE);
        int i = 1;
        ps.setString(i++, occupation.getName());
        ps.setString(i++, occupation.getWeekDay().getValue());
        ps.setInt(i++, occupation.getRoom());
        ps.setLong(i++, occupation.getTeacherId());
        ps.executeUpdate();
        closeResource(null, ps, null, null);
    }

}
