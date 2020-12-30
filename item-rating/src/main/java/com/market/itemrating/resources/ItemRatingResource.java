package com.market.itemrating.resources;

import com.market.itemrating.models.ItemRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsItems")
public class ItemRatingResource {


    @GetMapping("/{itemId}")
    public ItemRating getItemRatingById(@PathVariable("itemId") String itemId){
        return new ItemRating().builder().itemId(itemId).rating(4).build();
    }
}
