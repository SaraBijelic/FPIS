package com.fon.fpis.dto;

import java.util.ArrayList;
import java.util.List;

public class ProizvodListDTO {

    List<ProizvodDTO> proizvodi = new ArrayList<>();

    public ProizvodListDTO() {}

    public ProizvodListDTO(List<ProizvodDTO> proizvodi) { this.proizvodi = proizvodi; }

    public List<ProizvodDTO> getProizvodi() { return proizvodi; }

    public void setProizvodi(List<ProizvodDTO> proizvodi) { this.proizvodi = proizvodi; }
}
