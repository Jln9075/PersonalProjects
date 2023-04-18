package com.techelevator.controller;

import com.techelevator.dao.CartDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.CartItem;
import com.techelevator.model.User;
import com.techelevator.services.CartServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/cart")
public class CartController {

    private  CartServices cart;

    public CartController(CartServices cartServices){
        this.cart = cartServices;
    }

   @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CartItem> getCart(Principal principal) {
        int userId;
        userId = cart.getuserId(principal);


        return cart.getCartService(userId);
   }


}
