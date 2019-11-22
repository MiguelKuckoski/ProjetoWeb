package br.unisul.minha.ProjetoWeb.controller;

import br.unisul.minha.ProjetoWeb.controller.helper.ControllerHelper;
import br.unisul.minha.ProjetoWeb.model.Shopping;
import br.unisul.minha.ProjetoWeb.model.ShoppingCart;
import br.unisul.minha.ProjetoWeb.repositories.ShoppingCartRepository;
import br.unisul.minha.ProjetoWeb.repositories.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api/shoppingCart")
public class ShoppingController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ShoppingRepository shoppingRepository;

    @GetMapping(value = "list")
    public ResponseEntity list() {
        List<Shopping> shoppings = shoppingRepository.findAll();
        if(shoppings.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(shoppings);
    }

    @PostMapping(value = "shoppingCart")
    public ResponseEntity newShopping(@RequestBody @Validated ShoppingCart shoppingCart, BindingResult result) {
        if(result.hasErrors())
            return ResponseEntity.status(500).body(ControllerHelper.getErrors(result));
        shoppingCartRepository.save(shoppingCart);
        return ResponseEntity.ok().body("Compra efetuada com sucesso.");
    }

}
