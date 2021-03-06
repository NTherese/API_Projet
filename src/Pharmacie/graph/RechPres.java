/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.graph;

import Pharmacie.DAO.PrescriptionDAO;
import Pharmacie.Metier.Prescriptions;
import Pharmacie.Metier.vue_pres_medic;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meril
 */
public class RechPres extends javax.swing.JPanel {

    PrescriptionDAO presDAO=null;
    Prescriptions pres=null;
     DefaultTableModel dft1 = new DefaultTableModel();
    /**
     * Creates new form RechPres
     */
    public RechPres() {
        initComponents();
        dft1.addColumn("date prescription");
        dft1.addColumn("nom medicament");
        dft1.addColumn("description");
        dft1.addColumn("quantite");
        dft1.addColumn("unite");
        jTable1.setModel(dft1);
    }

    public void setPrescriptionDAO(PrescriptionDAO presDAO){
        this.presDAO=presDAO;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblidpres = new javax.swing.JLabel();
        lbldatepres = new javax.swing.JLabel();
        lblmedecinpres = new javax.swing.JLabel();
        lblidpatpres = new javax.swing.JLabel();
        txtidpres = new javax.swing.JTextField();
        txtidmedpres = new javax.swing.JTextField();
        txtidpatpres = new javax.swing.JTextField();
        btrech = new javax.swing.JButton();
        btmaj = new javax.swing.JButton();
        btdel = new javax.swing.JButton();
        txtdatepres = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnvelrech = new javax.swing.JButton();

        lblidpres.setText("  Identifiant de la prescription");

        lbldatepres.setText("  Date de la prescription");

        lblmedecinpres.setText("  Identifiant du medecin prescripteur");

        lblidpatpres.setText("  Identifiant du patient");

        btrech.setText("RECHERCHER");
        btrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrechActionPerformed(evt);
            }
        });

        btmaj.setText("MODIFIER");
        btmaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmajActionPerformed(evt);
            }
        });

        btdel.setText("SUPPRIMER");
        btdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdelActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnvelrech.setText("Nouvelle recherche");
        btnvelrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvelrechActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblmedecinpres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblidpres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbldatepres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblidpatpres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidpres, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(txtidmedpres)
                            .addComponent(txtidpatpres)
                            .addComponent(txtdatepres)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btrech)
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnvelrech)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btmaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addComponent(btdel)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblidpres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidpres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbldatepres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdatepres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblmedecinpres, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidmedpres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblidpatpres, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidpatpres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btrech)
                            .addComponent(btmaj)
                            .addComponent(btdel))
                        .addGap(45, 45, 45)
                        .addComponent(btnvelrech)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 112, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrechActionPerformed
        int numpres=0;
        try{
           numpres=Integer.parseInt(txtidpres.getText());
           pres=presDAO.read(numpres);
           txtdatepres.setText(pres.getDateP().toString());
           txtidmedpres.setText(String.valueOf(pres.getIdmed()));
           txtidpatpres.setText(String.valueOf(pres.getIdpat()));
           JOptionPane.showMessageDialog(this," prescription trouvé","succès",JOptionPane.INFORMATION_MESSAGE);
       }catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
       }
        
       try{
           //System.out.println(numpres);
            List<vue_pres_medic> Vue=presDAO.rech(numpres);
            int nr = dft1.getRowCount();
            for(int i=nr-1;i>=0;i--)dft1.removeRow(i);
            Vue.stream().map((vue) -> {
                Vector v = new Vector();
                v.add(vue.getDatepres());
                v.add(vue.getNom());
                v.add(vue.getDes());
                v.add(vue.getQte());
                v.add(vue.getUnite());
                return v;
            }).forEachOrdered((v) -> {
                dft1.addRow(v);
            });       
            JOptionPane.showMessageDialog(this," Detail de la prescription !!!","succès",JOptionPane.INFORMATION_MESSAGE);
       }
       catch(Exception f){
           JOptionPane.showMessageDialog(this,f.getMessage(),"ERREUR: DETAIL INDISPONIBLE ",JOptionPane.ERROR_MESSAGE);
           
       }
    }//GEN-LAST:event_btrechActionPerformed

    private void btmajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmajActionPerformed
        
        try{
           int numpres=Integer.parseInt(txtidpres.getText());
         int jour=Integer.parseInt(txtdatepres.getText().substring(0,2));
         int mois=Integer.parseInt(txtdatepres.getText().substring(4,5));
         int an=Integer.parseInt(txtdatepres.getText().substring(6));
         
        LocalDate datepres=LocalDate.of(an, mois,(jour));
        
        int idmedecin=Integer.parseInt(txtidmedpres.getText());
        int idpat=Integer.parseInt(txtidpatpres.getText());
        pres= new Prescriptions(numpres,datepres,idmedecin,idpat);
        presDAO.update(pres);
        JOptionPane.showMessageDialog(this," prescription mis à jour","succès",JOptionPane.INFORMATION_MESSAGE);
       }catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btmajActionPerformed

    private void btdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdelActionPerformed
        try{
             int numpres=Integer.parseInt(txtidpres.getText());
             presDAO.delete(pres);
             txtidpres.setText("");
             txtdatepres.setText("");
             txtidmedpres.setText("");
             txtidpatpres.setText("");
             JOptionPane.showMessageDialog(this," prescription effacé","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btdelActionPerformed

    private void btnvelrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvelrechActionPerformed
        txtidpres.setText("");
        txtdatepres.setText("");
        txtidmedpres.setText("");
        txtidpatpres.setText("");
    }//GEN-LAST:event_btnvelrechActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdel;
    private javax.swing.JButton btmaj;
    private javax.swing.JButton btnvelrech;
    private javax.swing.JButton btrech;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbldatepres;
    private javax.swing.JLabel lblidpatpres;
    private javax.swing.JLabel lblidpres;
    private javax.swing.JLabel lblmedecinpres;
    private javax.swing.JTextField txtdatepres;
    private javax.swing.JTextField txtidmedpres;
    private javax.swing.JTextField txtidpatpres;
    private javax.swing.JTextField txtidpres;
    // End of variables declaration//GEN-END:variables
}
