package com.example.H5220101.service;

import org.springframework.stereotype.Service;
import com.example.H5220101.entity.Oyuncak;

import java.util.List;

@Service
public interface OyuncakService {

    Oyuncak oyuncaklariGetir(Long id);

    Oyuncak oyuncagiKaydet(Oyuncak oyuncak);
    Oyuncak oyuncagiGuncelle(Oyuncak oyuncak);
    List<Oyuncak> oyuncaklariGetir();

    void oyuncagiSil(Long id);
}
