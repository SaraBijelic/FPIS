package com.fon.fpis.dto;

import java.util.ArrayList;
import java.util.List;

public class PotvrdaOKvalitetuListDTO {

    List<PotvrdaOKvalitetuDTO> potvrde = new ArrayList<>();

    public PotvrdaOKvalitetuListDTO() {}

    public PotvrdaOKvalitetuListDTO(List<PotvrdaOKvalitetuDTO> potvrde) { this.potvrde = potvrde; }

    public List<PotvrdaOKvalitetuDTO> getPotvrde() { return potvrde; }

    public void setPotvrde(List<PotvrdaOKvalitetuDTO> potvrde) { this.potvrde = potvrde; }
}
