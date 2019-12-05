package br.unisul.minha.ProjetoWeb.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {

    List<Shopping> shopping = new ArrayList<>();

    public ShoppingList() {
    }

    public ShoppingList(List<Shopping> shopping) {
        this.shopping = shopping;
    }

    public List<Shopping> getShopping() {
        return shopping;
    }

    public void setShopping(List<Shopping> shopping) {
        this.shopping = shopping;
    }

    public void addShopping(Shopping shopping) {
        this.shopping.add(shopping);
    }

}
