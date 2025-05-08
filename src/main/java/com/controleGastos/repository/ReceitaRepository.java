package com.controleGastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controleGastos.model.Receita;
import com.controleGastos.ENUM.origemENUM;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long>{
	List<Receita> findByOrigem(origemENUM origem);	
}
