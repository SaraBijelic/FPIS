package com.fon.fpis.dto;

import java.util.Date;


public class AddUpdatePotvrdaOKvalitetuDTO {

    private Long potvrdaOKvalitetuID;
    private String opisPotvrde;
    private Date datumPotvrde;
    private String vrstaRobe;
    private String mestoIzdavanja;
    private Long veterinarID;
    private Long zahtevID;
    private Long proizvodID;

    public AddUpdatePotvrdaOKvalitetuDTO() {
    }

    public Long getPotvrdaOKvalitetuID() { return potvrdaOKvalitetuID; }

    public void setPotvrdaOKvalitetuID(Long potvrdaOKvalitetuID) {
        this.potvrdaOKvalitetuID = potvrdaOKvalitetuID;
    }

    public String getOpisPotvrde() { return opisPotvrde; }

    public void setOpisPotvrde(String opisPotvrde) { this.opisPotvrde = opisPotvrde; }

    public Date getDatumPotvrde() { return datumPotvrde; }

    public void setDatumPotvrde(Date datumPotvrde) { this.datumPotvrde = datumPotvrde; }

    public String getVrstaRobe() { return vrstaRobe; }

    public void setVrstaRobe(String vrstaRobe) { this.vrstaRobe = vrstaRobe; }

    public String getMestoIzdavanja() { return mestoIzdavanja; }

    public void setMestoIzdavanja(String mestoIzdavanja) { this.mestoIzdavanja = mestoIzdavanja; }

    public Long getVeterinarID() { return veterinarID; }

    public void setVeterinarID(Long veterinarID) { this.veterinarID = veterinarID; }

    public Long getZahtevID() { return zahtevID; }

    public void setZahtevID(Long zahtevID) { this.zahtevID = zahtevID; }

    public Long getProizvodID() { return proizvodID; }

    public void setProizvodID(Long proizvodID) { this.proizvodID = proizvodID; }
}
