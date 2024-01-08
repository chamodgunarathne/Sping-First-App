package com.spingsample.backend.services.impl;

import com.spingsample.backend.exception.ItemNotFoundException;
import com.spingsample.backend.model.Sales;
import com.spingsample.backend.repository.ItemRepository;
import com.spingsample.backend.services.SalesService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor // by using this annotation we do not need to add the constructor like we did in the controller
public class SalesServiceImpl implements SalesService {

    private final ItemRepository itemRepository;

    // you can do the same as the controller to use the constructor injection

    // but no need to do it because of the @RequiredArgsContructor annotation

//    public SalesServiceImpl(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    @Override
    @GetMapping("/items")
    public List<Sales> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    @PostMapping("/item")
    public Sales newItem(@RequestBody Sales newItem){
        return itemRepository.save(newItem);
    }

    @Override
    @GetMapping("/item/{id}")
    public Sales getItembyId(@PathVariable Long id){
        return itemRepository.findById(id)
                .orElseThrow(()->new ItemNotFoundException(id));
    }

    @Override
    @PutMapping("/itemUpdate/{id}")
    public Sales updateItem(@RequestBody Sales newItem, @PathVariable Long id){
        return itemRepository.findById(id)
                .map(item -> {
                    item.setName((newItem.getName()));
                    item.setSales(newItem.getSales());
                    item.setPrice(newItem.getPrice());
                    return itemRepository.save(item);
                }).orElseThrow(()-> new ItemNotFoundException(id));
    }

    @Override
    @DeleteMapping("/itemDelete/{id}")
    public String deleteItem(@PathVariable Long id){
        if(!itemRepository.existsById(id)){
            throw new ItemNotFoundException(id);
        }
        itemRepository.deleteById(id);     return "Item with id " + id+ " has been deleted";
    }
}
