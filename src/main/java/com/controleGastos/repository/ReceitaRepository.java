package com.controleGastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controleGastos.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long>{

}
