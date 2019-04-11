package Pharmacie.DAO;

import Pharmacie.Metier.InfoPrescriptions;
import connections.DBConnection;
import java.sql.*;


/**
 * classe de mappage poo-relationnel InfoPrescriptions
 *
 * @author meril
 * @version 1.0
 * @see InfosPrescriptions
 */
public class InfoPrescDAO extends DAO<InfoPrescriptions> {
     Connection dbConnect=DBConnection.getConnection();

     /**
     * récupération des données d'une info sur la prescription sur base de son identifiant
     * @throws SQLException identifiant inconnu
     * @param id identifiant de l'information
     * @return information trouvé
     */
    @Override
    public InfoPrescriptions read(int id) throws SQLException {
        InfoPrescriptions info=null;
        String req="select * from api_info_pres_medi where idinfos=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setInt(1, id);
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     int idpres=rs.getInt("IDPRES");
                     int idmedoc=rs.getInt("IDMEDOC");
                     int qte=rs.getInt("QUANTITE");
                     String unit=rs.getString("UNITE");
                     info= new InfoPrescriptions(id,idpres,idmedoc,qte,unit);
                 }
                 else{
                     throw new SQLException("Identifiant de l'information de prescription inconnu");
                 }
             }
         }
        return info;
    }

    /**
     * création d'une information sur base des valeurs de son objet métier
     * @throws SQLException erreur de création
     * @param obj information à créer
     * @return information créée
     */
    @Override
    public InfoPrescriptions create(InfoPrescriptions obj) throws SQLException {
        int n;
        InfoPrescriptions info = null;
        String q1="insert into api_info_pres_medi(idpres,idmedoc,quantite,unite) values(?,?,?,?)";
        String q2="select idinfos from api_info_pres_medi where idpres=? and idmedoc=? and quantite=? and unite=?";
        try(PreparedStatement p1=dbConnect.prepareStatement(q1); PreparedStatement p2=dbConnect.prepareStatement(q2)){
            p1.setInt(1,obj.getIdpres());
            p1.setInt(2,obj.getIdmedoc());
            p1.setInt(3,obj.getQte());
            p1.setString(4,obj.getUnite());
            n=p1.executeUpdate();
            if(n==0){
                throw new SQLException("erreur creation infos");
            }
            p2.setInt(1,obj.getIdpres());
            p2.setInt(2,obj.getIdmedoc());
            p2.setInt(3,obj.getQte());
            p2.setString(4,obj.getUnite());            
            try(ResultSet rs=p2.executeQuery()){
                if(rs.next()){
                    int idinfos=rs.getInt("IDINFOS");
                    obj.setIdinfos(idinfos);
                    info=read(idinfos);
                }
                else{
                    throw new SQLException("erreur creation infos, infos introuvable");
                }
            }
        }
        
        return info;
    }

    @Override
    public InfoPrescriptions update(InfoPrescriptions obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * effacement de l'information sur base de son identifiant
     *
     * @throws SQLException erreur de suppression
     * @param obj info prescription à supprimer
     */
    @Override
    public void delete(InfoPrescriptions obj) throws SQLException {
        String req="delete from api_info_pres_medi where idinfos=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setInt(1,obj.getIdinfos());
            int n=p.executeUpdate();
            if(n==0){
                throw new SQLException("aucune ligne informations effacée");
            }
            else{
                System.out.println("Suppression effectuée avec succes!!!!");
            }
        }
    }
     
     
}
