package com.market.itemrating.models;

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
