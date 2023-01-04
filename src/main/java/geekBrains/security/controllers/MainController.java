package geekBrains.security.controllers;

import geekBrains.security.entities.User;
import geekBrains.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;




    @GetMapping("/login_form")
    public String login() {
        return "login";
    }

    @GetMapping("/authenticated")
    public String pageForAuthUsers(Model model, Principal principal){
        model.addAttribute("current_user", principal.getName());
        return "congratsAuthUser";
    }




    @GetMapping("/register_form")
    public String viewRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "registration_form";
    }

    @PostMapping("/adding_user")
    public String addNewUser(Model model, @Validated User user, BindingResult bs) {
        if (bs.hasErrors()) {
            return "registration_form";
        }
        user.setPassword(passwordCoder().encode(user.getPassword()));
        userRepository.save(user);
        model.addAttribute("newUser", user);
        return "congratsAddUser";
    }

    @Bean
    protected PasswordEncoder passwordCoder() { // шифратор для пароля
        return new BCryptPasswordEncoder(12);
    }



}
