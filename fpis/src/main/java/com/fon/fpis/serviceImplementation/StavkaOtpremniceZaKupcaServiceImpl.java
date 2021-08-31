package com.fon.fpis.serviceImplementation;

import com.fon.fpis.dto.StavkaOtpremniceZaKupcaDTO;
import com.fon.fpis.dto.StavkaOtpremniceZaKupcaListDTO;
import com.fon.fpis.repository.StavkaOtpremniceZaKupcaRepository;
import com.fon.fpis.service.StavkaOtpremniceZaKupcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StavkaOtpremniceZaKupcaServiceImpl implements StavkaOtpremniceZaKupcaService {

    @Autowired
    StavkaOtpremniceZaKupcaRepository stavkaOtpremniceZaKupcaRepository;

    @Override
    public StavkaOtpremniceZaKupcaDTO findOneStavkaOtpremnice(Long id) {
        return null;
    }

    @Override
    public StavkaOtpremniceZaKupcaListDTO findAllStavkeOtpremnice() {
        return null;
    }

    @Override
    public StavkaOtpremniceZaKupcaListDTO findAllStavkeIDOtpremnice(Long idOtpremnica) {
        return null;
    }

}
