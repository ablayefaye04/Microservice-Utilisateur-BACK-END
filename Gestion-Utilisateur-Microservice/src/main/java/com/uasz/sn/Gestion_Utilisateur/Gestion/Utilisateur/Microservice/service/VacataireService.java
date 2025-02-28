package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.service;

import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Vacataire;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.repository.VacataireRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VacataireService {
    @Autowired
    private VacataireRepository vacataireRepository;

    public Vacataire ajouter(Vacataire vacataire){
        return  vacataireRepository.save(vacataire);
    }

    public List<Vacataire> Liste (){
        return vacataireRepository.findAll();
    }

    public Vacataire rechercher(Long id){
        return vacataireRepository.findById(id).get();
    }

    public Vacataire modifier(Vacataire vacataire){
        return  vacataireRepository.save(vacataire);
    }

    public void supprimer(Long id){
        vacataireRepository.deleteById(id);
    }
}

