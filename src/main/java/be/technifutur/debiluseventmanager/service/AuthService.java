package be.technifutur.debiluseventmanager.service;

import be.technifutur.debiluseventmanager.model.dto.AuthDTO;
import be.technifutur.debiluseventmanager.model.form.LoginForm;

public interface AuthService {

    AuthDTO login(LoginForm loginForm);

}
