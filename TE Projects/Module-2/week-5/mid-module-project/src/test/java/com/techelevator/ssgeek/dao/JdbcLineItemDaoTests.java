package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import com.techelevator.ssgeek.model.LineItem;

public class JdbcLineItemDaoTests {

    private static final Customer CUSTOMER_1 = new Customer(1, "Customer 1", "Addr 1-1", "Addr 1-2", "City 1", "S1", "11111");
    private static final Customer CUSTOMER_2 = new Customer(2, "Customer 2", "Addr 2-1", "Addr 2-2", "City 2", "S2", "22222");
    private static final Customer CUSTOMER_3 = new Customer(3, "Customer 3", "Addr 3-1",       null, "City 3", "S3", "33333");
    private static final Customer CUSTOMER_4 = new Customer(4, "Customer 4", "Addr 4-1",       null, "City 4", "S4", "44444");

    //private static final LineItem LINE_ITEM_1 = new LineItem(1, 1, 4, 10);
}
