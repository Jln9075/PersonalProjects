package com.techelevator.services;

import com.techelevator.dao.CartDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Authority;
import com.techelevator.model.CartItem;
import com.techelevator.model.User;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;

@Component
public class CartServices {
    UserDao userDao;
    CartDao cartDao;


    public CartServices(UserDao userDao, CartDao cartDao){
        this.userDao = userDao;
        this.cartDao = cartDao;
    }

    public int getuserId(Principal principal){
        return userDao.findIdByUsername(principal.getName());
    }

    public List<CartItem> getCartService(int userId) {

        return cartDao.getCart(userId);

    }
}
