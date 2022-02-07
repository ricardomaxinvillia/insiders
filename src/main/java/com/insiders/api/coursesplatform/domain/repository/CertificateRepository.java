package com.insiders.api.coursesplatform.domain.repository;

import com.insiders.api.coursesplatform.domain.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
