package com.controleGastos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controleGastos.ENUM.categoriasENUM;
import com.controleGastos.ENUM.origemENUM;
import com.controleGastos.model.Despesa;
import com.controleGastos.service.DespesasService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/despesas")
public class DespesasController {
	
	private DespesasService service;
	
	@Autowired
	public DespesasController(DespesasService service) {
		this.service = service;
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Despesa> criarDespesa(@Valid @RequestBody Despesa despesa){
		Despesa despesaSalva = service.CriarDespesa(despesa);
		return ResponseEntity.status(201).body(despesaSalva);
	}
	
	@GetMapping("/totalMensal")
	public Double TotalMesReceita(@RequestParam int mes) {
		return service.SomaDespesaMes(mes);
	}
	
	@GetMapping("/categoriaDespesa/{categoria}")
	public ResponseEntity<List<Despesa>> listaCategoria(@PathVariable categoriasENUM categoria){
		return ResponseEntity.ok(service.listaCategoria(categoria));
	}
	
	@DeleteMapping("/delete/{id}")
	@Transactional
	public ResponseEntity<String> deleteDespesa(@PathVariable Long id) {
		try {
			service.deletarDespesa(id);
			return ResponseEntity.ok("Despesa deletada!");
		}
		catch (Exception e) {
	        return ResponseEntity.internalServerError().body("Erro ao deletar despesa: " + e.getMessage());
	    }
	}


}
