package org.example.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcRecipeDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcRecipeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public
//    public Customer getCustomer(int customerId) {
//        Customer customer = null;
//        String sql = "SELECT customer_id, name, street_address1, street_address2, city, state, zip_code " +
//                "FROM customer " +
//                "WHERE customer_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
//        if (results.next()) {
//            customer = mapRowToCustomer(results);
//        }
//        return customer;
//    }
}
