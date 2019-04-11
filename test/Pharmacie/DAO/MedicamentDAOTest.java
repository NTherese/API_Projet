/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.DAO;

import Pharmacie.Metier.Medicaments;
import connections.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
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
        Medicaments  obj=new Medicaments(0,"Testnom","Testdesc","Testcode");
        Medicaments expResult = instance.create(obj);
        id=expResult.getIdmed();
        Medicaments result = instance.read(id);
        assertEquals("Id differents ",expResult.getIdmed(), result.getIdmed());
        // TODO review the generated test code and remove the default call to fail.
        try{
            result=instance.read(0);
            fail("Exception d'id inconnu non genere");
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
        Medicaments obj=new Medicaments(0,"Testnom","Testdesc","Testcode");
        Medicaments expResult = instance.create(obj);
        code=expResult.getCode();
        Medicaments result = instance.read(code);
        assertEquals("Codes differents",expResult.getCode(), result.getCode());
        // TODO review the generated test code and remove the default call to fail.
        try{
            result=instance.read(0);
            fail("Exception d'un code inconnu non genere");
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
        
        Medicaments obj = new Medicaments(0,"Testnom","Testdesc","TestCode");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setDbConnect(dbConnect);
        Medicaments expResult = new Medicaments(0,"Testnom","Testdesc","TestCode");
        Medicaments result = instance.create(obj);
        
        assertEquals("Codes differents",expResult.getCode(), result.getCode());
        // TODO review the generated test code and remove the default call to fail.
        
        assertNotEquals("id medicament reste à zero",result.getIdmed(),expResult.getIdmed());
        int idmed=result.getIdmed();
        
        obj=new Medicaments(0,"Testnom2","Testdesc2","TestCode");
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
        Medicaments obj = new Medicaments(0,"Testnom","Testdesc","Testcode");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setDbConnect(dbConnect);
        obj=instance.create(obj);
        obj.setNom("TestNom2");
        //etc
        obj.setDesc("Testdesc2");
        //etc
        
        Medicaments expResult = obj;
        Medicaments result = instance.update(obj);
        assertEquals(expResult.getNom(), result.getNom());
        //etc
        assertEquals(expResult.getDesc(), result.getDesc());
        //etc
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of delete method, of class MedicamentDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Medicaments obj = new Medicaments(0,"Testnom","Testdesc","Testcode");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setDbConnect(dbConnect);
        obj=instance.create(obj);
        instance.delete(obj);
        try{
            instance.read(obj.getIdmed());
            fail("Exception de record introuvable non generee");
        }
        catch(SQLException e){}
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of rechNom method, of class MedicamentDAO.
     */
    @Test
    public void testRechNom() throws Exception {
        System.out.println("rechNom");
        Medicaments obj1=new Medicaments(0,"Testnom","Testdesc","TestCode");
        Medicaments obj2=new Medicaments(0,"Testnom","Testdesc2","TestCode2");
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
