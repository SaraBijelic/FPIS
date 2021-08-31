package com.fon.fpis.serviceImplementation;

import com.fon.fpis.domain.Radnik;
import com.fon.fpis.dto.RadnikDTO;
import com.fon.fpis.dto.RadnikListDTO;
import com.fon.fpis.exception.StoreException;
import com.fon.fpis.repository.RadnikRepository;
import com.fon.fpis.service.RadnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RadnikServiceImpl implements RadnikService {

    @Autowired
    RadnikRepository radnikRepository;

    @Override
    public RadnikListDTO findAllRadnik() {

        List<Radnik> radnici = radnikRepository.findAll();
        RadnikListDTO radniciDTO = new RadnikListDTO();

        if(radnici.isEmpty()){
            throw new StoreException(HttpStatus.NOT_FOUND, "Radnici doesn't exist!");
        }else{

            for (Radnik radnik : radnici){
                RadnikDTO radnikDTO = new RadnikDTO();
                radnikDTO.setRadnikID(radnik.getRadnikID());
                radnikDTO.setImePrezime(radnik.getImePrezime());
                radnikDTO.setJmbg(radnik.getJmbg());
                radnikDTO.setBrRadneKnjizice(radnik.getBrRadneKnjizice());
                radnikDTO.setRadnoMestoID(radnik.getRadnoMestoID());

                radniciDTO.getRadnici().add(radnikDTO);
            }
        }
        return radniciDTO;
    }
}
