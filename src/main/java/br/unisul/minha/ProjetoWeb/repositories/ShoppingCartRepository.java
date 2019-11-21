package br.unisul.minha.ProjetoWeb.repositories;

import br.unisul.minha.ProjetoWeb.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
}
