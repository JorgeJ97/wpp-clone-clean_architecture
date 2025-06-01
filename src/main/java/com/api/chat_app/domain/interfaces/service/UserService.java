package com.api.chat_app.domain.interfaces.service;

import com.api.chat_app.domain.entity.User;


public interface UserService {
    User getUserById(String id);
    User getUserByEmail(String email);
    User createUser(User user);
    User updateUser(User user);
    boolean existUserByEmail(String email);


}
