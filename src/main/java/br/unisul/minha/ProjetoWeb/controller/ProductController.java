package br.unisul.minha.ProjetoWeb.controller;

import br.unisul.minha.ProjetoWeb.model.Product;
import br.unisul.minha.ProjetoWeb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/")
    public ModelAndView list() {
        List<Product> products = productRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/product");
        mv.addObject("products", products);
        return mv;
    }
}
