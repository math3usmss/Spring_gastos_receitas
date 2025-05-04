package com.controleGastos.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.controleGastos.model.Despesa;
import com.controleGastos.repository.DespesasRepository;

@Service
public class DespesasService {
	
	private DespesasRepository repository;
	
	public DespesasService(DespesasRepository repository) {
		this.repository = repository;
	}
	
	public Despesa CriarDespesa(Despesa despesa) {
		
		if(despesa.getData().isBefore(LocalDate.now())) {
			throw new IllegalArgumentException();
		}
		
		return repository.save(despesa);
	}

}
