package com.fon.fpis.domain;

/***********************************************************************
 * Module:  NacinPlacanja.java
 * Author:  Korisnik
 * Purpose: Defines the Class NacinPlacanja
 ***********************************************************************/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Entity
public class NacinPlacanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long nacinPlacanjaID;
    private String nazivPlacanja;

    public NacinPlacanja() {
    }

    public Long getNacinPlacanjaID() { return nacinPlacanjaID; }

    public void setNacinPlacanjaID(Long nacinPlacanjaID) {
        this.nacinPlacanjaID = nacinPlacanjaID;
    }

    public String getNazivPlacanja() { return nazivPlacanja; }

    public void setNazivPlacanja(String nazivPlacanja) { this.nazivPlacanja = nazivPlacanja; }
}