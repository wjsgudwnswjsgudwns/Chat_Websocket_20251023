package com.jhj.vue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public abstract class WebSocketConfig implements WebSocketConfigurer{

	@Autowired
	private ChatHandler chatHandler;
	
	//WebSocket 핸들러 등록 메소드
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(chatHandler, "/ws/chat")
			.setAllowedOrigins("*"); // 모든 도메인(*)에서 들어오는 요청 허용
		
	}

	
}
