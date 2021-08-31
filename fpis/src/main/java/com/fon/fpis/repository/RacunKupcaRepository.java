package com.fon.fpis.repository;

import com.fon.fpis.domain.RacunKupca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacunKupcaRepository extends JpaRepository<RacunKupca, Long> {

}
