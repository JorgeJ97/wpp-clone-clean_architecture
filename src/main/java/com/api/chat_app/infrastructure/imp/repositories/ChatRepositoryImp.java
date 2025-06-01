package com.api.chat_app.infrastructure.imp.repositories;

import com.api.chat_app.domain.interfaces.repository.ChatRepository;
import com.api.chat_app.infrastructure.persistence.interfaces.ChatMongoRepository;
import com.api.chat_app.infrastructure.persistence.models.ChatModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ChatRepositoryImp implements ChatRepository<ChatModel> {
    private final ChatMongoRepository chatRepository;

    @Override
    public List<ChatModel> findAllByUserId(String id) {
        return List.of();
    }

    @Override
    public Optional<ChatModel> findById(String id) {
        return chatRepository.findById(id);
    }

    @Override
    public ChatModel save(ChatModel chatModel) {
        return chatRepository.save(chatModel);

    }
}
