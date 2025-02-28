package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.repository;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query("SELECT u FROM Utilisateur u WHERE u.username = :username")
    Utilisateur findUtilisateurByUsername(@Param("username") String username);
}
