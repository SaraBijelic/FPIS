package com.fon.fpis.repository;

import com.fon.fpis.domain.OtpremnicaZaKupca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OtpremnicaZaKupcaRepository extends JpaRepository<OtpremnicaZaKupca, Long> {

    List<OtpremnicaZaKupca> findByDatumOtpremanja(Date datum);
}
