package com.api.chat_app.domain.interfaces.repository;

import java.util.Optional;

public interface BasicRepository <TEntity> {
    Optional<TEntity> findById(String id);
    TEntity save(TEntity entity);
}
