package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.mapper;

import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.dto.LoginDTO;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.dto.UtilisateurDTO;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Utilisateur;
import org.mapstruct.Mapper;

@Mapper
public interface UtilisateurMapper {
    UtilisateurDTO utilisateurToDTO(Utilisateur utilisateur);
    Utilisateur dtoToUtilisateur(UtilisateurDTO utilisateurDTO);

    LoginDTO utilisateurToLogin(Utilisateur utilisateur);
    Utilisateur loginToUtilisateur(LoginDTO loginDTO);
}
