package com.market.basket.services.basketService;

import com.market.basket.model.BasketItem;
import com.market.basket.model.Item;
import com.market.basket.model.ItemRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BasketService {

    private WebClient.Builder webClientBuilder;

    @Autowired
    public BasketService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @HystrixCommand(fallbackMethod = "getFallBackBasketItem")
    public BasketItem getBasketItem(ItemRating itemRating) {
        Item item = webClientBuilder.build()
                .get()
                .uri("http://items-info-service/items/" + itemRating.getItemId())
                .retrieve()
                .bodyToMono(Item.class)
                .block();
        return new BasketItem(item.getName(), "Desc", itemRating.getRating());
    }


    private BasketItem getFallBackBasketItem(ItemRating itemRating){
        return new BasketItem().builder().description("desc-Fallback").name("fallback").rating(0).build();
    }

}
