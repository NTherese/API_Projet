package Pharmacie.DAO;

import Pharmacie.Metier.vue_qtite_presc;
import connections.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * classe de mappage poo-relationnel vue_qtite_presc
 *
 * @author meril
 * @version 1.0
 * @see vue_qtite_presc
 */
public class vue_qtite_prescDAO extends DAO<vue_qtite_presc> {
    Connection dbConnect=DBConnection.getConnection();
    /**
     * Methode permettant de recuperer les données de la vue sur la quantite de medicaments prescrits
     * @throws SQLException 
     */
    public List<vue_qtite_presc> affichVue(int id) throws SQLException {
        List<vue_qtite_presc> vue = new ArrayList<>();
       String req="select * from qtite_presc where idmedoc=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setInt(1,id);
            try(ResultSet rs=p.executeQuery()){
                while(rs.next()){
                    String nom=rs.getString("NOM");
                     String des=rs.getString("DESCRIPTION");
                     int qte=rs.getInt("somme");
                     String unit=rs.getString("UNITE");
                     vue.add(new vue_qtite_presc(id,nom,des,qte,unit));
                }
            }
            catch(SQLException e){
                  System.out.println("Erreur affichage vue somme medicament: "+e);
             }
        }
        catch(SQLException e){
            System.out.println("Erreur preparation de la requete affichage vue vue: "+e);
        }
        return vue;
    }


    @Override
    public vue_qtite_presc create(vue_qtite_presc obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public vue_qtite_presc update(vue_qtite_presc obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(vue_qtite_presc obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public vue_qtite_presc read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
