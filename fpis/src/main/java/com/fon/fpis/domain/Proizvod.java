package com.fon.fpis.domain;

/***********************************************************************
 * Module:  Proizvod.java
 * Author:  Korisnik
 * Purpose: Defines the Class Proizvod
 ***********************************************************************/

import javax.persistence.*;
import java.util.*;

@Entity
public class Proizvod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long proizvodID;
    private String nazivProizvoda;
    private Date datumProizvodnje;
    private Long cena;
    private String vrstaProizvoda;
    private int trenutnoStanjeZaliha;

    @ManyToOne
    private TipProizvoda tipProizvoda;

    @ManyToOne
    private JedinicaMere jedinicaMere;

    public Proizvod() {
    }

    public Long getProizvodID() { return proizvodID; }

    public void setProizvodID(Long proizvodID) { this.proizvodID = proizvodID; }

    public String getNazivProizvoda() { return nazivProizvoda; }

    public void setNazivProizvoda(String nazivProizvoda) { this.nazivProizvoda = nazivProizvoda; }

    public Date getDatumProizvodnje() { return datumProizvodnje; }

    public void setDatumProizvodnje(Date datumProizvodnje) { this.datumProizvodnje = datumProizvodnje; }

    public String getVrstaProizvoda() { return vrstaProizvoda; }

    public void setVrstaProizvoda(String vrstaProizvoda) { this.vrstaProizvoda = vrstaProizvoda; }

    public Long getCena() {
        return cena;
    }

    public void setCena(Long cena) {
        this.cena = cena;
    }

    public int getTrenutnoStanjeZaliha() {
        return trenutnoStanjeZaliha;
    }

    public void setTrenutnoStanjeZaliha(int trenutnoStanjeZaliha) {
        this.trenutnoStanjeZaliha = trenutnoStanjeZaliha;
    }

    public TipProizvoda getTipProizvoda() { return tipProizvoda; }

    public void setTipProizvoda(TipProizvoda tipProizvoda) { this.tipProizvoda = tipProizvoda; }

    public JedinicaMere getJedinicaMere() { return jedinicaMere; }

    public void setJedinicaMere(JedinicaMere jedinicaMere) { this.jedinicaMere = jedinicaMere; }
}