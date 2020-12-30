package com.market.basket.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserItemRating {
    private List<ItemRating> userItemRating;
}
