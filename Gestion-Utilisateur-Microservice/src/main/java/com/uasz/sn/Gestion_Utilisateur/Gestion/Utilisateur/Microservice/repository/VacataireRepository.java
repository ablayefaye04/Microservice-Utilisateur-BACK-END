package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.repository;

import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Vacataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VacataireRepository extends JpaRepository<Vacataire, Long> {
}
