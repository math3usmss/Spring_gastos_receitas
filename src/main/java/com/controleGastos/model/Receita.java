package com.controleGastos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.controleGastos.ENUM.origemENUM;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

@Entity
public class Receita implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotNull(message = "O valor é obrigatório!")
	private Double valor;
	
	@Column(nullable = true)
	private String descricao;
	
	@FutureOrPresent(message = "A data deve ser hoje ou no futuro!")
	@Column(nullable = false)
	private LocalDate data;
	
	@Column(nullable = true)
	@Enumerated(EnumType.STRING)
	private origemENUM origem;
	
	public Receita() {}

	public Receita(Double valor, String descricao,LocalDate data, origemENUM origem) {
		this.valor = valor;
		this.descricao = descricao;
		this.data = data;
		this.origem = origem;
	}

	public Long getId() {
		return id;
	}


	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public origemENUM getOrigem() {
		return origem;
	}

	public void setOrigem(origemENUM origem) {
		this.origem = origem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receita other = (Receita) obj;
		return Objects.equals(id, other.id);
	}
	
}
