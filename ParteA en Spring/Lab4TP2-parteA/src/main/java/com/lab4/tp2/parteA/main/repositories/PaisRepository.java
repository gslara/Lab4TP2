package com.lab4.tp2.parteA.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab4.tp2.parteA.main.entities.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
