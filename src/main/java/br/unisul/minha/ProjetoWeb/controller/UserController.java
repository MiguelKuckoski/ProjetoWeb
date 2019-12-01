package br.unisul.minha.ProjetoWeb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unisul.minha.ProjetoWeb.model.User;
import br.unisul.minha.ProjetoWeb.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

//    @PostMapping(value = "/register")
//    public ResponseEntity register(@RequestBody @Validated User newUser, @Validated Address newAdress, BindingResult result) {
//        User user = userRepository.findByLogin(newUser.getLogin());
//        if (user != null)
//            return ResponseEntity.badRequest().body("Usuário já cadastrado.");
//        if (result.hasErrors()) {
//            String errors = ControllerHelper.getErrors(result);
//            return ResponseEntity.status(505).body(errors);
//        }
//        userRepository.save(newUser);
//        return ResponseEntity.ok().body("Cadastro realizado com sucesso.");
//    }

	@PostMapping("/register")
	public ModelAndView registrar(@Valid User user, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		User usr = userRepository.findByLogin(user.getLogin());
		if (usr != null) {
			result.rejectValue("email", "", "Usuário já cadastrado");
		}

		if (result.hasErrors()) {
			mv.setViewName("/register");
			mv.addObject("usuario", user);
		} else {
			userRepository.save(user);
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
