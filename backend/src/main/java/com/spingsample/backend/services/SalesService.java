package com.spingsample.backend.services;

import com.spingsample.backend.model.Sales;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalesService {
    List<Sales> getAllItems();

    Sales newItem( Sales newItem);

    Sales getItembyId( Long id);

    Sales updateItem(Sales newItem, Long id);

    String deleteItem( Long id);
}
