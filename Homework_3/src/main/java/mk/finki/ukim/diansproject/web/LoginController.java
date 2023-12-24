package mk.finki.ukim.diansproject.web;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.diansproject.model.Exceptions.InvalidArgumentsException;
import mk.finki.ukim.diansproject.model.Exceptions.InvalidUserCredentialsException;
import mk.finki.ukim.diansproject.model.User;
import mk.finki.ukim.diansproject.service.AuthService;
import mk.finki.ukim.diansproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class LoginController {
    private final AuthService authService;
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping(value = {"/","/login"})
    public String getLoginPage() {
        return "login.html";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        User user = null;

        try {
            user = authService.login(request.getParameter("username"), request.getParameter("password"));
        } catch (InvalidUserCredentialsException | InvalidArgumentsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login.html";
        }

        request.getSession().setAttribute("user", user);
        return "redirect:/places";
    }


}
