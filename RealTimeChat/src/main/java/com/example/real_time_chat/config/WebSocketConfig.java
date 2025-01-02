package com.example.real_time_chat.config;

import com.example.real_time_chat.RealTimeChatApplication; // Asegúrate de importar la clase correcta
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final RealTimeChatApplication webSocketHandler; // Inyectamos la clase WebSocketHandler desde RealTimeChatApplication

    // Constructor para inyectar RealTimeChatApplication
    public WebSocketConfig(RealTimeChatApplication webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // Usamos WebSocketHandler desde RealTimeChatApplication
        registry.addHandler(webSocketHandler, "/chat")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
