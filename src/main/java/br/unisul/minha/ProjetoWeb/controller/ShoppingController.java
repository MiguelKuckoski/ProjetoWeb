package br.unisul.minha.ProjetoWeb.controller;

import br.unisul.minha.ProjetoWeb.model.Shopping;
import br.unisul.minha.ProjetoWeb.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping(value = "/")
    public ModelAndView list() {
        List<Shopping> shoppings = shoppingService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/");
        mv.addObject("shoppings", shoppings);

        return mv;
    }

    @PostMapping(value = "shopping")
    public ModelAndView newShopping(@Validated List<Shopping> shoppings, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/");
        if (result.hasErrors()) {
            mv.addObject("shoppings", shoppings);
        } else {
            String validate = shoppingService.save(shoppings);
            if(!validate.isEmpty())
                mv.addObject("shoppings", validate);
        }
        return mv;
    }

}
