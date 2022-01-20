package com.insiders.api.coursesplatform.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "tb_finished_lesson")
public class FinishedLesson {

    @Id
    private Long id;

    private LocalDate finishedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @OneToOne
    @JoinColumn(name = "id_course_lesson")
    private CourseLesson courseLesson;

}
