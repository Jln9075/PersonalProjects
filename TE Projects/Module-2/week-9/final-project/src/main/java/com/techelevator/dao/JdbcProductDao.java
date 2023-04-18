package com.techelevator.dao;

import com.techelevator.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Product product = mapRowToProduct(results);
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getByName(String productName) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name LIKE ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + productName + "%");
        while (results.next()) {
            Product product = mapRowToProduct(results);
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getBySku(String sku) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product_sku LIKE ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + sku + "%");
        while (results.next()) {
            Product product = mapRowToProduct(results);
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getProductDetail(int productId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);
        while (results.next()){
            Product product = mapRowToProduct(results);
            products.add(product);
        }

        return products;
    }


    public Product mapRowToProduct(SqlRowSet results) {
        Product product = new Product();

        product.setProductId(results.getInt("product_id"));
        product.setProductSku(results.getString("product_sku"));
        product.setName(results.getString("name"));
        product.setDescription(results.getString("description"));
        product.setPrice(results.getDouble("price"));
        product.setImageName(results.getString("image_name"));

        return product;
    }
}

