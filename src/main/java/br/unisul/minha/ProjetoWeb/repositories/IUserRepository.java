package br.unisul.minha.ProjetoWeb.repositories;

import br.unisul.minha.ProjetoWeb.model.Product;
import br.unisul.minha.ProjetoWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);
}