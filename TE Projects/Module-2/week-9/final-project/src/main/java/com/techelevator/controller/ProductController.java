package com.techelevator.controller;

import com.techelevator.dao.JdbcProductDao;
import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("permitAll")
@RequestMapping("/products")
public class ProductController {

    private ProductDao dao;

    public ProductController(ProductDao productDao) {
        this.dao = productDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Product> list(@RequestParam(required = false) String name, @RequestParam(required = false) String sku) {

        if (name == null && sku == null) {
            return dao.getAll();
        } else if (sku != null) {
            return dao.getBySku(sku);
        } else {
            return dao.getByName(name);
        }

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> list(@PathVariable("id") int productId){
        try {
            if (productId > 0) {
                return new ResponseEntity<>(dao.getProductDetail(productId), HttpStatus.OK);
            } else{
                throw new Exception();
            }
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}


