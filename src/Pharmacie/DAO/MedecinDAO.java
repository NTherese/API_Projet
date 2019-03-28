package Pharmacie.DAO;

import Pharmacie.Metier.Medecins;
import Pharmacie.Metier.Medicaments;
import connections.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe de mappage poo-relationnel medecins
 *
 * @author meril
 * @version 1.0
 * @see Medecins
 */



public class MedecinDAO extends DAO<Medecins> {
    Connection dbConnect=DBConnection.getConnection();

    @Override
    public Medecins read(String mat) throws SQLException {
        Medecins m=null;
        String req="select * from api_medecin where matricule like ?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setString(1, "%"+mat+"%");
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     int id=rs.getInt("IDMED");
                     String nom=rs.getString("NOM");
                     String pre=rs.getString("PRENOM");
                     String tel=rs.getString("TEL");
                     m=new Medecins(id,mat,nom,pre,tel);
                 }
                 else{
                     throw new SQLException("Matricule du medecin inconnu");
                 }
             }
         }
        return m;
    }

    
    /**
     * récupération des données d'un medecin sur base de son identifiant
     * @throws SQLException identifiant inconnu
     * @param id identifiant du medecin
     * @return medecin trouvé
     */
    public Medecins read(int id) throws SQLException {
        Medecins m=null;
        String req="select * from api_medecin where idmed=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setInt(1, id);
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     String mat=rs.getString("MATRICULE");
                     String nom=rs.getString("NOM");
                     String pre=rs.getString("PRENOM");
                     String tel=rs.getString("TEL");
                     m=new Medecins(id,mat,nom,pre,tel);
                 }
                 else{
                     throw new SQLException("Identifiant du medicament inconnu");
                 }
             }
         }
        return m;
    }
    
    
    @Override
    public Medecins create(Medecins obj) throws SQLException {
        int n;
        Medecins m = null;
        String q1="insert into api_medecin(matricule,nom,prenom,tel) values(?,?,?,?)";
        String q2="select idmed from api_medecin where matricule=? and nom=? and prenom=? and tel=?";
        try(PreparedStatement p1=dbConnect.prepareStatement(q1); PreparedStatement p2=dbConnect.prepareStatement(q2)){
            p1.setString(1,obj.getMat());
            p1.setString(2,obj.getNom());
            p1.setString(3,obj.getPrenom());
            p1.setString(4,obj.getTel());
            n=p1.executeUpdate();
            if(n==0){
                throw new SQLException("erreur creation medicament");
            }
            p2.setString(1,obj.getMat());
            p2.setString(2,obj.getNom());
            p2.setString(3,obj.getPrenom());
            p2.setString(4,obj.getTel());
            try(ResultSet rs=p2.executeQuery()){
                if(rs.next()){
                    int idmed=rs.getInt(1);
                     m= read(idmed);
                }
                else{
                    throw new SQLException("erreur creation medicament, medicament introuvable");
                }
            }
        }
        
        return m;
    }
    
    

    @Override
    public Medecins update(Medecins obj) throws SQLException {
         Medecins m = null;
        String req="update api_medecin set matricule=?,nom=?,prenom=?,tel=? where idmed=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setString(1,obj.getMat());
            p.setString(2,obj.getNom());
            p.setString(3,obj.getPrenom());
            p.setString(4,obj.getTel());
            p.setInt(5,obj.getIdmed());
            int n=p.executeUpdate();
            if(n==0){
                throw new SQLException("aucune ligne medicament mise à jour");
            }else{
                System.out.println("Mise à jour effectué avec succes!!!!!");
            }
            m=read(obj.getMat());
        }
        return m;
    }

    @Override
    public void delete(Medecins obj) throws SQLException {
         String req="delete from api_medecin where idmed=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setInt(1,obj.getIdmed());
            int n=p.executeUpdate();
            if(n==0){
                throw new SQLException("aucune ligne medicament effacée");
            }
            else{
                System.out.println("Suppression effectuée avec succes!!!!");
            }
        }
    }
    
}
