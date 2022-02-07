package com.insiders.api.coursesplatform.domain.repository;

import com.insiders.api.coursesplatform.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

//    @Query(value = "select * from tb_subscription s where s.id_user = :id", nativeQuery = true)
    List<Subscription> findByUser_Id(Long id);

}
