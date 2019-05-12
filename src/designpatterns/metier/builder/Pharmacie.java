/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.builder;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author meril
 */
public class Pharmacie {
    public static void main(String[] args) throws Exception {
        List<Medicament> mesMedicaments=new ArrayList<>();
        mesMedicaments.add(new Medicament(225,"23","para","pr palu"));
        try{
            Prescription p1=new Prescription.PrescriptionBuilder(1,new Medecin.MedecinBuilder(10,"458","ndzie").build(),new Patient.PatientBuilder(15,"Donald").build(), mesMedicaments).build();
            System.out.println(p1);
        } catch (Exception ex) {
            System.out.println("erreur "+ex);
        }
        
        try{
            Prescription p2=new Prescription.PrescriptionBuilder(0,new Medecin.MedecinBuilder(10,"458","ndzie").build(),new Patient.PatientBuilder(15,"Donald").build(), mesMedicaments).build();
            System.out.println(p2);
        } catch (Exception ex) {
            System.out.println("erreur p2 "+ex);
        }
    }
    
}
