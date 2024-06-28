package com.example.H5220101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.H5220101.entity.Oyuncak;
import com.example.H5220101.repo.OyuncakRepository;

import java.util.Date;

@SpringBootApplication
public class H5220101Application implements CommandLineRunner {

	@Autowired
	OyuncakRepository oyuncakRepository;

	public static void main(String[] args) {
		SpringApplication.run(H5220101Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Başlangıçta eklenmesini istediğiniz örnek oyuncaklar
		Oyuncak oyuncak = new Oyuncak();
		oyuncak.setAlisTarihi(new Date());
		oyuncak.setAlisFiyati(2599.99);
		oyuncak.setAd("Unicorn");
		oyuncak.setTur("Peluş");
		oyuncak.setDesi(1);
		oyuncak.setNotlar("Kız Çocuk");

		Oyuncak oyuncak1 = new Oyuncak();
		oyuncak1.setAlisTarihi(new Date());
		oyuncak1.setAlisFiyati(1999.99);
		oyuncak1.setAd("At");
		oyuncak1.setTur("Peluş");
		oyuncak1.setDesi(2);
		oyuncak1.setNotlar("Unisex");

		oyuncakRepository.save(oyuncak);
		oyuncakRepository.save(oyuncak1);
	}
}

/*import com.example.H5220101.entity.Oyuncak;
import com.example.H5220101.repo.OyuncakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class H5220101Application {

	public static void main(String[] args) {
		SpringApplication.run(H5220101Application.class, args);
	}
}

@Component
class H5220101Aplication implements CommandLineRunner {

	@Autowired
	private OyuncakRepository oyuncakRepository;

	@Override
	public void run(String... args) throws Exception {
		// Başlangıçta eklenmesini istediğiniz örnek oyuncaklar
		Oyuncak oyuncak = new Oyuncak();
		oyuncak.setAlisTarihi(new Date());
		oyuncak.setAlisFiyati(2599.99);
		oyuncak.setAd("Unicorn");
		oyuncak.setTur("Peluş");
		oyuncak.setDesi(1);
		oyuncak.setNotlar("Kız Çocuk");

		Oyuncak oyuncak1 = new Oyuncak();
		oyuncak1.setAlisTarihi(new Date());
		oyuncak1.setAlisFiyati(1999.99);
		oyuncak1.setAd("At");
		oyuncak1.setTur("Peluş");
		oyuncak1.setDesi(2);
		oyuncak1.setNotlar("Unisex");

		oyuncakRepository.save(oyuncak);
		oyuncakRepository.save(oyuncak1);
	}
}*/
