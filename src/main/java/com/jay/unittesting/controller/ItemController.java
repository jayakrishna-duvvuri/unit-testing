package com.jay.unittesting.controller;

import com.jay.unittesting.business.ItemBusinessService;
import com.jay.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "name", 25, 20);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return businessService.retrieveHardCodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems(){
        return businessService.retrieveAllItems();
    }
}
