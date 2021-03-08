package com.barchenko.labs.lab3.query;

public class Constants {

    public static final String FIND_TEACHERS_BY_WEEKDAY_AND_ROOM = "SELECT teacher.first_name, teacher.middle_name, teacher.last_name, teacher.lessons_count, teacher.students_count," +
            "occupation.name, occupation.weekDay, occupation.room\n" +
            "FROM teacher\n" +
            "JOIN occupation\n" +
            "ON teacher.id=occupation.teacher_id where occupation.weekDay = ? and occupation.room = ?";

    public static final String FIND_WEEKDAYS_BY_ROOMS_COUNT = "SELECT occupation.weekDay, count(*) as counter " +
            "FROM occupation group by occupation.weekDay";

    public static final String SQL_TEACHER_REMOVE = "DELETE FROM teacher "
            + "WHERE id = ?";
    public static final String SQL_OCCUPATION_REMOVE = "DELETE FROM occupation "
            + "WHERE id = ?";

    public static final String FIND_OCCUPATION_BY_WEEKDAY = "SELECT * FROM occupation where weekDay = ?\n" +
            "ORDER BY id ASC\n" +
            "LIMIT 1";

    public static final String CREATE_OCCUPATION_UPDATE = "INSERT INTO occupation ("
            + "name, weekDay, room, teacher_id) "
            + "VALUES (?,?,?,?)";

    public static final String SHOW_ALL_OCCUPATION = "select * from occupation";
}
