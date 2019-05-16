/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.builder;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author meril
 */
public class Pharmacie {
    public static void main(String[] args) throws Exception {
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        Date date = format.parse( "2019-05-16" );
        
         Set<Infos> mesInfos= new HashSet<>();
        Infos inf=new Infos(1,new Medicament(225,"23","para","pr palu"),null," boites",5 );
        mesInfos.add(inf);
        
        try{
            Prescription p1=new Prescription.PrescriptionBuilder().
                    setId(1).setDatepres(date).
                    setMedecin(new Medecin(1,"Matricule1","NomMedecin 1","PrenomMedecin 1","0468/841")).
                    setPatient(new Patient(1,"NomPatient 1","PrenomPatient 1","TelPatient1")).
                    setMesInfos(mesInfos).
                    build();
            System.out.println(p1);
        } catch (Exception ex) {
            System.out.println("erreur "+ex);
        }
        
        try{
            Prescription p2=new Prescription.PrescriptionBuilder().
                    setId(0).setDatepres(date).
                    setMedecin(new Medecin(1,"Matricule1","NomMedecin 1","PrenomMedecin 1","0468/841")).
                    setPatient(new Patient(1,"NomPatient 1","PrenomPatient 1","TelPatient1")).
                    setMesInfos(mesInfos).
                    build();
            
            System.out.println(p2);
        } catch (Exception ex) {
            System.out.println("erreur p2 "+ex);
        }
    }
    
}
