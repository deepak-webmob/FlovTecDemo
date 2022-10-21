package com.exchnage.demo.websocketConfig;

import com.exchnage.demo.client.WebsocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Configuration
public class WebsocketConfig {

   @Autowired
   WebsocketHandler websocketClient;
   @Autowired
   TokenManager tokenManager;

   @Bean
    public WebSocketConnectionManager webSocketConnectionManager(){

       WebSocketConnectionManager connectionManager = new WebSocketConnectionManager(new StandardWebSocketClient(),websocketClient,"wss://ws-manager-compress.bitmart.com/api?protocol=1.1");
       connectionManager.setAutoStartup(true);
       return  connectionManager;
   }

}
