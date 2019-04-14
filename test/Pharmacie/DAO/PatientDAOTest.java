/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import static Pharmacie.DAO.MedecinDAOTest.dbConnect;
import Pharmacie.Metier.InfoPrescriptions;
import Pharmacie.Metier.Medecins;
import Pharmacie.Metier.Medicaments;
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
public class PatientDAOTest {
    static Connection dbConnect;
    public PatientDAOTest() {
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
     * Test of read method, of class PatientDAO.
     */
    @Test
    public void testRead_String() throws Exception {
        System.out.println("read");
        String nom = "";
        PatientDAO instance = new PatientDAO();
        instance.setDbConnect(dbConnect);
        Patients obj = new Patients(0,"NomTestRS","PrenomTestRS","0000000000");
        Patients expResult = instance.create(obj);
        nom=expResult.getNom();
        Patients result = instance.read(nom);
        assertEquals("Noms differents ",expResult.getNom(), result.getNom());
        try{
            result=instance.read(0);
            fail("Exception d'un code inconnu non genere");
            instance.delete(obj);
        }
        catch(SQLException e){}
        instance.delete(result);
        
    }

    /**
     * Test of read method, of class PatientDAO.
     */
    @Test
    public void testRead_int() throws Exception {
        System.out.println("read");
        int id = 0;
        PatientDAO instance = new PatientDAO();
        Patients obj=new Patients(0,"NomTestRI","PrenomTestRI","0000000000");
        Patients expResult = instance.create(obj);
        id=expResult.getIdpat();
        Patients result = instance.read(id);
        assertEquals("identifiants differents ",expResult.getIdpat(), result.getIdpat());
        assertEquals("Noms differents ",expResult.getNom(),result.getNom());
        
        try{
            result=instance.read(0);
            fail("exception d'id inconnu non générée");
        }
        catch(SQLException e){}
        instance.delete(result);
    }

    /**
     * Test of create method, of class PatientDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Patients obj = new Patients(0,"NomTestC","PrenomTestC","0000000000");
        PatientDAO instance = new PatientDAO();
        instance.setDbConnect(dbConnect);
        Patients expResult = new Patients (0,"NomTestC","PrenomTestC","0000000000");
        Patients result = instance.create(obj);
        assertEquals("noms differents ",expResult.getNom(), result.getNom());
        
        instance.delete(result);
    }

    /**
     * Test of update method, of class PatientDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Patients obj = new Patients(0,"NomTestU","PrenomTest","0000000000");
        PatientDAO instance = new PatientDAO();
        instance.setDbConnect(dbConnect);
        obj=instance.create(obj);
        obj.setNom("NomTest2");
        obj.setPrenom("PrenomTest2");
        Patients expResult = obj;
        Patients result = instance.update(obj);
        assertEquals("Noms differents ",expResult.getNom(), result.getNom());
        assertEquals("Prenoms differents ",expResult.getPrenom(), result.getPrenom());
        
        instance.delete(result);
    }

    /**
     * Test of delete method, of class PatientDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Patients obj = new Patients(0,"NomTestU","PrenomTest","0000000000");
        PatientDAO instance = new PatientDAO();
        instance.setDbConnect(dbConnect);
        obj=instance.create(obj);
        instance.delete(obj);
        try{
            instance.read(obj.getIdpat());
            fail("Exception de record introuvable non genérée");
        }
       catch(SQLException e){}
        obj=instance.create(obj);
        
        Medecins medecin=new Medecins(0,"MT","NomTest","PrenomTest","0000000000");
        MedecinDAO medecind=new MedecinDAO();
        medecind.setDbConnect(dbConnect);
        medecin=medecind.create(medecin);
        
        Medicaments medicament = new Medicaments(0,"TestnomDL","TestdescDL","TestcodeDL");
       MedicamentDAO medicamentd=new MedicamentDAO();
       medicamentd.setDbConnect(dbConnect);
       medicament=medicamentd.create(medicament);
       
       Prescriptions prescription=new Prescriptions(0,LocalDate.now(),medecin.getIdmed(),obj.getIdpat());
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
        medecind.delete(medecin);
        instance.delete(obj);
    }
    
}
