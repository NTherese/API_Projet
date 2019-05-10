package Pharmacie.Metier;

import java.time.LocalDate;

/**
 * classe métier de gestion d'une prescription
 * @author meril
 * @version 1.0
 */
public class Prescriptions {
    protected int idpres; // identifiant unique de la prescription
    protected LocalDate dateP; // date de la prescription
    protected int idmed;// identifiant du medecin prescripteur
    protected int idpat;// patient qui a la prescription

    //constructeur par defaut
    public Prescriptions() {}

    /**
     * constucteur parametre
     * @param idpres identifiant de la prescription
     * @param dateP date de la prescription
     * @param idmed identifiant du medecin
     * @param idpat  identifiant du patient
     */
    public Prescriptions(int idpres, LocalDate dateP, int idmed) {
        this.idpres = idpres;
        this.dateP = dateP;
        this.idmed = idmed;
    }
    
    public Prescriptions(int idpres, LocalDate dateP, int idmed, int idpat) {
        this.idpres = idpres;
        this.dateP = dateP;
        this.idmed = idmed;
        this.idpat=idpat;
    }
    

    /**
     * getter idprescription
     * @return  id prescription en cours
     */
    public int getIdpres() {
        return idpres;
    }

    /**
     * setter idpres
     * @param idpres 
     */
    public void setIdpres(int idpres) {
        this.idpres = idpres;
    }

    /**
     * getter datePres
     * @return date la prescription en cours
     */
    public LocalDate getDateP() {    
        return dateP;
    }

    /**
     * setter datePres
     * @param dateP 
     */
    public void setDateP(LocalDate dateP) {    
        this.dateP = dateP;
    }

    /**
     * getter idmedicament
     * @return id du medicament sur la prescription en cours
     */
    public int getIdmed() {
        return idmed;
    }

    /**
     * setter idemed
     * @param idmed 
     */
    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }

    /**
     * getter patient
     * @return  patient 
     */
    public int getIdpat() {    
        return idpat;
    }

    /**setter patient
     * @param patient 
     */
    

    public void setIdpat(int idpat) {
        this.idpat = idpat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idpres;
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
        final Prescriptions other = (Prescriptions) obj;
        if (this.idpres != other.idpres) {
            return false;
        }
        return true;
    }   

    /**
     * affichage des informations de la prescription
     * @return description complete de la prescription
     */
    
    @Override
    public String toString() {
        return "Prescriptions{" + "idpres=" + idpres + ", dateP=" + dateP + ", idmed=" + idmed + ", idpat=" + idpat + '}';
    }

    
    
    
    
    
}
