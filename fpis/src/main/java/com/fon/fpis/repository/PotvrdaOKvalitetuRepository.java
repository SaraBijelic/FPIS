package com.fon.fpis.repository;

import com.fon.fpis.domain.PotvrdaOKvalitetu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotvrdaOKvalitetuRepository extends JpaRepository<PotvrdaOKvalitetu, Long> {

}
