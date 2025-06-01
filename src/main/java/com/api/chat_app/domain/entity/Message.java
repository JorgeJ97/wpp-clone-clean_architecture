package com.api.chat_app.domain.entity;

import java.util.Date;

public class Message {
    private String id;
    private String senderId;
    private String receiverId;
    private String message;
    private String imageUrl;
    private String videoUrl;
    private String documentUrl;
    private boolean isRead;
    private Date createdAt;

    public Message(String senderId, String receiverId, String message, String videoUrl, String imageUrl, String documentUrl) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.documentUrl = documentUrl;
    }



    public Message(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
    public boolean isRead() {
        return isRead;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
