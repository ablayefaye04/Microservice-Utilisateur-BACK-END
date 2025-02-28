package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.service;

import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Permanent;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.repository.PermanentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PermanentService {
    @Autowired
    private PermanentRepository permanentRepository;

    public Permanent ajouter(Permanent permanent){
        Optional<Permanent> optionalEtudiant = permanentRepository.findByMatricule(permanent.getMatricule());
        return permanentRepository.save(permanent);
    }

    public List<Permanent> Liste (){
        return permanentRepository.findAll();
    }

    public Permanent rechercher(Long id) {
        return permanentRepository.findById(id).get();
    }
    public Permanent modifier(Permanent permanent){
        return permanentRepository.save(permanent);
    }

    public void supprimer(Long id){
        permanentRepository.deleteById(id);
    }
}

