package br.unisul.minha.ProjetoWeb;

import br.unisul.minha.ProjetoWeb.model.Address;
import br.unisul.minha.ProjetoWeb.model.Product;
import br.unisul.minha.ProjetoWeb.model.State;
import br.unisul.minha.ProjetoWeb.model.User;
import br.unisul.minha.ProjetoWeb.repositories.ProductRepository;
import br.unisul.minha.ProjetoWeb.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class ProjetoWebApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ServiceUser serviceUser;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p2 = new Product(null, "Produto 2", 20.5, 6);
		Product p1 = new Product(null, "Produto 1", 12.2, 1);
		Product p3 = new Product(null, "Produto 3", 56.0, 9);
		Product p4 = new Product(null, "Produto 4", 18., 26);
		Product p5 = new Product(null, "Produto 5", 86.99, 2);
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		LocalDate localDate = LocalDate.of(1998, 02, 13);
		User user = new User(null, "miguelfreitas32@gmail.com", "123456", "123456","Miguel Kuckoski", localDate, 'M');
		Address address = new Address(null, "88090000", "Rua Prefeito Dib Cherem", 2349, "", "Florianópolis", State.SC, user);
		user.setAddress(address);
		serviceUser.save(user);
	}
}
