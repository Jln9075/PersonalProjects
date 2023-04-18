package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcProductDao(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public Product getProduct(int productId) {
        Product product = null;
        String sql = "SELECT product_id, name, description, price, image_name FROM product WHERE product_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);

        if(results.next()){
           product = mapRowToProduct(results);
        }

        return product;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> allProductsById = new ArrayList<>();
        Product listedProduct;

        String sql = "SELECT product_id, name, description, price, image_name FROM product ORDER BY product_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            listedProduct = mapRowToProduct(results);
            allProductsById.add(listedProduct);
        }

        return allProductsById;
    }

    @Override
    public List<Product> getProductsWithNoSales() {
        List<Product> allProductsWithNoSales = new ArrayList<>();
        Product listedProduct;

        String sqlPullProductsNoSales = "SELECT product_id, name, description, price, image_name FROM product WHERE " +
        "NOT EXISTS(SELECT product_id FROM line_item WHERE product.product_id = line_item.product_id);";
        SqlRowSet allProductsResults = jdbcTemplate.queryForRowSet(sqlPullProductsNoSales);


        while(allProductsResults.next()){
            listedProduct = mapRowToProduct(allProductsResults);
            allProductsWithNoSales.add(listedProduct);
        }

        return allProductsWithNoSales;
    }

    @Override
    public Product createProduct(Product newProduct) {
        Product product = null;

        String sqlCreateNewProduct = "INSERT INTO product(name, description, price, image_name)VALUES (?, ?, ?, ?) RETURNING product_id;";
        Integer newProductId = jdbcTemplate.queryForObject(sqlCreateNewProduct, Integer.class, newProduct.getName(), newProduct.getDescription(),
                newProduct.getPrice(), newProduct.getImageName());


        product = getProduct(newProductId);

        return product;
    }

    @Override
    public void updateProduct(Product updatedProduct) {

        String sqlUpdateProduct = "UPDATE product SET product_id=?, name=?, description=?, price=?, image_name=? WHERE product_id = ?";

        jdbcTemplate.update(sqlUpdateProduct, updatedProduct.getProductId(), updatedProduct.getName(), updatedProduct.getDescription(),
                updatedProduct.getPrice(), updatedProduct.getImageName(), updatedProduct.getProductId());

    }



    @Override
    public void deleteProduct(int productId) {
        String sqlDeleteProduct = "DELETE FROM product WHERE product_id = ?";

        jdbcTemplate.update(sqlDeleteProduct, productId);

    }

    private Product mapRowToProduct(SqlRowSet results){
        Product product = new Product();

        product.setProductId(results.getInt("product_id"));
        product.setName(results.getString("name"));
        product.setDescription(results.getString("description"));
        product.setPrice(results.getBigDecimal("price"));
        product.setImageName(results.getString("image_name"));

        return product;
    }
}
