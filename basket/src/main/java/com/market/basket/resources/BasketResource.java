package com.market.basket.resources;

import com.market.basket.model.BasketItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class BasketResource {

    @GetMapping("/{userId}")
    public List<BasketItem> getBasketItem(@PathVariable("userId") String userId) {
        BasketItem basketItem = new BasketItem().builder().name("Fork").description("Description").rating(2).build();
        return Collections.singletonList(basketItem);
    }
}
