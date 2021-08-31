package com.fon.fpis.repository;

import com.fon.fpis.domain.Veterinar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarRepository extends JpaRepository<Veterinar, Long> {
}
