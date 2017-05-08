package io.khasang.restaurant.model;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cat {

    private JdbcTemplate jdbcTemplate;

    public Cat() {
    }

    public Cat(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createCatTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
        jdbcTemplate.execute("CREATE TABLE cats(\n" +
                "id INTEGER CONSTRAINT firstkey PRIMARY KEY, \n" +
                "name VARCHAR (255) NOT NULL);");

        jdbcTemplate.execute("create SEQUENCE IF NOT EXISTS cats_seq");

        jdbcTemplate.execute("insert into cats (id, name) values (nextval('cats_seq'), 'TOM')");
        jdbcTemplate.execute("insert into cats (id, name) values (nextval('cats_seq'), ?)",
                new PreparedStatementCallback<Boolean>() {
                    @Override
                    public Boolean doInPreparedStatement(PreparedStatement ps)
                            throws SQLException, DataAccessException {
                        ps.setString(1, "Murcis");
                        return ps.execute();

                    }
                });
        return "table created";

    }
}
