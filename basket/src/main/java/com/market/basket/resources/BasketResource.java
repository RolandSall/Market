package com.market.basket.resources;

import com.market.basket.model.BasketItem;
import com.market.basket.model.Item;
import com.market.basket.model.ItemRating;
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

    private WebClient.Builder webClientBuilder;

    @Autowired
    public BasketResource(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/{userId}")
    public List<BasketItem> getBasketItem(@PathVariable("userId") String userId) {


        List<ItemRating> ratings = Arrays.asList(
                new ItemRating().builder().itemId("12").rating(5).build(),
                new ItemRating().builder().itemId("1234").rating(2).build()
        );

        return ratings.stream().map(itemRating -> {
                    Item item = webClientBuilder.build()
                            .get()
                            .uri("http://localhost:8083/items/" + itemRating.getItemId())
                            .retrieve()
                            .bodyToMono(Item.class)
                            .block();
                    return new BasketItem(item.getName(), "Desc", itemRating.getRating());
                }
        ).collect(Collectors.toList());
    }
}
