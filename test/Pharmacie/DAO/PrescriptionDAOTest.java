/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import static Pharmacie.DAO.MedicamentDAOTest.dbConnect;
import Pharmacie.Metier.Medecins;
import Pharmacie.Metier.Patients;
import Pharmacie.Metier.Prescriptions;
import connections.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author meril
 */
public class PrescriptionDAOTest {
    static Connection dbConnect;
    public PrescriptionDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        DBConnection.closeConnection();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class PrescriptionDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        Medecins med=new Medecins(0,"MT","NomTest","PrenomTest","0000000000");
        MedecinDAO m=new MedecinDAO();
        m.setDbConnect(dbConnect);
        med=m.create(med);
        Patients pat=new Patients(0,"NomTest","PrenomTest","0000000000");
        PatientDAO p=new PatientDAO();
        p.setDbConnect(dbConnect);
        pat=p.create(pat);
        Prescriptions obj = new Prescriptions(0,LocalDate.now(),med.getIdmed(),pat.getIdpat());
        PrescriptionDAO instance = new PrescriptionDAO();
        Prescriptions expResult=instance.create(obj);
        instance.setDbConnect(dbConnect);
        Prescriptions result=instance.read(expResult.getIdpres());
        assertEquals("Dates différentes",result.getDateP(),expResult.getDateP());
        assertEquals("Id médecin différents",result.getIdmed(),expResult.getIdmed());
        assertEquals("Id patient différents",result.getIdpat(),expResult.getIdpat());
        try {
            instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {}
        instance.delete(result);
        p.delete(pat);
        m.delete(med);
    }

    /**
     * Test of create method, of class PrescriptionDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Medecins med=new Medecins(0,"MT","NomTest","PrenomTest","0000000000");
        MedecinDAO m=new MedecinDAO();
        m.setDbConnect(dbConnect);
        med=m.create(med);
        Patients pat=new Patients(0,"NomTest","PrenomTest","0000000000");
        PatientDAO p=new PatientDAO();
        p.setDbConnect(dbConnect);
        pat=p.create(pat);
        Prescriptions obj = new Prescriptions(0,LocalDate.now(),med.getIdmed(),pat.getIdpat());
        Prescriptions expResult=obj;
        PrescriptionDAO instance = new PrescriptionDAO();
        instance.setDbConnect(dbConnect);
        Prescriptions result=instance.create(obj);
        assertEquals("Dates différentes",result.getDateP(),expResult.getDateP());
        assertEquals("Id médecin différents",result.getIdmed(),expResult.getIdmed());
        assertEquals("Id patient différents",result.getIdpat(),expResult.getIdpat());
        instance.delete(result);
        p.delete(pat);
        m.delete(med);
        
    }

    /**
     * Test of update method, of class PrescriptionDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Medecins med=new Medecins(0,"MT","NomTest","PrenomTest","0000000000");
        Medecins med2=new Medecins(0,"MA","NomTest2","PrenomTest2","0000000000");
        MedecinDAO m=new MedecinDAO();
        m.setDbConnect(dbConnect);
        med=m.create(med);
        med2=m.create(med2);
        Patients pat=new Patients(0,"NomTest","PrenomTest","0000000000");
        PatientDAO p=new PatientDAO();
        p.setDbConnect(dbConnect);
        pat=p.create(pat);
        Prescriptions obj = new Prescriptions(0,LocalDate.now(),med.getIdmed(),pat.getIdpat());
        PrescriptionDAO instance = new PrescriptionDAO();
        obj=instance.create(obj);
        obj.setIdmed(med2.getIdmed());
        Prescriptions expResult=obj;
        instance.setDbConnect(dbConnect);
        Prescriptions result=instance.update(obj);
        assertEquals("Dates différentes",result.getDateP(),expResult.getDateP());
        assertEquals("Id médecin différents",result.getIdmed(),expResult.getIdmed());
        assertEquals("Id patient différents",result.getIdpat(),expResult.getIdpat());
        instance.delete(result);
        p.delete(pat);
        m.delete(med);
        m.delete(med2);
    }

    /**
     * Test of delete method, of class PrescriptionDAO.
     */
    @Test
    public void testDelete() throws Exception {
       System.out.println("delete");
        Medecins med=new Medecins(0,"MT","NomTest","PrenomTest","0000000000");
        Medecins med2=new Medecins(0,"MA","NomTest2","PrenomTest2","0000000000");
        MedecinDAO m=new MedecinDAO();
        m.setDbConnect(dbConnect);
        med=m.create(med);
        med2=m.create(med2);
        Patients pat=new Patients(0,"NomTest","PrenomTest","0000000000");
        PatientDAO p=new PatientDAO();
        p.setDbConnect(dbConnect);
        pat=p.create(pat);
        Prescriptions obj = new Prescriptions(0,LocalDate.now(),med.getIdmed(),pat.getIdpat());
        PrescriptionDAO instance = new PrescriptionDAO();
        obj=instance.create(obj);
        obj.setIdmed(med2.getIdmed());
        Prescriptions expResult=obj;
        instance.setDbConnect(dbConnect);
        Prescriptions result=instance.update(obj);
        instance.delete(result);
        p.delete(pat);
        m.delete(med);
        m.delete(med2);
        try{
            instance.read(result.getIdpres());
            fail("exception de record introuvable non générée");
        }catch(Exception e){}   
    }
    
}
