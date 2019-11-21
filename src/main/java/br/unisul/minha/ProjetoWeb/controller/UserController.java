package br.unisul.minha.ProjetoWeb.controller;

import br.unisul.minha.ProjetoWeb.model.User;
import br.unisul.minha.ProjetoWeb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Valid User newUser, BindingResult result) {
        User user = userRepository.findByLogin(newUser.getLogin());
        if(user != null)
            return ResponseEntity.badRequest().body("Usuário já cadastrado.");
        userRepository.save(newUser);

        return ResponseEntity.ok().body("Cadastro realizado com sucesso.");
    }

    @GetMapping(value = "/list")
    public ResponseEntity list() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

}
