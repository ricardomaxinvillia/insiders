package com.insiders.api.coursesplatform.api.controller;

import com.insiders.api.coursesplatform.api.dto.SubscriptionDTO;
import com.insiders.api.coursesplatform.api.dto.UserConDTO;
import com.insiders.api.coursesplatform.api.dto.UserDTO;
import com.insiders.api.coursesplatform.domain.model.Subscription;
import com.insiders.api.coursesplatform.domain.model.User;
import com.insiders.api.coursesplatform.domain.repository.SubscriptionRepository;
import com.insiders.api.coursesplatform.domain.repository.UserRepository;
import com.insiders.api.coursesplatform.domain.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final SubscriptionRepository subscriptionRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, ModelMapper modelMapper, SubscriptionRepository subscriptionRepository, UserService userService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.subscriptionRepository = subscriptionRepository;
        this.userService = userService;
    }

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserConDTO> searchById(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            UserConDTO userConDTO = toDto(user.get());
//            Set<Subscription> subscription = new HashSet<>(subscriptionRepository.findByUser_Id(userId));
//            Set<SubscriptionDTO> subscriptionDTO = toSubscriptionDTOSet(subscription);
//            userConDTO.setSubscriptions(subscriptionDTO);
            return ResponseEntity.ok(userConDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User add(@RequestBody User user) {
        return userService.salvar(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateById(@PathVariable Long userId,
                                              @RequestBody User user) {
        if (userRepository.existsById(userId)) {
            user.setId(userId);
            UserDTO userDTO = toUserDTO(userService.alterar(user));
            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> removeById(@PathVariable Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public UserConDTO toDto(User user) {
        return modelMapper.map(user, UserConDTO.class);
    }

    public UserDTO toUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public Set<SubscriptionDTO> toSubscriptionDTOSet(Set<Subscription> subscription) {
        return subscription
                .stream()
                .map(subscription1 -> {
                    return modelMapper.map(subscription1, SubscriptionDTO.class);
                }).collect(Collectors.toSet());
    }

}
