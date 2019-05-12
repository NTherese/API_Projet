package designpatterns.metier.builder;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author meril
 */
public class Patient {
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
    public Patient(PatientBuilder pb) {
        this.idpat = pb.idpat;
        this.nom = pb.nom;
        this.prenom = pb.prenom;
        this.tel = pb.tel;
    }

    /**
     * getter idpatient
     * @return identifiant du patient
     */
    public int getIdpat() {
        return idpat;
    }

    

    /**
     * getter nom 
     * @return nom du patient
     */
    public String getNom() {
        return nom;
    }


    /**
     * getter prenom
     * @return prenom du patient
     */
    public String getPrenom() {
        return prenom;
    }

    

    /**
     * getter tel
     * @return telephone du patient
     */
    public String getTel() {
        return tel;
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
    
    public static class PatientBuilder{
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
    
            public PatientBuilder(int idpat, String nom) throws Exception{
                if(idpat<=0 || nom==null) throw new Exception("Informations de construction incompletes");
            }

        public PatientBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public PatientBuilder setTel(String tel) {
            this.tel = tel;
            return this;
        }
            
          public Patient build() throws Exception{
              return new Patient(this);
          }  
    
    }
}
