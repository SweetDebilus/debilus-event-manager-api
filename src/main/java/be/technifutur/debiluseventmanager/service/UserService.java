package be.technifutur.debiluseventmanager.service;

import be.technifutur.debiluseventmanager.model.dto.UserDTO;
import be.technifutur.debiluseventmanager.model.form.UserForm;

import java.util.List;

public interface UserService {

    void createUser (UserForm userForm);

    void updateUser (UserForm user, Long id);

    void deleteUser (Long id);

    UserDTO getUserById (Long id);

    UserDTO getUserByUsername (String username);

    List<UserDTO> getAllUsers ();

}
