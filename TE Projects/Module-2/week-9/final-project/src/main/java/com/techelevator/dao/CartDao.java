package com.techelevator.dao;

import com.techelevator.model.CartItem;
import com.techelevator.model.Product;

import java.security.Principal;
import java.util.List;

public interface CartDao {

    List<CartItem> getCart(int userId);

    boolean addItem(CartItem cartItem, Principal principal);

    boolean deleteItem(int itemId);

    boolean clearCart();

}
