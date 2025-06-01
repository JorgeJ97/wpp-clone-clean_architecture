package com.api.chat_app.domain.interfaces.repository;

import java.util.Optional;

public interface UserRepository<TUser> extends BasicRepository<TUser> {
    Optional<TUser>findByEmail(String email);
    boolean existByEmail(String email);
}
