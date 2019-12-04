package br.unisul.minha.ProjetoWeb.service;

import br.unisul.minha.ProjetoWeb.model.User;
import br.unisul.minha.ProjetoWeb.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String save(User user) {
        String validate = validate(user);
        if (validate.isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        return validate;
    }

    public String validate(User user) {
        String errors = "";
        if (!user.getPassword().equals(user.getConfirmPassword()))
            errors += "Senhas não correspondem";

        int age = LocalDate.now().getYear() - user.getBornDate().getYear();
        if (age < 5 || age > 105)
            errors += "Idade deve ser entre 5 e 105 anos";

        return errors;
    }

    public User findByLogin(String login) {
        User user = userRepository.findByLogin(login);
        return user;
    }


}
