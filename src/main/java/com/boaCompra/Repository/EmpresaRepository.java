package com.boaCompra.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boaCompra.Model.EmpresaModel;


public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long>{

	public List<EmpresaModel> findAllByDescricaoContainingIgnoreCase(String nome);
	
}
