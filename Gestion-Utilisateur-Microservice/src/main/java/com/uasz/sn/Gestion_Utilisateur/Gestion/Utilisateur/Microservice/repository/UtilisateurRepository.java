package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.repository;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Trouve un utilisateur par son nom d'utilisateur
    Utilisateur findByUsername(String username);
}
