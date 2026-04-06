/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.dao.ConnectionDao;
import com.campusconnect.model.Niveau;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author pc
 */
public class NiveauMetierImpl implements NiveauMetierI{

    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    @Override
    public Niveau create(Niveau niv) {
          con=ConnectionDao.getConnection();
        String sql="INSERT INTO niveau(nom) VALUES(?)";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, niv.getNom());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return niv;
    }

    @Override
    public Niveau modify(Integer id, Niveau niv) {
         con=ConnectionDao.getConnection();
        String sql="UPDATE niveau SET nom=? WHERE id=?";
        if(findById(id).isPresent()){
             try {
            pst=con.prepareStatement(sql);
            pst.setString(1, niv.getNom());
            pst.setInt(2, niv.getId());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return niv;
        }
       return null;
    }

    @Override
    public String delete(Integer id) {
         if(findById(id).isPresent()){
             try {
            con=ConnectionDao.getConnection();
            String sql="DELETE niveau WHERE id=?";
            pst=con.prepareStatement(sql);
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
        }
         return "niveau supprimer avec succes";
        }
       return null;
    }

    @Override
    public List<Niveau> show() {
        con=ConnectionDao.getConnection();
        String sql="SELECT * FROM niveau";
        List<Niveau> niveaux=new ArrayList<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
               Niveau niv=new Niveau();
               niv.setId(rs.getInt("id"));
               niv.setNom(rs.getString("nom"));
               niveaux.add(niv);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return niveaux;
    }

    @Override
    public Optional<Niveau> findById(Integer id) {
       return show().stream().filter(d->Objects.equals(d.getId(), id)).findFirst();
    }
    
}
