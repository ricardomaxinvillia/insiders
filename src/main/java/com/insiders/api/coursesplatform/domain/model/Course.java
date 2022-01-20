package com.insiders.api.coursesplatform.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "tb_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_course")
    private Long id;

    private String name;

    private String category;

    private Double workload;

    private String status;

    private Boolean hasCertificate;

    private Double evaluation;

    private LocalDate createdAt;

    private LocalDate updatedAt;

//    @OneToMany(mappedBy = "course")
//    private Set<Subscription> subscriptions = new java.util.LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "course")
//    private Set<CourseLesson> courseLessons = new HashSet<>();

    public Course() {

    }

    public Course(String name, String category, Double workload, String status, Boolean hasCertificate, Double evaluation) {
        this.name = name;
        this.category = category;
        this.workload = workload;
        this.status = status;
        this.hasCertificate = hasCertificate;
        this.evaluation = evaluation;
    }

}
