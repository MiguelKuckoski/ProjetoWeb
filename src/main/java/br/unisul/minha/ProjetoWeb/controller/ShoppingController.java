package br.unisul.minha.ProjetoWeb.controller;

import br.unisul.minha.ProjetoWeb.model.Shopping;
import br.unisul.minha.ProjetoWeb.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShoppingController {

	@Autowired
	private ShoppingService shoppingService;

	@GetMapping(value = "/report")
	public ModelAndView list() {
		List<Shopping> shoppings = shoppingService.findAll();
		Double shoppingValue = 0.;
		if(shoppings != null) {
			for (Shopping shopping: shoppings) {
				shoppingValue += shopping.getShoppingValue();
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/report");
		mv.addObject("shoppings", shoppings);
		mv.addObject("shoppingValue", shoppingValue);
		return mv;
	}

	@PostMapping(value = "/shopping")
	public ResponseEntity newShopping(@RequestBody Object shoppings) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/");
        String validate = shoppingService.save(shoppings);
        if(!validate.isEmpty()) {
            mv.addObject("shoppings", validate);
        }
		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}


}
