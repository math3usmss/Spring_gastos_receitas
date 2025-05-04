package com.controleGastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleGastos.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{

}
