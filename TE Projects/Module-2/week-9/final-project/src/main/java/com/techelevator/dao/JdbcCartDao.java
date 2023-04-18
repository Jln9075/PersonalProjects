package com.techelevator.dao;

import com.techelevator.model.CartItem;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCartDao implements CartDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcCartDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CartItem> getCart(int userId) {
        List<CartItem> cartItems = new ArrayList<>();
        String sql = "SELECT * FROM cart_item WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            CartItem cartItem = mapRowToCartItem(results);
            cartItems.add(cartItem);
        }

        return cartItems;
    }


    @Override
    public boolean addItem(CartItem cartItem, Principal principal) {
        boolean wasItemAdded = false;

        String sql = "INSERT INTO cart_item(cart_item_id, user_id, product_id, quantity) VALUES (?, ?, ?, ?);";


            jdbcTemplate.update(sql, cartItem.getCartItemId(), cartItem.getUserId(), cartItem.getProductId(), cartItem.getQuantity());
            wasItemAdded = true;



        return wasItemAdded;

    }

    @Override
    public boolean deleteItem(int itemId) {
        boolean wasItemDeleted = false;

        return wasItemDeleted;
    }

    @Override
    public boolean clearCart() {
        boolean wasCartCleared = false;

        return  wasCartCleared;
    }

    public CartItem mapRowToCartItem(SqlRowSet results){
        CartItem cartItem = new CartItem();

        cartItem.setCartItemId(results.getInt("cart_item_id"));
        cartItem.setUserId(results.getInt("user_id"));
        cartItem.setProductId(results.getInt("product_id"));
        cartItem.setQuantity(results.getInt("quantity"));

        return cartItem;
    }
}
