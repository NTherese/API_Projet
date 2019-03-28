package Pharmacie.Metier;

/**
 * Classe metier de gestion des medecins
 * @author meril
 * @version 1.0
 */
public class Medecins {
    protected int idmed; //identifiant unique du medecin
    protected String mat; // matricule du medecin
    protected String nom; //nom du medecin
    protected String prenom; //prenom du medecin
    protected String tel; //telephone du medecin

    //Constructeur par defaut
    public Medecins() {}

    /**
     * Constructeur parametre
     * @param idmed identifiant medecin
     * @param mat matricule du medecin
     * @param nom nom du medecin
     * @param prenom prenom du medecin
     * @param tel telephone du medecin
     */
    public Medecins(int idmed, String mat, String nom, String prenom, String tel) {
        this.idmed = idmed;
        this.mat = mat;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    /**
     * Getter id medecin
     * @return identifiant du medecin en cours
     */
    public int getIdmed() {
        return idmed;
    }

    /**
     * Setter Idmed
     * @param idmed id medecin
     */
    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }

    /**
     * getter matMedecin
     * @return matricule du medecin en cours
     */
    public String getMat() {
        return mat;
    }

    /**
     * setter mat
     * @param mat  
     */
    public void setMat(String mat) {
        this.mat = mat;
    }

    /**
     * getter nomMedecin
     * @return nom du medecin en cours
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * setter nomMedecin
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *getter prenomMedecin
     * @return prenom medecin en cours
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * setter prenomMedecin
     * @param prenom 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * getter telMedecin
     * @return tel medecin en cours
     */
    public String getTel() {
        return tel;
    }

    /**
     * setter telMedecin
     * @param tel 
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * affichage des informations du medecin
     * @return la description complete du medecin
     */
    @Override
    public String toString() {
        return "Medecins{" + "idmed=" + idmed + ", mat=" + mat + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + '}';
    }
    
    
    
}
