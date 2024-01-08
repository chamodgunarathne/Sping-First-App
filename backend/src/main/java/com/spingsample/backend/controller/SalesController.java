package com.spingsample.backend.controller;

import com.spingsample.backend.exception.ItemNotFoundException;
import com.spingsample.backend.model.Sales;
import com.spingsample.backend.repository.ItemRepository;
import com.spingsample.backend.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class SalesController {

    // autowiring is not recommended
//    @Autowired
//    private ItemRepository itemRepository;

    private final SalesService salesService;

    // this is constructor injection - the recommended approach
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Sales>> getAllItems() {
        List<Sales> items = salesService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping("/item")
    public ResponseEntity<Sales> newItem(@RequestBody Sales newItem) {
        Sales createdItem = salesService.newItem(newItem);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Sales> getItemById(@PathVariable Long id) {
        Sales item = salesService.getItembyId(id);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<Sales> updateItem(@RequestBody Sales newItem, @PathVariable Long id) {
        Sales updatedItem = salesService.updateItem(newItem, id);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/itemDel/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        String result = salesService.deleteItem(id);
        return ResponseEntity.ok(result);
    }










}
