package com.fon.fpis.dto;


import java.util.ArrayList;
import java.util.List;

public class StavkaOtpremniceZaKupcaListDTO {

    List<StavkaOtpremniceZaKupcaDTO> stavkeOtpremniceListDTO = new ArrayList<>();

    public StavkaOtpremniceZaKupcaListDTO() { }

    public StavkaOtpremniceZaKupcaListDTO(List<StavkaOtpremniceZaKupcaDTO> stavkeOtpremniceListDTO) {
        this.stavkeOtpremniceListDTO = stavkeOtpremniceListDTO;
    }

    public List<StavkaOtpremniceZaKupcaDTO> getStavkeOtpremniceListDTO() { return stavkeOtpremniceListDTO; }

    public void setStavkeOtpremniceListDTO(List<StavkaOtpremniceZaKupcaDTO> stavkeOtpremniceListDTO) {
        this.stavkeOtpremniceListDTO = stavkeOtpremniceListDTO;
    }
}
