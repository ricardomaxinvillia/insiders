package com.insiders.api.coursesplatform.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "tb_user")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    public User() {

    }

    public User(String firstName, String lastName, String email, String role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String role;

    private String password;

    private LocalDate createdAt;

    private LocalDate updatedAt;

//    @OneToMany(mappedBy = "user")
//    private Set<Subscription> subscriptions = new HashSet<>();
//
//    @OneToMany(mappedBy = "user")
//    private Set<Certificate> certificates = new HashSet<>();
//
//    @OneToMany(mappedBy = "user")
//    private Set<FinishedLesson> finishedLessons = new HashSet<>();

}
