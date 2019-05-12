
package designpatterns.metier.builder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author meril
 */
public class Medecin {
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
    public Medecin(MedecinBuilder mb) {
        this.idmed = mb.idmed;
        this.matricule = mb.matricule;
        this.nom =mb.nom;
        this.prenom = mb.prenom;
        this.tel = mb.tel;
    }

    /**
     * getter idmedecin
     * @return  identifiant du medecin
     */
    public int getIdmed() {
        return idmed;
    }

    

    /**
     * getter matricule 
     * @return matricule du medecin
     */
    public String getMatricule() {
        return matricule;
    }

    

    /**
     * getter nom
     * @return nom du medecin
     */
    public String getNom() {
        return nom;
    }

    

    /**
     * getter prenom
     * @return prenom du medecin
     */
    public String getPrenom() {
        return prenom;
    }

    

    /**
     * getter telephone
     * @return telephone du medcin
     */
    public String getTel() {
        return tel;
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
        int hash = 7;
        hash = 83 * hash + this.idmed;
        hash = 83 * hash + Objects.hashCode(this.matricule);
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

    public static class MedecinBuilder{
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

        public MedecinBuilder(int idmed, String matricule, String nom) throws Exception {
            if(idmed<=0 || matricule==null || nom==null) throw new Exception("Informations de construction incompletes");
        }

        public MedecinBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public MedecinBuilder setTel(String tel) {
            this.tel = tel;
            return this;
        }

        public Medecin build() throws Exception{
            return new Medecin(this);
        }    
    
    }
}
