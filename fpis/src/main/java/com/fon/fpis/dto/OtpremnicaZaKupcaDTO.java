package com.fon.fpis.dto;

import com.fon.fpis.domain.Kupac;
import com.fon.fpis.domain.Radnik;

import java.util.*;

public class OtpremnicaZaKupcaDTO {

    private Long otpremnicaZaKupcaID;
    private String otpremnicuPrimio;
    private Date datumOtpremanja;
    private RadnikDTO radnikDoprema;
    private KupacDTO kupacOtp;
    private RadnikDTO radnikKreirao;

    public OtpremnicaZaKupcaDTO() {
    }

    public Long getOtpremnicaZaKupcaID() { return otpremnicaZaKupcaID; }

    public void setOtpremnicaZaKupcaID(Long otpremnicaZaKupcaID) {
        this.otpremnicaZaKupcaID = otpremnicaZaKupcaID; }

    public String getOtpremnicuPrimio() { return otpremnicuPrimio; }

    public void setOtpremnicuPrimio(String otpremnicuPrimio) { this.otpremnicuPrimio = otpremnicuPrimio; }

    public Date getDatumOtpremanja() { return datumOtpremanja; }

    public void setDatumOtpremanja(Date datumOtpremanja) { this.datumOtpremanja = datumOtpremanja; }

    public RadnikDTO getRadnikDoprema() { return radnikDoprema; }

    public void setRadnikDoprema(RadnikDTO radnikDoprema) { this.radnikDoprema = radnikDoprema; }

    public KupacDTO getKupacOtp() { return kupacOtp; }

    public void setKupacOtp(KupacDTO kupacOtp) {
        this.kupacOtp = kupacOtp;
    }

    public RadnikDTO getRadnikKreirao() {
        return radnikKreirao;
    }

    public void setRadnikKreirao(RadnikDTO radnikKreirao) {
        this.radnikKreirao = radnikKreirao;
    }
}
