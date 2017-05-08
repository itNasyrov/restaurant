package io.khasang.restaurant.model;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Cat {
    private int id;
    private String name;
    private JdbcTemplate jdbcTemplate;

    public Cat() {
    }

    public Cat(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String createCatTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
        jdbcTemplate.execute("CREATE TABLE cats(\n" +
                "id INTEGER CONSTRAINT firstkey PRIMARY KEY, \n" +
                "name VARCHAR (255) NOT NULL);");
        return "table created";
    }

    public String updateCatTable(int updatedId) {
        String query = "UPDATE cats SET name='Richard IV' WHERE id=?";
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement updateCats = con.prepareStatement(query);
                updateCats.setInt(1, updatedId);
                return updateCats;
            }
        };
        int k = jdbcTemplate.update(creator);
        return "Rows updated = " + k;
    }

    public String insertCatToTable(Cat cat){
        String query = "INSERT INTO cats VALUES(?, ?)";
        Boolean isFail = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                ps.setInt(1, cat.getId());
                ps.setString(2, cat.getName());
                return ps.execute();
            }
        });
        return isFail ? "Sorry, the record is not inserted." : "The record inserted successfully.";
    }

    public String deleteFromTable(int deletedId){
        String query = "DELETE FROM cats WHERE id=?";
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement deleteCats = con.prepareStatement(query);
                deleteCats.setInt(1, deletedId);
                return deleteCats;
            }
        };
        int k = jdbcTemplate.update(creator);
        return "Rows deleted = " + k;
    }

    public List<Cat> findAll(){
        String sql = "SELECT name FROM cats ORDER BY name DESC";
        List<Cat> cats  = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Cat.class));
        return cats;
    }
}
