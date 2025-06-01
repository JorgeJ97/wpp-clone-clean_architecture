package com.api.chat_app.infrastructure.imp.services;

import com.api.chat_app.domain.entity.User;
import com.api.chat_app.domain.exception.UserNotFoundException;
import com.api.chat_app.domain.interfaces.repository.UserRepository;
import com.api.chat_app.domain.interfaces.service.PasswordEncoder;
import com.api.chat_app.domain.interfaces.service.UserService;
import com.api.chat_app.infrastructure.persistence.models.UserModel;
import com.api.chat_app.infrastructure.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private final UserRepository<UserModel> userRepository;
    private final PasswordEncoder passwordEncoder;
//
//    @PostConstruct
//    public void init() {
//        System.out.println("UserServiceImp initialized with: ");
//        System.out.println("PasswordEncoder: " + passwordEncoder.getClass().getName());
//        System.out.println("UserRepository: " + userRepository.getClass().getName());
//    }


    @Override
    public User getUserById(String id) {
        UserModel userFromDB = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return UserMapper.toDomain(userFromDB);
    }

    @Override
    public User getUserByEmail(String email) {
        UserModel userFromDB = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        return UserMapper.toDomain(userFromDB);
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserModel userFromDB = UserMapper.toModel(user);
        userFromDB = userRepository.save(userFromDB);
        return UserMapper.toDomain(userFromDB);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean existUserByEmail(String email) {
        return userRepository.existByEmail(email);
    }
}
