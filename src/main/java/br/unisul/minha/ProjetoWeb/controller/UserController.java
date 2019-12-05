package br.unisul.minha.ProjetoWeb.controller;

import javax.validation.Valid;

import br.unisul.minha.ProjetoWeb.model.State;
import br.unisul.minha.ProjetoWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unisul.minha.ProjetoWeb.model.Address;
import br.unisul.minha.ProjetoWeb.model.User;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ModelAndView registrar(@Valid User user, @Valid Address adress, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        User usr = userService.findByLogin(user.getLogin());
        if (usr != null) {
            result.rejectValue("email", "", "Usuário já cadastrado");
        }

        if (result.hasErrors()) {
            mv.setViewName("/register");
            mv.addObject("usuario", user);
        } else {
            user.setAddress(adress);
            String validate = userService.save(user);
            if (!validate.isEmpty()) {
                mv.setViewName("/register");
                mv.addObject("usuario", validate);
            }
            mv.setViewName("redirect:/login");
        }
        return mv;
    }

    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "/login";
    }

}
