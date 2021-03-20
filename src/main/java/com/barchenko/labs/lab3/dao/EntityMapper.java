package com.barchenko.labs.lab3.dao;

import java.sql.ResultSet;

//интерфейс для мапинга полей с бд в java class
public interface EntityMapper<T> {
    T mapRow(ResultSet rs);
}
