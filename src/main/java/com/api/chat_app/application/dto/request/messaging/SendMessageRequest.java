package com.api.chat_app.application.dto.request.messaging;

public class SendMessageRequest {
    private final String senderId;
    private final String receiverId;
    private final String text;
    private final String imageUrl;
    private final String videoUrl;
    private final String documentUrl;

    public SendMessageRequest(String senderId, String receiverId, String text, String imageUrl, String videoUrl, String documentUrl) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.text = text;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.documentUrl = documentUrl;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getText() {
        return text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }
}


