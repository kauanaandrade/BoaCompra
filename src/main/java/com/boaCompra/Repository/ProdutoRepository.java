package com.boaCompra.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boaCompra.Model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	public List<ProdutoModel> findAllByContainingIgnoreCase (String nome);
	
}
