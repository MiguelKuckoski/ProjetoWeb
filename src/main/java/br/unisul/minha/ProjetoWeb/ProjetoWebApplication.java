package br.unisul.minha.ProjetoWeb;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.unisul.minha.ProjetoWeb.model.Address;
import br.unisul.minha.ProjetoWeb.model.Product;
import br.unisul.minha.ProjetoWeb.model.State;
import br.unisul.minha.ProjetoWeb.model.User;
import br.unisul.minha.ProjetoWeb.repositories.IProductRepository;
import br.unisul.minha.ProjetoWeb.service.UserService;

@SpringBootApplication
public class ProjetoWebApplication implements CommandLineRunner {

	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p2 = new Product(null, "Produto 2", 20.5, 6, "caixa com 10");
		Product p1 = new Product(null, "Produto 1", 12.2, 1, "unidade");
		Product p3 = new Product(null, "Produto 3", 56.0, 9, "fardo");
		Product p4 = new Product(null, "Produto 4", 18., 26, "litros");
		Product p5 = new Product(null, "Produto 5", 86.99, 2, "caixa com 20");
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		LocalDate localDate = LocalDate.of(1998, 02, 13);
		User user = new User(null, "teste@teste.com", "123", "123", "Miguel Kuckoski", localDate, 'M');
		Address address = new Address(null, "88090000", "Rua Prefeito Dib Cherem", 2349, "", "Florianópolis", State.SC,
				user);
		user.setAddress(address);
		userService.save(user);
	}
}
