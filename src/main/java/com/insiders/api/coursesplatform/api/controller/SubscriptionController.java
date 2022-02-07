package com.insiders.api.coursesplatform.api.controller;

import com.insiders.api.coursesplatform.api.dto.SubscriptionConDTO;
import com.insiders.api.coursesplatform.api.dto.SubscriptionDTO;
import com.insiders.api.coursesplatform.domain.model.Course;
import com.insiders.api.coursesplatform.domain.model.Subscription;
import com.insiders.api.coursesplatform.domain.model.User;
import com.insiders.api.coursesplatform.domain.repository.CourseRepository;
import com.insiders.api.coursesplatform.domain.repository.SubscriptionRepository;
import com.insiders.api.coursesplatform.domain.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses/subscription")
public class SubscriptionController {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public SubscriptionController(SubscriptionRepository subscriptionRepository, UserRepository userRepository, CourseRepository courseRepository, ModelMapper modelMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<SubscriptionDTO> list() {
        return toSubscriptionDTOList(subscriptionRepository.findAll());
    }


    @GetMapping("/{subscriptionId}")
    public ResponseEntity<SubscriptionConDTO> searchById(@PathVariable Long subscriptionId) {
        Optional<Subscription> subscription = subscriptionRepository.findById(subscriptionId);
        if (subscription.isPresent()) {
            SubscriptionConDTO subscriptionConDTO = toDto(subscription.get());
            return ResponseEntity.ok(subscriptionConDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Subscription add(@RequestBody Subscription subscription, Long userId, Long courseId) {
        User user = userRepository.getById(userId);
        Course course = courseRepository.getById(courseId);
        subscription.setUser(user);
        subscription.setCourse(course);
        return subscriptionRepository.save(subscription);
    }

    public SubscriptionConDTO toDto(Subscription subscription) {
        return modelMapper.map(subscription, SubscriptionConDTO.class);
    }


    public List<SubscriptionDTO> toSubscriptionDTOList(List<Subscription> subscription) {
        return subscription
                .stream()
                .map(subscription1 -> {
                    return modelMapper.map(subscription1, SubscriptionDTO.class);
                }).collect(Collectors.toList());
    }

}
