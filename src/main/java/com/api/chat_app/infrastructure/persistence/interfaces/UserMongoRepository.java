package com.api.chat_app.infrastructure.persistence.interfaces;

import com.api.chat_app.infrastructure.persistence.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<UserModel, String> {
    Optional<UserModel> findByEmail(String email);
    boolean existsByEmail(String email);
}
