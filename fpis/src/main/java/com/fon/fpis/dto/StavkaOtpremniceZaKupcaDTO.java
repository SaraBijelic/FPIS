package com.fon.fpis.dto;

import com.fon.fpis.domain.OtpremnicaZaKupca;
import com.fon.fpis.domain.Proizvod;

public class StavkaOtpremniceZaKupcaDTO {

    private Long stavkaOtpremniceZaKupcaID;
    private OtpremnicaZaKupca otpremnicaZaKupca;
    private int kolicina;
    private ProizvodDTO proizvodOtpremnice;

    public StavkaOtpremniceZaKupcaDTO() {
    }

    public Long getStavkaOtpremniceZaKupcaID() { return stavkaOtpremniceZaKupcaID; }

    public void setStavkaOtpremniceZaKupcaID(Long stavkaOtpremniceZaKupcaID) { this.stavkaOtpremniceZaKupcaID = stavkaOtpremniceZaKupcaID; }

    public OtpremnicaZaKupca getOtpremnicaZaKupca() { return otpremnicaZaKupca; }

    public void setOtpremnicaZaKupca(OtpremnicaZaKupca otpremnicaZaKupca) { this.otpremnicaZaKupca = otpremnicaZaKupca; }

    public int getKolicina() { return kolicina; }

    public void setKolicina(int kolicina) { this.kolicina = kolicina; }

    public ProizvodDTO getProizvodOtpremnice() { return proizvodOtpremnice; }

    public void setProizvodOtpremnice(ProizvodDTO proizvodOtpremnice) {
        this.proizvodOtpremnice = proizvodOtpremnice;
    }
}
