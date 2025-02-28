package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.repository;

import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Permanent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface PermanentRepository extends JpaRepository<Permanent, Long> {
    @Query("SELECT p FROM Permanent p WHERE p.matricule = ?1")
    Optional findByMatricule(String Matricule);
}
