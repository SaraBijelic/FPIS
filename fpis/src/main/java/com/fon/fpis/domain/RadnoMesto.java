package com.fon.fpis.domain;
/***********************************************************************
 * Module:  RadnoMesto.java
 * Author:  Korisnik
 * Purpose: Defines the Class RadnoMesto
 ***********************************************************************/

import javax.persistence.*;
import java.util.*;

@Entity
public class RadnoMesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long radnoMestoID;
    private String nazivRadnogMesta;
    private String opisRadnogMesta;

    @ManyToOne
    private Odeljenje odeljenje;

    public RadnoMesto() {
    }

    public Long getRadnoMestoID() { return radnoMestoID; }

    public void setRadnoMestoID(Long radnoMestoID) { this.radnoMestoID = radnoMestoID; }

    public Odeljenje getOdeljenje() { return odeljenje; }

    public void setOdeljenje(Odeljenje odeljenje) { this.odeljenje = odeljenje; }

    public String getNazivRadnogMesta() { return nazivRadnogMesta; }

    public void setNazivRadnogMesta(String nazivRadnogMesta) { this.nazivRadnogMesta = nazivRadnogMesta; }

    public String getOpisRadnogMesta() { return opisRadnogMesta; }

    public void setOpisRadnogMesta(String opisRadnogMesta) {
        this.opisRadnogMesta = opisRadnogMesta;
    }

}