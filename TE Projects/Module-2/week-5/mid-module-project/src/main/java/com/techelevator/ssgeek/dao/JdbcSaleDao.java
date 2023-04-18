package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcSaleDao implements SaleDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcSaleDao(DataSource dataSource){ this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public Sale getSale(int saleId) {
        Sale sale = null;
// TODO Runs an  error when listing sales for a customer
        String  sqlGetSale = "SELECT sale_id, customer_id, sale_date, ship_date FROM sale WHERE sale_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetSale, saleId);
        if(results.next()){
            sale = mapRowToSale(results);
        }

        return sale;
    }

    @Override
    public List<Sale> getSalesUnshipped() {
        return null;
    }

    @Override
    public List<Sale> getSalesByCustomerId(int customerId) {
        return null;
    }

    @Override
    public List<Sale> getSalesByProductId(int productId) {
        List<Sale> allSalesByProductId = new ArrayList<>();
        Sale holdingSale;

        String sqlSelectSalesByProductId = "SELECT sale.sale_id, customer_id, sale_date, ship_date FROM sale JOIN line_item ON line_item.sale_id = sale.sale_id WHERE product_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectSalesByProductId, productId);

        while (results.next()){
            holdingSale = mapRowToSale(results);
            allSalesByProductId.add(holdingSale);
        }

        return allSalesByProductId;
    }

    @Override
    public Sale createSale(Sale newSale) {
        Sale sale = new Sale();
        String sqlInsertSale = "INSERT INTO sale (sale_id, customer_id, sale_date, ship_date) VALUES (?, ?, ?, ?)";
        String sqlReturnSale = "SELECT sale_id, customer_id, sale_date, ship_date FROM sale WHERE sale_id = ?";

        jdbcTemplate.update(sqlInsertSale, newSale.getSaleId(), newSale.getCustomerId(), newSale.getSaleDate(), newSale.getShipDate());
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlReturnSale, newSale.getSaleId());
        if(results.next()) {
            sale = mapRowToSale(results);
        }
        return sale;
    }

    @Override
    public void updateSale(Sale updatedSale) {

        String sqlUpdateSale = "UPDATE sale SET sale_id=?, customer_id=?, sale_date=?, ship_date=? WHERE sale_id = ?;";

        jdbcTemplate.update(sqlUpdateSale, updatedSale.getSaleId(), updatedSale.getCustomerId(),
                updatedSale.getSaleDate(), updatedSale.getShipDate(), updatedSale.getSaleId());
    }

    @Override
    public void deleteSale(int saleId) {

        String sqlDeleteSale = "DELETE FROM sale WHERE sale_id = ?";

        jdbcTemplate.update(sqlDeleteSale, saleId);
    }

    public Sale mapRowToSale(SqlRowSet results){
     Sale sale = new Sale();

     sale.setSaleId(results.getInt("sale_id"));
     sale.setCustomerId(results.getInt("customer_id"));
     if(results.getDate("sale_date") != null) {
         sale.setSaleDate(results.getDate("sale_date").toLocalDate());
     }
     if(results.getDate("ship_date") != null) {
         sale.setShipDate(results.getDate("ship_date").toLocalDate());
     }
     return sale;
    }
}
