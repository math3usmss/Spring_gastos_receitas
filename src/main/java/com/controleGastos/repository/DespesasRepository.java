package com.controleGastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleGastos.model.Despesa;

public interface DespesasRepository extends JpaRepository<Despesa, Long>{

}
