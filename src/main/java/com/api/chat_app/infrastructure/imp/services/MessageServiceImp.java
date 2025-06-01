package com.api.chat_app.infrastructure.imp.services;

import com.api.chat_app.application.dto.request.messaging.SendMessageRequest;
import com.api.chat_app.domain.entity.Message;
import com.api.chat_app.domain.interfaces.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp implements MessageService<SendMessageRequest> {

    @Override
    public Message createMessage(SendMessageRequest message) {
        return null;
    }

    @Override
    public Message addMessage(SendMessageRequest message) {
        return null;
    }
}
