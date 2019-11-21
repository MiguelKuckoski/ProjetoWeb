package br.unisul.minha.ProjetoWeb.repositories;

import br.unisul.minha.ProjetoWeb.model.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingRepository extends JpaRepository<Shopping, Integer> {
}
