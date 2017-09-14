package project.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import project.dao.TestDAO;
import project.dto.DayOffDto;

import java.sql.PreparedStatement;
import java.util.Date;

public class TestImpl implements TestDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TestImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertDayOff(DayOffDto dayOffDto) {
        String sql = "INSERT  INTO  dayoff (name, dateDay) VALUES (?,?)";
        jdbcTemplate.update(conn-> {
            PreparedStatement ps=conn.prepareStatement(sql, new String[]{"id"});
            ps.setString(1,"Anun");
            ps.setDate(2, (java.sql.Date) new Date());
            return ps;
        });


    }
}
