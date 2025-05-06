package com.controleGastos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.controleGastos.dto.TransacaoDTO;
import com.controleGastos.repository.DespesasRepository;
import com.controleGastos.repository.ReceitaRepository;

@Service
public class TransacaoService {
	
	private ReceitaRepository receitaRepository;
	private DespesasRepository despesasRepository;
	
	public TransacaoService(ReceitaRepository receitaRepository,DespesasRepository despesasRepository) {
		this.receitaRepository = receitaRepository;
		this.despesasRepository = despesasRepository;
	}
	
	public List<TransacaoDTO> listarTransacoes(){
		
		List<TransacaoDTO> transacoes = new ArrayList<>();
		
		receitaRepository.findAll().forEach(receita -> {
			transacoes.add(new TransacaoDTO(receita.getId(), 
					receita.getValor(), receita.getData(), 
					receita.getDescricao(), "RECEITA", receita.getOrigem()));
		});
		
		despesasRepository.findAll().forEach(despesa -> {
			transacoes.add(new TransacaoDTO(despesa.getId(), 
					despesa.getValor(), despesa.getData(), 
					despesa.getDescricao(), "DESPESA", despesa.getCategoria()));
		});
		
		
		return transacoes;
		
	}
	
	

}
