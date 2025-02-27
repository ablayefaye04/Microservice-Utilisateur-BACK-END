package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uasz.sn.Gestion_Utilisateur.Gestion_Utilisateur.Microservice.models.Utilisateur;
import com.uasz.sn.Gestion_Utilisateur.Gestion_Utilisateur.Microservice.repository.UtilisateurRepository;
import com.uasz.sn.Gestion_Utilisateur.Gestion_Utilisateur.Microservice.security.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public Utilisateur ajouter(Utilisateur utilisateur) {
        Utilisateur existe = utilisateurRepository.findByUsername(utilisateur.getUsername());
        if (existe != null) {
            throw new ResourceAlreadyExistException("Le username " + utilisateur.getUsername() + " existe déjà");
        }
        try {
            // Encoder le mot de passe avant de sauvegarder l'utilisateur
            utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
            return utilisateurRepository.save(utilisateur);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Erreur lors de l'ajout de l'utilisateur");
        }
    }

    public Utilisateur rechercher(String username) {
        try {
            return utilisateurRepository.findByUsername(username);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Utilisateur " + username + " n'existe pas");
        }
    }
}
