package com.api.chat_app.infrastructure.persistence.interfaces;

import com.api.chat_app.infrastructure.persistence.models.MessageModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageMongoRepository extends MongoRepository<MessageModel, String> {
}
