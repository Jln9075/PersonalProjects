package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import com.techelevator.ssgeek.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDaoTests extends BaseDaoTests {

    private static final Product PRODUCT_1 = new Product(1, "Product 1", "Description 1", BigDecimal.valueOf(9.99), "product-1.png" );
    private static final Product PRODUCT_2 = new Product(2, "Product 2", "Description 2", BigDecimal.valueOf(19.00), "product-2.png" );
    private static final Product PRODUCT_3 = new Product(3, "Product 3", "Description 3", BigDecimal.valueOf(123.45), "product-3.png" );
    private static final Product PRODUCT_4 = new Product(4, "Product 4", "Description 4", BigDecimal.valueOf(0.99), "product-4.png" );

    private JdbcProductDao productDao;
    private Product testProduct;

    @Before
    public void setup() {
        productDao = new JdbcProductDao(dataSource);
        testProduct = new Product(5, "Test Product", "Description 0", BigDecimal.valueOf(1.01), "product-0.png");
    }

    @Test
    public void getProduct_returns_product_by_Id(){
        //Arrange
        Product getProductTest;

        //Act
        getProductTest = productDao.getProduct(1);

        //Assert
        assertProductsMatch("getProduct", getProductTest, PRODUCT_1);

    }

    @Test
    public void getProduct_returns_null_with_inaccurate_product_id(){

        //Arrange
        Product nullTest;

        //Act
        nullTest = productDao.getProduct(-1);

        //Assert
        Assert.assertNull(nullTest);

    }

    @Test
    public void getProducts_returns_all_products_by_id(){

        //Arrange
        List<Product> allProducts = new ArrayList<>();

        //Act
        allProducts = productDao.getProducts();

        //Assert
        Assert.assertEquals("getProducts returns a List of incorrect size", 4, allProducts.size());

        assertProductsMatch("getProducts", PRODUCT_1, allProducts.get(0));
        assertProductsMatch("getProducts returns a list with incorrect or wrongly ordered data", PRODUCT_4, allProducts.get(3));

    }

    @Test
    public void getProductsWithNoSales_returns_all_products_with_no_sales(){
        //Arrange
        List<Product> productsWithNoSales = new ArrayList<>();

        //Act
        productsWithNoSales = productDao.getProductsWithNoSales();

        //Assert
        Assert.assertEquals("getProductsWithNoSales returns a List of incorrect size", 1, productsWithNoSales.size());

        assertProductsMatch("getProductsWithNoSales", PRODUCT_3, productsWithNoSales.get(0));
    }

    @Test
    public void createProduct_creates_product_with_correct_values(){
        //Arrange
        Product newProduct = null;
        //Act
        newProduct = productDao.createProduct(testProduct);

        //Assert
        assertProductsMatch("createProduct", testProduct, newProduct);

    }

    @Test
    public void updateProduct_updates_product_with_new_values(){
        //Arrange
        Product updatedProductTwo = new Product(2, "Testing Name", "Testing Description", BigDecimal.valueOf(30.01), "product-2.test");

        //Act
        productDao.updateProduct(updatedProductTwo);

        //Assert
        assertProductsMatch("updateProduct", updatedProductTwo, productDao.getProduct(2));
    }

    @Test
    public void deleteProduct_removes_product_from_database(){
        //Arrange

        //Act
        productDao.deleteProduct(3);

        //Assert
        Assert.assertNull(productDao.getProduct(3));
    }

    public void assertProductsMatch(String messagePrefix, Product expected, Product actual){
        String message = messagePrefix + ": Unexpected data in field '%s'. ";

        Assert.assertEquals(String.format(message, "product_id"), expected.getProductId(), actual.getProductId());
        Assert.assertEquals(String.format(message, "name"), expected.getName(), actual.getName());
        Assert.assertEquals(String.format(message, "description"), expected.getDescription(), actual.getDescription());
        Assert.assertEquals(String.format(message, "price"), expected.getPrice(), actual.getPrice());
        Assert.assertEquals(String.format(message, "imageName"), expected.getImageName(), actual.getImageName());

    }
}
