package com.insiders.api.coursesplatform.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "tb_subscription")
public class Subscription {

    @Id
    @Column(name = "id_subscription")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double progress;

    private String status;

    private LocalDate updatedAt;

    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    public Subscription() {
    }

    public Subscription(Double progress, String status) {
        this.progress = progress;
        this.status = status;
    }
}
