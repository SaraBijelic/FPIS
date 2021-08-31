package com.fon.fpis.domain;

/***********************************************************************
 * Module:  ZahtevZaProveromKvaliteta.java
 * Author:  Korisnik
 * Purpose: Defines the Class ZahtevZaProveromKvaliteta
 ***********************************************************************/

import javax.persistence.*;
import java.util.*;

@Entity
public class ZahtevZaProveromKvaliteta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long zahtevID;
    private Date datum;
    private String napomena;

    @ManyToOne
    private Veterinar veterinar;

    @ManyToOne
    private Proizvod proizvod;

    @ManyToOne
    private Radnik radnik;


    public ZahtevZaProveromKvaliteta() {
    }

    public Long getZahtevID() { return zahtevID; }

    public void setZahtevID(Long zahtevID) { this.zahtevID = zahtevID; }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Veterinar getVeterinar() {
        return veterinar;
    }

    public void setVeterinar(Veterinar veterinar) {
        this.veterinar = veterinar;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }
}
