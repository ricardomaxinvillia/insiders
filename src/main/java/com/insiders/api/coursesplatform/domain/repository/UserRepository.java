package com.insiders.api.coursesplatform.domain.repository;

import com.insiders.api.coursesplatform.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(value = "select user from User user inner join Subscription subscription on subscription.user = user" +
////            " inner join Certificate certificate on certificate.user = user" +
////            " left join FinishedLesson finishedLesson on finishedLesson.user = user" +
//            " where user.id = :id")
//    Optional<User> findByUser(Long id);
}
