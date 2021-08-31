package com.fon.fpis.domain;

import javax.persistence.*;

@Entity
public class StavkaRacunaKupca {

    @EmbeddedId
    private StavkaRacunaID stavkaRacunaId;

    @MapsId("racunId")
    @ManyToOne
    @JoinColumn(name="racun_kupca_racun_kupcaid")
    private RacunKupca racunKupca;

    private double kolicinaRobeZaPlacanje;
    private double rabat;
    private double cenaSaPopustom;

    @ManyToOne
    private Proizvod proizvodStavkeRacuna;

    public StavkaRacunaKupca() {

    }

    public StavkaRacunaID getStavkaRacunaId() { return stavkaRacunaId; }

    public void setStavkaRacunaId(StavkaRacunaID stavkaRacunaId) { this.stavkaRacunaId = stavkaRacunaId; }

    public double getKolicinaRobeZaPlacanje() { return kolicinaRobeZaPlacanje; }

    public void setKolicinaRobeZaPlacanje(double kolicinaRobeZaPlacanje) {
        this.kolicinaRobeZaPlacanje = kolicinaRobeZaPlacanje;
    }

    public double getRabat() { return rabat; }

    public void setRabat(double rabat) { this.rabat = rabat; }

    public double getCenaSaPopustom() { return cenaSaPopustom; }

    public void setCenaSaPopustom(double cenaSaPopustom) {
        this.cenaSaPopustom = cenaSaPopustom;
    }

    public RacunKupca getRacunKupca() { return racunKupca; }

    public void setRacunKupca(RacunKupca racunKupca) { this.racunKupca = racunKupca; }

    public Proizvod getProizvodStavkeRacuna() { return proizvodStavkeRacuna; }

    public void setProizvodStavkeRacuna(Proizvod proizvodStavkeRacuna) {
        this.proizvodStavkeRacuna = proizvodStavkeRacuna;
    }

}
