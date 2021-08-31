package com.fon.fpis.dto;

import com.fon.fpis.domain.*;
import java.util.*;

public class ProizvodDTO {

    private Long proizvodID;
    private String nazivProizvoda;
    private Date datumProizvodnje;
    private Long cena;
    private String vrstaProizvoda;
    private int trenutnoStanjeZaliha;
    private TipProizvodaDTO tipProizvoda;
    private JedinicaMereDTO jedinicaMere;


    public ProizvodDTO() {
    }

    public Long getProizvodID() { return proizvodID; }

    public void setProizvodID(Long proizvodID) { this.proizvodID = proizvodID; }

    public String getNazivProizvoda() { return nazivProizvoda; }

    public void setNazivProizvoda(String nazivProizvoda) { this.nazivProizvoda = nazivProizvoda; }

    public Date getDatumProizvodnje() { return datumProizvodnje; }

    public void setDatumProizvodnje(Date datumProizvodnje) { this.datumProizvodnje = datumProizvodnje; }

    public String getVrstaProizvoda() { return vrstaProizvoda; }

    public void setVrstaProizvoda(String vrstaProizvoda) { this.vrstaProizvoda = vrstaProizvoda; }

    public Long getCena() { return cena; }

    public void setCena(Long cena) { this.cena = cena; }

    public int getTrenutnoStanjeZaliha() {
        return trenutnoStanjeZaliha;
    }

    public void setTrenutnoStanjeZaliha(int trenutnoStanjeZaliha) {
        this.trenutnoStanjeZaliha = trenutnoStanjeZaliha;
    }

    public TipProizvodaDTO getTipProizvoda() { return tipProizvoda; }

    public void setTipProizvoda(TipProizvodaDTO tipProizvoda) { this.tipProizvoda = tipProizvoda; }

    public JedinicaMereDTO getJedinicaMere() { return jedinicaMere; }

    public void setJedinicaMere(JedinicaMereDTO jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }
}
