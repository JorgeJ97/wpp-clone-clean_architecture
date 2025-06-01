package com.api.chat_app.infrastructure.persistence.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document(collection = "user")
public class UserModel {

    @Id
    private String id;

    private String username;
    private String email;

    @Builder.Default
    private String image = "";
    private String password;

    private boolean isOnline;

}
