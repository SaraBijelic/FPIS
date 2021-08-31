package com.fon.fpis.repository;

import com.fon.fpis.domain.ZahtevZaProveromKvaliteta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ZahtevZaProveromKvalitetaRepository extends JpaRepository<ZahtevZaProveromKvaliteta, Long> {

    List<ZahtevZaProveromKvaliteta> findByDatum(Date datum);
}
