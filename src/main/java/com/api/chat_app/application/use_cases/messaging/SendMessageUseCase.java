package com.api.chat_app.application.use_cases.messaging;

import com.api.chat_app.application.dto.request.messaging.SendMessageRequest;
import com.api.chat_app.domain.entity.Chat;
import com.api.chat_app.domain.entity.Message;
import com.api.chat_app.domain.interfaces.service.ChatService;
import com.api.chat_app.domain.interfaces.service.MessageService;

import java.util.List;

public class SendMessageUseCase {
    private final ChatService chatService;
    private final MessageService<SendMessageRequest> messageService;

    public SendMessageUseCase(ChatService chatService, MessageService<SendMessageRequest> messageService){
        this.chatService = chatService;
        this.messageService = messageService;
    }

    public Message run(SendMessageRequest request){

        var chat = chatService.getChatByParticipantsId(request.getSenderId(), request.getReceiverId())
                .orElse(chatService.createChat(new Chat(List.of(request.getSenderId(), request.getReceiverId()))));

        var message = messageService.addMessage(request);

        chat.addMessage(message.getId());
        chatService.updateChat(chat);

        return message;
    }

}
