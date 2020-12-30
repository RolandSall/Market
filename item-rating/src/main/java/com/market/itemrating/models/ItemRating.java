package com.market.itemrating.models;

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
