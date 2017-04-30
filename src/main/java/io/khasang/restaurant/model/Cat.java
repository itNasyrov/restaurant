package io.khasang.restaurant.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class Cat {

    private JdbcTemplate jdbcTemplate;

    public Cat(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Cat() {
    }

    public String createCatTable(){
        jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
        jdbcTemplate.execute("CREATE TABLE cats(\n" +
                "id INTEGER CONSTRAINT firstkey PRIMARY KEY, \n" +
                "name VARCHAR (255) NOT NULL);");
        return "first table created";
    }
}
