package com.fon.fpis.service;

import com.fon.fpis.dto.*;

public interface StavkaRacunaKupcaService {

    public StavkaRacunaKupcaDTO findOneStavkaRacuna(Long id);

    public StavkaRacunaKupcaListDTO findAllStavkeRacuna();

    public StavkaRacunaKupcaListDTO findAllStavkeIDRacuna(Long idRacuna);

    public boolean addStavkeRacuna(AddUpdateStavkeRacunaListDTO stavkeRacunaDTO);

}
