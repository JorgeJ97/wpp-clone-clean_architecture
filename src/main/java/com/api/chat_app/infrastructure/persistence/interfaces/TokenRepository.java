package com.api.chat_app.infrastructure.persistence.interfaces;

import com.api.chat_app.infrastructure.persistence.models.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TokenRepository extends MongoRepository<Token, String> {
    void deleteByToken(String token);
    void deleteByUserId(String userId);

//    @Query(value = "{'userId : 0?', 'expired': true}", delete = true)
//    void deleteExpiredTokensByUserId(String userId);
}
