package com.fon.fpis.dto;

import java.util.ArrayList;
import java.util.List;

public class NacinPlacanjaListDTO {

    List<NacinPlacanjaDTO> placanja = new ArrayList<>();

    public NacinPlacanjaListDTO() { }

    public NacinPlacanjaListDTO(List<NacinPlacanjaDTO> placanja) { this.placanja = placanja; }

    public List<NacinPlacanjaDTO> getPlacanja() { return placanja; }

    public void setPlacanja(List<NacinPlacanjaDTO> placanja) { this.placanja = placanja; }
}
