package br.unisul.minha.ProjetoWeb.repositories;

import br.unisul.minha.ProjetoWeb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

}
