package com.market.itemsinfo.resources;

import com.market.itemsinfo.models.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemResource {

    @GetMapping("/{itemId}")
    public Item getItemInfo(@PathVariable("itemId") String itemId){
        return new Item().builder().itemId(itemId).name("Test Name").build();
    }
}
