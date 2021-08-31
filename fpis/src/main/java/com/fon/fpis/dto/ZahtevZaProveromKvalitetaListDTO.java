package com.fon.fpis.dto;

import java.util.*;

public class ZahtevZaProveromKvalitetaListDTO {

    List<ZahtevzaProveromKvalitetaDTO> zahtevi = new ArrayList<>();;

    public ZahtevZaProveromKvalitetaListDTO() {}

    public ZahtevZaProveromKvalitetaListDTO(List<ZahtevzaProveromKvalitetaDTO> zahtevi) { this.zahtevi = zahtevi; }

    public List<ZahtevzaProveromKvalitetaDTO> getZahtevi() { return zahtevi; }

    public void setZahtevi(List<ZahtevzaProveromKvalitetaDTO> zahtevi) { this.zahtevi = zahtevi; }
}
