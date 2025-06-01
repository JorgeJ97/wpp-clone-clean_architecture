package com.api.chat_app.infrastructure.persistence.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "message")
public class MessageModel {
    private String id;
    private String senderId;
    private String receiverId;
    private String message;
    private String imageUrl;
    private String videoUrl;
    private String documentUrl;
    private Date createdAt;
}
