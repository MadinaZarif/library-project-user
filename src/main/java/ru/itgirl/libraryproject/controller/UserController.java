package ru.itgirl.libraryproject.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.libraryproject.service.UserService;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "library-users")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    String getUsersView(Model model) {
        model.addAttribute("users", userService.getAllusers());
        return "users";
    }



}
