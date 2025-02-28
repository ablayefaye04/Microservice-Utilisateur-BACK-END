package com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele;

public abstract class Enseignant extends Utilisateur{
    private String Specialite;
    private boolean archive;

    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String specialite) {
        Specialite = specialite;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }
//@OneToMany(mappedBy = "enseignant")
    //private Set<Choix> choixEnseignements = new HashSet<>();

}
