package com.api.chat_app.domain.entity;


import java.util.List;
import java.util.Map;

public class Chat {
    private String id;
    private List<String> participantsId;
    private List<String> messagesId;
    private Message lastMessage;
    private Map<String, Integer> unread;

    public Chat( List<String> participants) {
        this.participantsId = participants;

    }


    public Chat() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getParticipantsId() {
        return participantsId;
    }

    public void setParticipants(List<String> participantsId) {
        this.participantsId = participantsId;
    }

    public List<String> getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(List<String> messagesId) {
        this.messagesId = messagesId;
    }

    public void addMessage(String messageId){
        messagesId.addLast(messageId);
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Map<String, Integer> getUnread() {
        return unread;
    }

    public void setUnread(Map<String, Integer> unread) {
        this.unread = unread;
    }
}

