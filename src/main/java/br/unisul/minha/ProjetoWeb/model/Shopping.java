package br.unisul.minha.ProjetoWeb.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Shopping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;

    @ManyToOne
    private Product product;

    @OneToOne
    private User user;

    private LocalDateTime shoppingDate;

    @Transient
    private Double shoppingValue;

    public Shopping() {
    }

    public Shopping(Integer quantity, Product product, User user, LocalDateTime shoppingDate) {
        this.quantity = quantity;
        this.product = product;
        this.user = user;
        this.shoppingDate = shoppingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getShoppingDate() {
        return shoppingDate;
    }

    public void setShoppingDate(LocalDateTime shoppingDate) {
        this.shoppingDate = shoppingDate;
    }

    public Double getShoppingValue() {
        return shoppingValue;
    }

    public void setShoppingValue(Double shoppingValue) {
        this.shoppingValue = shoppingValue;
    }

    public void calcShoppingValue() {
       this.shoppingValue = this.product.getPrice() * this.quantity;
    }
}
