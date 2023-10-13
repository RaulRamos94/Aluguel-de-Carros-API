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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AluguelDeCarrosAPI.model.Cliente;
import com.example.AluguelDeCarrosAPI.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
    }

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable("idCliente") Long idCliente){
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        if(cliente.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable("idCliente") Long idCliente, @RequestBody Cliente cliente){
        Optional<Cliente> clienteCadastrado = clienteRepository.findById(idCliente);
        
        if(clienteCadastrado.isPresent()){
            clienteCadastrado.get().setNome(cliente.getNome());
            clienteCadastrado.get().setCpf(cliente.getCpf());
            clienteCadastrado.get().setDataNascimento(cliente.getDataNascimento());
            clienteCadastrado.get().setDataCadastro(cliente.getDataCadastro());
            clienteCadastrado.get().setCarros(cliente.getCarros());

            return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(clienteCadastrado.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<String> excluirCliente(@PathVariable Long idCliente){
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        if(cliente.isPresent()){
            clienteRepository.deleteById(idCliente);
            return ResponseEntity.ok().body("Cliente excluído com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
}
