/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier;

import java.time.LocalDate;

/**
 *
 * @author meril
 */
public class Prescription {
    private int idpres;
    private LocalDate datePrescription;

    public Prescription() {
    }

    public Prescription(int idpres, LocalDate datePrescription) {
        this.idpres = idpres;
        this.datePrescription = datePrescription;
    }

    public int getIdpres() {
        return idpres;
    }

    public void setIdpres(int idpres) {
        this.idpres = idpres;
    }

    public LocalDate getDatePrescription() {
        return datePrescription;
    }

    public void setDatePrescription(LocalDate datePrescription) {
        this.datePrescription = datePrescription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idpres;
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
    
    
}
