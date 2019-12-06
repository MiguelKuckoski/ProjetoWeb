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
import br.unisul.minha.ProjetoWeb.repositories.IShoppingRepository;
import br.unisul.minha.ProjetoWeb.service.UserService;

@SpringBootApplication
public class ProjetoWebApplication implements CommandLineRunner {

	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private IShoppingRepository shoppingRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p1 = new Product(null, "barbeador", 12.2, 1, "unidade");
		Product p2 = new Product(null, "fifa19", 20.5, 6, "caixa com 10");
		Product p3 = new Product(null, "monitor", 56.0, 9, "fardo");
		Product p4 = new Product(null, "mouse", 18., 26, "litros");
		Product p5 = new Product(null, "rexona", 86.99, 2, "caixa com 20");
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		LocalDate localDate = LocalDate.of(1998, 02, 13);
		User user = new User(null, "teste@teste.com", "123", "123", "Miguel Kuckoski", localDate, 'M');
		Address address = new Address(null, "88090000", "Rua Prefeito Dib Cherem", 2349, "", "Florianópolis", State.SC,
				user);
		user.setAddress(address);
		userService.save(user);

//		Shopping s1 = new Shopping(1, p1, user, LocalDateTime.now());
//		Shopping s2 = new Shopping(4, p2, user, LocalDateTime.now());
//		Shopping s3 = new Shopping(6, p3, user, LocalDateTime.now());
//		Shopping s4 = new Shopping(2, p4, user, LocalDateTime.now());
//		Shopping s5 = new Shopping(10, p5, user, LocalDateTime.now());

//		shoppingRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5));
	}
}
