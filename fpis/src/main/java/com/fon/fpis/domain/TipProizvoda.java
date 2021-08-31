package com.fon.fpis.domain;

/***********************************************************************
 * Module:  TipProizvoda.java
 * Author:  Korisnik
 * Purpose: Defines the Class TipProizvoda
 ***********************************************************************/

import javax.persistence.*;
import java.util.*;

@Entity
public class TipProizvoda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long tipProizvodaID;
    private String nazivTipaProizvoda;

    public TipProizvoda() {
    }

    public Long getTipProizvodaID() {
        return tipProizvodaID;
    }

    public void setTipProizvodaID(Long tipProizvodaID) {
        this.tipProizvodaID = tipProizvodaID;
    }

    public String getNazivTipaProizvoda() {
        return nazivTipaProizvoda;
    }

    public void setNazivTipaProizvoda(String nazivTipaProizvoda) {
        this.nazivTipaProizvoda = nazivTipaProizvoda;
    }

    /*public Set<Proizvod> getProizvod() {
        return proizvod;
    }

    public void setProizvod(Set<Proizvod> proizvod) {
        this.proizvod = proizvod;
    }*/
}