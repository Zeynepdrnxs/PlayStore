package com.example.H5220101.controller;

import com.example.H5220101.entity.Oyuncak;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.H5220101.dto.OyuncakDTO;
import com.example.H5220101.service.OyuncakServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j

public class OyuncakController {


    @Autowired
    OyuncakServiceImpl oyuncakService;

    @PostMapping("/ekle")
    public ResponseEntity<String> ekle(@RequestBody OyuncakDTO oyuncakDTO) {
        log.info("ekle servisi çağrıldı. Parametreler:" + oyuncakDTO);
        try {
            Oyuncak oyuncak = new Oyuncak();
            log.debug("ekle servisi : Oyuncak nesnesi oluşturuldu");
            oyuncak.setAlisTarihi(oyuncakDTO.getAlisTarihi());
            oyuncak.setAlisFiyati(oyuncakDTO.getAlisFiyati());
            oyuncak.setAd(oyuncakDTO.getAd());
            oyuncak.setTur(oyuncakDTO.getTur());
            oyuncak.setDesi(oyuncakDTO.getDesi());
            oyuncak.setNotlar(oyuncakDTO.getNotlar());
            log.debug("ekle servisi : Oyuncak nesnesinin değerleri atandı.");
            Oyuncak kaydedilmisOyuncak = oyuncakService.oyuncagiKaydet(oyuncak);
            log.debug("ekle servisi : Oyuncak servisi çağrıldı.");
            return ResponseEntity.ok(kaydedilmisOyuncak.getAd() + " oyuncak ismi ile yeni bir oyuncak oluşturuldu.");
        } catch (Exception e) {
            log.error("ekle servisi çalışırken hata aldı. "
                    + "Parametreler:" + oyuncakDTO
                    + "Hata:" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ekleme başarısız! Hata: " + e.getMessage());
        }
    }

    @GetMapping("/getir")
    public OyuncakDTO oyuncagiGetir(Long id) {
        Oyuncak oyuncak = oyuncakService.oyuncaklariGetir(id);
        OyuncakDTO oyuncakDTO = new OyuncakDTO(oyuncak.getID(),oyuncak.getAlisTarihi(),oyuncak.getAlisFiyati(), oyuncak.getAd(), oyuncak.getTur(), oyuncak.getNotlar(), oyuncak.getDesi());
        return oyuncakDTO;
    }

    @DeleteMapping("/sil")
    public String oyuncagiSil(Long id) {
        if (id < 1) {
            return "ID bilgisi boş olamaz!";
        }
        oyuncakService.oyuncagiSil(id);
        return id + " id nolu Oyuncak silindi!";
    }

    @PutMapping("/guncelle/{id}")
    public OyuncakDTO oyuncagiGuncelle(@PathVariable Long id, @RequestBody OyuncakDTO oyuncakDTO) {
        Oyuncak oyuncak = oyuncakService.oyuncaklariGetir(id);
        oyuncak.setAlisTarihi(oyuncakDTO.getAlisTarihi());
        oyuncak.setAlisFiyati(oyuncakDTO.getAlisFiyati());
        oyuncak.setAd(oyuncakDTO.getAd());
        oyuncak.setTur(oyuncakDTO.getTur());
        oyuncak.setDesi(oyuncakDTO.getDesi());
        oyuncak.setNotlar(oyuncakDTO.getNotlar());
        oyuncakService.oyuncagiKaydet(oyuncak);
        return new OyuncakDTO(oyuncak.getID(),oyuncak.getAlisTarihi(),oyuncak.getAlisFiyati(), oyuncak.getAd(), oyuncak.getTur(), oyuncak.getNotlar(), oyuncak.getDesi());
    }



    @GetMapping("/listele")
    public List<OyuncakDTO> listele() {
        log.info("listele servisi çağrıldı!");
        List<Oyuncak> oyuncaklariListele = oyuncakService.oyuncaklariGetir();
        List<OyuncakDTO> tumOyuncaklariListele = new ArrayList<>();
        for (Oyuncak o : oyuncaklariListele) {
            OyuncakDTO oDTO = new OyuncakDTO(o.getID(),o.getAlisTarihi(),o.getAlisFiyati(), o.getAd(), o.getTur(), o.getNotlar(), o.getDesi());
            tumOyuncaklariListele.add(oDTO);
        }

        return tumOyuncaklariListele;
    }

}
