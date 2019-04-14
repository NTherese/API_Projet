package Pharmacie.Metier;

/**
 * Classe metier pour la somme des quantites prescrites par medicaments
 * @author meril
 * @version 1.0
 */
public class vue_qtite_presc {
    protected int idemedoc;
    protected String nom;
    protected String description;
    protected int somme;
    protected String unite;

    public vue_qtite_presc() {}

    public vue_qtite_presc(int idemedoc, String nom, String description, int somme, String unite) {
        this.idemedoc = idemedoc;
        this.nom = nom;
        this.description = description;
        this.somme = somme;
        this.unite = unite;
    }

    public int getIdemedoc() {
        return idemedoc;
    }

    public void setIdemedoc(int idemedoc) {
        this.idemedoc = idemedoc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    @Override
    public String toString() {
        return "Médicament n°"+idemedoc+":"+"\nNom :" + nom + " "+description+"\nQuantite totale prescrite:" + somme + " " + unite;
    }
    
    
    
}
