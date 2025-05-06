package com.controleGastos.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.controleGastos.model.Receita;
import com.controleGastos.repository.ReceitaRepository;

@Service
public class ReceitaService {
	
	private ReceitaRepository repository;
	
	
	public ReceitaService(ReceitaRepository repository) {
		this.repository = repository;
	}
	
	public Receita criarReceita(Receita receita) {
		
		if(receita.getData().isBefore(LocalDate.now())) {
			throw new IllegalArgumentException();
		}
		
		return repository.save(receita);
	}
	
	public Double SomaReceitasMes(int mes) {
		return repository.findAll().stream().filter(data -> data.getData().getMonthValue() == mes)
				.mapToDouble(valor -> valor.getValor()).sum();
	}
	
}