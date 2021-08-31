package com.fon.fpis.service;

import com.fon.fpis.dto.*;

public interface RacunKupcaService {

    public RacunKupcaListDTO findAllRacunKupca();

    public boolean addRacunKupca(AddUpdateRacunKupcaDTO racun);

    public boolean deleteRacunaKupca(Long racunID);

    public boolean updateRacunKupca(AddUpdateRacunKupcaDTO racun);
}
