package com.exchnage.demo.client;

import com.exchnage.demo.models.OrderBook;
import com.exchnage.demo.models.OrderBookResponse;
import com.exchnage.demo.service.OrderBookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;

import java.util.List;

@Service
public class WebsocketHandler implements WebSocketHandler {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    OrderBookService orderBookService;


    @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("===============??222");
        session.sendMessage(new TextMessage("{\"op\":\"subscribe\",\"args\":[\"spot/depth50:BTC_USDT\"]}"
    ));

       // session.sendMessage(new TextMessage("{\"type\":\"subscribe\",\"product_ids\":[\"BTC-USD\"],\"channels\":[\"level2\"]}"));
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        //System.out.println(message.getPayload());
        OrderBookResponse response =  objectMapper.readValue(message.getPayload().toString(), OrderBookResponse.class);
        if(response.getTable().equals("spot/depth50") ) {
           OrderBook book =  response.getData().get(0);
           List<List<String>> bids = book.getBids();
            List<List<String>> asks = book.getAsks();
            System.out.println("Symbol ==>"+book.getAsks().toString());
          System.out.println("List of asks==>"+book.getAsks().toString());
            System.out.println("List of bids==>"+book.getAsks().toString());
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    System.out.println("Transport Error");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("Connection closed");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
