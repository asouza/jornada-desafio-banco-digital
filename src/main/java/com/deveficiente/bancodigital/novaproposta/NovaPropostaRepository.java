package com.deveficiente.bancodigital.novaproposta;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovaPropostaRepository extends CrudRepository<NovaProposta, Long>{

	Optional<NovaProposta> findByCodigo(String codigo);

}
