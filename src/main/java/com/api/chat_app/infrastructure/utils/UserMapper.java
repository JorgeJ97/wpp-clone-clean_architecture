package com.api.chat_app.infrastructure.utils;

import com.api.chat_app.domain.entity.User;
import com.api.chat_app.infrastructure.persistence.models.UserModel;

public class UserMapper {
    private UserMapper(){}

    public static User toDomain(UserModel userModel){
        return new User(userModel.getId(),
                userModel.getUsername(),
                userModel.getEmail(),
                userModel.getImage(),
                userModel.getPassword());
    }

    public static UserModel toModel(User user){
        return UserModel.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .image(user.getImage() != null ? user.getImage() : "")
                .password(user.getPassword())
                .build();
    }
}
