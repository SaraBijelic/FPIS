package com.fon.fpis.domain;

/***********************************************************************
 * Module:  StavkaRacunaVeterinara.java
 * Author:  Korisnik
 * Purpose: Defines the Class StavkaRacunaVeterinara
 ***********************************************************************/

import javax.persistence.*;

@Entity
public class StavkaRacunaVeterinara {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long stavkaRacunVeterinaraID;

    @ManyToOne
    private RacunVeterinara racunVeterinara;
    private double cenaSaPopustom;
    private double rabat;
    private double kolicina;

    @ManyToOne
    private Proizvod proizvod;

    public StavkaRacunaVeterinara() {
    }

    public Long getStavkaRacunVeterinaraID() {
        return stavkaRacunVeterinaraID;
    }

    public void setStavkaRacunVeterinaraID(Long stavkaRacunVeterinaraID) {
        this.stavkaRacunVeterinaraID = stavkaRacunVeterinaraID;
    }

    public double getCenaSaPopustom() {
        return cenaSaPopustom;
    }

    public void setCenaSaPopustom(double cenaSaPopustom) {
        this.cenaSaPopustom = cenaSaPopustom;
    }

    public double getRabat() {
        return rabat;
    }

    public void setRabat(double rabat) {
        this.rabat = rabat;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public RacunVeterinara getRacunVeterinara() { return racunVeterinara; }

    public void setRacunVeterinara(RacunVeterinara racunVeterinara) { this.racunVeterinara = racunVeterinara; }

    public Proizvod getProizvod() { return proizvod; }

    public void setProizvod(Proizvod proizvod) { this.proizvod = proizvod; }
}
