package com.fon.fpis.serviceImplementation;

import com.fon.fpis.domain.*;
import com.fon.fpis.dto.*;
import com.fon.fpis.exception.StoreException;
import com.fon.fpis.repository.PotvrdaOKvalitetuRepository;
import com.fon.fpis.repository.ProizvodRepository;
import com.fon.fpis.repository.VeterinarRepository;
import com.fon.fpis.repository.ZahtevZaProveromKvalitetaRepository;
import com.fon.fpis.service.PotvrdaOKvalitetuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PotvrdaOKvalitetuServiceImpl implements PotvrdaOKvalitetuService {

    @Autowired
    PotvrdaOKvalitetuRepository potvrdaOKvalitetuRepository;

    @Autowired
    VeterinarRepository veterinarRepository;

    @Autowired
    ZahtevZaProveromKvalitetaRepository zaProveromKvalitetaRepository;

    @Autowired
    ProizvodRepository proizvodRepository;

    @Override
    public PotvrdaOKvalitetuDTO findPotvrdaOKvalitetu(Long id) {
        return null;
    }

    @Override
    public PotvrdaOKvalitetuListDTO findAllPotvrdaOKvalitetu() {

        List<PotvrdaOKvalitetu> potvrde = potvrdaOKvalitetuRepository.findAll();
        PotvrdaOKvalitetuListDTO potvrdeDTO = new PotvrdaOKvalitetuListDTO();

        if(potvrde.isEmpty()){
            throw new StoreException(HttpStatus.NOT_FOUND, "Potvrde doesn't exist!");
        }else{
            for (PotvrdaOKvalitetu potvrda : potvrde){
                PotvrdaOKvalitetuDTO potvrdaDTO = new PotvrdaOKvalitetuDTO();

                potvrdaDTO.setPotvrdaOKvalitetuID(potvrda.getPotvrdaOKvalitetuID());
                potvrdaDTO.setOpisPotvrde(potvrda.getOpisPotvrde());
                potvrdaDTO.setDatumPotvrde(potvrda.getDatumPotvrde());
                potvrdaDTO.setVrstaRobe(potvrda.getVrstaRobe());
                potvrdaDTO.setMestoIzdavanja(potvrda.getMestoIzdavanja());
                potvrdaDTO.setVeterinar(setovanjeVeterinaraDTO(potvrda.getVeterinar()));
                potvrdaDTO.setZahtev(setovanjeZahtevaDTO(potvrda.getZahtev()));
                potvrdaDTO.setProizvod(setovanjeProizvodaDTO(potvrda.getProizvod()));

                potvrdeDTO.getPotvrde().add(potvrdaDTO);
            }
        }
        return potvrdeDTO;
    }

    @Override
    public boolean updatePotvrdaOKvalitetu(AddUpdatePotvrdaOKvalitetuDTO potvrdaDTO) {

        PotvrdaOKvalitetu potvrda = potvrdaOKvalitetuRepository.getOne(potvrdaDTO.getPotvrdaOKvalitetuID());

        if(potvrda != null){

            potvrda.setOpisPotvrde(potvrdaDTO.getOpisPotvrde());
            potvrda.setDatumPotvrde(potvrdaDTO.getDatumPotvrde());
            Proizvod proizvod = proizvodRepository.getOne(potvrdaDTO.getProizvodID());
            potvrda.setProizvod(proizvod);
            Veterinar veterinar = veterinarRepository.getOne(potvrdaDTO.getVeterinarID());
            potvrda.setVeterinar(veterinar);
            ZahtevZaProveromKvaliteta zahtev = zaProveromKvalitetaRepository.getOne(potvrdaDTO.getZahtevID());
            potvrda.setZahtev(zahtev);
            potvrda.setMestoIzdavanja(potvrdaDTO.getMestoIzdavanja());
            potvrda.setVrstaRobe(potvrdaDTO.getVrstaRobe());
            potvrdaOKvalitetuRepository.save(potvrda);
            return true;
        }else {
            throw new StoreException(HttpStatus.NOT_FOUND, "Potvrda doesn't exist!");
        }
    }

    @Override
    public boolean addPotvrdaOKvalitetu(AddUpdatePotvrdaOKvalitetuDTO potvrdaDTO) {

        PotvrdaOKvalitetu potvrda = new PotvrdaOKvalitetu();

        potvrda.setPotvrdaOKvalitetuID(potvrdaDTO.getPotvrdaOKvalitetuID());
        potvrda.setOpisPotvrde(potvrdaDTO.getOpisPotvrde());
        potvrda.setDatumPotvrde(potvrdaDTO.getDatumPotvrde());
        Proizvod proizvod = proizvodRepository.getOne(potvrdaDTO.getProizvodID());
        potvrda.setProizvod(proizvod);
        Veterinar veterinar = veterinarRepository.getOne(potvrdaDTO.getVeterinarID());
        potvrda.setVeterinar(veterinar);
        ZahtevZaProveromKvaliteta zahtev = zaProveromKvalitetaRepository.getOne(potvrdaDTO.getZahtevID());
        potvrda.setZahtev(zahtev);
        potvrda.setMestoIzdavanja(potvrdaDTO.getMestoIzdavanja());
        potvrda.setVrstaRobe(potvrdaDTO.getVrstaRobe());
        potvrdaOKvalitetuRepository.save(potvrda);
        return true;
    }

    @Override
    public boolean deletePotvrda(Long potvdraID) {
        potvrdaOKvalitetuRepository.deleteById(potvdraID);
        return true;
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

    public ZahtevzaProveromKvalitetaDTO setovanjeZahtevaDTO(ZahtevZaProveromKvaliteta zahtev){

        ZahtevzaProveromKvalitetaDTO zahtevDTO = new ZahtevzaProveromKvalitetaDTO();

        zahtevDTO.setZahtevID(zahtev.getZahtevID());
        zahtevDTO.setProizvod(setovanjeProizvodaDTO(zahtev.getProizvod()));
        zahtevDTO.setVeterinar(setovanjeVeterinaraDTO(zahtev.getVeterinar()));
        zahtevDTO.setDatum(zahtev.getDatum());
        zahtevDTO.setNapomena(zahtev.getNapomena());
        zahtevDTO.setRadnik(setovanjeRadnikaDTO(zahtev.getRadnik()));

        return zahtevDTO;
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
