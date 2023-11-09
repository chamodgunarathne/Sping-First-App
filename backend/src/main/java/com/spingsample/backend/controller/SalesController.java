package com.spingsample.backend.controller;

import com.spingsample.backend.model.Sales;
import com.spingsample.backend.model.User;
import com.spingsample.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SalesController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/item")
    Sales newItem(@RequestBody Sales newItem){
        return itemRepository.save(newItem);
    }

    @GetMapping("/items")
    List<Sales> getAllItems(){
        return itemRepository.findAll();
    }
}
