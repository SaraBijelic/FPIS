package com.fon.fpis.dto;

public class KupacDTO {

    private Long kupacID;
    private String nazivKupca;
    private String PIB;
    private String maticniBroj;
    private String ziroRacun;
    private String email;
    private String webSite;

    public KupacDTO() {
    }

    public Long getKupacID() { return kupacID; }

    public void setKupacID(Long kupacID) { this.kupacID = kupacID; }

    public String getNazivKupca() { return nazivKupca; }

    public void setNazivKupca(String nazivKupca) { this.nazivKupca = nazivKupca; }

    public String getPIB() { return PIB; }

    public void setPIB(String PIB) { this.PIB = PIB; }

    public String getMaticniBroj() { return maticniBroj; }

    public void setMaticniBroj(String maticniBroj) { this.maticniBroj = maticniBroj; }

    public String getZiroRacun() { return ziroRacun; }

    public void setZiroRacun(String ziroRacun) { this.ziroRacun = ziroRacun; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getWebSite() { return webSite; }

    public void setWebSite(String webSite) { this.webSite = webSite; }
}
