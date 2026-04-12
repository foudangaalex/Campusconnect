/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campusconnect.metier;

import com.campusconnect.dao.ConnectionDao;
import com.campusconnect.model.Filiere;
import com.campusconnect.model.Niveau;
import dtos.FiliereDTO;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author pc
 */
public class FiliereMetierImpl implements FiliereMetierI{

    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    @Override
    public Filiere create(Filiere fil) {
          con=ConnectionDao.getConnection();
        String sql="INSERT INTO filiere(nom) VALUES(?)";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, fil.getNom());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return fil;
    }

    @Override
    public Filiere modify(Integer id, Filiere fil) {
         con=ConnectionDao.getConnection();
        String sql="UPDATE filiere SET nom=? WHERE id=?";
             try {
            pst=con.prepareStatement(sql);
            pst.setString(1, fil.getNom());
            pst.setInt(2, fil.getId());
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return fil;
        
    }

    @Override
    public String delete(Integer id) {
         if(findById(id).isPresent()){
             try {
            con=ConnectionDao.getConnection();
            String sql="DELETE FROM filiere WHERE id=?";
            pst=con.prepareStatement(sql);
            pst.setInt(1,id);
            int executeUpdate = pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
        }
         return "supprimer avec succes";
        }
       return null;
    }

    @Override
    public List<FiliereDTO> show() {
        con=ConnectionDao.getConnection();
        String sql="SELECT * FROM filiere";
        List<FiliereDTO> filieresDTO=new ArrayList<>();
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
               FiliereDTO fil=new FiliereDTO();
               fil.setId(rs.getInt("id"));
               fil.setNom(rs.getString("nom"));
               filieresDTO.add(fil);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return filieresDTO;
    }

    @Override
    public Optional<FiliereDTO> findById(Integer id) {
       return show().stream().filter(d->Objects.equals(d.getId(), id)).findFirst();
    }
    
}
