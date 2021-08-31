package com.fon.fpis.domain;

/***********************************************************************
 * Module:  JedinicaMere.java
 * Author:  Korisnik
 * Purpose: Defines the Class JedinicaMere
 ***********************************************************************/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;


@Entity
public class JedinicaMere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long jedinicaMereID;
    private String nazivJediniceMere;

    public JedinicaMere() {
    }

    public Long getJedinicaMereID() { return jedinicaMereID; }

    public void setJedinicaMereID(Long jedinicaMereID) {
        this.jedinicaMereID = jedinicaMereID;
    }

    public String getNazivJediniceMere() {
        return nazivJediniceMere;
    }

    public void setNazivJediniceMere(String nazivJediniceMere) {
        this.nazivJediniceMere = nazivJediniceMere;
    }
}
