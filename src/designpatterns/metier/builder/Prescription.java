package designpatterns.metier.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
    
    /**
     * Liste des medicaments prescris
     */
    
    protected List<Medicament> mesMedicaments=new ArrayList<>();
    
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
    public Prescription(PrescriptionBuilder pb) {
        this.idpres = pb.idpres;
        this.datepres = pb.datepres;
        this.monMedecin = pb.monMedecin;
        this.monPatient =pb.monPatient;
        this.mesMedicaments=pb.mesMedicaments;          
    }

    /**
     * getter idpres
     * @return identifiant prescription
     */
    public int getIdpres() {
        return idpres;
    }

    /**
     * getter datepres
     * @return date de la prescription
     */
    public Date getDatepres() {
        return datepres;
    }

        
    public Medecin getMonMedecin() {
        return monMedecin;
    }

    
    public Patient getMonPatient() {
        return monPatient;
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
    
    public static class PrescriptionBuilder{
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
        
            /**
         * Liste des medicaments prescris
         */        
         protected List<Medicament> mesMedicaments=new ArrayList<>();

        public PrescriptionBuilder(int idpres, Medecin monMedecin, Patient monPatient, List mesMedicaments) throws Exception {
            if(idpres<=0 || monMedecin==null || monPatient==null || mesMedicaments==null) throw new Exception("Informations de construction de la prescription incompletes");
        }

        public PrescriptionBuilder setDatepres(Date datepres) {
            this.datepres=datepres;
            return this;
        }

        public PrescriptionBuilder setMedecin(Medecin medecin) {
            this.monMedecin=medecin;
            return this;
        }
        
        public PrescriptionBuilder setPatient(Patient patient) {
            this.monPatient=patient;
            return this;
        }
        
        public PrescriptionBuilder setMedicament(List<Medicament> monMedic) {
            this.mesMedicaments=monMedic;
            return this;
        }
        
        public Prescription build() throws Exception{
            return new Prescription(this);
        }
        
        
    }
}
