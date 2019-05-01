/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier;

import Pharmacie.Metier.Prescriptions;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author meril
 */
public class Medecin {
    private String idmed;
    private String matricule;
    private String nom;
    private String prenom;
    private String tel;
    private Set<Prescriptions> prescription =new HashSet<>();

    public Medecin() {
    }

    public Medecin(String idmed, String matricule, String nom, String prenom, String tel) {
        this.idmed = idmed;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public String getIdmed() {
        return idmed;
    }

    public void setIdmed(String idmed) {
        this.idmed = idmed;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Set<Prescriptions> getPrescription() {
        return prescription;
    }

    public void setPrescription(Set<Prescriptions> prescription) {
        this.prescription = prescription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.matricule);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medecin other = (Medecin) obj;
        if (!Objects.equals(this.matricule, other.matricule)) {
            return false;
        }
        return true;
    }
    
    
}
