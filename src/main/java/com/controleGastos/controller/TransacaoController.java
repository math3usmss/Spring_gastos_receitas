package com.controleGastos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleGastos.dto.TransacaoDTO;
import com.controleGastos.service.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
	
	private TransacaoService service;
	
	public TransacaoController(TransacaoService service) {
		this.service = service;
	}
	
	@GetMapping("/todasTransacoes")
	public List<TransacaoDTO> listarTransacoes(){
		return service.listarTransacoes();
	}
	
	

}
