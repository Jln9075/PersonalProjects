package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.dao.JdbcRecipeDao;

public class    Main {
    public static void main(String[] args) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/SSGeek");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Jln!651488");

        JdbcRecipeDao jdbcRecipeDao = new JdbcRecipeDao(dataSource);
    }
}