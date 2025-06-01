package com.api.chat_app.domain.interfaces.service;

import com.api.chat_app.domain.entity.Message;

public interface MessageService <TMessageRequest> {
    Message createMessage(TMessageRequest message);
    Message addMessage(TMessageRequest message);
}
