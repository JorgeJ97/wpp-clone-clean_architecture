package com.api.chat_app.infrastructure.persistence.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map; 

@Getter
@Setter
@Document(collection = "chats")

public class ChatModel {
    @Id
    private String id;

    @DBRef(lazy = true)
    private List<UserModel> participants;

    @DBRef(lazy = true)
    private List<MessageModel> messages;

    @DBRef(lazy = false)
    private MessageModel lastMessage;

    private Map<String, Integer> unread;


}
