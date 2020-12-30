package com.market.itemsinfo.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Item {
    private String itemId;
    private String name;
}
