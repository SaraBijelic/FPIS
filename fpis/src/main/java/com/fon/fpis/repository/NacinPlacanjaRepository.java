package com.fon.fpis.repository;

import com.fon.fpis.domain.NacinPlacanja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacinPlacanjaRepository extends JpaRepository<NacinPlacanja, Long> {
}
