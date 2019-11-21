package br.unisul.minha.ProjetoWeb.controller;

import br.unisul.minha.ProjetoWeb.model.Product;
import br.unisul.minha.ProjetoWeb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/list")
    public ResponseEntity list() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
}
