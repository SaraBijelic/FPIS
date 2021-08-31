package com.fon.fpis.dto;

import java.util.ArrayList;
import java.util.List;

public class StavkaRacunaKupcaListDTO {

    List<StavkaRacunaKupcaDTO> stavke = new ArrayList<>();

    public StavkaRacunaKupcaListDTO() { }

    public List<StavkaRacunaKupcaDTO> getStavke() { return stavke; }

    public void setStavke(List<StavkaRacunaKupcaDTO> stavke) { this.stavke = stavke; }
}
