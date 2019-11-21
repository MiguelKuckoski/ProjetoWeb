package br.unisul.minha.ProjetoWeb.repositories;

import br.unisul.minha.ProjetoWeb.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
