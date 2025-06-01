package com.api.chat_app.domain.interfaces.service;

import com.api.chat_app.domain.entity.Chat;

import java.util.List;
import java.util.Optional;

public interface ChatService {
    List<Chat>getAllChatsByUserId(String userId);
    Chat getChatById(String chatId );
    Optional<Chat> getChatByParticipantsId(String userId, String otherUserId);
    Chat createChat(Chat chat);
    Chat updateChat(Chat chat);
}
