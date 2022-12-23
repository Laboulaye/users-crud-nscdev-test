package com.testprojects.NSCTest.controller;

import com.testprojects.NSCTest.model.User;
import com.testprojects.NSCTest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

/**
 * Контроллер по работе с пользователями
 */
@Controller
@RequestMapping("users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "show";

    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "new-user";
    }

    @PostMapping()
    public String add(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "new-user";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";

    }
    @PutMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult result){
        if(result.hasErrors()) {
            return "edit-user";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id){
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}
