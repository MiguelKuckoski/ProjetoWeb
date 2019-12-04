package br.unisul.minha.ProjetoWeb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O cep é obrigatório")
    private String zipcode;
    private String street;
    private Integer number;
    private String complement;
    private String city;
    private Integer state;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Address() {
    }

    public Address(Integer id, String zipcode, String street, int number, String complement, String city, State state, User user) {
        this.id = id;
        this.zipcode = zipcode;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state.getCodIbge();
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return State.parse(state);
    }

    public void setState(State state) {
        this.state = state.getCodIbge();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
