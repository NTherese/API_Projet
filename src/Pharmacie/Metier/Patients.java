package Pharmacie.Metier;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe metier de gestion des patients
 * @author meril
 * @version 1.0
 */
public class Patients {
    protected int idpat; //identifiant unique du patient
    protected String nom; // nom du patient
    protected String prenom; //prenom du patient
    protected String tel; //telephone du patient
    private Set<Prescriptions> prescription=new HashSet<>();
    
    //Constucteur par defaut
    public Patients() {}

    /**
     * Constructeur parametre 
     * @param idpat identifiant unique du patient
     * @param nom nom du patient
     * @param prenom prenom du patient
     * @param tel telephone du patient
     */
    public Patients(int idpat, String nom, String prenom, String tel) {
        this.idpat = idpat;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    /**
     * getter idPat
     * @return identifiant du patient en cours
     */
    public int getIdpat() {
        return idpat;
    }

    /**
     * setter idpat
     * @param idpat 
     */
    public void setIdpat(int idpat) {
        this.idpat = idpat;
    }

    /**
     * getter nom
     * @return  nom du patient en cours
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter prenom
     * @return prenom du patient en cours
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * setter prenom
     * @param prenom 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * getter tel
     * @return telephone du patient en cours
     */
    public String getTel() {
        return tel;
    }

    /**
     * setter tel
     * @param tel 
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * getter de la prescription
     * @return le set de la prescription
     */
    public Set<Prescriptions> getPrescription() {
        return prescription;
    }
    /**
     * setter prescription
     * @param prescription 
     */
    public void setPrescription(Set<Prescriptions> prescription) {
        this.prescription = prescription;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.nom);
        hash = 83 * hash + Objects.hashCode(this.prenom);
        hash = 83 * hash + Objects.hashCode(this.tel);
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
        final Patients other = (Patients) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        return true;
    }

    
    
    /**
     * Affiche les informations du patient
     * @return la description complete du patient
     */
    @Override
    public String toString() {
        return "Patients{" + "idpat=" + idpat + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + '}';
    }
    
    
    
    
    
}
