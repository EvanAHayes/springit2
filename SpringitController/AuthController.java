package com.ehayes.springit2.SpringitController;

import com.ehayes.springit2.Service.UserService;
import com.ehayes.springit2.Springitmodel.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping(value = "/register")
    public String RegisterNewUser(@Valid User user, BindingResult bindingResult, Model model,
                                  RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
           logger.info("Validation errors were found while registering a new user");
           model.addAttribute("user", user);
           model.addAttribute("validationErrors", bindingResult.getAllErrors());
                   return "register";

        }else{
            //register new user
            User newUser =userService.register(user);
            redirectAttributes
                    .addAttribute("id", newUser.getId())
            .addFlashAttribute("success", true);

            return "redirect:/register";
        }
    }


}
