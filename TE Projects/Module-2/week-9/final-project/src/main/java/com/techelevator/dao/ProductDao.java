package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getAll();

    List<Product> getByName(String productName);

    List<Product> getBySku(String sku);

    List<Product> getProductDetail(int productId);


}
