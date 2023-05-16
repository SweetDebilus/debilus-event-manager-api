package be.technifutur.debiluseventmanager.service.impl;

import be.technifutur.debiluseventmanager.model.dto.AuthDTO;
import be.technifutur.debiluseventmanager.model.form.LoginForm;
import be.technifutur.debiluseventmanager.service.AuthService;
import be.technifutur.debiluseventmanager.util.JWTProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JWTProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public AuthDTO login(LoginForm loginForm) {
        Authentication auth = new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword());
        auth = authenticationManager.authenticate(auth);
        return new AuthDTO(auth.getName(), jwtProvider.createToken(auth));
    }

}
