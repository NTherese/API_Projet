package Pharmacie.DAO;

/**
 * classe de mappage poo-relationnel medicament
 *
 * @author meril
 * @version 1.0
 * @see Medicaments
 */
import Pharmacie.DAO.DAO;
import java.sql.SQLException;
import java.sql.*;
import Pharmacie.Metier.Medicaments;
import connections.DBConnection;
import java.util.ArrayList;
import java.util.List;


public class MedicamentDAO extends DAO<Medicaments> {

        Connection dbConnect=DBConnection.getConnection();

    /**
     * récupération des données d'un medicament sur base de son identifiant
     * @throws SQLException identifiant inconnu
     * @param id identifiant du medicament
     * @return medicament trouvé
     */
        @Override
    public Medicaments read(int id) throws SQLException {
        Medicaments m=null;
        String req="select * from api_medicament where idmedoc=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setInt(1, id);
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     String nom=rs.getString("NOM");
                     String des=rs.getString("DESCRIPTION");
                     String code=rs.getString("CODE");
                     m=new Medicaments(id,nom,des,code);
                 }
                 else{
                     throw new SQLException("Identifiant du medicament inconnu");
                 }
             }
         }
        return m;
    }
    
    /**
     * Recuperation des données d'un medicament sur base de son code
     * @param code code du medicament
     * @return medicament trouve
     * @throws SQLException code inconnu
     */
    public Medicaments read(String code) throws SQLException {
        Medicaments m=null;
        String req="select * from api_medicament where code=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setString(1, code);
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     int id=rs.getInt("IDMEDOC");
                     String nom=rs.getString("NOM");
                     String des=rs.getString("DESCRIPTION");
                     m=new Medicaments(id,nom,des,code);
                 }
                 else{
                     throw new SQLException("Code du medicament inconnu");
                 }
             }
         }
        return m;
    }

    
    /**
     * création d'un medicament sur base des valeurs de son objet métier
     * @throws SQLException erreur de création
     * @param obj medicament à créer
     * @return medicament créé
     */
    @Override
    public Medicaments create(Medicaments obj) throws SQLException {
        int n;
        Medicaments m = null;
        String q1="insert into api_medicament(nom, description,code) values(?,?,?)";
        String q2="select idmedoc from api_medicament where nom=? and description=? and code=?";
        try(PreparedStatement p1=dbConnect.prepareStatement(q1); PreparedStatement p2=dbConnect.prepareStatement(q2)){
            p1.setString(1,obj.getNom());
            p1.setString(2,obj.getDesc());
            p1.setString(3,obj.getCode());
            n=p1.executeUpdate();
            if(n==0){
                throw new SQLException("erreur creation medicament");
            }
            p2.setString(1,obj.getNom());
            p2.setString(2,obj.getDesc());
            p2.setString(3,obj.getCode());
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

    
    /**
     * mise à jour des données du medicament sur base de son identifiant
     *
     * @return Medicament
     * @param obj medicament à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Medicaments update(Medicaments obj) throws SQLException {
        Medicaments m = null;
        String req="update api_medicament set nom=?,description=?,code=? where idmedoc=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setString(1,obj.getNom());
            p.setString(2,obj.getDesc());
            p.setString(3,obj.getCode());
            p.setInt(4,obj.getIdmed());
            int n=p.executeUpdate();
            if(n==0){
                throw new SQLException("aucune ligne medicament mise à jour");
            }
            else{
                System.out.println("Mise à jour effectué avec succes!!!!!");
            }
            m=read(obj.getIdmed());
        }
        return m;
    }

    
    /**
     * effacement du medicament sur base de son identifiant
     *
     * @throws SQLException erreur de suppression
     * @param obj medicament à supprimer
     */
    @Override
    public void delete(Medicaments obj) throws SQLException {
        String req="delete from api_medicament where idmedoc=?";
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
  
    
    /**
     * méthode permettant de récupérer tous les medicaments portant un certain nom
     * @param nomrech nom du medicament recherché
     * @return liste de medicaments
     * @throws SQLException nom inconnu
     */
    public List<Medicaments> rechNom(String nomrech) throws SQLException {
        List<Medicaments> Meds = new ArrayList<>();
        String req = "select * from api_medicament where nom like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+nomrech+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int id = rs.getInt("IDMEDOC");
                    String nom = rs.getString("NOM");
                    String des = rs.getString("DESCRIPTION");
                    String code = rs.getString("CODE");
                    Meds.add(new Medicaments(id,nom,des,code));
                }
                if (!trouve) {
                    throw new SQLException("nom inconnu");
                } else {
                    return Meds;
                }
            }
        }
        
        
    }

    
    
}

