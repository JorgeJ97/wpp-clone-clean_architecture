package com.api.chat_app.infrastructure.imp.repositories;

import com.api.chat_app.domain.interfaces.repository.UserRepository;
import com.api.chat_app.infrastructure.persistence.interfaces.UserMongoRepository;
import com.api.chat_app.infrastructure.persistence.models.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImp  implements UserRepository<UserModel> {
    private final UserMongoRepository userRepository;

    @Override
    public Optional<UserModel> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public UserModel save(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserModel> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}