package be.technifutur.debiluseventmanager.service.impl;

import be.technifutur.debiluseventmanager.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository utilisateurRepository;

    public UserDetailServiceImpl(UserRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return utilisateurRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
    }
}
