package com.fon.fpis.dto;

public class TipProizvodaDTO {

    private Long tipProizvodaID;
    private String nazivTipaProizvoda;

    public TipProizvodaDTO() { }

    public Long getTipProizvodaID() { return tipProizvodaID; }

    public void setTipProizvodaID(Long tipProizvodaID) { this.tipProizvodaID = tipProizvodaID; }

    public String getNazivTipaProizvoda() { return nazivTipaProizvoda; }

    public void setNazivTipaProizvoda(String nazivTipaProizvoda) {
        this.nazivTipaProizvoda = nazivTipaProizvoda;
    }
}
