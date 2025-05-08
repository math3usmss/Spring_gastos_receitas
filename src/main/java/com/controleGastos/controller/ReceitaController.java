package com.controleGastos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controleGastos.ENUM.origemENUM;
import com.controleGastos.model.Receita;
import com.controleGastos.service.ReceitaService;

import jakarta.transaction.Transactional;
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
		
		receita.setOrigem(receita.getOrigem());
		return ResponseEntity.status(201).body(receitaSalva);
	}
	
	@GetMapping("/totalMensal")
	public Double TotalMesReceita(@RequestParam int mes) {
		return service.SomaReceitasMes(mes);
	}
	
	@GetMapping("/origemReceita/{origem}")
	public ResponseEntity<List<Receita>> listaOrigem(@PathVariable origemENUM origem){
		return ResponseEntity.ok(service.listaOrigem(origem));
	}
	
	@DeleteMapping("/delete/{id}")
	@Transactional
	public ResponseEntity<String> deleteReceita(@PathVariable Long id) {
		try {
			service.deletarReceita(id);
			return ResponseEntity.ok("Receita deletada!");
		}
		catch (Exception e) {
	        return ResponseEntity.internalServerError().body("Erro ao deletar receita: " + e.getMessage());
	    }
	}
 
}
