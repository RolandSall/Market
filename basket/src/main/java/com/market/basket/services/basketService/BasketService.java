package com.market.basket.services.basketService;

import com.market.basket.model.BasketItem;
import com.market.basket.model.Item;
import com.market.basket.model.ItemRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "getFallBackBasketItem",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            }
    )
    public BasketItem getBasketItem(ItemRating itemRating) {
        Item item = webClientBuilder.build()
                .get()
                .uri("http://items-info-service/items/" + itemRating.getItemId())
                .retrieve()
                .bodyToMono(Item.class)
                .block();
        return new BasketItem(item.getName(), "Desc", itemRating.getRating());
    }


    private BasketItem getFallBackBasketItem(ItemRating itemRating) {
        return new BasketItem().builder().description("desc-Fallback").name("fallback").rating(0).build();
    }

}
