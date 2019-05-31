/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.observer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author meril
 */
public class Medecin extends Subject{
    /**
   * identifiant unique du medecin
   */
    protected int idmed;
    
    /**
     * matricule unique du medecin
     */
    protected String matricule;
    
    /**
     * nom du medecin
     */
    protected String nom;
    
    /**
     * prenom du medecin
     */
    protected String prenom;
    
    /**
     * telephone du medecin
     */
    protected String tel;
    
    protected Set<Prescription> mesPrescriptions= new HashSet<>();
    
    //protected Patient patient;

    /**
     * Contructeur par défaut
     */
    public Medecin() {
    }

    /**
     * Constructeur paramétré
     * @param idmed identifiant du medecin
     * @param matricule matricule du medecin
     * @param nom nom du medecin
     * @param prenom prenom du medecin
     * @param tel telephone du medecin
     */
    public Medecin(int idmed, String matricule, String nom, String prenom, String tel) {
        this.idmed = idmed;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    //Possible modification
    
    
    
    /*public Medecin(int idmed, String matricule, String nom, String prenom, String tel,Patient pat) {
        this.idmed = idmed;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
       this.patient=pat;
       this.addObserver(pat);
    }*/
    
    
    /**
     * getter idmedecin
     * @return  identifiant du medecin
     */
    public int getIdmed() {
        return idmed;
    }

    /**
     * setter idmedecin
     * @param idmed identifiant du medecin
     */
    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }

    /**
     * getter matricule 
     * @return matricule du medecin
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * setter matricule
     * @param matricule  matricule du medecin
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * getter nom
     * @return nom du medecin
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom
     * @param nom nom du medecin 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter prenom
     * @return prenom du medecin
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * setter prenom
     * @param prenom  prenom du medecin
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * getter telephone
     * @return telephone du medcin
     */
    public String getTel() {
        return tel;
    }

    /**
     * setter telephone
     * @param tel  telephone du medecin
     */
    public void setTel(String tel) {
        this.tel = tel;
        notifyObservers();
    }

    
    
    /**
     * Methode toString
     * @return informations completes sur le medecin
     */
    @Override
    public String toString() {
        return "Medecin{" + "idmed=" + idmed + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + '}';
    }

    public Set<Prescription> getMesPrescriptions() {
        return mesPrescriptions;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idmed;
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
        if (this.idmed != other.idmed) {
            return false;
        }
        if (!Objects.equals(this.matricule, other.matricule)) {
            return false;
        }
        return true;
    }

    @Override
    public String getNotification() {
        return "nouveau numero de telephone du medecin "+matricule+" = "+tel;
    }


}
