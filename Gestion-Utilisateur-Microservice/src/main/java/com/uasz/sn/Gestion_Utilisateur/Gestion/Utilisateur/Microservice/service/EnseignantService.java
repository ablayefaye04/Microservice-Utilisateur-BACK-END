package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.service;


import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Enseignant;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.repository.EnseignantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;

    public Enseignant ajouter(Enseignant enseignant){
        return  enseignantRepository.save(enseignant);
    }

    public List<Enseignant> Liste (){
        return enseignantRepository.findAll();
    }

    public Enseignant rechercherParId(Long id) {
        System.out.println("Recherche de l'enseignant avec ID : " + id);
        Enseignant enseignant = enseignantRepository.findById(id).orElse(null);
        System.out.println("Résultat de la recherche : " + (enseignant != null ? enseignant.toString() : "Aucun enseignant trouvé"));
        return enseignant;
    }


    public Enseignant modifier(Enseignant enseignant){
        return  enseignantRepository.save(enseignant);
    }

    public void activer(Long id){
        Enseignant enseignant = enseignantRepository.findById(id).get();
        if (enseignant.isActive()==true){
            enseignant.setActive(false);
        }else {
            enseignant.setActive(true);
        }
        enseignantRepository.save(enseignant);
    }

    public void archiver(Long id){
        Enseignant enseignant = enseignantRepository.findById(id).get();
        if (enseignant.isArchive()==true){
            enseignant.setArchive(false);
        }else {
            enseignant.setArchive(true);
        }
        enseignantRepository.save(enseignant);
    }
}
