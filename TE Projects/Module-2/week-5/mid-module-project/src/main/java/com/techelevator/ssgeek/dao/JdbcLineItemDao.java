package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.LineItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcLineItemDao implements LineItemDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcLineItemDao(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}


    @Override
    public List<LineItem> getLineItemsBySale(int saleId){
        List<LineItem> lineItemsBySale = new ArrayList<>();
        LineItem lineItem = null;

        String sql = "SELECT line_item_id, sale_id, product_id, quantity FROM line_item WHERE saleId = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, saleId);

        while(results.next()){
            lineItem = mapRowToLineItem(results);
            lineItemsBySale.add(lineItem);
        }

        return lineItemsBySale;
    }

    public LineItem mapRowToLineItem(SqlRowSet results){
        LineItem lineItem = new LineItem();

        lineItem.setLineItemId(results.getInt("line_item_id"));
        lineItem.setSaleId(results.getInt("sale_id"));
        lineItem.setProductId(results.getInt("product_id"));
        lineItem.setQuantity(results.getInt("quantity"));

        return lineItem;

    }
}
