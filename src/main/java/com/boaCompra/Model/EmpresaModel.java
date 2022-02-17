package com.boaCompra.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_empresa")
public class EmpresaModel {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idEmpresa;
	private @NotBlank int nome;
	private @NotBlank int valorFixo;
	private @NotBlank int valorKm;
	
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("empresa")
	private List<ProdutoModel> produto;

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getNome() {
		return nome;
	}

	public void setNome(int nome) {
		this.nome = nome;
	}

	public int getValorFixo() {
		return valorFixo;
	}

	public void setValorFixo(int valorFixo) {
		this.valorFixo = valorFixo;
	}

	public int getValorKm() {
		return valorKm;
	}

	public void setValorKm(int valorKm) {
		this.valorKm = valorKm;
	}
	
	
}
