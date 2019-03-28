package Pharmacie.Metier;

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
     * Affiche les informations du patient
     * @return la description complete du patient
     */
    @Override
    public String toString() {
        return "Patients{" + "idpat=" + idpat + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + '}';
    }
    
    
    
    
    
}
