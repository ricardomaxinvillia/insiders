package com.insiders.api.coursesplatform.domain.service;

import com.insiders.api.coursesplatform.domain.model.User;
import com.insiders.api.coursesplatform.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User salvar(User user){
        user.setCreatedAt(LocalDate.now());
        return userRepository.save(user);
    }

    public User alterar(User user){
        Optional<User> userSearch = userRepository.findById(user.getId());
        if (user.getFirstName() != null){
            userSearch.get().setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null){
            userSearch.get().setLastName(user.getLastName());
        }
        if (user.getPassword() != null){
            userSearch.get().setPassword(user.getPassword());
        }
        userSearch.get().setUpdatedAt(LocalDate.now());
        return userRepository.save(userSearch.get());
    }

}
