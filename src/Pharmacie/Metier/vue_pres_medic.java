package Pharmacie.Metier;

import java.time.LocalDate;

/**
 * Classe metier pour les medicaments prescrits
 * @author meril
 * @version 1.0
 */
public class vue_pres_medic {
    protected LocalDate datepres;// date de la prescription
    protected String nom; //nom du medicament prescrit
    protected String des; // description du medicament prescrit
    protected int qte;//quantite du medicament prescrit
    protected String unite; // unite du medicament prescrit

    //Constructeur par defaut
    public vue_pres_medic() {}

    public vue_pres_medic(LocalDate datepres, String nom, String des, int qte, String unite) {
        this.datepres = datepres;
        this.nom = nom;
        this.des = des;
        this.qte = qte;
        this.unite = unite;
    }

    
    public LocalDate getDatepres() {
        return datepres;
    }

    public void setDatepres(LocalDate datepres) {
        this.datepres = datepres;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    @Override
    public String toString() {
        return "date de la prescription: " + datepres + ", nom du medicament: " + nom + ", description du medicament: =" + des + ", quantite du medicament: " + qte + ", unite du medicament: " + unite + "\n";
    }
    
    
    
    
}
