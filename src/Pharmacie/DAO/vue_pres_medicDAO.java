package Pharmacie.DAO;

import Pharmacie.Metier.vue_pres_medic;
import connections.DBConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

/**
 * classe de mappage poo-relationnel vue_pres_medic
 *
 * @author meril
 * @version 1.0
 * @see vue_pres_medic
 */
public class vue_pres_medicDAO extends DAO<vue_pres_medic> {
    Connection dbConnect=DBConnection.getConnection();
    
    /**
     * Methode permettant de recuperer les données de la vue sur la quantite de medicaments prescrits
     * @throws SQLException 
     */
    public List<vue_pres_medic> affichVue() throws SQLException {
        List<vue_pres_medic> vue = new ArrayList<>();
       String req="select dateprescription,nom,description,quantite, unite from prescr_medic";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            try(ResultSet rs=p.executeQuery()){
                while(rs.next()){
                    LocalDate date=rs.getDate("DATEPRESCRIPTION").toLocalDate();
                    String nom=rs.getString("NOM");
                     String des=rs.getString("DESCRIPTION");
                     int qte=rs.getInt("QUANTITE");
                     String unit=rs.getString("UNITE");
                     vue.add(new vue_pres_medic(date,nom,des,qte,unit));
                }
            }
            catch(SQLException e){
                  System.out.println("Erreur affichage vue presription medicament: "+e);
             }
        }
        catch(SQLException e){
            System.out.println("Erreur preparation de la requete affichage vue prescription medicament: "+e);
        }
        return vue;
    }


    @Override
    public vue_pres_medic read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public vue_pres_medic create(vue_pres_medic obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public vue_pres_medic update(vue_pres_medic obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(vue_pres_medic obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
