package br.org.generation.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.gamestore.models.CategoriaModel;

@Repository
public interface CategoryRepository extends JpaRepository<CategoriaModel, Long> {
	Object findAllByCategoriaContainingIgnoreCase(String categoria);
}