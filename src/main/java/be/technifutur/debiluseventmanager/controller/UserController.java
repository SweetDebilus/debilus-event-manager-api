package be.technifutur.debiluseventmanager.controller;

import be.technifutur.debiluseventmanager.model.dto.UserDTO;
import be.technifutur.debiluseventmanager.model.form.UserForm;
import be.technifutur.debiluseventmanager.service.UserService;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid UserForm userForm) {
        userService.createUser(userForm);
    }

    @PatchMapping("/{id}/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody @Valid UserForm userForm, @PathVariable Long id) {
        userService.updateUser(userForm, id);
    }

    @PatchMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PatchMapping("/{id}/reactivate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void reactivate(@PathVariable Long id) {
        userService.reactivateUser(id);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}
