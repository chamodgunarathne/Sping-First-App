package com.spingsample.backend.controller;

import com.spingsample.backend.exception.ItemNotFoundException;
import com.spingsample.backend.model.Sales;
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

    @GetMapping("/item/{id}")
    Sales getItembyId(@PathVariable Long id){
        return itemRepository.findById(id)
                .orElseThrow(()->new ItemNotFoundException(id));
    }

    @PutMapping("/itemUpdate/{id}")
    Sales updateItem(@RequestBody Sales newItem, @PathVariable Long id){
        return itemRepository.findById(id)
                .map(item -> {
                    item.setName((newItem.getName()));
                    item.setSales(newItem.getSales());
                    item.setPrice(newItem.getPrice());
                    return itemRepository.save(item);
                }).orElseThrow(()-> new ItemNotFoundException(id));
    }

    @DeleteMapping("/itemDelete/{id}")
    String deleteItem(@PathVariable Long id){
        if(!itemRepository.existsById(id)){
            throw new ItemNotFoundException(id);
        }
        itemRepository.deleteById(id);
        return "Item with id " + id+ " has been deleted";
    }
}
