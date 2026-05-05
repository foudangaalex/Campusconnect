/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.dao.ConnectionDao;
import com.campusconnect.model.Cours;
import dtos.CourDTO;
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
        String sql="INSERT INTO matiere(code,nom,coef ) VALUES(?,?,?)";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, c.getCode());
            pst.setString(2, c.getNom());
            pst.setInt(3, c.getCoef());
            
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
        String sql="UPDATE matiere SET  code=?,nom=?,coef=?  WHERE id=?";
       
             try {
            pst=con.prepareStatement(sql);
            pst.setString(1, c.getCode());
            pst.setString(2, c.getNom());
            pst.setInt(3, c.getCoef());
            
            pst.setInt(4, c.getId());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return c;
       
    }

    @Override
    public String delete(Integer id) {
       
             try {
            con=ConnectionDao.getConnection();
            String sql="DELETE FROM matiere WHERE id=?";
            pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
        }
         return "matiere supprimer avec succes";
        
    }

    @Override
    public List<CourDTO> show() {
        con=ConnectionDao.getConnection();
        String sql="SELECT * FROM matiere ";
        List<CourDTO> cours=new ArrayList<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
               CourDTO cour=new CourDTO();
               cour.setId(rs.getInt("id"));
               cour.setCode(rs.getString("code"));
               cour.setNom(rs.getString("nom"));
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
    public Optional<CourDTO> findById(Integer id) {
       return show().stream().filter(cour->Objects.equals(cour.getId(), id)).findFirst();
    }
    
}
