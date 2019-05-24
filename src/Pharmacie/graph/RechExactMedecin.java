/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.graph;

import Pharmacie.DAO.MedecinDAO;
import Pharmacie.DAO.PrescriptionDAO;
import Pharmacie.Metier.Medecins;
import Pharmacie.Metier.Prescriptions;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meril
 */
public class RechExactMedecin extends javax.swing.JPanel {

    MedecinDAO medDAO=null;
    Medecins meds=null;
    PrescriptionDAO presDAO=null;
    Prescriptions pres= null;
    DefaultTableModel dft1 = new DefaultTableModel();
    
    
    /**
     * Creates new form RechExactMedecin
     */
    public RechExactMedecin() {
        initComponents();
        dft1.addColumn("idpres");
        dft1.addColumn("dateprescription");
        dft1.addColumn("idmed");
        dft1.addColumn("idpat");
        jTable1.setModel(dft1);
    }
    
    public void setPrescriptionDAO(PrescriptionDAO presDAO){
        this.presDAO=presDAO;
    }
    
    public void setMedecinDAO(MedecinDAO medDAO){
        this.medDAO=medDAO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblidmedecin = new javax.swing.JLabel();
        lblmatmedecin = new javax.swing.JLabel();
        lblnommedecin = new javax.swing.JLabel();
        lblprenommedecin = new javax.swing.JLabel();
        lbltelmedecin = new javax.swing.JLabel();
        txtidmedecin = new javax.swing.JTextField();
        txtmatmedecin = new javax.swing.JTextField();
        txtnommedecin = new javax.swing.JTextField();
        txtpremedecin = new javax.swing.JTextField();
        txttelmedecin = new javax.swing.JTextField();
        btrech = new javax.swing.JButton();
        btmodif = new javax.swing.JButton();
        btsup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnveRech = new javax.swing.JButton();

        lblidmedecin.setText("  Identifiant medecin");

        lblmatmedecin.setText("  Matricule medecin");

        lblnommedecin.setText("  Nom medecin");

        lblprenommedecin.setText("  Prenom medecin");

        lbltelmedecin.setText("  Telephone medecin");

        btrech.setText("Rechercher");
        btrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrechActionPerformed(evt);
            }
        });

        btmodif.setText("Modifier");
        btmodif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodifActionPerformed(evt);
            }
        });

        btsup.setText("Supprimer");
        btsup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsupActionPerformed(evt);
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

        btnveRech.setText("Nouvelle recherche");
        btnveRech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnveRechActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btrech)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btmodif))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblprenommedecin)
                            .addComponent(lblidmedecin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblmatmedecin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblnommedecin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbltelmedecin, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidmedecin)
                            .addComponent(txtmatmedecin, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(txtnommedecin)
                            .addComponent(txtpremedecin)
                            .addComponent(txttelmedecin))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(btsup)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(btnveRech)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblidmedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidmedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblmatmedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmatmedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblnommedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnommedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addComponent(lblprenommedecin))
                            .addComponent(txtpremedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltelmedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelmedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btrech)
                    .addComponent(btmodif)
                    .addComponent(btsup))
                .addGap(42, 42, 42)
                .addComponent(btnveRech)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrechActionPerformed
        int numed = 0;
        try{
           numed=Integer.parseInt(txtidmedecin.getText());
           meds=medDAO.read(numed);
           txtmatmedecin.setText(meds.getMat());
            txtnommedecin.setText(meds.getNom());
           txtpremedecin.setText(meds.getPrenom());
           txttelmedecin.setText(meds.getTel());
           JOptionPane.showMessageDialog(this," Medecin trouvé","succès",JOptionPane.INFORMATION_MESSAGE);
       }catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
        
       try{
           System.out.println(numed);
            List<Prescriptions> prescrip=presDAO.rechExacteMed(numed);
            int nr = dft1.getRowCount();
            for(int i=nr-1;i>=0;i--)dft1.removeRow(i);
            prescrip.stream().map((p) -> {
                Vector v = new Vector();
                v.add(p.getIdpres());
                v.add(p.getDateP());
                v.add(p.getIdmed());
                v.add(p.getIdpat());
                return v;
            }).forEachOrdered((v) -> {
                dft1.addRow(v);
            });       
            JOptionPane.showMessageDialog(this," prescription associé au medecin trouvé","succès",JOptionPane.INFORMATION_MESSAGE);
       }
       catch(Exception f){
           JOptionPane.showMessageDialog(this,f.getMessage(),"ERREUR PRESCRIPTION ASSOCIE INTROUVABLE",JOptionPane.ERROR_MESSAGE);
           
       }
    }//GEN-LAST:event_btrechActionPerformed

    private void btmodifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodifActionPerformed
       try{  
            int numed=Integer.parseInt(txtidmedecin.getText());
            String matricule=txtmatmedecin.getText();
            String nom=txtnommedecin.getText();
            String prenom=txtpremedecin.getText();
            String tel=txttelmedecin.getText();
            Medecins medecs=new Medecins(numed,matricule,nom,prenom,tel);
            medDAO.update(medecs);
            JOptionPane.showMessageDialog(this," medecin mis à jour","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btmodifActionPerformed

    private void btsupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsupActionPerformed
        try{
             int numed=Integer.parseInt(txtidmedecin.getText());
             medDAO.delete(meds);
             txtidmedecin.setText("");
             txtmatmedecin.setText("");
             txtnommedecin.setText("");
             txtpremedecin.setText("");
             txttelmedecin.setText("");
             JOptionPane.showMessageDialog(this," medecin effacé","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btsupActionPerformed

    private void btnveRechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnveRechActionPerformed
            txtidmedecin.setText("");
             txtmatmedecin.setText("");
             txtnommedecin.setText("");
             txtpremedecin.setText("");
             txttelmedecin.setText("");
    }//GEN-LAST:event_btnveRechActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmodif;
    private javax.swing.JButton btnveRech;
    private javax.swing.JButton btrech;
    private javax.swing.JButton btsup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblidmedecin;
    private javax.swing.JLabel lblmatmedecin;
    private javax.swing.JLabel lblnommedecin;
    private javax.swing.JLabel lblprenommedecin;
    private javax.swing.JLabel lbltelmedecin;
    private javax.swing.JTextField txtidmedecin;
    private javax.swing.JTextField txtmatmedecin;
    private javax.swing.JTextField txtnommedecin;
    private javax.swing.JTextField txtpremedecin;
    private javax.swing.JTextField txttelmedecin;
    // End of variables declaration//GEN-END:variables
}
