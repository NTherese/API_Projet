/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.graph;

import Pharmacie.DAO.PatientDAO;
import Pharmacie.DAO.PrescriptionDAO;
import Pharmacie.Metier.Patients;
import Pharmacie.Metier.Prescriptions;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meril
 */
public class RechExact extends javax.swing.JPanel {

        PatientDAO patDAO=null;
        Patients pat=null;
        PrescriptionDAO presDAO=null;
        Prescriptions pres= null;
        DefaultTableModel dft1 = new DefaultTableModel();
    /**
     * Creates new form RechExact
     */
    public RechExact() {
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
    
    public void setPatientDAO(PatientDAO patDAO){
        this.patDAO=patDAO;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblnumpat = new javax.swing.JLabel();
        lblnom = new javax.swing.JLabel();
        lblprenom = new javax.swing.JLabel();
        lbltel = new javax.swing.JLabel();
        txtnumpat = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtprenom = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        btrech = new javax.swing.JButton();
        btmaj = new javax.swing.JButton();
        btdel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnelrech = new javax.swing.JButton();

        lblnumpat.setText("  Identifiant ");

        lblnom.setText("   Nom");

        lblprenom.setText("  Prenom");

        lbltel.setText("  Telephone");

        txtnumpat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumpatActionPerformed(evt);
            }
        });

        btrech.setText("RECHERCHER");
        btrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrechActionPerformed(evt);
            }
        });

        btmaj.setText("MISE A JOUR");
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

        btnelrech.setText("Nouvelle recherche");
        btnelrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelrechActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(txtnumpat, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblnom, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblprenom)
                                    .addComponent(lbltel))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttel, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(txtprenom)
                                    .addComponent(txtnom, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btrech)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(btmaj, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btdel)
                        .addGap(320, 320, 320))))
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(btnelrech)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblnumpat)
                                    .addComponent(txtnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblnom))
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprenom)
                            .addComponent(txtprenom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbltel)
                            .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btdel)
                    .addComponent(btmaj)
                    .addComponent(btrech))
                .addGap(18, 18, 18)
                .addComponent(btnelrech)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumpatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumpatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumpatActionPerformed

    private void btrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrechActionPerformed
       int except = 0; //Pour la modification demandée
        int numpat = 0;
        try{
           numpat=Integer.parseInt(txtnumpat.getText());
           pat=patDAO.read(numpat);
           txtnom.setText(pat.getNom());
           txtprenom.setText(pat.getPrenom());
           txttel.setText(pat.getTel());
           JOptionPane.showMessageDialog(this," patient trouvé","succès",JOptionPane.INFORMATION_MESSAGE);
       }catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR PATIENT",JOptionPane.ERROR_MESSAGE);
        except=1;
     }
     if(except==1){
         
     }
     else{
       try{
           //System.out.println(numpat);
            List<Prescriptions> prescrip=presDAO.rechExacte(numpat);
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
            JOptionPane.showMessageDialog(this," prescription associé au patient trouvé","succès",JOptionPane.INFORMATION_MESSAGE);
       }
       catch(Exception f){
           JOptionPane.showMessageDialog(this,"Pas de prescription pour ce patient","ERREUR PRESCRIPTION ASSOCIE INTROUVABLE",JOptionPane.ERROR_MESSAGE);
           
       }
     }
    }//GEN-LAST:event_btrechActionPerformed

    private void btmajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmajActionPerformed
        
        try{  
            int numpat=Integer.parseInt(txtnumpat.getText());
            String nom=txtnom.getText();
            String prenom=txtprenom.getText();
            String tel=txttel.getText();
            Patients p=new Patients(numpat,nom,prenom,tel);
            patDAO.update(p);
            JOptionPane.showMessageDialog(this," patient mis à jour","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btmajActionPerformed

    private void btdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdelActionPerformed
        try{
             int numpat=Integer.parseInt(txtnumpat.getText());
             patDAO.delete(pat);
             txtnumpat.setText("");
             txtnom.setText("");
             txtprenom.setText("");
             txttel.setText("");
             JOptionPane.showMessageDialog(this," patient effacé","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btdelActionPerformed

    private void btnelrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelrechActionPerformed
       txtnumpat.setText("");
             txtnom.setText("");
             txtprenom.setText("");
             txttel.setText("");
    }//GEN-LAST:event_btnelrechActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdel;
    private javax.swing.JButton btmaj;
    private javax.swing.JButton btnelrech;
    private javax.swing.JButton btrech;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblnom;
    private javax.swing.JLabel lblnumpat;
    private javax.swing.JLabel lblprenom;
    private javax.swing.JLabel lbltel;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnumpat;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
