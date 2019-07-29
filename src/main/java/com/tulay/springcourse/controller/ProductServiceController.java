package com.tulay.springcourse.controller;


import com.tulay.springcourse.component.ProductNotFoundException;
import com.tulay.springcourse.entitiy.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
public class ProductServiceController {

    private static Map<String, Product> producRepo= new HashMap<>();
    static {
        Product honey= new Product();
        honey.setId("1");
        honey.setName("Honey");
        producRepo.put(honey.getId(),honey);

        Product almond= new Product();
        almond.setId("2");
        almond.setName("Almond");
        producRepo.put(almond.getId(),almond);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        producRepo.remove(id);

        return  new ResponseEntity<>(producRepo.values(),HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
       if(!producRepo.containsKey(id)) throw new ProductNotFoundException();

        producRepo.remove(id);
        producRepo.put(id,product);
        return new ResponseEntity<>("product updated", HttpStatus.OK);
    }
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        producRepo.put(product.getId(),product);
        return new ResponseEntity<>("product created", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(producRepo.values(), HttpStatus.OK);

    }


}
