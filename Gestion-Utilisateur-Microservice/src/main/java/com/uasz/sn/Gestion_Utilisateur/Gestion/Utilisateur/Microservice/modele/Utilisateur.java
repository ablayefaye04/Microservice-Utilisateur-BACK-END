package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String nom;
    private String prenom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    private boolean active;
    private String role;
}