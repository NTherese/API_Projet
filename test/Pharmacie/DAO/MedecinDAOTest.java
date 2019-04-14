/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import static Pharmacie.DAO.MedicamentDAOTest.dbConnect;
import Pharmacie.Metier.InfoPrescriptions;
import Pharmacie.Metier.Medecins;
import Pharmacie.Metier.Medicaments;
import Pharmacie.Metier.Patients;
import Pharmacie.Metier.Prescriptions;
import connections.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
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
public class MedecinDAOTest {
    static Connection dbConnect;
    public MedecinDAOTest() {
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
     * Test of read method, of class MedecinDAO.
     */
    @Test
    public void testRead_int() throws Exception {
        System.out.println("read");
        MedecinDAO instance=new MedecinDAO();
        instance.setDbConnect(dbConnect);
        Medecins obj = new Medecins(0,"MT","NomTest","PrenomTest","0000000000");
        Medecins expResult = instance.create(obj);
        int id = expResult.getIdmed();
        Medecins result = instance.read(id);
        assertEquals("Identidiants differents ",expResult.getIdmed(), result.getIdmed());
        assertEquals("Matricules differents ",expResult.getMat(), result.getMat());
        try{
            result=instance.read(0);
             fail("Exceptio d'id inconnu non genere");
        }
        catch(SQLException e){}
        instance.delete(result);
        
       
    }

    /**
     * Test of create method, of class MedecinDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Medecins obj = new Medecins(0,"MT","NomTest","PrenomTest","0000000000");
        MedecinDAO instance = new MedecinDAO();
        instance.setDbConnect(dbConnect);
        Medecins expResult = new Medecins(0,"MT","NomTest","PrenomTest","0000000000");
        Medecins result = instance.create(obj);
        assertEquals(" Noms differents ",expResult.getNom(), result.getNom());
        assertEquals("Matricules differents ",expResult.getMat(), result.getMat());
        
        instance.delete(result);
    }

    /**
     * Test of update method, of class MedecinDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Medecins obj = new Medecins(0,"MT","NomTest","PrenomTest","0000000000");
        MedecinDAO instance = new MedecinDAO();
        instance.setDbConnect(dbConnect);
        obj=instance.create(obj);
        obj.setMat("Matricule");
        obj.setTel("212548955");
        Medecins expResult = obj;
        Medecins result = instance.update(obj);
        assertEquals("Matricules differents ",expResult.getMat(), result.getMat());
        assertEquals("Telephones differents ",expResult.getTel(), result.getTel());
        
        instance.delete(result);
    }

    /**
     * Test of delete method, of class MedecinDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Medecins obj = new Medecins(0,"MT","NomTest","PrenomTest","0000000000");
        MedecinDAO instance = new MedecinDAO();
        instance.setDbConnect(dbConnect);
        obj=instance.create(obj);
        instance.delete(obj);
        try{
            instance.read(obj.getIdmed());
            fail("Exception de record introuvable non genérée");
        }
        catch(SQLException e){}
        obj=instance.create(obj);
        
        Patients patient=new Patients(0,"Testnompat","Testprenompat","Testtelpat");
       PatientDAO patientd= new PatientDAO();
       patientd.setDbConnect(dbConnect);
       patient=patientd.create(patient);
       
       Medicaments medicament = new Medicaments(0,"TestnomDL","TestdescDL","TestcodeDL");
       MedicamentDAO medicamentd=new MedicamentDAO();
       medicamentd.setDbConnect(dbConnect);
       medicament=medicamentd.create(medicament);
       
       Prescriptions prescription=new Prescriptions(0,LocalDate.now(),obj.getIdmed(),patient.getIdpat());
        PrescriptionDAO prescriptiond= new PrescriptionDAO();
        prescriptiond.setDbConnect(dbConnect);
        prescription=prescriptiond.create(prescription);
        
        
        InfoPrescriptions infopres = new InfoPrescriptions(0,prescription.getIdpres(),medicament.getIdmed(),5,"Testunite");
        InfoPrescDAO infopresd= new InfoPrescDAO();
        infopresd.setDbConnect(dbConnect);
        infopres=infopresd.create(infopres);
        
        try{
            instance.delete(obj);
            fail("Exception de record de parent clé etrangere");
        }
        catch(Exception e){}
        infopresd.delete(infopres);
        prescriptiond.delete(prescription);
        medicamentd.delete(medicament);
        patientd.delete(patient);
        instance.delete(obj);
    }

    /**
     * Test of read method, of class MedecinDAO.
     */
    @Test
    public void testRead_String() throws Exception {
        System.out.println("read");
        String mat = "";
        MedecinDAO instance = new MedecinDAO();
        instance.setDbConnect(dbConnect);
        Medecins obj= new Medecins(0,"MT","NomTest","PrenomTest","0000000000");
        Medecins expResult = instance.create(obj);
        mat=expResult.getMat();
        Medecins result = instance.read(mat);
        assertEquals("Matricules differents ",expResult.getMat(), result.getMat());
        
        try{
            result=instance.read(0);
            fail("Exception d'un code inconnu non genere");
            instance.delete(obj);
        }
        catch(SQLException e){}
        instance.delete(result);
    }
    
    
    
}
