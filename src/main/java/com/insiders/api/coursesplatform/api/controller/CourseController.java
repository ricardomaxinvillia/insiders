package com.insiders.api.coursesplatform.api.controller;

import com.insiders.api.coursesplatform.domain.model.Course;
import com.insiders.api.coursesplatform.domain.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> searchById(@PathVariable Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course add(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateById(@PathVariable Long courseId,
                                           @RequestBody Course course) {
        if (courseRepository.existsById(courseId)) {
            course.setId(courseId);
            courseRepository.save(course);
            return ResponseEntity.ok(course);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> removeById(@PathVariable Long courseId) {
        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
