/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.dao.ConnectionDao;
import com.campusconnect.model.Matiere;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author pc
 */
public class MatiereMetierImpl implements MatiereMetierI{
    
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    @Override
    public Matiere create(Matiere m) {
         con=ConnectionDao.getConnection();
        String sql="INSERT INTO matiere(code,nom) VALUES(?,?)";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, m.getCode());
            pst.setString(2, m.getNom());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return m;
    }

    @Override
    public Matiere modify(Integer id, Matiere m) {
        con=ConnectionDao.getConnection();
        String sql="UPDATE matiere SET code=?,nom=? WHERE id=?";
        if(findById(id).isPresent()){
             try {
            pst=con.prepareStatement(sql);
            pst.setString(1, m.getCode());
            pst.setString(2, m.getNom());
            pst.setInt(3, m.getId());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return m;
        }
       return null;
    }

    @Override
    public String delete(Integer id) {
       if(findById(id).isPresent()){
             try {
            con=ConnectionDao.getConnection();
            String sql="DELETE matiere WHERE id=?";
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
    public List<Matiere> show() {
        con=ConnectionDao.getConnection();
        String sql="SELECT * FROM matiere";
        List<Matiere> departemets=new ArrayList<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
               Matiere mat=new Matiere();
               mat.setId(rs.getInt("id"));
               mat.setCode(rs.getString("code"));
               mat.setNom(rs.getString("nom"));
               departemets.add(mat);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return departemets;
    }

    @Override
    public Optional<Matiere> findById(Integer id) {
       return show().stream().filter(ma->Objects.equals(ma.getId(), id)).findFirst();
    }
    
}
