package Pharmacie.Metier;

import java.util.Objects;

/**
 * classe métier de gestion d'un medicament
 * @author meril
 * @version 1.0
 */

public class Medicaments {
    protected int idmed;     //identifiant unique du medicament
    protected String nom;   //nom du medicament
    protected String desc;  // description du medicament
    protected String code;  // code du medicament

    //Constructeur par défaut
    public Medicaments() {}

    /**Constructeur parametre
     * @param idmed id du medicament
     * @param nom nom du medicament
     * @param desc description du medicament
     * @param code code du medicament
     * Constructeur parametre
     */
    
    public Medicaments(int idmed, String nom, String desc, String code) {
        this.idmed = idmed;
        this.nom = nom;
        this.desc = desc;
        this.code = code;
    }

    /**
     * getter idmedicament
     * @return id medicament en cours
     */
    public int getIdmed() {
        return idmed;
    }

    /**
     * setter idmed
     * @param idmed identifiant du medicament
     */
    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }

    /**
     * getter nom
     * @return  nom du medicament en cours
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom
     * @param nom nom du medicament
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter
     * @return description du medicament
     */
    public String getDesc() {
        return desc;
    }

    /**
     * setter desc
     * @param desc description du medicament
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * getter code
     * @return code du medicament en cours
     */
    public String getCode() {
        return code;
    }

    /**
     * setter code
     * @param code  code du medicament
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * affichage des informations du medicament
     * @return description complete du medicament
     */
    @Override
    public String toString() {
        return "Medicaments{" + "idmed=" + idmed + ", nom=" + nom + ", desc=" + desc + ", code=" + code + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Medicaments other = (Medicaments) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    
    

    
    
    
    
}
