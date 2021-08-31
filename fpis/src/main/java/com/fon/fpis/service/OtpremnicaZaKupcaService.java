package com.fon.fpis.service;

import com.fon.fpis.dto.OtpremnicaZaKupcaDTO;
import com.fon.fpis.dto.OtpremnicaZaKupcaListDTO;

import java.util.Date;

public interface OtpremnicaZaKupcaService {

    public OtpremnicaZaKupcaDTO findOneOtpremnica(java.lang.Long id);

    public OtpremnicaZaKupcaListDTO findAllOtpremnica();

    public OtpremnicaZaKupcaListDTO findAllOtpremnicaDatum(Date datum);
}
