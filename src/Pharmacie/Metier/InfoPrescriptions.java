package Pharmacie.Metier;

/**
 * classe métier de gestion des informations d'une prescription
 * @author meril
 * @version 1.0
 */
public class InfoPrescriptions {
    protected int idinfos; //identifiant unique des informations d'une prescription
    protected int idpres;// identifiant d'une prescription
    protected int idmedoc;// identifiant du medicament sur la prescription
    protected int qte;// quantite du medicament prescrits
    protected String unite; // unite du medicament prescrits
    
    // Constructeur par defaut
    public InfoPrescriptions() {}

    /**
     * Constructeur parametre
     * @param idinfos
     * @param idpres
     * @param idmedoc
     * @param qte
     * @param unite 
     */
    public InfoPrescriptions(int idinfos, int idpres, int idmedoc, int qte, String unite) {
        this.idinfos = idinfos;
        this.idpres = idpres;
        this.idmedoc = idmedoc;
        this.qte = qte;
        this.unite = unite;
    }

    /**
     * getter idinfos
     * @return id de l'informaton en cours d'enregistrement
     */
    public int getIdinfos() {
        return idinfos;
    }

    /**
     * setter idinfos
     * @param idinfos 
     */
    public void setIdinfos(int idinfos) {
        this.idinfos = idinfos;
    }

    /**
     * getter id prescription
     * @return id de la prescription en cours
     */
    public int getIdpres() {
        return idpres;
    }

    /**
     * setter idpres
     * @param idpres 
     */
    public void setIdpres(int idpres) {
        this.idpres = idpres;
    }

    /**
     * getter idmedoc
     * @return id du medicament en cours
     */
    public int getIdmedoc() {
        return idmedoc;
    }

    /**
     * setter idmedoc
     * @param idmedoc 
     */
    public void setIdmedoc(int idmedoc) {
        this.idmedoc = idmedoc;
    }

    /**
     * getter qte
     * @return quantite de medicaments prescris
     */
    public int getQte() {
        return qte;
    }

    /**
     * setter qte
     * @param qte 
     */
    public void setQte(int qte) {
        this.qte = qte;
    }

    /**
     * getter unite
     * @return unite du medicament prescrit
     */
    public String getUnite() {
        return unite;
    }

    /**
     * setter unite
     * @param unite 
     */
    public void setUnite(String unite) {
        this.unite = unite;
    }

    /**
     * affichages des informations
     * @return descriprion complete des informations sur une prescription
     */
    @Override
    public String toString() {
        return "InfoPrescriptions{" + "idinfos=" + idinfos + ", idpres=" + idpres + ", idmedoc=" + idmedoc + ", qte=" + qte + ", unite=" + unite + '}';
    }
    
    
    
    
}
