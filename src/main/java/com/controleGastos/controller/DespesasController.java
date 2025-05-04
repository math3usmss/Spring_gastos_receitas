package com.controleGastos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleGastos.model.Despesa;
import com.controleGastos.service.DespesasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/despesa")
public class DespesasController {
	
	private DespesasService service;
	
	public DespesasController(DespesasService service) {
		this.service = service;
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Despesa> criarDespesa(@Valid @RequestBody Despesa despesa){
		Despesa despesaSalva = service.CriarDespesa(despesa);
		return ResponseEntity.status(201).body(despesaSalva);
	}

}
