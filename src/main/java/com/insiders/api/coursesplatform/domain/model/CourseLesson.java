package com.insiders.api.coursesplatform.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "tb_course_lesson")
public class CourseLesson {

    @Id
    @Column(name = "id_courseLesson")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double duration;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private Integer numOrder;

    @OneToOne(mappedBy = "courseLesson")
    private FinishedLesson finishedLesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private Course course;

}
