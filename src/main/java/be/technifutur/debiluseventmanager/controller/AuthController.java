package be.technifutur.debiluseventmanager.controller;

import be.technifutur.debiluseventmanager.model.dto.AuthDTO;
import be.technifutur.debiluseventmanager.model.form.LoginForm;
import be.technifutur.debiluseventmanager.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthDTO login(@RequestBody LoginForm loginForm) {
        return authService.login(loginForm);
    }

}
