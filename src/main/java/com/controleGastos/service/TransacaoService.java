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
	private ReceitaService receitaService;
	private DespesasService despesaService;
	
	public TransacaoService(ReceitaRepository receitaRepository,DespesasRepository despesasRepository,
			ReceitaService receitaService, DespesasService despesaService) {
		this.receitaRepository = receitaRepository;
		this.despesasRepository = despesasRepository;
		this.receitaService = receitaService;
		this.despesaService = despesaService;
	}
	
	public List<TransacaoDTO> listarTransacoes(){
		
		List<TransacaoDTO> transacoes = new ArrayList<>();
		
		receitaRepository.findAll().forEach(receita -> {
			transacoes.add(new TransacaoDTO(receita.getId(), 
					receita.getValor(), receita.getData(), 
					receita.getDescricao(), "RECEITA", receita.getOrigem(), null));
		});
		
		despesasRepository.findAll().forEach(despesa -> {
			transacoes.add(new TransacaoDTO(despesa.getId(), 
					despesa.getValor(), despesa.getData(), 
					despesa.getDescricao(), "DESPESA", null, despesa.getCategoria()));
		});
		
		
		return transacoes;
		
	}
	
	public Double SaldoMensal(int mes){
		return receitaService.SomaReceitasMes(mes) - despesaService.SomaDespesaMes(mes);
	}
	
	

}
