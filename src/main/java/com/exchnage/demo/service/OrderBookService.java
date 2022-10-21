package com.exchnage.demo.service;

import com.exchnage.demo.models.OrderBook;
import com.exchnage.demo.repository.OrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBookService {
    @Autowired
    OrderBookRepository orderBookRepository;

    public void saveAndUpdateOrderBook(OrderBook book){
        this.orderBookRepository.save(book);
    }

//    public String bestBidPrice(){
//        OrderBook orderBook;
//
//    }
}
