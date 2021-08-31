package com.fon.fpis.repository;

import com.fon.fpis.domain.StavkaOtpremniceZaKupca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StavkaOtpremniceZaKupcaRepository extends JpaRepository<StavkaOtpremniceZaKupca, Long> {

}
