package designpatterns.metier.builder;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author meril
 */
public class Medicament {
    /**
     * identifiant unique du medicament
     */
    protected int idmedoc;
    
    /**
     * code unique du medicament
     */
    protected String code;
    
    /**
     * nom du medcicament
     */
    protected String nom;
    
    
    /**
     * description du medicament
     */
    protected String description;
    
    protected Set<Infos> mesInfos= new HashSet<>();

    /**
     * constructeur par defaut
     */
    public Medicament() {
    }

    /**
     * construcetru parametre
     * @param idmedoc identifiant unique du medicament
     * @param code code du medicament
     * @param nom nom du medicament
     * @param description  description du medicament
     */
    public Medicament(int idmedoc, String code, String nom, String description) {
        this.idmedoc = idmedoc;
        this.code = code;
        this.nom = nom;
        this.description = description;
    }

    /**
     * getter idmedoc
     * @return identifiant du medicament
     */
    public int getIdmedoc() {
        return idmedoc;
    }

    /**
     * setter idmedoc
     * @param idmedoc identifiant du medicament 
     */
    public void setIdmedoc(int idmedoc) {
        this.idmedoc = idmedoc;
    }

    /**
     * getter code
     * @return code unique  du medicament
     */
    public String getCode() {
        return code;
    }

    /**
     * setter code
     * @param code code du medicament 
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * getter nom
     * @return  nom du medicament
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
     * getter description
     * @return description du medicament
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter description
     * @param description description du medicament
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Infos> getMesInfos() {
        return mesInfos;
    }

    /**
     * afficage des informations du medicament
     * @return informations completes du medicament
     */
    @Override
    public String toString() {
        return "Medicament{" + "idmedoc=" + idmedoc + ", code=" + code + ", nom=" + nom + ", description=" + description + '}';
    }
    
    
}
