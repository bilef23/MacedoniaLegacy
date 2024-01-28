package mk.finki.ukim.diansproject.web;

import mk.finki.ukim.diansproject.model.Exceptions.InvalidArgumentsException;
import mk.finki.ukim.diansproject.model.Exceptions.PasswordsDoNotMatchException;
import mk.finki.ukim.diansproject.model.Exceptions.UsernameAlreadyExistsException;
import mk.finki.ukim.diansproject.model.Role;
import mk.finki.ukim.diansproject.service.AuthService;
import mk.finki.ukim.diansproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final AuthService authService;
    private final UserService userService;

    public RegisterController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping()
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        return "signin.html";
    }

    @PostMapping()
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String email
    ) {
        try{
            System.out.println("OKS");
            this.userService.register(username, password, repeatedPassword, name, email, Role.USER);
            return "redirect:/login";
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException | UsernameAlreadyExistsException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }

}
