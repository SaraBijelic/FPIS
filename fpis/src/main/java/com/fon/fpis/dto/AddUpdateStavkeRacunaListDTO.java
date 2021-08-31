package com.fon.fpis.dto;

import java.util.ArrayList;
import java.util.List;

public class AddUpdateStavkeRacunaListDTO {

    List<AddUpdateStavkeRacunaDTO> stavkeList = new ArrayList<>();

    public AddUpdateStavkeRacunaListDTO() { }

    public AddUpdateStavkeRacunaListDTO(List<AddUpdateStavkeRacunaDTO> stavkeList) {
        this.stavkeList = stavkeList;
    }

    public List<AddUpdateStavkeRacunaDTO> getStavkeList() { return stavkeList; }

    public void setStavkeList(List<AddUpdateStavkeRacunaDTO> stavkeList) { this.stavkeList = stavkeList; }
}
