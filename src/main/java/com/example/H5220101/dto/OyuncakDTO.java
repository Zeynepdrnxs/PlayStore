package com.example.H5220101.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class OyuncakDTO { // Data Transfer Object

    private Long ID;
    private Date alisTarihi;
    private Double alisFiyati;
    private String ad;
    private String tur;
    private String notlar;
    private Integer desi;
}
