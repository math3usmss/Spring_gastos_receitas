package com.controleGastos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controleGastos.model.Receita;
import com.controleGastos.service.ReceitaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
	
	private ReceitaService service;
	
	public ReceitaController(ReceitaService service) {
		this.service = service;
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Receita> criarReceita(@Valid @RequestBody Receita receita){
		Receita receitaSalva = service.criarReceita(receita);
		return ResponseEntity.status(201).body(receitaSalva);
	}
	
	@GetMapping("/totalMensal")
	public Double TotalMesReceita(@RequestParam int mes) {
		return service.SomaReceitasMes(mes);
	}

}
