package com.insiders.api.coursesplatform.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "tb_course_approval")
public class CourseApproval {


    @Id
    @Column(name = "id_courseApproval")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String approvedBy;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @OneToOne
    @JoinColumn(name = "id_course")
    private Course course;

}
