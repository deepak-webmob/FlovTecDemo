package com.exchnage.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderBookResponse {

    @JsonProperty("data")
    private List<OrderBook> data;

    @JsonProperty("table")
    private String table;
}
