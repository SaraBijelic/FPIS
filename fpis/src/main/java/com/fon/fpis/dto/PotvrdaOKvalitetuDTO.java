package com.fon.fpis.dto;


import com.fon.fpis.domain.Kupac;
import com.fon.fpis.domain.Proizvod;
import com.fon.fpis.domain.Veterinar;
import com.fon.fpis.domain.ZahtevZaProveromKvaliteta;

import javax.persistence.ManyToOne;
import java.util.Date;


public class PotvrdaOKvalitetuDTO {

    private Long potvrdaOKvalitetuID;
    private String opisPotvrde;
    private Date datumPotvrde;
    private String vrstaRobe;
    private String mestoIzdavanja;
    private VeterinarDTO veterinar;
    private ZahtevzaProveromKvalitetaDTO zahtev;
    private ProizvodDTO proizvod;

    public PotvrdaOKvalitetuDTO() {
    }

    public Long getPotvrdaOKvalitetuID() { return potvrdaOKvalitetuID; }

    public void setPotvrdaOKvalitetuID(Long potvrdaOKvalitetuID) { this.potvrdaOKvalitetuID = potvrdaOKvalitetuID; }

    public String getOpisPotvrde() { return opisPotvrde; }

    public void setOpisPotvrde(String opisPotvrde) { this.opisPotvrde = opisPotvrde; }

    public Date getDatumPotvrde() { return datumPotvrde; }

    public void setDatumPotvrde(Date datumPotvrde) { this.datumPotvrde = datumPotvrde; }

    public String getVrstaRobe() { return vrstaRobe; }

    public void setVrstaRobe(String vrstaRobe) { this.vrstaRobe = vrstaRobe; }

    public String getMestoIzdavanja() { return mestoIzdavanja; }

    public void setMestoIzdavanja(String mestoIzdavanja) { this.mestoIzdavanja = mestoIzdavanja; }

    public VeterinarDTO getVeterinar() { return veterinar; }

    public void setVeterinar(VeterinarDTO veterinar) { this.veterinar = veterinar; }

    public ZahtevzaProveromKvalitetaDTO getZahtev() { return zahtev; }

    public void setZahtev(ZahtevzaProveromKvalitetaDTO zahtev) { this.zahtev = zahtev; }

    public ProizvodDTO getProizvod() { return proizvod; }

    public void setProizvod(ProizvodDTO proizvod) { this.proizvod = proizvod; }
}
