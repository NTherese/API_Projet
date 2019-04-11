/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

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
public class MedicamentDAOTest {
    static Connection dbConnect;
    public MedicamentDAOTest() {
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
     * Test of read method, of class MedicamentDAO.
     */
    @Test
    public void testRead_int() throws Exception {
        System.out.println("read");
        int id = 0;
        MedicamentDAO instance = new MedicamentDAO();
        instance.setDbConnect(dbConnect);
        Medicaments  obj=new Medicaments(0,"TestnomRDI","TestdescRDI","TestcodeRDI");
        Medicaments expResult = instance.create(obj);
        id=expResult.getIdmed();
        Medicaments result = instance.read(id);
        assertEquals("Id differents ",expResult.getIdmed(), result.getIdmed());
        // TODO review the generated test code and remove the default call to fail.
        try{
            result=instance.read(0);
            fail("Exception d'id inconnu non genere");
            instance.delete(obj);
        }
        catch(SQLException e){}
        instance.delete(result);
        
    }

    /**
     * Test of read method, of class MedicamentDAO.
     */
    @Test
    public void testRead_String() throws Exception {
        System.out.println("read");
        String code = "";
        MedicamentDAO instance = new MedicamentDAO();
        instance.setDbConnect(dbConnect);
        Medicaments obj=new Medicaments(0,"TestnomRDS","TestdescRDS","TestcodeRDS");
        Medicaments expResult = instance.create(obj);
        code=expResult.getCode();
        Medicaments result = instance.read(code);
        assertEquals("Codes differents",expResult.getCode(), result.getCode());
        // TODO review the generated test code and remove the default call to fail.
        try{
            result=instance.read(0);
            fail("Exception d'un code inconnu non genere");
            instance.delete(obj);
        }
        catch(SQLException e){}
        instance.delete(result);
        
    }

    /**
     * Test of create method, of class MedicamentDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        
        Medicaments obj = new Medicaments(0,"TestnomC","TestdescC","TestCodeC");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setDbConnect(dbConnect);
        Medicaments expResult = new Medicaments(0,"TestnomC","TestdescC","TestCodeC");
        Medicaments result = instance.create(obj);
        
        assertEquals("Codes differents",expResult.getCode(), result.getCode());
        // TODO review the generated test code and remove the default call to fail.
        
        assertNotEquals("id medicament reste à zero",result.getIdmed(),expResult.getIdmed());
        int idmed=result.getIdmed();
        
        obj=new Medicaments(0,"TestnomC2","TestdescC2","TestCodeC");
        try{
            obj=instance.create(obj);
            fail("Exception de doublons non generee");
            instance.delete(obj);
        }
        catch(Exception e){}
        instance.delete(result);   
    }

    /**
     * Test of update method, of class MedicamentDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Medicaments obj = new Medicaments(0,"TestnomUP","TestdescUP","TestcodeUP");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setDbConnect(dbConnect);
        obj=instance.create(obj);
        obj.setNom("TestNomUP6");
        //etc
        obj.setDesc("TestdescUP6");
        //etc
        
        Medicaments expResult = obj;
        Medicaments result = instance.update(obj);
        assertEquals("Noms differents ",expResult.getNom(), result.getNom());
        //etc
        assertEquals("Decription differentes ",expResult.getDesc(), result.getDesc());
        //etc
        instance.delete(result);
       
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of delete method, of class MedicamentDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Medicaments obj = new Medicaments(0,"TestnomDL","TestdescDL","TestcodeDL");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setDbConnect(dbConnect);
        obj=instance.create(obj);
        instance.delete(obj);
        try{
            instance.read(obj.getIdmed());
            fail("Exception de record introuvable non generee");
        }
        catch(SQLException e){}
        instance.create(obj);
        Patients patient=new Patients(0,"Testnompat","Testprenompat","Testtelpat");
       PatientDAO patientd= new PatientDAO();
       patientd.setDbConnect(dbConnect);
       patient=patientd.create(patient);
       
        Medecins medecin=new Medecins(0,"TestmatriMD","Testnom","Testprenom","Testtel");
        MedecinDAO medecind=new MedecinDAO();
        medecind.setDbConnect(dbConnect);
        medecin=medecind.create(medecin);
        
        Prescriptions prescription=new Prescriptions(0,LocalDate.now(),medecin.getIdmed(),patient.getIdpat());
        PrescriptionDAO prescriptiond= new PrescriptionDAO();
        prescriptiond.setDbConnect(dbConnect);
        prescription=prescriptiond.create(prescription);
        
        
        InfoPrescriptions infopres = new InfoPrescriptions(0,prescription.getIdpres(),obj.getIdmed(),5,"Testunite");
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
        medecind.delete(medecin);
        patientd.delete(patient);
        instance.delete(obj);
       
    }

    /**
     * Test of rechNom method, of class MedicamentDAO.
     */
    @Test
    public void testRechNom() throws Exception {
        System.out.println("rechNom");
        Medicaments obj1=new Medicaments(0,"TestnomRC","TestdescRC","TestCodeRC");
        Medicaments obj2=new Medicaments(0,"TestnomRC","TestdescRC2","TestCodeRC2");
        String nomrech = "Testnom";
        MedicamentDAO instance = new MedicamentDAO();
        instance.setDbConnect(dbConnect);
        obj1=instance.create(obj1);
        obj2=instance.create(obj2);
        
        List<Medicaments> result = instance.rechNom(nomrech);
        if(result.indexOf(obj1)<0) fail("record introuvable "+obj1);
        if(result.indexOf(obj2)<0) fail("record introuvable "+obj2);
        instance.delete(obj1);
        instance.delete(obj2);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
