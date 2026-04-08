/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.dao.ConnectionDao;
import com.campusconnect.model.Cours;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author pc
 */
public class CourMetierImpl implements CourMetierI{
    
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    @Override
    public Cours create(Cours c) {
         con=ConnectionDao.getConnection();
        String sql="INSERT INTO matiere(code,nom,id_ens ,id_niv, nbre_heure,coef ,id_sal) VALUES(?,?,?,?,?,?,?,?)";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, c.getCode());
            pst.setString(2, c.getNom());
            pst.setInt(3, c.getId_ens());
            pst.setInt(4, c.getId_niv());
            pst.setString(5, c.getNbre_heure());
            pst.setInt(6, c.getCoef());
            pst.setInt(7, c.getId_sal());
            pst.setInt(8, c.getId());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return c;
    }
 
    @Override
    public Cours modify(Integer id, Cours c) {
        con=ConnectionDao.getConnection();
        String sql="UPDATE cours SET  code=?,nom=? ,id_ens=? ,id_niv=?, nbre_heure=? ,coef=? ,id_sal=? WHERE id=?";
        if(findById(id).isPresent()){
             try {
            pst=con.prepareStatement(sql);
            pst.setString(1, c.getCode());
            pst.setString(2, c.getNom());
            pst.setInt(3, c.getId_ens());
            pst.setInt(4, c.getId_niv());
            pst.setString(5, c.getNbre_heure());
            pst.setInt(6, c.getCoef());
            pst.setInt(7, c.getId_sal());
            pst.setInt(8, c.getId());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return c;
        }
       return null;
    }

    @Override
    public String delete(Integer id) {
       if(findById(id).isPresent()){
             try {
            con=ConnectionDao.getConnection();
            String sql="DELETE cours WHERE id=?";
            pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
        }
         return "matiere supprimer avec succes";
        }
       return null;
    }

    @Override
    public List<Cours> show() {
        con=ConnectionDao.getConnection();
        String sql="SELECT * FROM cours";
        List<Cours> cours=new ArrayList<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
               Cours cour=new Cours();
               cour.setId(rs.getInt("id"));
               cour.setCode(rs.getString("code"));
               cour.setNom(rs.getString("nom"));
               cour.setId_ens(rs.getInt("id_ens"));
               cour.setId_niv(rs.getInt("id_niv"));
               cour.setId_sal(rs.getInt("id_sal"));
               cour.setNbre_heure(rs.getString("nbre_heure"));
               cour.setCoef(rs.getInt("coef"));
               cours.add(cour);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cours;
    }

    @Override
    public Optional<Cours> findById(Integer id) {
       return show().stream().filter(cour->Objects.equals(cour.getId(), id)).findFirst();
    }
    
}
