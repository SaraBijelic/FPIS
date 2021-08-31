package com.fon.fpis.dto;

import java.util.*;

public class OtpremnicaZaKupcaListDTO {

    List<OtpremnicaZaKupcaDTO> otpremnice = new ArrayList<>();

    public OtpremnicaZaKupcaListDTO() {}

    public OtpremnicaZaKupcaListDTO(List<OtpremnicaZaKupcaDTO> otpremnice) { this.otpremnice = otpremnice; }

    public List<OtpremnicaZaKupcaDTO> getOtpremnice() { return otpremnice; }

    public void setOtpremnice(List<OtpremnicaZaKupcaDTO> otpremnice) { this.otpremnice = otpremnice; }
}
