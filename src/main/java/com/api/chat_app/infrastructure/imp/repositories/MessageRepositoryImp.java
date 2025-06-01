package com.api.chat_app.infrastructure.imp.repositories;

import com.api.chat_app.domain.interfaces.repository.BasicRepository;
import com.api.chat_app.infrastructure.persistence.interfaces.MessageMongoRepository;
import com.api.chat_app.infrastructure.persistence.models.MessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MessageRepositoryImp implements BasicRepository<MessageModel> {
    private final MessageMongoRepository messageRepository;

    @Override
    public Optional<MessageModel> findById(String id) {
        return messageRepository.findById(id);
    }

    @Override
    public MessageModel save(MessageModel message) {
        return messageRepository.save(message);
    }
}
