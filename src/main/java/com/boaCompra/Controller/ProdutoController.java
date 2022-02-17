package com.boaCompra.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boaCompra.Model.EmpresaModel;
import com.boaCompra.Model.ProdutoModel;
import com.boaCompra.Repository.ProdutoRepository;


@RestController
@RequestMapping("/api/v1/produto")
@CrossOrigin("*")
public class ProdutoController {
	
	private @Autowired ProdutoRepository repositorio;
	
	@GetMapping("/todos")
    public ResponseEntity<List<ProdutoModel>> getAll(){
        if (repositorio.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        else {
            return ResponseEntity.status(200).body(repositorio.findAll());

        }
    }
	
	@GetMapping("/custo")
	public ResponseEntity<List<ProdutoModel>> getByAll(){
		
		ProdutoModel pesoProduto = new ProdutoModel();
		ProdutoModel distancia = new ProdutoModel();
		EmpresaModel valorFixo = new EmpresaModel();
		EmpresaModel valorKm = new EmpresaModel();
		
		int[] listaValue = new int[20];
		
		for(int i = 0; i < listaValue.length; i++){	
			
			ResponseEntity<List<ProdutoModel>> custo = valorFixo +(pesoProduto*distancia*valorKm);
			return custo;
			
		}
		Arrays.sort(listaValue);
		
		 if (repositorio.findAll().isEmpty()) {
	            return ResponseEntity.status(204).build();
	        }
	        else {
	            return ResponseEntity.status(200).body(repositorio.findAll());

	        }
		
	}
	
	@GetMapping("/{id_produto}")
    public ResponseEntity<ProdutoModel> getById(@PathVariable(value = "id_produto") long idProduto) {
        return repositorio.findById(idProduto).map(resp -> ResponseEntity.status(200).body(resp))
                .orElse(ResponseEntity.status(400).build());
    }
	
	@PostMapping("/salvar")
    public ResponseEntity<ProdutoModel> salvar(@Valid @RequestBody ProdutoModel novoProduto) {
        return ResponseEntity.status(201).body(repositorio.save(novoProduto));
    
    }
	
	 @PutMapping("/atualizar")
	    public ResponseEntity<ProdutoModel> atualizar(@Valid @RequestBody ProdutoModel novoProduto) {
	        return ResponseEntity.status(201).body(repositorio.save(novoProduto));

	    }

	    @DeleteMapping("/deletar/{id_produto}")
	    public ResponseEntity<ProdutoModel> deletar(@PathVariable(value = "id_produto") Long idProduto) {
	        Optional<ProdutoModel> objetoOptional = repositorio.findById(idProduto);

	        if (objetoOptional.isPresent()) {
	            repositorio.deleteById(idProduto);
	            return ResponseEntity.status(204).build();
	        } else {
	            return ResponseEntity.status(400).build();
	        }
	    }
	
}
