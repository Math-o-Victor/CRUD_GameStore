package br.org.generation.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.gamestore.models.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoModel, Long> {
	
	Object findAllByNomeContainingIgnoreCase(String nome);

}
