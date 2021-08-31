package com.fon.fpis.domain;

import javax.persistence.*;
import java.util.*;


@Entity
public class OtpremnicaZaKupca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long otpremnicaZaKupcaID;
    private String otpremnicuPrimio;
    private Date datumOtpremanja;

    @ManyToOne
    private Radnik radnikDoprema;

    @ManyToOne
    private Kupac kupacOtp;

    @ManyToOne
    private Radnik radnikKreirao;

    @OneToMany(mappedBy = "otpremnicaZaKupca", fetch = FetchType.LAZY)
    private List<StavkaOtpremniceZaKupca> stavkeOtpremnice;

    public OtpremnicaZaKupca() {
    }

    public Long getOtpremnicaZaKupcaID() { return otpremnicaZaKupcaID; }

    public void setOtpremnicaZaKupcaID(Long otpremnicaZaKupcaID) {
        this.otpremnicaZaKupcaID = otpremnicaZaKupcaID;
    }

    public String getOtpremnicuPrimio() { return otpremnicuPrimio; }

    public void setOtpremnicuPrimio(String otpremnicuPrimio) { this.otpremnicuPrimio = otpremnicuPrimio; }

    public Date getDatumOtpremanja() { return datumOtpremanja; }

    public void setDatumOtpremanja(Date datumOtpremanja) { this.datumOtpremanja = datumOtpremanja; }

    public Radnik getRadnikDoprema() { return radnikDoprema; }

    public void setRadnikDoprema(Radnik radnikDoprema) { this.radnikDoprema = radnikDoprema; }

    public Kupac getKupacOtp() { return kupacOtp; }

    public void setKupacOtp(Kupac kupacOtp) { this.kupacOtp = kupacOtp; }

    public Radnik getRadnikKreirao() { return radnikKreirao; }

    public void setRadnikKreirao(Radnik radnikKreirao) { this.radnikKreirao = radnikKreirao; }

    public List<StavkaOtpremniceZaKupca> getStavkeOtpremnice() { return stavkeOtpremnice; }

    public void setStavkeOtpremnice(List<StavkaOtpremniceZaKupca> stavkeOtpremnice) {
        this.stavkeOtpremnice = stavkeOtpremnice;
    }
}
