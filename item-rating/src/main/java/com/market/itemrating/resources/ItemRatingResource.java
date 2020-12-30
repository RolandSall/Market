package com.market.itemrating.resources;

import com.market.itemrating.models.ItemRating;
import com.market.itemrating.models.UserItemRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsItems")
public class ItemRatingResource {


    @GetMapping("/{itemId}")
    public ItemRating getItemRatingById(@PathVariable("itemId") String itemId){
        return new ItemRating().builder().itemId(itemId).rating(4).build();
    }

    @GetMapping("/users/{userId}")
    public UserItemRating getUserRating(@PathVariable("userId") String userId){
        List<ItemRating> itemRatingListPerUser = Arrays.asList(
                new ItemRating().builder().itemId("12").rating(5).build(),
                new ItemRating().builder().itemId("1234").rating(2).build()
        );
        UserItemRating userItemRating = new UserItemRating().builder().userItemRating(itemRatingListPerUser).build();
        return userItemRating;
    }
}
