package com.fon.fpis.dto;

import com.fon.fpis.domain.Proizvod;
import com.fon.fpis.domain.Radnik;
import com.fon.fpis.domain.Veterinar;
import java.util.Date;

public class ZahtevzaProveromKvalitetaDTO {

    private Long zahtevID;
    private Date datum;
    private String napomena;
    private VeterinarDTO veterinar;
    private ProizvodDTO proizvod;
    private RadnikDTO radnik;

    public ZahtevzaProveromKvalitetaDTO() {
    }

    public Long getZahtevID() { return zahtevID; }

    public void setZahtevID(Long zahtevID) { this.zahtevID = zahtevID; }

    public Date getDatum() { return datum; }

    public void setDatum(Date datum) { this.datum = datum; }

    public String getNapomena() { return napomena; }

    public void setNapomena(String napomena) { this.napomena = napomena; }

    public VeterinarDTO getVeterinar() { return veterinar; }

    public void setVeterinar(VeterinarDTO veterinar) { this.veterinar = veterinar; }

    public ProizvodDTO getProizvod() { return proizvod; }

    public void setProizvod(ProizvodDTO proizvod) { this.proizvod = proizvod; }

    public RadnikDTO getRadnik() { return radnik; }

    public void setRadnik(RadnikDTO radnik) { this.radnik = radnik; }
}
