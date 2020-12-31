package com.market.basket.resources;

import com.market.basket.model.BasketItem;
import com.market.basket.model.Item;
import com.market.basket.model.ItemRating;
import com.market.basket.model.UserItemRating;
import com.market.basket.services.basketService.BasketService;
import com.market.basket.services.ratingService.RatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BasketResource {

    private BasketService basketService;
    private RatingService ratingService;

    @Autowired
    public BasketResource(BasketService basketService, RatingService ratingService) {
        this.basketService = basketService;
        this.ratingService = ratingService;
    }

    @GetMapping("/{userId}")
    public List<BasketItem> getBasketItem(@PathVariable("userId") String userId) {
        UserItemRating ratingsList = ratingService.getUserRating(userId);
        return ratingsList.getUserItemRating().stream().map(itemRating -> basketService.getBasketItem(itemRating)).collect(Collectors.toList());
    }
}
