package com.fon.fpis.domain;

/***********************************************************************
 * Module:  RacunVeterinara.java
 * Author:  Korisnik
 * Purpose: Defines the Class RacunVeterinara
 ***********************************************************************/

import javax.persistence.*;
import java.util.*;


@Entity
public class RacunVeterinara {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long racunVeterinaraID;

    private String brRacuna;
    private String napomena;
    private String pozivNaBroj;

    @ManyToOne
    private NacinPlacanja nacinPlacanja;

    @ManyToOne
    private Veterinar veterinar;

    @ManyToOne
    private PotvrdaOKvalitetu potvrdaOKvalitetu;

    @OneToMany(mappedBy = "racunVeterinara", fetch = FetchType.LAZY)
    private Set<StavkaRacunaVeterinara> stavkaRacunaVeterinara;

    public RacunVeterinara() {
    }

    public Long getRacunVeterinaraID() { return racunVeterinaraID; }

    public void setRacunVeterinaraID(Long racunVeterinaraID) { this.racunVeterinaraID = racunVeterinaraID; }

    public String getBrRacuna() { return brRacuna; }

    public void setBrRacuna(String brRacuna) { this.brRacuna = brRacuna; }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getPozivNaBroj() {
        return pozivNaBroj;
    }

    public void setPozivNaBroj(String pozivNaBroj) {
        this.pozivNaBroj = pozivNaBroj;
    }

    public NacinPlacanja getNacinPlacanja() { return nacinPlacanja; }

    public void setNacinPlacanja(NacinPlacanja nacinPlacanja) { this.nacinPlacanja = nacinPlacanja; }

    public Set<StavkaRacunaVeterinara> getStavkaRacunaVeterinara() { return stavkaRacunaVeterinara; }

    public void setStavkaRacunaVeterinara(Set<StavkaRacunaVeterinara> stavkaRacunaVeterinara) {
        this.stavkaRacunaVeterinara = stavkaRacunaVeterinara;
    }

    public Veterinar getVeterinar() { return veterinar; }

    public void setVeterinar(Veterinar veterinar) { this.veterinar = veterinar; }

    public PotvrdaOKvalitetu getPotvrdaOKvalitetu() { return potvrdaOKvalitetu; }

    public void setPotvrdaOKvalitetu(PotvrdaOKvalitetu potvrdaOKvalitetu) {
        this.potvrdaOKvalitetu = potvrdaOKvalitetu;
    }
}