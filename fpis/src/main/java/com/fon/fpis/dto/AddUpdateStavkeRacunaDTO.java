package com.fon.fpis.dto;

public class AddUpdateStavkeRacunaDTO {

    private Long stavkaRacunaKupcaID;
    private Long racunKupcaID;
    private double kolicinaRobeZaPlacanje;
    private double rabat;
    private double cenaSaPopustom;
    private Long proizvodStavkeRacunaID;

    public AddUpdateStavkeRacunaDTO() {
    }

    public Long getStavkaRacunaKupcaID() { return stavkaRacunaKupcaID; }

    public void setStavkaRacunaKupcaID(Long stavkaRacunaKupcaID) {
        this.stavkaRacunaKupcaID = stavkaRacunaKupcaID;
    }

    public Long getRacunKupcaID() { return racunKupcaID; }

    public void setRacunKupcaID(Long racunKupcaID) { this.racunKupcaID = racunKupcaID; }

    public double getKolicinaRobeZaPlacanje() { return kolicinaRobeZaPlacanje; }

    public void setKolicinaRobeZaPlacanje(double kolicinaRobeZaPlacanje) {
        this.kolicinaRobeZaPlacanje = kolicinaRobeZaPlacanje;
    }

    public double getRabat() { return rabat; }

    public void setRabat(double rabat) { this.rabat = rabat; }

    public double getCenaSaPopustom() { return cenaSaPopustom; }

    public void setCenaSaPopustom(double cenaSaPopustom) { this.cenaSaPopustom = cenaSaPopustom; }

    public Long getProizvodStavkeRacunaID() { return proizvodStavkeRacunaID; }

    public void setProizvodStavkeRacunaID(Long proizvodStavkeRacunaID) {
        this.proizvodStavkeRacunaID = proizvodStavkeRacunaID;
    }
}
