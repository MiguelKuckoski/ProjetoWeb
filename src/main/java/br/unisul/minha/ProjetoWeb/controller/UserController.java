package br.unisul.minha.ProjetoWeb.controller;

import br.unisul.minha.ProjetoWeb.controller.helper.ControllerHelper;
import br.unisul.minha.ProjetoWeb.model.Address;
import br.unisul.minha.ProjetoWeb.model.User;
import br.unisul.minha.ProjetoWeb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Validated User newUser, @Validated Address newAdress, BindingResult result) {
        User user = userRepository.findByLogin(newUser.getLogin());
        if (user != null)
            return ResponseEntity.badRequest().body("Usuário já cadastrado.");
        if (result.hasErrors()) {
            String errors = ControllerHelper.getErrors(result);
            return ResponseEntity.status(505).body(errors);
        }
        userRepository.save(newUser);
        return ResponseEntity.ok().body("Cadastro realizado com sucesso.");
    }

    @GetMapping("/register")
    public String register() { return "/register"; }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "/login";
    }
}
