package com.exchnage.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URISyntaxException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws URISyntaxException, InterruptedException {

		SpringApplication.run(DemoApplication.class, args);
//		final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("wss://ws-feed.exchange.coinbase.com"));
//		clientEndPoint.addMessageHandler(message -> System.out.println("my meesage==."+message));
//
//		clientEndPoint.sendMessage("{\"type\":\"subscribe\",\"channels\":[{\"name\":\"heartbeat\",\"product_ids\":[\"BTC-USD\"]}]}");
//
//		clientEndPoint.sendMessage("{\"type\":\"subscribe\",\"product_ids\":[\"BTC-USD\"],\"channels\":[\"ticker\"]}");



	}

}
