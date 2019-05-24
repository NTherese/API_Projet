/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.graph;

import Pharmacie.DAO.MedecinDAO;
import Pharmacie.Metier.Medecins;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meril
 */
public class RechPartMedecin extends javax.swing.JPanel {

    
    MedecinDAO medecinDAO=null;
   DefaultTableModel dft1 = new DefaultTableModel();
        
    /**
     * Creates new form RechPartMedecin
     */
    public RechPartMedecin() {
        initComponents();
        dft1.addColumn("idmedecin");
        dft1.addColumn("matricule");
        dft1.addColumn("nom");
        dft1.addColumn("prenom");
        dft1.addColumn("tel");
        jTable1.setModel(dft1);
    }
    
    public void setMedecinDAO(MedecinDAO medDAO){
        this.medecinDAO=medDAO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblmatmedecin = new javax.swing.JLabel();
        txtmatmed = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnvelrech = new javax.swing.JButton();

        lblmatmedecin.setText("  Matricule du medecin");

        txtmatmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmatmedActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblmatmedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(txtmatmed, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnvelrech)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmatmedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmatmed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnvelrech)
                        .addGap(84, 84, 84))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtmatmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmatmedActionPerformed
        try{ 
        String mat=txtmatmed.getText();
        List<Medecins> meds=medecinDAO.rechPart(mat);
        int nr = dft1.getRowCount();
        for(int i=nr-1;i>=0;i--)dft1.removeRow(i);
        meds.stream().map((med) -> {
            Vector v = new Vector();
            v.add(med.getIdmed());
            v.add(med.getMat());
            v.add(med.getNom());
            v.add(med.getPrenom());
            v.add(med.getTel());
                return v;
            }).forEachOrdered((v) -> {
                dft1.addRow(v);
            });
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtmatmedActionPerformed

    private void btnvelrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvelrechActionPerformed
        txtmatmed.setText("");
    }//GEN-LAST:event_btnvelrechActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnvelrech;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblmatmedecin;
    private javax.swing.JTextField txtmatmed;
    // End of variables declaration//GEN-END:variables
}
