package com.fon.fpis.dto;

import com.fon.fpis.domain.*;

import java.util.*;

public class RacunKupcaDTO {

    private Long racunKupcaID;
    private int rokPlacanjaKupca;
    private String napomenaRacunaKupca;
    private double cenaRacuna;
    private KupacDTO kupac;
    private RadnikDTO radnik;
    private Long otpremnicaRacunaID;
    private NacinPlacanjaDTO nacinPlacanja;
    private StavkaRacunaKupcaListDTO stavkaRacunaKupca;

    public RacunKupcaDTO() {
    }

    public Long getRacunKupcaID() { return racunKupcaID; }

    public void setRacunKupcaID(Long racunKupcaID) { this.racunKupcaID = racunKupcaID; }

    public int getRokPlacanjaKupca() { return rokPlacanjaKupca; }

    public void setRokPlacanjaKupca(int rokPlacanjaKupca) { this.rokPlacanjaKupca = rokPlacanjaKupca; }

    public String getNapomenaRacunaKupca() { return napomenaRacunaKupca; }

    public void setNapomenaRacunaKupca(String napomenaRacunaKupca) {
        this.napomenaRacunaKupca = napomenaRacunaKupca;
    }

    public double getCenaRacuna() { return cenaRacuna; }

    public void setCenaRacuna(double cenaRacuna) { this.cenaRacuna = cenaRacuna; }

    public KupacDTO getKupac() { return kupac; }

    public void setKupac(KupacDTO kupac) { this.kupac = kupac; }

    public RadnikDTO getRadnik() { return radnik; }

    public void setRadnik(RadnikDTO radnik) { this.radnik = radnik; }

    public Long getOtpremnicaRacunaID() { return otpremnicaRacunaID; }

    public void setOtpremnicaRacunaID(Long otpremnicaRacunaID) {
        this.otpremnicaRacunaID = otpremnicaRacunaID;
    }

    public StavkaRacunaKupcaListDTO getStavkaRacunaKupca() { return stavkaRacunaKupca; }

    public void setStavkaRacunaKupca(StavkaRacunaKupcaListDTO stavkaRacunaKupca) {
        this.stavkaRacunaKupca = stavkaRacunaKupca;
    }

    public NacinPlacanjaDTO getNacinPlacanja() { return nacinPlacanja; }

    public void setNacinPlacanja(NacinPlacanjaDTO nacinPlacanja) { this.nacinPlacanja = nacinPlacanja; }
}
