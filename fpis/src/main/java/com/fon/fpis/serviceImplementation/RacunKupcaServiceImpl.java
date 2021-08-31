package com.fon.fpis.serviceImplementation;
import com.fon.fpis.domain.*;
import com.fon.fpis.dto.*;
import com.fon.fpis.exception.StoreException;
import com.fon.fpis.repository.*;
import com.fon.fpis.service.RacunKupcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RacunKupcaServiceImpl implements RacunKupcaService {

    @Autowired
    RacunKupcaRepository racunKupcaRepository;

    @Autowired
    NacinPlacanjaRepository nacinPlacanjaRepository;

    @Autowired
    OtpremnicaZaKupcaRepository otpremnicaZaKupcaRepository;

    @Autowired
    RadnikRepository radnikRepository;

    @Autowired
    ProizvodRepository proizvodRepository;

    @Autowired
    StavkaRacunaKupcaRepository stavkaRacunaKupcaRepository;

    @Override
    public RacunKupcaListDTO findAllRacunKupca() {

        List<RacunKupca> racuni = racunKupcaRepository.findAll();
        RacunKupcaListDTO racuniDTO = new RacunKupcaListDTO();

        if(racuni.isEmpty()){
            throw new StoreException(HttpStatus.NOT_FOUND, "RacuniKupca doesn't exist!");
        }else{
            for (RacunKupca racun : racuni){
                RacunKupcaDTO racunDTO = new RacunKupcaDTO();
                racunDTO.setRacunKupcaID(racun.getRacunKupcaID());
                racunDTO.setRokPlacanjaKupca(racun.getRokPlacanjaKupca());
                racunDTO.setNapomenaRacunaKupca(racun.getNapomenaRacunaKupca());
                racunDTO.setKupac(setovanjeKupcaDTO(racun.getKupac()));
                racunDTO.setRadnik(setovanjeRadnikaDTO(racun.getRadnik()));
                racunDTO.setOtpremnicaRacunaID(racun.getOtpremnicaRacunaID());
                racunDTO.setNacinPlacanja(setovanjeNacinaPlacanjaDTO(racun.getNacinPlacanja()));
                racuniDTO.getRacuni().add(racunDTO);
            }
        }
        return racuniDTO;
    }

    @Override
    public boolean addRacunKupca(AddUpdateRacunKupcaDTO racunDTO) {

        RacunKupca racun = new RacunKupca();
        racun.setRacunKupcaID(racunDTO.getRacunKupcaID());
        racun.setRokPlacanjaKupca(racunDTO.getRokPlacanjaKupca());
        racun.setNapomenaRacunaKupca(racunDTO.getNapomenaRacunaKupca());
        NacinPlacanja nacinPlacanja = nacinPlacanjaRepository.getOne(racunDTO.getNacinPlacanjaID());
        racun.setNacinPlacanja(nacinPlacanja);
        racun.setOtpremnicaRacunaID(racunDTO.getOtpremnicaRacunaID());
        OtpremnicaZaKupca otpremnicaZaKupca = otpremnicaZaKupcaRepository.getOne(racunDTO.getOtpremnicaRacunaID());
        racun.setKupac(otpremnicaZaKupca.getKupacOtp());
        racun.setCenaRacuna(racunDTO.getCenaRacuna());
        Radnik radnik = radnikRepository.getOne(racunDTO.getRadnikID());
        racun.setRadnik(radnik);
        racun = racunKupcaRepository.save(racun);
        for(AddUpdateStavkeRacunaDTO stavkaRacunaDTO: racunDTO.getStavkaRacunaKupca().getStavkeList()){
            StavkaRacunaKupca stavkaRacuna = new StavkaRacunaKupca();
            stavkaRacuna.setStavkaRacunaId(new StavkaRacunaID(stavkaRacunaDTO.getStavkaRacunaKupcaID(),racun.getRacunKupcaID()));
            stavkaRacuna.setRacunKupca(racun);
            stavkaRacuna.setKolicinaRobeZaPlacanje(stavkaRacunaDTO.getKolicinaRobeZaPlacanje());
            stavkaRacuna.setRabat(stavkaRacunaDTO.getRabat());
            stavkaRacuna.setCenaSaPopustom(stavkaRacunaDTO.getCenaSaPopustom());
            Proizvod proizvod = proizvodRepository.getOne(stavkaRacunaDTO.getProizvodStavkeRacunaID());
            stavkaRacuna.setProizvodStavkeRacuna(proizvod);
            this.stavkaRacunaKupcaRepository.save(stavkaRacuna);
        }
        return true;
    }

    @Override
    public boolean deleteRacunaKupca(Long racunID) {

        RacunKupca racun = racunKupcaRepository.getOne(racunID);
        System.out.println("Stavke "+racun.getStavkaRacunaKupca().size());
        for(StavkaRacunaKupca stavka : racun.getStavkaRacunaKupca()){
            StavkaRacunaKupca stavkaRacuna = stavkaRacunaKupcaRepository.getOne(stavka.getStavkaRacunaId());
            if (stavkaRacuna!=null) this.stavkaRacunaKupcaRepository.deleteById(stavkaRacuna.getStavkaRacunaId());
        }
        racunKupcaRepository.deleteById(racunID);
        return true;
    }

    @Override
    public boolean updateRacunKupca(AddUpdateRacunKupcaDTO racunDTO) {

        RacunKupca racun = racunKupcaRepository.getOne(racunDTO.getRadnikID());

        if(racun != null){

            racun.setRokPlacanjaKupca(racunDTO.getRokPlacanjaKupca());
            racun.setNapomenaRacunaKupca(racunDTO.getNapomenaRacunaKupca());
            NacinPlacanja nacinPlacanja = nacinPlacanjaRepository.getOne(racunDTO.getNacinPlacanjaID());
            racun.setNacinPlacanja(nacinPlacanja);
            racun.setOtpremnicaRacunaID(racunDTO.getOtpremnicaRacunaID());
            OtpremnicaZaKupca otpremnicaZaKupca = otpremnicaZaKupcaRepository.getOne(racunDTO.getOtpremnicaRacunaID());
            racun.setKupac(otpremnicaZaKupca.getKupacOtp());
            racun.setCenaRacuna(racunDTO.getCenaRacuna());
            Radnik radnik = radnikRepository.getOne(racunDTO.getRadnikID());
            racun.setRadnik(radnik);
            racunKupcaRepository.save(racun);
            List<StavkaRacunaKupca> stavkeR = stavkaRacunaKupcaRepository.findStavkaRacunaKupcasByRacunKupca_RacunKupcaID(racunDTO.getRacunKupcaID());
            for(StavkaRacunaKupca stavka : stavkeR){
                StavkaRacunaKupca stavkaRacuna = stavkaRacunaKupcaRepository.getOne(stavka.getStavkaRacunaId());
                if (stavkaRacuna!=null) this.stavkaRacunaKupcaRepository.deleteById(stavkaRacuna.getStavkaRacunaId());
            }
            RacunKupca racunKupca = racunKupcaRepository.getOne(racunDTO.getRacunKupcaID());
            for(AddUpdateStavkeRacunaDTO stavkaRacunaDTO: racunDTO.getStavkaRacunaKupca().getStavkeList()){
                StavkaRacunaKupca stavkaRacuna = new StavkaRacunaKupca();
                stavkaRacuna.setStavkaRacunaId(new StavkaRacunaID(stavkaRacunaDTO.getStavkaRacunaKupcaID(),stavkaRacunaDTO.getRacunKupcaID()));
                stavkaRacuna.setRacunKupca(racunKupca);
                stavkaRacuna.setKolicinaRobeZaPlacanje(stavkaRacunaDTO.getKolicinaRobeZaPlacanje());
                stavkaRacuna.setRabat(stavkaRacunaDTO.getRabat());
                stavkaRacuna.setCenaSaPopustom(stavkaRacunaDTO.getCenaSaPopustom());
                Proizvod proizvod = proizvodRepository.getOne(stavkaRacunaDTO.getProizvodStavkeRacunaID());
                stavkaRacuna.setProizvodStavkeRacuna(proizvod);
                this.stavkaRacunaKupcaRepository.save(stavkaRacuna);
            }
            return true;
        }else{
            throw new StoreException(HttpStatus.NOT_FOUND, "Racun doesn't exist!");
        }
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
}
