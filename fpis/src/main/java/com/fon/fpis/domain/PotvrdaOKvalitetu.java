package com.fon.fpis.domain;

/***********************************************************************
 * Module:  PotvrdaOKvalitetu.java
 * Author:  Korisnik
 * Purpose: Defines the Class PotvrdaOKvalitetu
 ***********************************************************************/

import javax.persistence.*;
import java.util.*;

@Entity
public class PotvrdaOKvalitetu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long potvrdaOKvalitetuID;
    private String opisPotvrde;
    private Date datumPotvrde;
    private String vrstaRobe;
    private String mestoIzdavanja;

    @ManyToOne
    private Veterinar veterinar;

    @ManyToOne
    private ZahtevZaProveromKvaliteta zahtev;

    @ManyToOne
    private Proizvod proizvod;

    public PotvrdaOKvalitetu() {
    }

    public Long getPotvrdaOKvalitetuID() {
        return potvrdaOKvalitetuID;
    }

    public void setPotvrdaOKvalitetuID(Long potvrdaOKvalitetuID) {
        this.potvrdaOKvalitetuID = potvrdaOKvalitetuID;
    }

    public String getOpisPotvrde() {
        return opisPotvrde;
    }

    public void setOpisPotvrde(String opisPotvrde) {
        this.opisPotvrde = opisPotvrde;
    }

    public Date getDatumPotvrde() {
        return datumPotvrde;
    }

    public void setDatumPotvrde(Date datumPotvrde) {
        this.datumPotvrde = datumPotvrde;
    }

    public String getVrstaRobe() {
        return vrstaRobe;
    }

    public void setVrstaRobe(String vrstaRobe) {
        this.vrstaRobe = vrstaRobe;
    }

    public String getMestoIzdavanja() {
        return mestoIzdavanja;
    }

    public void setMestoIzdavanja(String mestoIzdavanja) {
        this.mestoIzdavanja = mestoIzdavanja;
    }

    public Veterinar getVeterinar() { return veterinar; }

    public void setVeterinar(Veterinar veterinar) { this.veterinar = veterinar; }

    public ZahtevZaProveromKvaliteta getZahtev() { return zahtev; }

    public void setZahtev(ZahtevZaProveromKvaliteta zahtev) { this.zahtev = zahtev; }

    public Proizvod getProizvod() { return proizvod; }

    public void setProizvod(Proizvod proizvod) { this.proizvod = proizvod; }
}