package com.fon.fpis.dto;

import com.fon.fpis.domain.RacunKupca;
import java.util.*;

public class RacunKupcaListDTO {

    List<RacunKupcaDTO> racuni = new ArrayList<>();

    public RacunKupcaListDTO() {}

    public RacunKupcaListDTO(List<RacunKupcaDTO> racuni) { this.racuni = racuni; }

    public List<RacunKupcaDTO> getRacuni() { return racuni; }

    public void setRacuni(List<RacunKupcaDTO> racuni) { this.racuni = racuni; }
}
