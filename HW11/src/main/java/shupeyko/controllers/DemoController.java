package shupeyko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shupeyko.entities.User;
import shupeyko.services.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/unsecured")
    public String usecuredPage() {
        return "unsecured";
    }

    @GetMapping("/auth_page")
    public String authenticatedPage() {
        return "authenticated";
    }

    @GetMapping("/admin")
    // @PreAuthorize("hasRole('ADMIN')")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/products")
    public String productsPage(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("Unable to find user by username: " + principal.getName()));
        return "This page includes all products. Approved only managers and admins. You authorized as: " + user.getUsername();
        // страница со списком товаров, на которой можно добавлять позиции и редактировать существующие. На эту страницу имеют доступ админы и менеджеры.
    }
    @GetMapping("/users")
    public String usersPage(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("Unable to find user by username: " + principal.getName()));
        return "This page includes all users. Approved only admins. You authorized as: " + user.getUsername();
        // страница со списком всех пользователей, к которой имеют доступ только админы.
    }
    @GetMapping("/create_user")
    public String createUserPage(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("Unable to find user by username: " + principal.getName()));
        return "This superadmin page with the ability to create new users and specify roles for existing ones. You authorized as: " + user.getUsername();
        // страница суперадмина с возможностью создавать новых пользователей и указывать роли существующим.
    }
    @GetMapping("/user_info")
    public String daoTestPage(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("Unable to find user by username: " + principal.getName()));
        return "Authenticated user info: " + user.getUsername() + " : " + user.getEmail();
    }
}
