package com.controleGastos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.controleGastos.ENUM.origemENUM;
import com.controleGastos.model.Receita;
import com.controleGastos.repository.ReceitaRepository;

import jakarta.transaction.Transactional;

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
	
	public List<Receita> listaOrigem(origemENUM origmem){
		return repository.findByOrigem(origmem);
	}
	
	public void deletarReceita(Long id) {
		repository.deleteById(id);
		repository.flush();
	}
	
	
	
}