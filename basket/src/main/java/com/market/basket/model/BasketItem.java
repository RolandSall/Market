package com.market.basket.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BasketItem {
    private String name;
    private String description;
    private double rating;
}
