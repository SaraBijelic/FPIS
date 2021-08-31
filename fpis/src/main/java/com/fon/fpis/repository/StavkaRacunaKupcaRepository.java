package com.fon.fpis.repository;

import com.fon.fpis.domain.StavkaRacunaID;
import com.fon.fpis.domain.StavkaRacunaKupca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StavkaRacunaKupcaRepository extends JpaRepository<StavkaRacunaKupca, StavkaRacunaID> {

    public List<StavkaRacunaKupca> findStavkaRacunaKupcasByRacunKupca_RacunKupcaID(Long idRacuna);

    public boolean deleteAllByRacunKupcaRacunKupcaID(Long IdRacuna);
}
