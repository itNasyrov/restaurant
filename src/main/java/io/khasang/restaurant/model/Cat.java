package io.khasang.restaurant.model;

import org.springframework.jdbc.core.JdbcTemplate;

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
        return "table created";
    }

    public String addCatTable(){
        jdbcTemplate.execute("INSERT INTO cats VALUES (1, 'Vaska')");
        return "add cat";
    }

    public String deleteCatTable() {
        jdbcTemplate.execute("DELETE FROM cats");
        return "table deleted";
    }

    public String updateCatTable() {
        jdbcTemplate.execute("UPDATE cats SET name = 'Barsik'");
        return "table updated";
    }
}
