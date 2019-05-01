/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier;

import Pharmacie.Metier.Prescriptions;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author meril
 */
public class Patient {
    private int idpat;
    private String nom;
    private String prenom;
    private String tel;
    private Set<Prescriptions> prescription=new HashSet();

    public Patient() {
    }

    public Patient(int idpat, String nom, String prenom, String tel) {
        this.idpat = idpat;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public int getIdpat() {
        return idpat;
    }

    public void setIdpat(int idpat) {
        this.idpat = idpat;
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
        int hash = 5;
        hash = 53 * hash + this.idpat;
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
        final Patient other = (Patient) obj;
        if (this.idpat != other.idpat) {
            return false;
        }
        return true;
    }
    
    
}
