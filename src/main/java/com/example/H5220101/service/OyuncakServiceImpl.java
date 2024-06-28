package com.example.H5220101.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.H5220101.entity.Oyuncak;
import com.example.H5220101.repo.OyuncakRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Slf4j
@Service
public class OyuncakServiceImpl implements OyuncakService {

    @Autowired
    private OyuncakRepository oyuncakRepository;

    @Override
    public Oyuncak oyuncagiGuncelle(Oyuncak oyuncak) {
        // Gelen parametreleri logla
        System.out.println("Alış Tarihi: " + oyuncak.getAlisTarihi());
        System.out.println("Alış Fiyatı: " + oyuncak.getAlisFiyati());
        System.out.println("Ad: " + oyuncak.getAd());
        System.out.println("Tür: " + oyuncak.getTur());
        System.out.println("Desi: " + oyuncak.getDesi());
        System.out.println("Notlar: " + oyuncak.getNotlar());

        // Veritabanında güncelleme işlemi yap
        Oyuncak guncellenmisOyuncak = oyuncakRepository.save(oyuncak);

        // Güncellenmiş oyuncak nesnesini döndür
        return guncellenmisOyuncak;
    }

    // Diğer metodlar
    @Override
    public Oyuncak oyuncaklariGetir(Long id) {
        log.info("oyuncagiGetir servisi çağırıldı.");
        return oyuncakRepository.getReferenceById(id);
    }

    @Override
    public Oyuncak oyuncagiKaydet(Oyuncak oyuncak) {
        return oyuncakRepository.save(oyuncak);
    }

    @Override
    public List<Oyuncak> oyuncaklariGetir() {
        return oyuncakRepository.findAll();
    }

    @Override
    public void oyuncagiSil(Long id) {
        oyuncakRepository.deleteById(id);
    }

}