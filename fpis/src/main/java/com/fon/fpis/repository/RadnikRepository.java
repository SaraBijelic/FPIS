package com.fon.fpis.repository;

import com.fon.fpis.domain.Radnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadnikRepository extends JpaRepository<Radnik, Long> {
}
