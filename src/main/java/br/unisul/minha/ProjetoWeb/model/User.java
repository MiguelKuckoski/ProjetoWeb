package br.unisul.minha.ProjetoWeb.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O login é obrigatório")
    private String login;

    @NotNull(message = "A senha é obrigatória")
    private String password;
    private String name;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate bornDate;

    @NotNull(message = "O sexo é obrigatório")
    private char sex;

    @JsonManagedReference
    @OneToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Address address;

    @OneToMany
    private List<ShoppingCart> shoppingCart;

    public User() {
    }

    public User(Integer id, String login, String password, String name, LocalDate bornDate, char sex) {
        this.id =id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.bornDate = bornDate;
        this.sex = sex;
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

    public List<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<ShoppingCart> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}