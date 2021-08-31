package com.fon.fpis.domain;

import javax.persistence.*;

@Entity
public class StavkaOtpremniceZaKupca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long stavkaOtpremniceZaKupcaID;

    @ManyToOne
    private OtpremnicaZaKupca otpremnicaZaKupca;

    private int kolicina;

    @ManyToOne
    private Proizvod proizvodOtpremnice;

    public StavkaOtpremniceZaKupca() {
    }

    public Long getStavkaOtpremniceZaKupcaID() { return stavkaOtpremniceZaKupcaID; }

    public void setStavkaOtpremniceZaKupcaID(Long stavkaOtpremniceZaKupcaID) { this.stavkaOtpremniceZaKupcaID = stavkaOtpremniceZaKupcaID; }

    public OtpremnicaZaKupca getOtpremnicaZaKupca() { return otpremnicaZaKupca; }

    public void setOtpremnicaZaKupca(OtpremnicaZaKupca otpremnicaZaKupca) { this.otpremnicaZaKupca = otpremnicaZaKupca; }

    public int getKolicina() { return kolicina; }

    public void setKolicina(int kolicina) { this.kolicina = kolicina; }

    public Proizvod getProizvodOtpremnice() { return proizvodOtpremnice; }

    public void setProizvodOtpremnice(Proizvod proizvodOtpremnice) {
        this.proizvodOtpremnice = proizvodOtpremnice;
    }
}
