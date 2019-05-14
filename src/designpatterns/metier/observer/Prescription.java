/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.observer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author meril
 */
public class Prescription {
    /**
     * identifiant unique de la prescription
     */
    protected int idpres;
    
    /**
     * date de la prescription
     */
    protected java.util.Date datepres;
    
    /**
     * Medecin prescripteur
     */
    protected Medecin monMedecin;
    
    /**
     * Patient precrit
     */
    protected Patient monPatient;
    
    protected Set<Infos> mesInfos= new HashSet<>();

    /**
     * constructeur par defaut
     */
    public Prescription() {
    }

    /**
     * constructeur parametre
     * @param idpres identifiant unique de la prescription
     * @param datepres date de la prescription
     * @param monMedecin medecin prescripteur
     * @param monPatient patient precrit
     */
    public Prescription(int idpres, Date datepres, Medecin monMedecin, Patient monPatient) {
        this.idpres = idpres;
        this.datepres = datepres;
        this.monMedecin = monMedecin;
        this.monPatient = monPatient;
    }

    /**
     * getter idpres
     * @return identifiant prescription
     */
    public int getIdpres() {
        return idpres;
    }

    /**
     * setter idpres
     * @param idpres identifiant prescription 
     */
    public void setIdpres(int idpres) {
        this.idpres = idpres;
    }

    /**
     * getter datepres
     * @return date de la prescription
     */
    public Date getDatepres() {
        return datepres;
    }

    /**
     * setter datepre
     * @param datepres date de la prescription 
     */
    public void setDatepres(Date datepres) {
        this.datepres = datepres;
    }

    
    public Medecin getMonMedecin() {
        return monMedecin;
    }

    public void setMonMedecin(Medecin monMedecin) {
        this.monMedecin = monMedecin;
    }

    public Patient getMonPatient() {
        return monPatient;
    }

    public void setMonPatient(Patient monPatient) {
        this.monPatient = monPatient;
    }

    public Set<Infos> getMesInfos() {
        return mesInfos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idpres;
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
        final Prescription other = (Prescription) obj;
        if (this.idpres != other.idpres) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prescription{" + "idpres=" + idpres + ", datepres=" + datepres + ", monMedecin=" + monMedecin + ", monPatient=" + monPatient + ", mesInfos=" + mesInfos + '}';
    }
    
    
}
