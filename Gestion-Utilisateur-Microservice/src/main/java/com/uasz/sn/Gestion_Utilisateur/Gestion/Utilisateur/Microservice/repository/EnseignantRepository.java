package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.repository;

import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface EnseignantRepository extends JpaRepository <Enseignant, Long> {
    Optional<Enseignant> findByUsername(String username); // Nouvelle méthode

}
