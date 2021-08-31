package com.fon.fpis.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StavkaRacunaID implements Serializable {

        private Long stavkaRacunaKupcaID;
        private Long racunId;

    public StavkaRacunaID() {
    }

    public StavkaRacunaID(Long stavkaRacunaKupcaID, Long racunId) {
        this.stavkaRacunaKupcaID = stavkaRacunaKupcaID;
        this.racunId = racunId;
    }

    public Long getStavkaRacunaKupcaID() { return stavkaRacunaKupcaID; }

    public void setStavkaRacunaKupcaID(Long stavkaRacunaKupcaID) { this.stavkaRacunaKupcaID = stavkaRacunaKupcaID; }

    public Long getRacunId() { return racunId; }

    public void setRacunId(Long racunId) { this.racunId = racunId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StavkaRacunaID that = (StavkaRacunaID) o;
        return Objects.equals(stavkaRacunaKupcaID, that.stavkaRacunaKupcaID) && Objects.equals(racunId, that.racunId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stavkaRacunaKupcaID, racunId);
    }
}
