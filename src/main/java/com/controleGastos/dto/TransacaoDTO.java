package com.controleGastos.dto;

import java.time.LocalDate;

public record TransacaoDTO (
	Long id,
	Double valor,
	LocalDate data,
	String descricao,
	String tipo,
	String detalhe
){}
