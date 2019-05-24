package Pharmacie.DAO;

import Pharmacie.Metier.Medecins;
import Pharmacie.Metier.Patients;
import connections.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


/**
 * classe de mappage poo-relationnel patients
 *
 * @author meril
 * @version 1.0
 * @see Patients
 */
public class PatientDAO extends DAO<Patients>{
    Connection dbConnect=DBConnection.getConnection();
    
    
    public Patients read(String nom) throws SQLException {
        Patients p=null;
        String req="select * from api_patient where nom like ?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setString(1, "%"+nom+"%");
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     int id=rs.getInt("IDPAT");
                     String pre=rs.getString("PRENOM");
                     String tel=rs.getString("TEL");
                     p=new Patients(id,nom,pre,tel);
                 }
                 else{
                     throw new SQLException("Nom du patient inconnu");
                 }
             }
         }
        return p;
    }

    /**
     * récupération des données d'un patient sur base de son identifiant
     * @throws SQLException identifiant inconnu
     * @param id identifiant du patient
     * @return patient trouvé
     */
    @Override
    public Patients read(int id) throws SQLException {
        Patients p=null;
        String req="select * from api_patient where idpat=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setInt(1, id);
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     String nom=rs.getString("NOM");
                     String pre=rs.getString("PRENOM");
                     String tel=rs.getString("TEL");
                     p=new Patients(id,nom,pre,tel);
                 }
                 else{
                     throw new SQLException("Identifiant du patient inconnu");
                 }
             }
         }
        return p;
    }
    
    @Override
    public Patients create(Patients obj) throws SQLException {
        int n;
        Patients p = null;
        String q1="insert into api_patient(nom,prenom,tel) values(?,?,?)";
        String q2="select idpat from api_patient where nom=? and prenom=? and tel=?";
        try(PreparedStatement p1=dbConnect.prepareStatement(q1); PreparedStatement p2=dbConnect.prepareStatement(q2)){
            p1.setString(1,obj.getNom());
            p1.setString(2,obj.getPrenom());
            p1.setString(3,obj.getTel());
            n=p1.executeUpdate();
            if(n==0){
                throw new SQLException("erreur creation patient");
            }
            p2.setString(1,obj.getNom());
            p2.setString(2,obj.getPrenom());
            p2.setString(3,obj.getTel());
            try(ResultSet rs=p2.executeQuery()){
                if(rs.next()){
                    int id=rs.getInt(1);
                    p=read(id);
                }
                else{
                    throw new SQLException("erreur creation patient,patient introuvable");
                }
            }
        }
        
        return p;
    }

    @Override
    public Patients update(Patients obj) throws SQLException {
        Patients pat = null;
        String req="update api_patient set nom=?,prenom=?,tel=? where idpat=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setString(1,obj.getNom());
            p.setString(2,obj.getPrenom());
            p.setString(3,obj.getTel());
            p.setInt(4,obj.getIdpat());
            int n=p.executeUpdate();
            if(n==0){
                throw new SQLException("aucune ligne patient mise à jour");
            }else{
                System.out.println("Mise à jour effectué avec succes!!!!!");
            }
            pat=read(obj.getNom());
        }
        return pat;
    }

    @Override
    public void delete(Patients obj) throws SQLException {
        String req="delete from api_patient where idpat=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setInt(1,obj.getIdpat());
            int n=p.executeUpdate();
            if(n==0){
                throw new SQLException("aucune ligne medicament effacée");
            }
            else{
                System.out.println("Suppression effectuée avec succes!!!!");
            }
        }
        catch(SQLIntegrityConstraintViolationException mes){
            throw new SQLException("Impossible de supprimer car lié à d'autres tables");
        }
    }
    
    
    // Recherche exacte sur l'identifiant du patient 
    
    public List<Patients> rechEx(int idpat) throws SQLException{
        List<Patients> pat = new ArrayList<>();
            String req = "select * from api_patient where idpat=?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1,idpat );
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    String nom=rs.getString("NOM");
                    String prenom=rs.getString("PRENOM");
                    String tel=rs.getString("TEL");
                    pat.add(new Patients(idpat,nom,prenom,tel));
                }
                if (!trouve) {
                    throw new SQLException("Patient inconnu");
                } else {
                    return pat;
                }
            }
        }
    
    }
    
    //Recherche partielle sur le nom du patient
    
    
    public List<Patients> rechPart(String nom) throws SQLException{
        List<Patients> pat = new ArrayList<>();
            String req = "select * from api_patient where upper(nom) like ?";
           
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1,"%"+nom.toUpperCase()+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    String name=rs.getString("NOM");
                    int idpat=rs.getInt("IDPAT");
                    String prenom=rs.getString("PRENOM");
                    String tel=rs.getString("TEL");
                    pat.add(new Patients(idpat,name,prenom,tel));
                }
                if (!trouve) {
                    throw new SQLException("Patient inconnu");
                } else {
                    return pat;
                }
            }
        }
    
    }
    
    
    public List<Patients> AfficPat() throws SQLException{
        List<Patients> pat = new ArrayList<>();
            String req = "select * from api_patient";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idpat=rs.getInt("IDPAT");
                    String nom=rs.getString("NOM");
                    String prenom=rs.getString("PRENOM");
                    String tel=rs.getString("TEL");
                    pat.add(new Patients(idpat,nom,prenom,tel));
                }
                if (!trouve) {
                    throw new SQLException("Patient inconnu");
                } else {
                    return pat;
                }
            }
        }
    
    }
    
}
