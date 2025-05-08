package com.controleGastos.dto;

import java.time.LocalDate;

import com.controleGastos.ENUM.categoriasENUM;
import com.controleGastos.ENUM.origemENUM;

public record TransacaoDTO (
	Long id,
	Double valor,
	LocalDate data,
	String descricao,
	String tipo,
	origemENUM origem,
	categoriasENUM categoria
){}
