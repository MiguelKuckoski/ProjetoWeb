package br.unisul.minha.ProjetoWeb.controller;

import br.unisul.minha.ProjetoWeb.model.Product;
import br.unisul.minha.ProjetoWeb.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductRepository productRepository;

    @GetMapping(value = "/")
    public ModelAndView list() {
        List<Product> products = productRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/product");
        mv.addObject("products", products);
        return mv;
    }
}
