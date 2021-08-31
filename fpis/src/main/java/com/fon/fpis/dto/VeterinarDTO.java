package com.fon.fpis.dto;

public class VeterinarDTO {

    private Long veterinarID;
    private String nazivFirme;
    private String pib;
    private String maticniBr;
    private String ziroRacun;
    private String email;
    private String webSite;

    public VeterinarDTO() {
    }

    public Long getVeterinarID() { return veterinarID; }

    public void setVeterinarID(Long veterinarID) { this.veterinarID = veterinarID; }

    public String getNazivFirme() { return nazivFirme; }

    public void setNazivFirme(String nazivFirme) { this.nazivFirme = nazivFirme; }

    public String getPib() { return pib; }

    public void setPib(String pib) { this.pib = pib; }

    public String getMaticniBr() { return maticniBr; }

    public void setMaticniBr(String maticniBr) { this.maticniBr = maticniBr; }

    public String getZiroRacun() { return ziroRacun; }

    public void setZiroRacun(String ziroRacun) { this.ziroRacun = ziroRacun; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getWebSite() { return webSite; }

    public void setWebSite(String webSite) { this.webSite = webSite; }
}
