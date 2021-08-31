package com.fon.fpis.serviceImplementation;

import com.fon.fpis.domain.NacinPlacanja;
import com.fon.fpis.dto.NacinPlacanjaDTO;
import com.fon.fpis.dto.NacinPlacanjaListDTO;
import com.fon.fpis.exception.StoreException;
import com.fon.fpis.repository.NacinPlacanjaRepository;
import com.fon.fpis.service.NacinPlacanjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NacinPlacanjaServiceImpl implements NacinPlacanjaService {

    @Autowired
    NacinPlacanjaRepository nacinPlacanjaRepository;

    @Override
    public NacinPlacanjaListDTO findAllNaciniPlacanja() {

        List<NacinPlacanja> placanja = nacinPlacanjaRepository.findAll();
        NacinPlacanjaListDTO placanjaDTO = new NacinPlacanjaListDTO();

        if(placanja.isEmpty()){
            throw new StoreException(HttpStatus.NOT_FOUND, "Placanja doesn't exist!");
        }else{
            for (NacinPlacanja nacin : placanja){
                NacinPlacanjaDTO nacinDT0 = new NacinPlacanjaDTO();
                nacinDT0.setNacinPlacanjaID(nacin.getNacinPlacanjaID());
                nacinDT0.setNazivPlacanja(nacin.getNazivPlacanja());

                placanjaDTO.getPlacanja().add(nacinDT0);
            }
        }
        return placanjaDTO;
    }
}
