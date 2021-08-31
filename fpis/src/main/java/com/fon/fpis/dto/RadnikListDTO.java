package com.fon.fpis.dto;
import com.fon.fpis.domain.Radnik;

import java.util.*;

public class RadnikListDTO {

    List<RadnikDTO> radnici = new ArrayList<>();

    public RadnikListDTO() {}

    public List<RadnikDTO> getRadnici() { return radnici; }

    public void setRadnici(List<RadnikDTO> radnici) { this.radnici = radnici; }
}
