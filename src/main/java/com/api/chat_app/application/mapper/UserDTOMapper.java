package com.api.chat_app.application.mapper;

import com.api.chat_app.application.dto.request.auth.RegisterRequest;
import com.api.chat_app.application.dto.response.auth.UserDetail;
import com.api.chat_app.domain.entity.User;

public class UserDTOMapper {
    private UserDTOMapper(){}

    public static User registerRequestToDomainUser(RegisterRequest request){
        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public static UserDetail domainUserToUserDetail(User user){
        return new UserDetail(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getImage());
    }

    public static User UserDetailToDomainUser(UserDetail userDetail){
        return User.builder()
                .id(userDetail.id())
                .username(userDetail.username())
                .email(userDetail.email())
                .image(userDetail.image())
                .build();
    }

}
