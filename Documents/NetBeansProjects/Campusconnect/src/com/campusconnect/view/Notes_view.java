/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.campusconnect.view;

import com.campusconnect.metier.EtudiantMetierI;
import com.campusconnect.metier.EtudiantMetierImpl;
import com.campusconnect.metier.FiliereMetierI;
import com.campusconnect.metier.FiliereMetierImpl;
import com.campusconnect.metier.NiveauMetierI;
import com.campusconnect.metier.NiveauMetierImpl;
import com.campusconnect.model.Etudiant;
import dtos.EtudiantDTO;
import dtos.FiliereDTO;
import dtos.NiveauDTO;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Notes_view extends javax.swing.JPanel {

     private EtudiantMetierI metier;
     private NiveauMetierI niveauMetierI;
     private FiliereMetierI filiereMetierI;
    public Notes_view() {
        initComponents();
        //idText.setVisible(false);
        metier=new EtudiantMetierImpl();
        niveauMetierI=new NiveauMetierImpl();
        filiereMetierI=new FiliereMetierImpl();
        tableau();
        initializeCombobox1();
        initializeCombobox2();
    } 
    
    public void initializeCombobox1(){
//        jComboBox1.removeAllItems();
        niveauMetierI.show().stream().forEach(niv->{
          //  jComboBox1.addItem(niv);
        });
        
        
    }
    public void initializeCombobox2(){
     //   jComboBox2.removeAllItems();
        filiereMetierI.show().stream().forEach(fil->{
      //      jComboBox2.addItem(fil);
        });
    }

    public void tableau(){
//        DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
     //   model.setRowCount(0);
         List<EtudiantDTO> etudiants = metier.show();
         etudiants.forEach(e->{
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-MM");
             String dateAffichee = (e.getDatnaiss() != null) ? sdf.format(e.getDatnaiss()) : "";
              Object[] row = {
            e.getId(),
            e.getNom(),
            e.getPrenom(),
            e.getEmail(),
            e.getMatricule(),
            dateAffichee
            
            
        };
//        model.addRow(row);
         });
         
    }
    private Object findItemByString(JComboBox combo, String name) {
          for (int i = 0; i < combo.getItemCount(); i++) {
        if (combo.getItemAt(i).toString().equals(name)) {
            return combo.getItemAt(i);
        }
    }
    return null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1318, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("INSCRIPTION", jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1314, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("AUTRES", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 435, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    
}
