package io.khasang.restaurant.model;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dog {

    private JdbcTemplate jdbcTemplate;
    private String DOG_ID_COLUMN = "id";
    private String DOG_NAME_COLUMN = "name";
    private String DOG_BREED_COLUMN = "breed";

    public Dog() {
    }

    public Dog(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createDogTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS dogs");
        jdbcTemplate.execute("CREATE TABLE dogs(\n" +
                DOG_ID_COLUMN + " INTEGER PRIMARY KEY, \n" +
                DOG_NAME_COLUMN + " VARCHAR (255) NOT NULL, \n" +
                DOG_BREED_COLUMN + " VARCHAR (255) NULL);"
        );
        jdbcTemplate.execute("CREATE SEQUENCE dogs_id_seq;");
        jdbcTemplate.execute("ALTER TABLE dogs\n" +
                "ALTER COLUMN id\n" +
                "SET DEFAULT NEXTVAL('dogs_id_seq');");
        return "table dogs created";
    }

    public String insertDogTable(String name, String breed) {
        String insertQuery = "INSERT INTO dogs (" + DOG_NAME_COLUMN + ", " + DOG_BREED_COLUMN + ") VALUES (?, ?);";
        jdbcTemplate.execute(insertQuery, new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, breed);
                return preparedStatement.execute();
            }
        });
        return "dog inserted";
    }


}
