package com.market.basket.services.ratingService;

import com.market.basket.model.BasketItem;
import com.market.basket.model.ItemRating;
import com.market.basket.model.UserItemRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@Service
public class RatingService {

    private WebClient.Builder webClientBuilder;

    @Autowired
    public RatingService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @HystrixCommand(fallbackMethod = "getFallBackUserRating",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public UserItemRating getUserRating(String userId) {
        return webClientBuilder.build()
                .get()
                .uri("http://item-rating-service/ratingsItems/users/" + userId)
                .retrieve()
                .bodyToMono(UserItemRating.class)
                .block();
    }

    private UserItemRating getFallBackUserRating(String userId) {
        ItemRating itemRating = new ItemRating().builder().itemId("Fallback-Item").rating(1).build();
        UserItemRating userItemRating = new UserItemRating().builder().userItemRating(Arrays.asList(itemRating)).build();
        return userItemRating;
    }
}
