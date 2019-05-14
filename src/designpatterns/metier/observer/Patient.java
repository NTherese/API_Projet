/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.observer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author meril
 */
public class Patient extends Observer {
     /**
   * identifiant unique du patient
   */
    protected int idpat;
    
    
    /**
     * nom du patient
     */
    protected String nom;
    
    /**
     * prenom du patient
     */
    protected String prenom;
    
    /**
     * telephone du patient
     */
    protected String tel;
    
    protected Set<Prescription> mesPrescriptions= new HashSet<>();

    /**
     * Constructeur par défaut
     */
    public Patient() {
    }

    /**
     * constructeur paramétré
     * @param idpat identifiant du patient
     * @param nom nom du patient
     * @param prenom  prenom du patient
     * @param tel telephone du patient
     */
    public Patient(int idpat, String nom, String prenom, String tel) {
        this.idpat = idpat;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    /**
     * getter idpatient
     * @return identifiant du patient
     */
    public int getIdpat() {
        return idpat;
    }

    /**
     * setter idpatient
     * @param idpat identifiant du patient
     */
    public void setIdpat(int idpat) {
        this.idpat = idpat;
    }

    /**
     * getter nom 
     * @return nom du patient
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom
     * @param nom  nom du patient
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter prenom
     * @return prenom du patient
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * setter prenom
     * @param prenom prenom du patient 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * getter tel
     * @return telephone du patient
     */
    public String getTel() {
        return tel;
    }

    /**
     * setter tel
     * @param tel telephone du patient 
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * methode toString
     * @return informations completes du patient
     */
    @Override
    public String toString() {
        return "Patient{" + "idpat=" + idpat + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + '}';
    }

    public Set<Prescription> getMesPrescriptions() {
        return mesPrescriptions;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idpat;
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

    @Override
    public void update(String msg) {
        System.out.println(prenom+" "+nom+" a reçu le msg : "+msg);
    }
    
}
