package com.api.chat_app.infrastructure.persistence.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "token")
public class Token {

    public enum TokenType{
        BEARER
    }

    @Id
    private String id;

    @Indexed(unique = true)
    public String token;

    public TokenType tokenType = TokenType.BEARER;

    @Indexed
    private String userId;
}
