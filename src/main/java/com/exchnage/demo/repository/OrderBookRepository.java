package com.exchnage.demo.repository;

import com.exchnage.demo.models.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook,String> {
    public OrderBook findBySymbol(String symbol);
}
