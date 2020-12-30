package com.market.basket.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ItemRating {
    private String itemId;
    private double rating;
}
