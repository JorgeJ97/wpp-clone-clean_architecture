package com.api.chat_app.infrastructure.imp.services;

import com.api.chat_app.domain.entity.Chat;
import com.api.chat_app.domain.interfaces.service.ChatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImp implements ChatService {
    @Override
    public List<Chat> getAllChatsByUserId(String userId) {
        return List.of();
    }

    @Override
    public Chat getChatById(String chatId) {
        return null;
    }

    @Override
    public Optional<Chat> getChatByParticipantsId(String userId, String otherUserId) {
        return Optional.empty();
    }

    @Override
    public Chat createChat(Chat chat) {
        return null;
    }

    @Override
    public Chat updateChat(Chat chat) {
        return null;
    }
}
