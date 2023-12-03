package mk.finki.ukim.diansproject.web;

import mk.finki.ukim.diansproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getLoginPage(){
        return "login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,@RequestParam String password){
        if(userService.isAuthenticated(email,password)){
            return "redirect:/places";
        }
        return "login.html";
    }
    @GetMapping("/signin")
    public String getSigninPage(){
        return "signin.html";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name,@RequestParam String email,@RequestParam String password2
            , @RequestParam String username,@RequestParam String password1){
        if(!password1.equals(password2)){
            return "redirect:/signin";
        }
        userService.addUser(name,username,email,password1);
        return "redirect:/";
    }
}
