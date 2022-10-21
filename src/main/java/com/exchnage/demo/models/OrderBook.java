package com.exchnage.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@ToString
public class OrderBook {
    @Id
    @JsonProperty("symbol")
    private  String symbol;

    @JsonProperty("ms_t")
    @Column
    private  String ms_t;

    @JsonProperty("bids")
    @Column
    private  List<List<String>>  bids;

    @JsonProperty("asks")
    @Column
    private  List<List<String>>  asks;
}
