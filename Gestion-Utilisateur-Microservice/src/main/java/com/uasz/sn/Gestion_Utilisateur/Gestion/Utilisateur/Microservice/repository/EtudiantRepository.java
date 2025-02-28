package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.repository;

import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
