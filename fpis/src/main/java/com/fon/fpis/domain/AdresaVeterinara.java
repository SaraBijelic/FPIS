package com.fon.fpis.domain;

/***********************************************************************
 * Module:  AdresaVeterinara.java
 * Author:  Korisnik
 * Purpose: Defines the Class AdresaVeterinara
 ***********************************************************************/

import javax.persistence.*;

@Entity
public class AdresaVeterinara {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long adresaVeterinaraID;

    @ManyToOne
    private Veterinar veterinar;

    private String ulica;
    private String broj;
    private String fax;
    private String telefon;

    @ManyToOne
    private Grad grad;

    public AdresaVeterinara() {}

    public Long getAdresaVeterinaraID() { return adresaVeterinaraID; }

    public void setAdresaVeterinaraID(Long adresaVeterinaraID) { this.adresaVeterinaraID = adresaVeterinaraID; }

    public Veterinar getVeterinar() { return veterinar; }

    public void setVeterinar(Veterinar veterinar) { this.veterinar = veterinar; }

    public Grad getGrad() { return grad; }

    public void setGrad(Grad grad) { this.grad = grad; }

    public String getUlica() { return ulica; }

    public void setUlica(String ulica) { this.ulica = ulica; }

    public String getBroj() { return broj; }

    public void setBroj(String broj) { this.broj = broj; }

    public String getFax() { return fax; }

    public void setFax(String fax) { this.fax = fax; }

    public String getTelefon() { return telefon; }

    public void setTelefon(String telefon) { this.telefon = telefon; }
}