package com.api.chat_app.infrastructure.persistence.interfaces;

import com.api.chat_app.infrastructure.persistence.models.ChatModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMongoRepository extends MongoRepository<ChatModel, String> {
}
