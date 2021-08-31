package com.fon.fpis.serviceImplementation;

import com.fon.fpis.domain.Kupac;
import com.fon.fpis.domain.OtpremnicaZaKupca;
import com.fon.fpis.domain.Radnik;
import com.fon.fpis.domain.StavkaOtpremniceZaKupca;
import com.fon.fpis.dto.*;
import com.fon.fpis.exception.StoreException;
import com.fon.fpis.repository.OtpremnicaZaKupcaRepository;
import com.fon.fpis.service.OtpremnicaZaKupcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OtpremnicaZaKupcaServiceImpl implements OtpremnicaZaKupcaService {

    @Autowired
    OtpremnicaZaKupcaRepository otpremnicaZaKupcaRepository;

    @Override
    public OtpremnicaZaKupcaDTO findOneOtpremnica(java.lang.Long id) {

        OtpremnicaZaKupca otpremnicaZaKupca = otpremnicaZaKupcaRepository.getOne(id);
        OtpremnicaZaKupcaDTO otpremnicaZaKupcaDTO = new OtpremnicaZaKupcaDTO();
        if(otpremnicaZaKupca != null){
            otpremnicaZaKupcaDTO.setOtpremnicaZaKupcaID(otpremnicaZaKupca.getOtpremnicaZaKupcaID());
            otpremnicaZaKupcaDTO.setDatumOtpremanja(otpremnicaZaKupca.getDatumOtpremanja());
            otpremnicaZaKupcaDTO.setOtpremnicuPrimio(otpremnicaZaKupca.getOtpremnicuPrimio());
            otpremnicaZaKupcaDTO.setKupacOtp(setovanjeKupcaDTO(otpremnicaZaKupca.getKupacOtp()));
            otpremnicaZaKupcaDTO.setRadnikDoprema(setovanjeRadnikaDTO(otpremnicaZaKupca.getRadnikDoprema()));
            otpremnicaZaKupcaDTO.setRadnikKreirao(setovanjeRadnikaDTO(otpremnicaZaKupca.getRadnikKreirao()));
        }else {
            throw new StoreException(HttpStatus.NOT_FOUND, "Otpremnica doesn't exist!");
        }
        return otpremnicaZaKupcaDTO;
    }

    @Override
    public OtpremnicaZaKupcaListDTO findAllOtpremnica() {

        List<OtpremnicaZaKupca> otpremnice = otpremnicaZaKupcaRepository.findAll();
        OtpremnicaZaKupcaListDTO otpremnicaZaKupcaListDTO = new OtpremnicaZaKupcaListDTO();
        if(otpremnice.isEmpty()){
            throw new StoreException(HttpStatus.NOT_FOUND, "Otpremnice doesn't exist!");
        }else{
            for (OtpremnicaZaKupca otpremnicaZaKupca : otpremnice){
                OtpremnicaZaKupcaDTO otpremnicaZaKupcaDTO = new OtpremnicaZaKupcaDTO();
                otpremnicaZaKupcaDTO.setOtpremnicaZaKupcaID(otpremnicaZaKupca.getOtpremnicaZaKupcaID());
                otpremnicaZaKupcaDTO.setDatumOtpremanja(otpremnicaZaKupca.getDatumOtpremanja());
                otpremnicaZaKupcaDTO.setOtpremnicuPrimio(otpremnicaZaKupca.getOtpremnicuPrimio());
                otpremnicaZaKupcaDTO.setKupacOtp(setovanjeKupcaDTO(otpremnicaZaKupca.getKupacOtp()));
                otpremnicaZaKupcaDTO.setRadnikDoprema(setovanjeRadnikaDTO(otpremnicaZaKupca.getRadnikDoprema()));
                otpremnicaZaKupcaDTO.setRadnikKreirao(setovanjeRadnikaDTO(otpremnicaZaKupca.getRadnikKreirao()));
                otpremnicaZaKupcaListDTO.getOtpremnice().add(otpremnicaZaKupcaDTO);
            }
        }
        return otpremnicaZaKupcaListDTO;
    }

    @Override
    public OtpremnicaZaKupcaListDTO findAllOtpremnicaDatum(Date datum) {

        List<OtpremnicaZaKupca> otpremnice = otpremnicaZaKupcaRepository.findByDatumOtpremanja(datum);
        OtpremnicaZaKupcaListDTO otpremnicaZaKupcaListDTO = new OtpremnicaZaKupcaListDTO();
        if(otpremnice.isEmpty()){
            throw new StoreException(HttpStatus.NOT_FOUND, "Otpremnice doesn't exist!");
        }else{
            for (OtpremnicaZaKupca otpremnicaZaKupca : otpremnice){
                OtpremnicaZaKupcaDTO otpremnicaZaKupcaDTO = new OtpremnicaZaKupcaDTO();
                otpremnicaZaKupcaDTO.setOtpremnicaZaKupcaID(otpremnicaZaKupca.getOtpremnicaZaKupcaID());
                otpremnicaZaKupcaDTO.setDatumOtpremanja(otpremnicaZaKupca.getDatumOtpremanja());
                otpremnicaZaKupcaDTO.setOtpremnicuPrimio(otpremnicaZaKupca.getOtpremnicuPrimio());
                otpremnicaZaKupcaDTO.setKupacOtp(setovanjeKupcaDTO(otpremnicaZaKupca.getKupacOtp()));
                otpremnicaZaKupcaDTO.setRadnikDoprema(setovanjeRadnikaDTO(otpremnicaZaKupca.getRadnikDoprema()));
                otpremnicaZaKupcaDTO.setRadnikKreirao(setovanjeRadnikaDTO(otpremnicaZaKupca.getRadnikKreirao()));
                otpremnicaZaKupcaListDTO.getOtpremnice().add(otpremnicaZaKupcaDTO);
            }
        }
        return otpremnicaZaKupcaListDTO;
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
}
