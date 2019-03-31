package Pharmacie.DAO;

import Pharmacie.Metier.Prescriptions;
import connections.DBConnection;
import java.sql.*;
import java.time.LocalDate;

/**
 * classe de mappage poo-relationnel precription
 *
 * @author meril
 * @version 1.0
 * @see Prescriptions
 */
public class PrescriptionDAO extends DAO<Prescriptions>{
    Connection dbConnect=DBConnection.getConnection();

    /**
     * récupération des données d'une prescription sur base de son identifiant
     * @throws SQLException identifiant inconnu
     * @param id identifiant de la prescription
     * @return prescription trouvé
     */
    @Override
    public Prescriptions read(int id) throws SQLException {
       Prescriptions p=null;
        String req="select * from api_prescription where idpres=?";
         try(PreparedStatement p1=dbConnect.prepareStatement(req)){
             p1.setInt(1, id);
             try(ResultSet rs=p1.executeQuery()){
                 if(rs.next()){
                     LocalDate date=rs.getDate("DATEPRESCRIPTION").toLocalDate();
                     int idmedecin=rs.getInt("IDMED");
                     int idpat=rs.getInt("IDPAT");
                     p=new Prescriptions(id,date,idmedecin,idpat);
                 }
                 else{
                     throw new SQLException("Identifiant de la prescription inconnu");
                 }
             }
         }
        return p;
    }
    
    
    /**
     * création d'une prescription sur base des valeurs de son objet métier
     * @throws SQLException erreur de création
     * @param obj prescription à créer
     * @return prescription créé
     */
    @Override
    public Prescriptions create(Prescriptions obj) throws SQLException {
        int n;
        Prescriptions p= null;
        String q1="insert into api_prescription(dateprescription, idmed,idpat) values(?,?,?)";
        String q2="select idpres from api_prescription where dateprescription=? and idmed=? and idpat=?";
        try(PreparedStatement p1=dbConnect.prepareStatement(q1); PreparedStatement p2=dbConnect.prepareStatement(q2)){
            p1.setDate(1,java.sql.Date.valueOf(obj.getDateP()));
            p1.setInt(2,obj.getIdmed());
            p1.setInt(3,obj.getIdpat());
            n=p1.executeUpdate();
            if(n==0){
                throw new SQLException("erreur creation prescription");
            }
            p2.setDate(1,java.sql.Date.valueOf(obj.getDateP()));
            p2.setInt(2,obj.getIdmed());
            p2.setInt(3,obj.getIdpat());
            try(ResultSet rs=p2.executeQuery()){
                if(rs.next()){
                    int idpres=rs.getInt(1);
                    p=read(idpres);
                }
                else{
                    throw new SQLException("erreur creation prescription, prescription introuvable");
                }
            }
        }
        
        return p;
    }

    /**
     * mise à jour des données d'une prescription sur base de son identifiant
     * @return prescription
     * @param obj prescription à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Prescriptions update(Prescriptions obj) throws SQLException {
       
        Prescriptions pres = null;
        String req="update api_prescription set dateprescription=?,idmed=?,idpat=? where idpres=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setDate(1,java.sql.Date.valueOf(obj.getDateP()));
            p.setInt(2,obj.getIdmed());
            p.setInt(3,obj.getIdpat());
            p.setInt(4,obj.getIdpres());
            int n=p.executeUpdate();
            if(n==0){
                throw new SQLException("aucune ligne prescription mise à jour");
            }
            else{
                System.out.println("Mise à jour effectué avec succes!!!!!");
            }
            pres=read(obj.getIdpres());
        }
        return pres;
    }

    /**
     * effacement du medicament sur base de son identifiant
     *
     * @throws SQLException erreur de suppression
     * @param obj medicament à supprimer
     */
    @Override
    public void delete(Prescriptions obj) throws SQLException {
        String req="delete from api_prescription where idpres=?";
        try(PreparedStatement p=dbConnect.prepareStatement(req)){
            p.setInt(1,obj.getIdpres());
            int n=p.executeUpdate();
            if(n==0){
                throw new SQLException("aucune ligne prescription effacée");
            }
            else{
                System.out.println("Suppression effectuée avec succes!!!!");
            }
        }
    }
      
    

}