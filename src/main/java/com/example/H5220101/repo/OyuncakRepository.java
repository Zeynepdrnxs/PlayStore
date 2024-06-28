package com.example.H5220101.repo;

import com.example.H5220101.entity.Oyuncak;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OyuncakRepository extends JpaRepository<Oyuncak, Long> {
    // Özel sorgular eklenebilir, ancak genellikle JpaRepository'nin sunduğu metotlar yeterlidir.
}
