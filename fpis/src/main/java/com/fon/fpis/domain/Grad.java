package com.fon.fpis.domain;

/***********************************************************************
 * Module:  Grad.java
 * Author:  Korisnik
 * Purpose: Defines the Class Grad
 ***********************************************************************/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;


@Entity
public class Grad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long gradID;
    private String nazivGrada;

    public Grad() {}

    public Long getGradID() {
        return gradID;
    }

    public void setGradID(long gradID) {
        this.gradID = gradID;
    }

    public String getNazivGrada() {
        return nazivGrada;
    }

    public void setNazivGrada(String nazivGrada) {
        this.nazivGrada = nazivGrada;
    }
}