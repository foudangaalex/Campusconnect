/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.dao.ConnectionDao;
import com.campusconnect.model.Departement;
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
public class DepartementMetierImpl implements DepartementMetierI{
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    @Override
    public Departement create(Departement d) {
        con=ConnectionDao.getConnection();
        String sql="INSERT INTO departement(nom) VALUES(?)";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, d.getNom());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return d;
    }

    @Override
    public Departement modify(Integer id, Departement d) {
         con=ConnectionDao.getConnection();
        String sql="UPDATE departement SET nom=? WHERE id=?";
        if(findById(id).isPresent()){
             try {
            pst=con.prepareStatement(sql);
            pst.setString(1, d.getNom());
            pst.setInt(2, d.getId());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return d;
        }
       return null;
    }

    @Override
    public String delete(Integer id) {
        if(findById(id).isPresent()){
             try {
            con=ConnectionDao.getConnection();
            String sql="DELETE departement WHERE id=?";
            pst=con.prepareStatement(sql);
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartementMetierImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "departemet supprimer avec succes";
        }
       return null;
    }

    @Override
    public List<Departement> show() {
        con=ConnectionDao.getConnection();
        String sql="SELECT * FROM departement";
        List<Departement> departemets=new ArrayList<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
               Departement dep=new Departement();
               dep.setId(rs.getInt("id"));
               dep.setNom(rs.getString("nom"));
               departemets.add(dep);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartementMetierImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departemets;
    }

    @Override
    public Optional<Departement> findById(Integer id) {
       
        return show().stream().filter(d->Objects.equals(d.getId(), id)).findFirst();
    }
    
}
