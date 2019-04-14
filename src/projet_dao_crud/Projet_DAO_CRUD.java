package projet_dao_crud;
import Pharmacie.DAO.InfoPrescDAO;
import Pharmacie.DAO.MedicamentDAO;
import Pharmacie.DAO.MedecinDAO;
import Pharmacie.DAO.PatientDAO;
import Pharmacie.DAO.PrescriptionDAO;
import Pharmacie.DAO.vue_pres_medicDAO;
import Pharmacie.DAO.vue_qtite_prescDAO;
import Pharmacie.Metier.InfoPrescriptions;
import Pharmacie.Metier.Medecins;
import java.sql.*;
import java.util.*;
import Pharmacie.Metier.Medicaments;
import Pharmacie.Metier.Patients;
import Pharmacie.Metier.Prescriptions;
import Pharmacie.Metier.vue_qtite_presc;
import connections.DBConnection;
import static java.lang.System.exit;
import java.time.LocalDate;

/**
 *
 * @author meril
 */

public class Projet_DAO_CRUD {
    Connection dbc=null;
    Scanner sc=new Scanner(System.in);
    Connection dbConnect=DBConnection.getConnection();
    private MedicamentDAO MedDAO = new MedicamentDAO();
    private MedecinDAO MDAO = new MedecinDAO();
    private PatientDAO PDAO= new PatientDAO();
    private vue_qtite_prescDAO Vue=new vue_qtite_prescDAO();
    private PrescriptionDAO prescripDAO = new PrescriptionDAO();
    private InfoPrescDAO infoDAO= new InfoPrescDAO();
    Patients pat=null;
    Medicaments M=null;
    Medecins medecin=null;
    vue_qtite_presc v=null;
    Prescriptions prescription=null;
    InfoPrescriptions info =null;

    //Constructeur par defaut de la classe
    public Projet_DAO_CRUD() {}
    
    //Methode de verification d'une chaine String avec une expression reguliere
    public boolean verifier_chaine(String ch, String regex){
                return ch.matches(regex);
    }
    
