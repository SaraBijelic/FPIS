package com.fon.fpis.service;

import com.fon.fpis.dto.AddUpdatePotvrdaOKvalitetuDTO;
import com.fon.fpis.dto.PotvrdaOKvalitetuDTO;
import com.fon.fpis.dto.PotvrdaOKvalitetuListDTO;
import java.security.Principal;

public interface PotvrdaOKvalitetuService {

    public PotvrdaOKvalitetuDTO findPotvrdaOKvalitetu(Long id);

    public PotvrdaOKvalitetuListDTO findAllPotvrdaOKvalitetu();

    public boolean updatePotvrdaOKvalitetu(AddUpdatePotvrdaOKvalitetuDTO potvrda);

    public boolean addPotvrdaOKvalitetu(AddUpdatePotvrdaOKvalitetuDTO potvrda);

    public boolean deletePotvrda(Long potvdraID);


}
