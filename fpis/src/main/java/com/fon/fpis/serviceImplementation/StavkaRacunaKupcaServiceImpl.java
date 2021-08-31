package com.fon.fpis.serviceImplementation;

import com.fon.fpis.domain.*;
import com.fon.fpis.dto.*;
import com.fon.fpis.repository.ProizvodRepository;
import com.fon.fpis.repository.RacunKupcaRepository;
import com.fon.fpis.repository.StavkaRacunaKupcaRepository;
import com.fon.fpis.service.StavkaRacunaKupcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StavkaRacunaKupcaServiceImpl implements StavkaRacunaKupcaService {

    @Autowired
    StavkaRacunaKupcaRepository stavkaRacunaKupcaRepository;

    @Autowired
    RacunKupcaRepository racunKupcaRepository;

    @Autowired
    ProizvodRepository proizvodRepository;

    @Override
    public StavkaRacunaKupcaDTO findOneStavkaRacuna(Long id) {
        return null;
    }

    @Override
    public StavkaRacunaKupcaListDTO findAllStavkeRacuna() {
        List<StavkaRacunaKupca> stavkeRacuna =
                stavkaRacunaKupcaRepository.findAll();
        StavkaRacunaKupcaListDTO stavkeRacunaDTO = new StavkaRacunaKupcaListDTO();
        if(stavkeRacuna != null){
            for (StavkaRacunaKupca stavka : stavkeRacuna){
                StavkaRacunaKupcaDTO stavkaDTO = new StavkaRacunaKupcaDTO();
                stavkaDTO.setRacunKupca(setovanjeRacunaDTO(stavka.getRacunKupca()));
                stavkaDTO.setStavkaRacunaKupcaID(stavka.getStavkaRacunaId().getStavkaRacunaKupcaID());
                stavkaDTO.setRabat(stavka.getRabat());
                stavkaDTO.setCenaSaPopustom(stavka.getCenaSaPopustom());
                stavkaDTO.setKolicinaRobeZaPlacanje(stavka.getKolicinaRobeZaPlacanje());
                stavkaDTO.setProizvodStavkeRacuna(setovanjeProizvodaDTO(stavka.getProizvodStavkeRacuna()));
                stavkeRacunaDTO.getStavke().add(stavkaDTO);
            }
        }
        return stavkeRacunaDTO;
    }

    @Override
    public StavkaRacunaKupcaListDTO findAllStavkeIDRacuna(Long idRacuna) {

        List<StavkaRacunaKupca> stavkeRacuna =
                stavkaRacunaKupcaRepository.findStavkaRacunaKupcasByRacunKupca_RacunKupcaID(idRacuna);
        StavkaRacunaKupcaListDTO stavkeRacunaDTO = new StavkaRacunaKupcaListDTO();
        if(stavkeRacuna != null){
            for (StavkaRacunaKupca stavka : stavkeRacuna){
                StavkaRacunaKupcaDTO stavkaDTO = new StavkaRacunaKupcaDTO();
                stavkaDTO.setRacunKupca(setovanjeRacunaDTO(stavka.getRacunKupca()));
                stavkaDTO.setStavkaRacunaKupcaID(stavka.getStavkaRacunaId().getStavkaRacunaKupcaID());
                stavkaDTO.setRabat(stavka.getRabat());
                stavkaDTO.setCenaSaPopustom(stavka.getCenaSaPopustom());
                stavkaDTO.setKolicinaRobeZaPlacanje(stavka.getKolicinaRobeZaPlacanje());
                stavkaDTO.setProizvodStavkeRacuna(setovanjeProizvodaDTO(stavka.getProizvodStavkeRacuna()));
                stavkeRacunaDTO.getStavke().add(stavkaDTO);
            }
        }
        return stavkeRacunaDTO;
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

    public  RacunKupcaDTO setovanjeRacunaDTO(RacunKupca racunKupca){

        RacunKupcaDTO racunDTO = new RacunKupcaDTO();
        racunDTO.setRacunKupcaID(racunKupca.getRacunKupcaID());
        racunDTO.setRokPlacanjaKupca(racunKupca.getRokPlacanjaKupca());
        racunDTO.setNapomenaRacunaKupca(racunKupca.getNapomenaRacunaKupca());
        racunDTO.setKupac(setovanjeKupcaDTO(racunKupca.getKupac()));
        racunDTO.setRadnik(setovanjeRadnikaDTO(racunKupca.getRadnik()));
        racunDTO.setOtpremnicaRacunaID(racunKupca.getOtpremnicaRacunaID());
        racunDTO.setNacinPlacanja(setovanjeNacinaPlacanjaDTO(racunKupca.getNacinPlacanja()));

        return racunDTO;
    }

    public KupacDTO setovanjeKupcaDTO(Kupac kupac){

        KupacDTO kupacDTO = new KupacDTO();
        kupacDTO.setKupacID(kupac.getKupacID());
        kupacDTO.setNazivKupca(kupac.getNazivKupca());
        kupacDTO.setEmail(kupac.getEmail());
        kupacDTO.setZiroRacun(kupac.getZiroRacun());
        kupacDTO.setPIB(kupac.getPIB());
        kupacDTO.setMaticniBroj(kupac.getMaticniBroj());
        kupacDTO.setWebSite(kupac.getWebSite());

        return kupacDTO;
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

    public NacinPlacanjaDTO setovanjeNacinaPlacanjaDTO(NacinPlacanja nacinPlacanja){

        NacinPlacanjaDTO nacinPlacanjaDTO = new NacinPlacanjaDTO();

        nacinPlacanjaDTO.setNacinPlacanjaID(nacinPlacanja.getNacinPlacanjaID());
        nacinPlacanjaDTO.setNazivPlacanja(nacinPlacanja.getNazivPlacanja());

        return nacinPlacanjaDTO;
    }

    public JedinicaMereDTO setovanjeJediniceMereDTO(JedinicaMere jedinicaMere){

        JedinicaMereDTO jedinicaMereDTO = new JedinicaMereDTO();

        jedinicaMereDTO.setJedinicaMereID(jedinicaMere.getJedinicaMereID());
        jedinicaMereDTO.setNazivJediniceMere(jedinicaMere.getNazivJediniceMere());

        return jedinicaMereDTO;
    }

    @Override
    public boolean addStavkeRacuna(AddUpdateStavkeRacunaListDTO stavkeRacunaDTO) {

        List<StavkaRacunaKupca> stavkeRacuna = new ArrayList<>();

        for (AddUpdateStavkeRacunaDTO stavkaDTO : stavkeRacunaDTO.getStavkeList()) {
            StavkaRacunaKupca stavka = new StavkaRacunaKupca();

            RacunKupca racun = racunKupcaRepository.getOne(stavkaDTO.getRacunKupcaID());
            stavka.setRacunKupca(racun);
            stavka.setStavkaRacunaId(new StavkaRacunaID(stavkaDTO.getStavkaRacunaKupcaID(),racun.getRacunKupcaID()));
            stavka.setKolicinaRobeZaPlacanje(stavkaDTO.getKolicinaRobeZaPlacanje());
            stavka.setRabat(stavkaDTO.getRabat());
            stavka.setCenaSaPopustom(stavkaDTO.getCenaSaPopustom());
            Proizvod proizvod = proizvodRepository.getOne(stavkaDTO.getProizvodStavkeRacunaID());
            stavka.setProizvodStavkeRacuna(proizvod);
            stavkeRacuna.add(stavka);
        }
        stavkaRacunaKupcaRepository.saveAll(stavkeRacuna);
        return true;
    }
}
