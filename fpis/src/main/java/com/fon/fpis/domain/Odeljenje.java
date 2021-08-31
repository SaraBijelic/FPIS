package com.fon.fpis.domain; /***********************************************************************
 * Module:  Odeljenje.java
 * Author:  Korisnik
 * Purpose: Defines the Class Odeljenje
 ***********************************************************************/

import javax.persistence.*;

@Entity
public class Odeljenje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long odeljenjeID;
    private String nazivODeljenja;

    public Odeljenje() {
    }

    public Long getOdeljenjeID() { return odeljenjeID; }

    public void setOdeljenjeID(Long odeljenjeID) {
        this.odeljenjeID = odeljenjeID;
    }

    public String getNazivODeljenja() {
        return nazivODeljenja;
    }

    public void setNazivODeljenja(String nazivODeljenja) {
        this.nazivODeljenja = nazivODeljenja;
    }

}