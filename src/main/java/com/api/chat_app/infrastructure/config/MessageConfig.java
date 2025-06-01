package com.api.chat_app.infrastructure.config;

import com.api.chat_app.application.dto.request.messaging.SendMessageRequest;
import com.api.chat_app.application.use_cases.messaging.SendMessageUseCase;
import com.api.chat_app.domain.interfaces.service.ChatService;
import com.api.chat_app.domain.interfaces.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    @Bean
    public SendMessageUseCase sendMessageUseCase(
            ChatService chatService,
            MessageService<SendMessageRequest> messageService){
        return new SendMessageUseCase(chatService, messageService);

    }
}
