package be.technifutur.debiluseventmanager.model.form;

import be.technifutur.debiluseventmanager.model.entity.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserForm {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String gender;
    @NotNull
    private List<String> jobs;
    @NotBlank
    private String rank;
    @NotBlank
    private String race;

    public User toEntity() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setGender(this.gender);
        return user;
    }

}
