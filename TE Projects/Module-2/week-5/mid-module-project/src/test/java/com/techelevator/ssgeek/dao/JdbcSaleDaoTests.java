package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcSaleDaoTests extends BaseDaoTests{

    private static final Sale SALE_1 = new Sale(1, 1,LocalDate.parse("2022-01-01"), null);
    private static final Sale SALE_2 = new Sale(2, 1, LocalDate.parse("2022-02-01"), LocalDate.parse("2022-02-02"));
    private static final Sale SALE_3 = new Sale(3, 2, LocalDate.parse("2022-03-01"), null);
    private static final Sale SALE_4 = new Sale(4, 2, LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-02"));

    private JdbcSaleDao saleDao;
    private Sale testSale;

    @Before
    public void setup(){
        saleDao = new JdbcSaleDao(dataSource);
        testSale = new Sale(5, 3, LocalDate.parse("1995-09-10"), LocalDate.parse("1997-08-15"));
    }

    @Test
    public void getSale_returns_sale_by_id(){
        //Arrange
        Sale sale;
        //Act
        sale = saleDao.getSale(1);
        //Assert

        assertSalesMatch("getSale", SALE_1, sale);
    }

    @Test
    public void getSalesByProductId_returns_List_of_sales_in_order(){
        //Arrange
        List<Sale> testingList = new ArrayList<>();

        //Act
        testingList = saleDao.getSalesByProductId(1);

        //Assert

        Assert.assertEquals("getSalesByProductId returns List of incorrect size", 3, testingList.size());

        assertSalesMatch("getSaleByProductId", SALE_1, testingList.get(0));
        assertSalesMatch("getSaleByProductId", SALE_3, testingList.get(2));

    }

    @Test
    public void createSale_creates_and_returns_new_sale(){
        //Arrange

        //Act

        //Assert

        assertSalesMatch("createSale", testSale, saleDao.createSale(testSale));
    }

    @Test
    public void updateSale_updates_sale_in_database(){
        //Arrange
        Sale updatedSale3 = new Sale(3, 2, LocalDate.parse("2022-03-01"), LocalDate.parse("2022-04-10"));

        //Act
        saleDao.updateSale(updatedSale3);

        //Assert

        assertSalesMatch("updateSale", updatedSale3, saleDao.getSale(3));
    }

    @Test
    public void deleteSale_removes_sale_from_database(){
        //Arrange

        //Act
        saleDao.deleteSale(4);
        //Assert
        Assert.assertNull("getSale returns data that is not null for deleted sale", saleDao.getSale(4));
    }

    public void assertSalesMatch(String messagePrefix, Sale expected, Sale actual){
        String message = messagePrefix + ": unexpected data in field '%s'. ";

        Assert.assertEquals(String.format(message, "sale_id"), expected.getSaleId(), actual.getSaleId());
        Assert.assertEquals(String.format(message, "customer_id"), expected.getCustomerId(), actual.getCustomerId());
        Assert.assertEquals(String.format(message, "sale_date"), expected.getSaleDate(), actual.getSaleDate());
        Assert.assertEquals(String.format(message, "ship_date"), expected.getShipDate(), actual.getShipDate());

    }
}
