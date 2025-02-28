package com.uasz.sn.Gestion_Utilisateur.Gestion_Utilisateur.Microservice.service;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Utilisateur;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UtilisateurDetailService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("Utilisateur inexistant: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                utilisateur.getUsername(),
                utilisateur.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(utilisateur.getRole()))
        );
    }
}