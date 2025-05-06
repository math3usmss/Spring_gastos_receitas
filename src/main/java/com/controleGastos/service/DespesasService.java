package com.controleGastos.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleGastos.model.Despesa;
import com.controleGastos.repository.DespesasRepository;

@Service
public class DespesasService {
	
	private DespesasRepository repository;
	
	@Autowired
	public DespesasService(DespesasRepository repository) {
		this.repository = repository;
	}
	
	public Despesa CriarDespesa(Despesa despesa) {
		
		if(despesa.getData().isBefore(LocalDate.now())) {
			throw new IllegalArgumentException();
		}
		
		return repository.save(despesa);
	}
	
	public Double SomaDespesaMes(int mes) {
		return repository.findAll().stream().filter(data -> data.getData().getMonthValue() == mes)
				.mapToDouble(valor -> valor.getValor()).sum();
	}

}
