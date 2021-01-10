package com.adfolks.modern.demo.pa.controller;


import com.adfolks.modern.demo.pa.service.ProductConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ProductAvailability {
    @Autowired
    ProductConsumer productConsumer;

    @GetMapping(value = {"/product-availability/{id}","/product-availability/"})
    public ResponseEntity<?> getProduct(@PathVariable(required = false, name = "id") Integer id) {
        if (id != null) {
            return ResponseEntity.ok(new HashMap<Integer,Integer>(){{
                put(id,productConsumer.getDataStore().get(id));
            }});
        } else {
            return ResponseEntity.ok(productConsumer.getDataStore());
        }
    }
}
