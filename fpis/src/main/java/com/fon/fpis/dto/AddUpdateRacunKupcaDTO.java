package com.fon.fpis.dto;

public class AddUpdateRacunKupcaDTO {

    private Long racunKupcaID;
    private int rokPlacanjaKupca;
    private String napomenaRacunaKupca;
    private double cenaRacuna;
    private Long kupacID;
    private Long radnikID;
    private Long otpremnicaRacunaID;
    private Long nacinPlacanjaID;
    private AddUpdateStavkeRacunaListDTO stavkaRacunaKupca;

    public AddUpdateRacunKupcaDTO() {
    }

    public Long getRacunKupcaID() { return racunKupcaID; }

    public void setRacunKupcaID(Long racunKupcaID) { this.racunKupcaID = racunKupcaID; }

    public int getRokPlacanjaKupca() { return rokPlacanjaKupca; }

    public void setRokPlacanjaKupca(int rokPlacanjaKupca) { this.rokPlacanjaKupca = rokPlacanjaKupca; }

    public String getNapomenaRacunaKupca() { return napomenaRacunaKupca; }

    public void setNapomenaRacunaKupca(String napomenaRacunaKupca) {
        this.napomenaRacunaKupca = napomenaRacunaKupca;
    }

    public double getCenaRacuna() { return cenaRacuna; }

    public void setCenaRacuna(double cenaRacuna) { this.cenaRacuna = cenaRacuna; }

    public Long getKupacID() { return kupacID; }

    public void setKupacID(Long kupacID) { this.kupacID = kupacID; }

    public Long getRadnikID() { return radnikID; }

    public void setRadnikID(Long radnikID) { this.radnikID = radnikID; }

    public Long getOtpremnicaRacunaID() { return otpremnicaRacunaID; }

    public void setOtpremnicaRacunaID(Long otpremnicaRacunaID) { this.otpremnicaRacunaID = otpremnicaRacunaID; }

    public Long getNacinPlacanjaID() { return nacinPlacanjaID; }

    public void setNacinPlacanjaID(Long nacinPlacanjaID) { this.nacinPlacanjaID = nacinPlacanjaID; }

    public AddUpdateStavkeRacunaListDTO getStavkaRacunaKupca() { return stavkaRacunaKupca; }

    public void setStavkaRacunaKupca(AddUpdateStavkeRacunaListDTO stavkaRacunaKupca) {
        this.stavkaRacunaKupca = stavkaRacunaKupca;
    }
}
