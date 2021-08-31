package com.fon.fpis.service;

import com.fon.fpis.dto.StavkaOtpremniceZaKupcaDTO;
import com.fon.fpis.dto.StavkaOtpremniceZaKupcaListDTO;

public interface StavkaOtpremniceZaKupcaService {

    public StavkaOtpremniceZaKupcaDTO findOneStavkaOtpremnice(Long id);

    public StavkaOtpremniceZaKupcaListDTO findAllStavkeOtpremnice();

    public StavkaOtpremniceZaKupcaListDTO findAllStavkeIDOtpremnice(Long idOtpremnica);

}
