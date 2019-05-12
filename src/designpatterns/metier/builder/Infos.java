package designpatterns.metier.builder;

import java.util.Objects;

/**
 *
 * @author meril
 */
public class Infos {
    protected int idinfos;
    protected Medicament monMedicament;
    protected Prescription maPrescription;
    protected String unite;
    protected int quantite;

    public Infos() {
    }

    public Infos(int idinfos, Medicament monMedicament, Prescription maPrescription, String unite, int quantite) {
        this.idinfos = idinfos;
        this.monMedicament = monMedicament;
        this.maPrescription = maPrescription;
        this.unite = unite;
        this.quantite = quantite;
    }

    public int getIdinfos() {
        return idinfos;
    }

    public void setIdinfos(int idinfos) {
        this.idinfos = idinfos;
    }

    public Medicament getMonMedicament() {
        return monMedicament;
    }

    public void setMonMedicament(Medicament monMedicament) {
        this.monMedicament = monMedicament;
    }

    public Prescription getMaPrescription() {
        return maPrescription;
    }

    public void setMaPrescription(Prescription maPrescription) {
        this.maPrescription = maPrescription;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.monMedicament);
        hash = 89 * hash + Objects.hashCode(this.maPrescription);
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
        final Infos other = (Infos) obj;
        if (!Objects.equals(this.monMedicament, other.monMedicament)) {
            return false;
        }
        if (!Objects.equals(this.maPrescription, other.maPrescription)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Infos{" + "idinfos=" + idinfos + ", monMedicament=" + monMedicament + ", maPrescription=" + maPrescription + ", unite=" + unite + ", quantite=" + quantite + '}';
    }
    
    
}
