package com.api.chat_app.domain.interfaces.repository;

import java.util.List;

public interface ChatRepository <TChat> extends BasicRepository<TChat>{
    List<TChat> findAllByUserId(String userId);
}
