package com.fon.fpis.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.*;

@Entity
public class RacunKupca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long racunKupcaID;
    private int rokPlacanjaKupca;
    private String napomenaRacunaKupca;
    private double cenaRacuna;

    @ManyToOne
    private Kupac kupac;

    @ManyToOne
    private Radnik radnik;

    private Long otpremnicaRacunaID;

    @ManyToOne
    private NacinPlacanja nacinPlacanja;

    @OneToMany(mappedBy = "racunKupca", fetch = FetchType.LAZY)
    private List<StavkaRacunaKupca> stavkaRacunaKupca;

    public RacunKupca() {
    }

    public Long getRacunKupcaID() {
        return racunKupcaID;
    }

    public void setRacunKupcaID(Long racunKupcaID) {
        this.racunKupcaID = racunKupcaID;
    }

    public int getRokPlacanjaKupca() {
        return rokPlacanjaKupca;
    }

    public void setRokPlacanjaKupca(int rokPlacanjaKupca) {
        this.rokPlacanjaKupca = rokPlacanjaKupca;
    }

    public String getNapomenaRacunaKupca() {
        return napomenaRacunaKupca;
    }

    public void setNapomenaRacunaKupca(String napomenaRacunaKupca) {
        this.napomenaRacunaKupca = napomenaRacunaKupca;
    }

    public double getCenaRacuna() { return cenaRacuna; }

    public void setCenaRacuna(double cenaRacuna) { this.cenaRacuna = cenaRacuna; }

    public Kupac getKupac() { return kupac; }

    public void setKupac(Kupac kupac) { this.kupac = kupac; }

    public Radnik getRadnik() { return radnik; }

    public void setRadnik(Radnik radnik) { this.radnik = radnik; }

    public Long getOtpremnicaRacunaID() { return otpremnicaRacunaID; }

    public void setOtpremnicaRacunaID(Long otpremnicaRacunaID) {
        this.otpremnicaRacunaID = otpremnicaRacunaID;
    }

    public List<StavkaRacunaKupca> getStavkaRacunaKupca() { return stavkaRacunaKupca; }

    public void setStavkaRacunaKupca(List<StavkaRacunaKupca> stavkaRacunaKupca) {
        this.stavkaRacunaKupca = stavkaRacunaKupca;
    }

    public NacinPlacanja getNacinPlacanja() { return nacinPlacanja; }

    public void setNacinPlacanja(NacinPlacanja nacinPlacanja) { this.nacinPlacanja = nacinPlacanja; }
}
