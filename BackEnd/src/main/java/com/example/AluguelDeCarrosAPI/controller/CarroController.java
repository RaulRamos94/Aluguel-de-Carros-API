package com.example.AluguelDeCarrosAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.AluguelDeCarrosAPI.model.Carro;
import com.example.AluguelDeCarrosAPI.repository.CarroRepository;

public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @PostMapping
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody Carro carro){
        return ResponseEntity.status(HttpStatus.CREATED).body(carroRepository.save(carro));
    }

    @GetMapping
    public List<Carro> listarCarros(){
        return carroRepository.findAll();
    }

    @GetMapping("/{idCarro}")
    public ResponseEntity<Carro> buscarCarroPorId(@PathVariable("idCarro") Long idCarro){
        Optional<Carro> carro = carroRepository.findById(idCarro);

        if(carro.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(carro.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{idCarro}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable("idCarro") Long idCarro, @RequestBody Carro carro){
        Optional<Carro> carroCadastrado = carroRepository.findById(idCarro);
        
        if(carroCadastrado.isPresent()){
            carroCadastrado.get().setMarca(carro.getMarca());
            carroCadastrado.get().setModelo(carro.getModelo());
            carroCadastrado.get().setPlaca(carro.getPlaca());
            carroCadastrado.get().setDataCadastro(carro.getDataCadastro());            

            return ResponseEntity.status(HttpStatus.OK).body(carroRepository.save(carroCadastrado.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{idCarro}")
    public ResponseEntity<String> excluirCarro(@PathVariable Long idCarro){
        Optional<Carro> carro = carroRepository.findById(idCarro);

        if(carro.isPresent()){
            carroRepository.deleteById(idCarro);
            return ResponseEntity.ok().body("Carro excluído com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
}
