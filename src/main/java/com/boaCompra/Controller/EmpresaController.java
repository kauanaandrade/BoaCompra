package com.boaCompra.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.boaCompra.Model.EmpresaModel;
import com.boaCompra.Repository.EmpresaRepository;





public class EmpresaController {

	private @Autowired EmpresaRepository repositorio;
	
	@GetMapping("/todos")
    public ResponseEntity<List<EmpresaModel>> getAll(){
        if (repositorio.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        else {
            return ResponseEntity.status(200).body(repositorio.findAll());

        }
    }
	
	 @PostMapping("/salvar")
	    public ResponseEntity<EmpresaModel> salvar(@Valid @RequestBody EmpresaModel novaEmpresa) {
	        return ResponseEntity.status(201).body(repositorio.save(novaEmpresa));
	   
	    }
	
	@PutMapping("/atualizar")
    public ResponseEntity<EmpresaModel> atualizar(@Valid @RequestBody EmpresaModel novaEmpresa) {
        return ResponseEntity.status(201).body(repositorio.save(novaEmpresa));

    }
	
	@DeleteMapping("/deletar/{id_produto}")
    public ResponseEntity<EmpresaModel> deletar(@PathVariable(value = "id_produto") Long idEmpresa) {
        Optional<EmpresaModel> objetoOptional = repositorio.findById(idEmpresa);

        if (objetoOptional.isPresent()) {
            repositorio.deleteById(idEmpresa);
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }
	
}
