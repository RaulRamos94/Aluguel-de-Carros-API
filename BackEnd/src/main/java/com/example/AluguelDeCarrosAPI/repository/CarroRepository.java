package com.example.AluguelDeCarrosAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AluguelDeCarrosAPI.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{
    
}
