package com.insiders.api.coursesplatform.domain.repository;

import com.insiders.api.coursesplatform.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
