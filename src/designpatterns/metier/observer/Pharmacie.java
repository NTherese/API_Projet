package designpatterns.metier.observer;

/**
 *
 * @author meril
 */
public class Pharmacie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Medecin m1=new Medecin(1,"M1","Docteur nom 1","Docteur prenom 1","Docteur tel 1");
         Medecin m2=new Medecin(2,"M2","Docteur nom 2","Docteur prenom 2","Docteur tel 2");   
         
         Patient p1=new Patient(1,"Patient nom 1","Patient prenom 1","Patient tel 1");
         Patient p2=new Patient(2,"Patient nom 2","Patient prenom 2","Patient tel 2");
        
         
        m1.addObserver(p1);
        m1.addObserver(p2);
        m2.addObserver(p1);
        
        m1.setTel("modif tel docteur 1");
        m2.setTel("modif tel docteur 2");
        
    }
    
}
