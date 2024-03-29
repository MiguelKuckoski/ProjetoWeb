package br.unisul.minha.ProjetoWeb.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "O login é obrigatório")
	private String login;

	@NotNull(message = "A senha é obrigatória")
	private String password;

	@Transient
	private String confirmPassword;

	private String name;

	@NotNull(message = "A data de nascimento é obrigatória")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate bornDate;

	@NotNull(message = "O sexo é obrigatório")
	private char sex;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Address address;

	public User() {
	}

	public User(Integer id, String login, String password, String confirmPassword,String name, LocalDate bornDate, char sex, Address address) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.bornDate = bornDate;
		this.sex = sex;
		this.confirmPassword = confirmPassword;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBornDate() {
		return bornDate;
	}

	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


}
