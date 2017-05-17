package io.khasang.restaurant.config;

import io.khasang.restaurant.dao.DocumentDao;
import io.khasang.restaurant.dao.impl.DocumentDaoImpl;
import io.khasang.restaurant.entity.Document;
import io.khasang.restaurant.model.Cat;
import io.khasang.restaurant.model.Dog;
import io.khasang.restaurant.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
@Configuration
@PropertySource(value = {"classpath:util.properties"})
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DocumentDao documentDao() {
        return new DocumentDaoImpl(Document.class);
    }

    @Bean
    public UserDetailsService userDetailsService(){
        JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
        jdbcImpl.setDataSource(jdbcDataSource());
        jdbcImpl.setUsersByUsernameQuery("");
        jdbcImpl.setAuthoritiesByUsernameQuery("");
        return jdbcImpl;
    }

    @Bean
    DriverManagerDataSource jdbcDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driver"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(jdbcDataSource());
        return jdbcTemplate;
    }

    @Bean
    public Cat cat(){
        return new Cat(jdbcTemplate());
    }

    @Bean
    public Dog dog(){
        return new Dog(jdbcTemplate());
    }


    @Bean
    public Message message() {
        return new Message("hello bean!");
    }

}
