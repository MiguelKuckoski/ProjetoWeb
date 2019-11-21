package br.unisul.minha.ProjetoWeb.repositories;

import br.unisul.minha.ProjetoWeb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
