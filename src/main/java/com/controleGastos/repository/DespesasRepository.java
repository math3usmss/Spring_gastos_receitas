package com.controleGastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleGastos.model.Despesa;
import java.util.List;
import com.controleGastos.ENUM.categoriasENUM;


public interface DespesasRepository extends JpaRepository<Despesa, Long>{
	List<Despesa> findByCategoria(categoriasENUM categoria);
}
