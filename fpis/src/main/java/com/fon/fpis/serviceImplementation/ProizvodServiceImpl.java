package com.fon.fpis.serviceImplementation;

import com.fon.fpis.domain.JedinicaMere;
import com.fon.fpis.domain.Proizvod;
import com.fon.fpis.domain.TipProizvoda;
import com.fon.fpis.dto.JedinicaMereDTO;
import com.fon.fpis.dto.ProizvodDTO;
import com.fon.fpis.dto.ProizvodListDTO;
import com.fon.fpis.dto.TipProizvodaDTO;
import com.fon.fpis.exception.StoreException;
import com.fon.fpis.repository.ProizvodRepository;
import com.fon.fpis.repository.TipProizvodaRepository;
import com.fon.fpis.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class ProizvodServiceImpl implements ProizvodService {

    @Autowired
    ProizvodRepository proizvodRepository;

    @Autowired
    TipProizvodaRepository tipProizvodaRepository;

    public TipProizvodaDTO setovanjeTipaProizvodaDTO(TipProizvoda tipProizvoda){

        TipProizvodaDTO tipProizvodaDTO = new TipProizvodaDTO();

        tipProizvodaDTO.setTipProizvodaID(tipProizvoda.getTipProizvodaID());
        tipProizvodaDTO.setNazivTipaProizvoda(tipProizvoda.getNazivTipaProizvoda());

        return tipProizvodaDTO;
    }

    public JedinicaMereDTO setovanjeJediniceMereDTO(JedinicaMere jedinicaMere){

        JedinicaMereDTO jedinicaMereDTO = new JedinicaMereDTO();

        jedinicaMereDTO.setJedinicaMereID(jedinicaMere.getJedinicaMereID());
        jedinicaMereDTO.setNazivJediniceMere(jedinicaMere.getNazivJediniceMere());

        return jedinicaMereDTO;
    }

    @Override
    public ProizvodListDTO findAllProizvod() {

        List<Proizvod> proizvodi = proizvodRepository.findAll();
        ProizvodListDTO proizvodListDTO = new ProizvodListDTO();

        if(proizvodi.isEmpty()){
            throw new StoreException(HttpStatus.NOT_FOUND, "Proizvodi doesn't exist!");
        }else {
            for(Proizvod proizvod : proizvodi){
                ProizvodDTO proizvodDTO = new ProizvodDTO();
                proizvodDTO.setProizvodID(proizvod.getProizvodID());
                proizvodDTO.setDatumProizvodnje(proizvod.getDatumProizvodnje());
                proizvodDTO.setNazivProizvoda(proizvod.getNazivProizvoda());
                proizvodDTO.setVrstaProizvoda(proizvod.getVrstaProizvoda());
                proizvodDTO.setCena(proizvod.getCena());
                proizvodDTO.setJedinicaMere(setovanjeJediniceMereDTO(proizvod.getJedinicaMere()));
                proizvodDTO.setTrenutnoStanjeZaliha(proizvod.getTrenutnoStanjeZaliha());
                proizvodDTO.setTipProizvoda(setovanjeTipaProizvodaDTO(proizvod.getTipProizvoda()));
                proizvodListDTO.getProizvodi().add(proizvodDTO);
            }
        }
        return proizvodListDTO;
    }
}
