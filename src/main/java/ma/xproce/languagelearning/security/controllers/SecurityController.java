package ma.xproce.languagelearning.security.controllers;

import ma.xproce.languagelearning.security.entities.User;
import ma.xproce.languagelearning.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {
    @Autowired
    AccountService accountService;

    @GetMapping("accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }

    @GetMapping("/indexpage")
    public String home(){
        return "redirect:listeLangues";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("submit_register")
    public String submit_register(@ModelAttribute("user")User user,
                                  @RequestParam("confirm") String confirm){
       User user1= accountService.createUser(user.getUserName(),user.getEmail(),user.getPassword(),confirm);
        accountService.addRoleToUser(user1.getUserName(),"USER");
        return "redirect:login";
    }
}
