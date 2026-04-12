
package com.campusconnect.metier;

import com.campusconnect.dao.ConnectionDao;
import com.campusconnect.model.Professeur;
import dtos.ProfesseurDTO;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author pc
 */
public class ProfesseurMetierImpl implements ProfesseurMetierI{
    private ConnectionDao dao;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    
    @Override
    public Professeur create(Professeur prof) {
        try { 
            con=ConnectionDao.getConnection();
            String query="INSERT INTO professeur(nom,prenom,email,id_dept,statut,datnaiss) VALUES(?,?,?,?,?,?)";
            pst= con.prepareStatement(query);
           // pst.setInt(, prof.getId());
            pst.setString(1, prof.getNom());
            pst.setString(2, prof.getPrenom());
            pst.setString(3, prof.getEmail());
            pst.setInt(4, prof.getId_dept());
            pst.setString(5, prof.getStatut());
            pst.setLong(6, prof.getDatnaiss().getTime());
            int i=pst.executeUpdate();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return prof;
    }

    @Override
    public Professeur modify(Integer id, Professeur prof) {
         
         try {  
             con=ConnectionDao.getConnection();
            String query="UPDATE professeur SET nom=?,prenom=?,email=?,id_dept=?,statut=?,datnaiss=? WHERE id=?";
            pst= con.prepareStatement(query);
            pst.setInt(7, prof.getId());
            pst.setString(1, prof.getNom());
            pst.setString(2, prof.getPrenom());
            pst.setString(3, prof.getEmail());
            pst.setInt(4, prof.getId_dept());
            pst.setString(5, prof.getStatut());
            pst.setLong(6, prof.getDatnaiss().getTime());
            int i=pst.executeUpdate();
            con.close();
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
        return prof;
    }

    @Override
    public String delete(Integer id) {
        try {
             con=ConnectionDao.getConnection();
            String query="DELETE FROM professeur WHERE id=?";
            pst= con.prepareStatement(query);
            pst.setInt(1, id);
            int i=pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());        }
        return "SUPPRESSION REUSSI";
    }

    @Override
    public List<ProfesseurDTO> show() {
        List<ProfesseurDTO> list=new ArrayList<>();
        try {
            con=ConnectionDao.getConnection();
            String query="SELECT prof.*,dept.nom as nom_dept FROM professeur prof JOIN departement dept ON prof.id_dept=dept.id";
            st= con.createStatement();
            rs=st.executeQuery(query);
            
             while(rs.next()){
                 ProfesseurDTO p=new ProfesseurDTO();
                 p.setNom(rs.getString("nom"));
                 p.setPrenom(rs.getString("prenom"));
                 p.setEmail(rs.getString("email"));
                 p.setNom_dept(rs.getString("nom_dept"));
                 p.setStatut(rs.getString("statut"));
                 Long millis=rs.getLong("datnaiss");
                 p.setDatnaiss(new Date(millis));
                 p.setId(rs.getInt("id"));
                 list.add(p);
             }
             con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        return list;
    }

    @Override
    public Optional<ProfesseurDTO> findById(Integer id) {
        
        return show().stream().filter(prof->Objects.equals(prof.getId(), id)).findFirst();
     }

   
    
}
