package br.unisul.minha.ProjetoWeb.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;
    private LocalDateTime date;

    @OneToMany
    private List<Shopping> shopping;

    public ShoppingCart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Shopping> getShopping() {
        return shopping;
    }

    public void setShopping(List<Shopping> shopping) {
        this.shopping = shopping;
    }
}
