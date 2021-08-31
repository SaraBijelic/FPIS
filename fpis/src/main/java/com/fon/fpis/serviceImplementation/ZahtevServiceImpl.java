package com.fon.fpis.serviceImplementation;

import com.fon.fpis.domain.*;
import com.fon.fpis.dto.*;
import com.fon.fpis.exception.StoreException;
import com.fon.fpis.repository.ZahtevZaProveromKvalitetaRepository;
import com.fon.fpis.service.ZahtevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class ZahtevServiceImpl implements ZahtevService {

    @Autowired
    ZahtevZaProveromKvalitetaRepository zahtevZaProveromKvalitetaRepository;

    @Override
    public ZahtevZaProveromKvalitetaListDTO findAllZahtev() {

        List<ZahtevZaProveromKvaliteta> zahtevi = zahtevZaProveromKvalitetaRepository.findAll();
        ZahtevZaProveromKvalitetaListDTO zahteviListDTO = new ZahtevZaProveromKvalitetaListDTO();

        if(zahtevi.isEmpty()){
            throw new StoreException(HttpStatus.NOT_FOUND, "Zahtevi doesn't exist!");
        }else {
            for (ZahtevZaProveromKvaliteta zahtev : zahtevi) {
                ZahtevzaProveromKvalitetaDTO zahtevDTO = new ZahtevzaProveromKvalitetaDTO();
                zahtevDTO.setZahtevID(zahtev.getZahtevID());
                zahtevDTO.setProizvod(setovanjeProizvodaDTO(zahtev.getProizvod()));
                zahtevDTO.setVeterinar(setovanjeVeterinaraDTO(zahtev.getVeterinar()));
                zahtevDTO.setDatum(zahtev.getDatum());
                zahtevDTO.setNapomena(zahtev.getNapomena());
                zahtevDTO.setRadnik(setovanjeRadnikaDTO(zahtev.getRadnik()));
                zahteviListDTO.getZahtevi().add(zahtevDTO);
            }
        }
        return zahteviListDTO;
    }

    public ProizvodDTO setovanjeProizvodaDTO(Proizvod proizvod){

        ProizvodDTO proizvodDTO = new ProizvodDTO();

        proizvodDTO.setProizvodID(proizvod.getProizvodID());
        proizvodDTO.setTipProizvoda(setovanjeTipaProizvodaDTO(proizvod.getTipProizvoda()));
        proizvodDTO.setVrstaProizvoda(proizvod.getVrstaProizvoda());
        proizvodDTO.setNazivProizvoda(proizvod.getNazivProizvoda());
        proizvodDTO.setDatumProizvodnje(proizvod.getDatumProizvodnje());
        proizvodDTO.setCena(proizvod.getCena());
        proizvodDTO.setJedinicaMere(setovanjeJediniceMereDTO(proizvod.getJedinicaMere()));
        proizvodDTO.setTrenutnoStanjeZaliha(proizvod.getTrenutnoStanjeZaliha());

        return proizvodDTO;
    }

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

    public VeterinarDTO setovanjeVeterinaraDTO(Veterinar veterinar){

        VeterinarDTO veterinarDTO = new VeterinarDTO();

        veterinarDTO.setVeterinarID(veterinar.getVeterinarID());
        veterinarDTO.setNazivFirme(veterinar.getNazivFirme());
        veterinarDTO.setEmail(veterinar.getEmail());
        veterinarDTO.setZiroRacun(veterinar.getZiroRacun());
        veterinarDTO.setPib(veterinar.getPib());
        veterinarDTO.setMaticniBr(veterinar.getMaticniBr());
        veterinarDTO.setWebSite(veterinar.getWebSite());

        return veterinarDTO;
    }

    public RadnikDTO setovanjeRadnikaDTO(Radnik radnik){

        RadnikDTO radnikDTO = new RadnikDTO();

        radnikDTO.setRadnikID(radnik.getRadnikID());
        radnikDTO.setBrRadneKnjizice(radnik.getBrRadneKnjizice());
        radnikDTO.setJmbg(radnik.getJmbg());
        radnikDTO.setImePrezime(radnik.getImePrezime());
        radnikDTO.setRadnoMestoID(radnik.getRadnoMestoID());

        return radnikDTO;
    }
}
