package com.fon.fpis.dto;

public class StavkaRacunaKupcaDTO {

    private Long stavkaRacunaKupcaID;
    private RacunKupcaDTO racunKupca;
    private double kolicinaRobeZaPlacanje;
    private double rabat;
    private double cenaSaPopustom;
    private ProizvodDTO proizvodStavkeRacuna;

    public StavkaRacunaKupcaDTO() {
    }

    public Long getStavkaRacunaKupcaID() { return stavkaRacunaKupcaID; }

    public void setStavkaRacunaKupcaID(Long stavkaRacunaKupcaID) { this.stavkaRacunaKupcaID = stavkaRacunaKupcaID; }

    public RacunKupcaDTO getRacunKupca() { return racunKupca; }

    public void setRacunKupca(RacunKupcaDTO racunKupca) { this.racunKupca = racunKupca; }

    public double getKolicinaRobeZaPlacanje() { return kolicinaRobeZaPlacanje; }

    public void setKolicinaRobeZaPlacanje(double kolicinaRobeZaPlacanje) {
        this.kolicinaRobeZaPlacanje = kolicinaRobeZaPlacanje;
    }

    public double getRabat() { return rabat; }

    public void setRabat(double rabat) { this.rabat = rabat; }

    public double getCenaSaPopustom() { return cenaSaPopustom; }

    public void setCenaSaPopustom(double cenaSaPopustom) { this.cenaSaPopustom = cenaSaPopustom; }

    public ProizvodDTO getProizvodStavkeRacuna() { return proizvodStavkeRacuna; }

    public void setProizvodStavkeRacuna(ProizvodDTO proizvodStavkeRacuna) {
        this.proizvodStavkeRacuna = proizvodStavkeRacuna;
    }
}
