package br.unisul.minha.ProjetoWeb.service;

import br.unisul.minha.ProjetoWeb.model.Shopping;
import br.unisul.minha.ProjetoWeb.repositories.IShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingService {

    @Autowired
    private IShoppingRepository shoppingRepository;

    public String save(List<Shopping> shoppings) {
        String validate = validate(shoppings);
        if (validate.isEmpty()) {
            shoppingRepository.saveAll(shoppings);
        }
        return validate;
    }

    public String validate(List<Shopping> shoppings) {
        return ""; //TODO
    }

    public List<Shopping> findAll() {
        List<Shopping> shoppings = shoppingRepository.findAll();
        return shoppings;
    }
}
