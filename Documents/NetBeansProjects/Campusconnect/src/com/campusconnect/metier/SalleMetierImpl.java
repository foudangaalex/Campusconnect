/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.dao.ConnectionDao;
import com.campusconnect.model.Departement;
import com.campusconnect.model.Salle;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class SalleMetierImpl implements SalletMetierI{
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    @Override
    public Salle create(Salle s) {
        con=ConnectionDao.getConnection();
        String sql="INSERT INTO salle (nom,capacite,type) VALUES(?,?,?)";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, s.getNom());
            pst.setInt(2, s.getCap_max());
            pst.setString(3, s.getType());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return s;
    }

    @Override
    public Salle modify(Integer id, Salle s) {
         con=ConnectionDao.getConnection();
        String sql="UPDATE salle SET nom=?,capacite=?,type=? WHERE id=?";
        
             try {
            pst=con.prepareStatement(sql);
            pst.setString(1, s.getNom());
            pst.setInt(2, s.getCap_max());
            pst.setString(3, s.getType());
            pst.setInt(4, s.getId());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return s;
       
    }

    @Override
    public String delete(Integer id) {
       
             try {
            con=ConnectionDao.getConnection();
            String sql="DELETE FROM salle WHERE id=?";
            pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalleMetierImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "departemet supprimer avec succes";
        
    }

    @Override
    public List<Salle> show() {
        con=ConnectionDao.getConnection();
        String sql="SELECT * FROM salle";
        List<Salle> salles=new ArrayList<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
               Salle salle=new Salle();
               salle.setId(rs.getInt("id"));
               salle.setNom(rs.getString("nom"));
               salle.setCap_max(rs.getInt("capacite"));
               salle.setType(rs.getString("type"));
               salles.add(salle);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalleMetierImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salles;
    }

    @Override
    public Optional<Salle> findById(Integer id) {
       
        return show().stream().filter(sal->Objects.equals(sal.getId(), id)).findFirst();
    }
    
}
