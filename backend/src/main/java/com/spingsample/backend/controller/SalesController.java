package com.spingsample.backend.controller;

import com.spingsample.backend.exception.ItemNotFoundException;
import com.spingsample.backend.model.Sales;
import com.spingsample.backend.repository.ItemRepository;
import com.spingsample.backend.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController {

    // autowiring is not recommended
//    @Autowired
//    private ItemRepository itemRepository;

    private final SalesService salesService;

    // this is constructor injection - the recommended approach
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }










}
