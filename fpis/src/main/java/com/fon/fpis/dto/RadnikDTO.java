package com.fon.fpis.dto;


public class RadnikDTO {

    private Long radnikID;
    private String brRadneKnjizice;
    private String jmbg;
    private String imePrezime;
    private Long radnoMestoID;

    public RadnikDTO() {
    }

    public Long getRadnikID() { return radnikID; }

    public void setRadnikID(Long radnikID) { this.radnikID = radnikID; }

    public String getBrRadneKnjizice() { return brRadneKnjizice; }

    public void setBrRadneKnjizice(String brRadneKnjizice) { this.brRadneKnjizice = brRadneKnjizice; }

    public String getJmbg() { return jmbg; }

    public void setJmbg(String jmbg) { this.jmbg = jmbg; }

    public String getImePrezime() { return imePrezime; }

    public void setImePrezime(String imePrezime) { this.imePrezime = imePrezime; }

    public Long getRadnoMestoID() { return radnoMestoID; }

    public void setRadnoMestoID(Long radnoMestoID) { this.radnoMestoID = radnoMestoID; }
}
