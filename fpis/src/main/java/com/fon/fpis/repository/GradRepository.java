package com.fon.fpis.repository;

import com.fon.fpis.domain.Grad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradRepository extends JpaRepository<Grad, Long> {
}
