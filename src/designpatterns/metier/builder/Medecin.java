
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
    public Medecin(int idmed, String matricule, String nom, String prenom, String tel) {    
        this.idmed = idmed;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
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

    
    public Medecin setId(int id) {
            this.idmed=id;
            return this;
        }
        
        public Medecin setMat(String mat) {
            this.matricule=mat;
            return this;
        }
        
        public Medecin  setNom(String nom) {
            this.nom=nom;
            return this;
        }
        
        public Medecin setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public Medecin setTel(String tel) {
            this.tel = tel;
            return this;
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
}