    //Menu general du projet
    public void MenuGeneral(){
        int choix;
        String option ="";
        if(dbConnect==null){
            System.out.println("Connection ivalide");
            System.exit(1);
        }
        //System.out.println("Connexion etablie");
        MedDAO.setDbConnect(dbConnect);
        do{
            do{
                System.out.println("\n\t\tMENU GENERAL PROJET GESTION PHARMACIE: \n\t1-Gestion medicaments \n\t2-Gestion medecin \n\t3-Gestion patient \n\t4-Gestion prescription \n\t5- Gestion des informations de la prescription \n\t6-Quitter");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-6]") == false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: verif();break;
                        case 2: menuMedecin();break;
                        case 3: menuPat();break;
                        case 4: menuPrescrip();break;
                        case 5: menuInfos(); break;
                        case 6: exit(0); break; 
            }
        }while(choix!=5);
        DBConnection.closeConnection();
    }
    
    //=======================================   GESTION DES MEDICAMENTS + VUE  =======================================================
    
    //Menu gestion des medicaments
    public void verif(){
        int choix;
        String option ="";
        do{
            do{
                System.out.println("\n\t\tMENU MEDICAMENT: \n\t1-creation medicament \n\t2-Recherche medicament \n\t3-Consulter les medicaments prescrits \n\t4-Revenir au menu principal");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-4]") == false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: creation();break;
                        case 2: recherche();break;
                        case 3: vue(); break;
                        case 4: MenuGeneral();
            }
        }while(choix!=4);
    }
    
    //Utilisation de la vue sur la quantite prescrite pour l'id d'un medicament precis
    public void vue(){
        vue_qtite_prescDAO vueQt = new vue_qtite_prescDAO();
        System.out.println("Entrez l'identifiant du medicament: ");
        int id=sc.nextInt();
        sc.skip("\n");
        try{
            System.out.println(vueQt.affichVue(id));
        } catch (SQLException e) {
            System.out.println("Erreur: "+e);
        }
    }
    
    //Creation medicament
    public void creation(){
        System.out.println("Nom: ");
        String nom=sc.nextLine();
        System.out.println("Description: ");
        String des=sc.nextLine();
        System.out.println("Code: ");
        String code=sc.nextLine();
        Medicaments md=new Medicaments(0,nom,des,code);
        try{
            md=MedDAO.create(md);
            int id=md.getIdmed();
            System.out.println("Le numero du medicament est: "+id);
        } catch (SQLException e) {
            System.out.println("Erreur: "+e);
        }
    }
        
    //Recherche medicament
    public void recherche() {
        String option="";
        int choix;
        try {
            System.out.println("code recherché :");
            String nc = sc.nextLine();
            M=MedDAO.read(nc);
            System.out.println("Medicament actuel : " + M);
            do{
                    do{
                        System.out.println("Operations à faire sur le medicament: \n\t1-Modifier \n\t2-Supprimer \n\t3-Revenir au menu precedent");
                        option=sc.nextLine();
                    }while(verifier_chaine(option,"[1-3]")==false);
                    choix =Integer.parseInt(option);
                    switch(choix){
                        case 1: modification();break;
                        case 2: supprim();verif();
                        case 3: break;
                    }
                }while(choix!=3);

        } catch (SQLException e) {
            System.out.println("Erreur recherche medicament" + e.getMessage());
        }
         sc.skip("\n");
    }
    
    //modification du medicament
    public void modification() {
        String option=""; int choix;
        try {
            sc.skip("\n");
            do{
            do{
                System.out.println("Que voulez-vous modifier? \n\t1-Nom \n\t2-Description \n\t3-Code \n\t4-Revenir au menu precedent");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-4]")==false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: 
                            System.out.println("Entrez le nom: ");
                            String nom=sc.nextLine();
                            M.setNom(nom);
                            MedDAO.update(M); break;
                        case 2: 
                            System.out.println("Entrez la description: ");
                            String des=sc.nextLine();
                            M.setDesc(des);
                            MedDAO.update(M);break;
                        case 3: 
                            System.out.println("Entrez le code: ");
                            String code=sc.nextLine();
                            M.setCode(code);
                            MedDAO.update(M);break; 
                        case 4: break;
            }
        }while(choix!=4);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }
    
    //Suppression du medicament
    public void supprim() {
        try {
            MedDAO.delete(M);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
    
    
    //==========================================    GESTION DES MEDECINS    ==========================================================
    
    //Menu gestion des medecins
    public void menuMedecin(){
        int choix;
        String option ="";
        do{
            do{
                System.out.println("\n\t\tMENU MEDECINS: \n\t1-creation medecin \n\t2-Recherche medecin  \n\t3-Revenir au menu principal");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-3]") == false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: creMedecin();break;
                        case 2: rechMedecin();break;
                        case 3: MenuGeneral();
            }
        }while(choix!=3);
    }
    
    //Creation medecin
    public void creMedecin(){
        System.out.println("Matricule: ");
        String mat=sc.nextLine();
        System.out.println("Nom: ");
        String nom=sc.nextLine();
        System.out.println("Prenom:  ");
        String pre=sc.nextLine();
        System.out.println("Telephone : ");
        String tel=sc.nextLine();
        Medecins md=new Medecins(0,mat,nom,pre,tel);
        try{
            md=MDAO.create(md);
            int id=md.getIdmed();
            System.out.println("Le numero du medecin est: "+id);
        } catch (SQLException e) {
            System.out.println("Erreur cre medecin: "+e);
        }
    }
    
    //Recherche medecin
    public void rechMedecin() {
        String option="";
        int choix;
        try {
            System.out.println("Matricule recherché :");
            String mat = sc.nextLine();
            medecin=MDAO.read(mat);
            System.out.println("Medecin actuel : " + medecin);
            do{
                    do{
                        System.out.println("Operations à faire sur le medecin: \n\t1-Modifier \n\t2-Supprimer \n\t3-Revenir au menu precedent");
                        option=sc.nextLine();
                    }while(verifier_chaine(option,"[1-3]")==false);
                    choix =Integer.parseInt(option);
                    switch(choix){
                        case 1: modifMedecin();break;
                        case 2: supMedecin();menuMedecin();
                        case 3: break;
                    }
                }while(choix!=3);

        } catch (SQLException e) {
            System.out.println("Erreur recherche medecin " + e.getMessage());
        }
         sc.skip("\n");
    }
    
    //Modification d'infos du medecin
    public void modifMedecin() {
        String option=""; int choix;
        try {
            sc.skip("\n");
            do{
            do{
                System.out.println("Que voulez-vous modifier? \n\t1-Nom \n\t2-Prenom \n\t3-telephone \n\t4-Revenir au menu precedent");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-4]")==false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: 
                            System.out.println("Entrez le nom: ");
                            String nom=sc.nextLine();
                            medecin.setNom(nom);
                            MDAO.update(medecin); break;
                        case 2: 
                            System.out.println("Entrez le prenom ");
                            String pre=sc.nextLine();
                            medecin.setPrenom(pre);
                            MDAO.update(medecin);break;
                        case 3: 
                            System.out.println("Entrez le telephone: ");
                            String tel=sc.nextLine();
                            medecin.setTel(tel);
                            MDAO.update(medecin);break; 
                        case 4: break;
            }
        }while(choix!=4);
        } catch (SQLException e) {
            System.out.println("Erreur dans la modification du medecin" + e.getMessage());
        }

    }
    
    
    //Suppresion d'un medecin
    public void supMedecin() {
        try {
            MDAO.delete(medecin);
        } catch (SQLException e) {
            System.out.println("Erreur de suppresion du medecin " + e.getMessage());
        }
    }
    
    
    //======================================    GESTION DES PATIENTS    ===========================================================================
    
    //Menu gestion des patients
    public void menuPat(){
        int choix;
        String option ="";
        do{
            do{
                System.out.println("\n\t\tMENU PATIENTS: \n\t1-creation patient \n\t2-Recherche patient  \n\t3-Revenir au menu principal");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-3]") == false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: crePat();break;
                        case 2: rechPat();break;
                        case 3:  MenuGeneral();
            }
        }while(choix!=3);
    }
    
    //Creation patient
     public void crePat(){
        System.out.println("Nom: ");
        String nom=sc.nextLine();
        System.out.println("Prenom:  ");
        String pre=sc.nextLine();
        System.out.println("Telephone : ");
        String tel=sc.nextLine();
        Patients patient=new Patients(0,nom,pre,tel);
        try{
            patient=PDAO.create(patient);
            int id=patient.getIdpat();
            System.out.println("Le numero du patient est: "+id);
        } catch (SQLException e) {
            System.out.println("Erreur creation patient: "+e);
        }
    }
     
     //Recherche d'un patient
     public void rechPat(){
         String option="";
        int choix;
        try {
            System.out.println("Identifiant recherché :");
            int id=sc.nextInt();sc.skip("\n");
            pat=PDAO.read(id);
            System.out.println("Patient actuel : " + pat);
            do{
                    do{
                        System.out.println("Operations à faire sur le patient: \n\t1-Modifier \n\t2-Supprimer \n\t3-Revenir au menu precedent");
                        option=sc.nextLine();
                    }while(verifier_chaine(option,"[1-3]")==false);
                    choix =Integer.parseInt(option);
                    switch(choix){
                        case 1: modifPat();break;
                        case 2: supPat();menuPat();
                        case 3: break;
                    }
                }while(choix!=3);

        } catch (SQLException e) {
            System.out.println("Erreur recherche patient " + e.getMessage());
        }
         sc.skip("\n");
     }
    
     //Modification d'infos du patient
    public void modifPat() {
        String option=""; int choix;
        try {
            sc.skip("\n");
            do{
            do{
                System.out.println("Que voulez-vous modifier? \n\t1-Nom \n\t2-Prenom \n\t3-telephone \n\t4-Revenir au menu precedent");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-4]")==false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: 
                            System.out.println("Entrez le nom: ");
                            String nom=sc.nextLine();
                            pat.setNom(nom);
                            PDAO.update(pat);
                            break;
                        case 2: 
                            System.out.println("Entrez le prenom ");
                            String pre=sc.nextLine();
                            pat.setPrenom(pre);
                            PDAO.update(pat);break;
                        case 3: 
                            System.out.println("Entrez le telephone: ");
                            String tel=sc.nextLine();
                            pat.setTel(tel);
                            PDAO.update(pat);break; 
                        case 4: break;
            }
        }while(choix!=4);
        } catch (SQLException e) {
            System.out.println("Erreur dans la modification du medecin" + e.getMessage());
        }

    }
    
    
    //Suppresion d'un patient
    public void supPat() {
        try {
            PDAO.delete(pat);
        } catch (SQLException e) {
            System.out.println("Erreur de suppresion du patient " + e.getMessage());
        }
    }
    
    
    //========================================  GESTION DES PRESCRIPTIONS ========================================================
    //Menu gestion des prescriptions
    public void menuPrescrip(){
        int choix;
        String option ="";
        do{
            do{
                System.out.println("\n\t\tMENU PRESCRIPTIONS: \n\t1-creation prescription \n\t2-Recherche prescription  \n\t3-Revenir au menu principal");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-3]") == false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: crePres();break;
                        case 2: rechPres();break;
                        case 3:  MenuGeneral();
            }
        }while(choix!=3);
    }
    
    //Creation prescriptions
     public void crePres(){
        System.out.println("Date de la prescription:  ");
        System.out.print("Jour: "); int jr=sc.nextInt();
         System.out.print("\nMois: "); int mois=sc.nextInt();
         System.out.print("\nAnnee: "); int an=sc.nextInt();
         LocalDate date=LocalDate.of(an, mois, jr);
        System.out.println("id du medecin:  ");
        int idmedecin=sc.nextInt();
        System.out.println("id du patient : ");
        int idpat=sc.nextInt();
        sc.skip("\n");
        Prescriptions pres= new Prescriptions(0,date,idmedecin,idpat);
        try{
            pres=prescripDAO.create(pres);
            int id=pres.getIdpres();
            System.out.println("Le numero de la prescription est: "+id);
        } catch (SQLException e) {
            System.out.println("Erreur creation prescription: "+e);
        }
    }
    
     //Recherche d'un patient
     public void rechPres(){
         String option="";
        int choix;
        try {
            System.out.println("Identifiant recherché :");
            int id=sc.nextInt();sc.skip("\n");
            prescription=prescripDAO.read(id);
            System.out.println("Prescription actuelle : " + prescription);
            do{
                    do{
                        System.out.println("Operations à faire sur la prescription: \n\t1-Supprimer \n\t2-Revenir au menu precedent");
                        option=sc.nextLine();
                    }while(verifier_chaine(option,"[1-2]")==false);
                    choix =Integer.parseInt(option);
                    switch(choix){
                        case 1: supPres();menuPrescrip();
                        case 2: break;
                    }
                }while(choix!=3);

        } catch (SQLException e) {
            System.out.println("Erreur recherche prescription " + e.getMessage());
        }
         sc.skip("\n");
     }
    
     //Suppresion d'un patient
    public void supPres() {
        try {
            prescripDAO.delete(prescription);
        } catch (SQLException e) {
            System.out.println("Erreur de suppresion de la prescription " + e.getMessage());
        }
    }

    //========================================  GESTION DES INFOS DES PRESCRIPTIONS + VUE ========================================================
    //Menu gestion des informations sur une prescription
    public void menuInfos(){
        int choix;
        String option ="";
        do{
            do{
                System.out.println("\n\t\tMENU INFOS PRESCRIPTIONS: \n\t1-creation infos prescription \n\t2-Recherche prescription \n\t3-Afficher la liste des precriptions  \n\t4-Revenir au menu principal");
                option=sc.nextLine();
            }while(verifier_chaine(option,"[1-3]") == false);
            choix =Integer.parseInt(option);
            switch(choix){
                        case 1: creInfPres();break;
                        case 2: rechInfPres();break;
                        case 3: vueP();break;
                        case 4:  MenuGeneral();
            }
        }while(choix!=3);
    }
    
    //Creation infos prescriptions
     public void creInfPres(){
         System.out.println("id de la prescription: ");
         int idpres=sc.nextInt();
        System.out.println("id du medicament:  ");
        int idmedoc=sc.nextInt();
        System.out.println("Quantite precrites : ");
        int qte=sc.nextInt();
        sc.skip("\n");
         System.out.println("Unite du medicament prescrit: ");
         String unite=sc.nextLine();
        InfoPrescriptions pres= new InfoPrescriptions(0,idpres,idmedoc,qte,unite);
        try{
            pres=infoDAO.create(pres);
            int id=pres.getIdinfos();
            System.out.println("Le numero de l'information cre est: "+id);
        } catch (SQLException e) {
            System.out.println("Erreur creation info prescription: "+e);
        }
    }
     
     //Recherche d'une information de prescription
     public void rechInfPres(){
         String option="";
        int choix;
        try {
            System.out.println("Identifiant recherché :");
            int id=sc.nextInt();sc.skip("\n");
            info=infoDAO.read(id);
            System.out.println("Info de la prescription actuelle : " + info);
            do{
                    do{
                        System.out.println("Operations à faire : \n\t1-Supprimer \n\t2-Revenir au menu precedent");
                        option=sc.nextLine();
                    }while(verifier_chaine(option,"[1-2]")==false);
                    choix =Integer.parseInt(option);
                    switch(choix){
                        case 1: supInfPres();menuPrescrip();
                        case 2: break;
                    }
                }while(choix!=3);
        } catch (SQLException e) {
            System.out.println("Erreur recherche info d'une prescription " + e.getMessage());
        }
         sc.skip("\n");
     }
     
     //Suppresion d'une information
    public void supInfPres() {
        try {
            infoDAO.delete(info);
        } catch (SQLException e) {
            System.out.println("Erreur de suppresion de l'info de la  prescription " + e.getMessage());
        }
    }
     
    
    //Utilisation de la vue sur les informations des prescriptions
    public void vueP(){
        vue_pres_medicDAO vueQt = new vue_pres_medicDAO();
        sc.skip("\n");
        try{
            System.out.println(vueQt.affichVue());
        } catch (SQLException e) {
            System.out.println("Erreur: "+e);
        }
    }
    
    
    //======================================== Main General pour executer le programme ========================================================
    
    
    public static void main(String[] args) {
        Projet_DAO_CRUD proj=new Projet_DAO_CRUD();
        proj.MenuGeneral();
    }
    
}
