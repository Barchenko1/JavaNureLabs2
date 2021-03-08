package com.barchenko.labs.lab3.dao;

import com.barchenko.labs.lab3.entity.Occupation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface OccupationDao {
    Optional<List<Occupation>> findAllOccupation();
    Optional<Occupation> findOccupationByWeekDay(Connection connection, String weekDay) throws SQLException;
    void removeOccupation(Connection connection, Occupation occupation) throws SQLException;
    void creteOccupation(Connection connection, Occupation occupation) throws SQLException;
}
