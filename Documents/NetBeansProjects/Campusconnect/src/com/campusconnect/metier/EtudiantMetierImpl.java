
package com.campusconnect.metier;

import com.campusconnect.dao.ConnectionDao;
import com.campusconnect.model.Etudiant;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author pc
 */
public class EtudiantMetierImpl implements EtudiantMetierI{
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    
    @Override
    public Etudiant create(Etudiant e) {
            
        try { 
            con=ConnectionDao.getConnection();
            String query="INSERT INTO etudiant(nom,prenom,niveau,email,filiere,matricule,datnaiss) VALUES(?,?,?,?,?,?,?)";
            pst= con.prepareStatement(query);
            //SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
            // String datnaiss=format.format(e.getDatnaiss());
            //pst.setInt(1, e.getId());
            pst.setString(1, e.getNom());
            pst.setString(2, e.getPrenom());
            pst.setString(3, e.getNiveau());
            pst.setString(4, e.getEmail());
            pst.setString(5, e.getFiliere());
            pst.setString(6, e.getMatricule());
            pst.setLong(7,e.getDatnaiss().getTime());
            int i=pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantMetierImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    @Override
    public Etudiant modify(Integer id, Etudiant e) {
         
           Optional <Etudiant> byId=findById(id);
            if(byId.isPresent()){
            try { 
            
             con=ConnectionDao.getConnection();
            String query="UPDATE etudiant SET nom=?,prenom=?,niveau=?,email=?,filiere=?,matricule=?,datnaiss=? WHERE id=?";
            pst= con.prepareStatement(query);
            pst.setInt(8, e.getId());
            pst.setString(1, e.getNom());
            pst.setString(2, e.getPrenom());
            pst.setString(3, e.getNiveau());
            pst.setString(4, e.getEmail());
            pst.setString(5, e.getFiliere());
            pst.setString(6, e.getMatricule());
            pst.setLong(7,e.getDatnaiss().getTime());
            int i=pst.executeUpdate();
            con.close();
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
        return e;
            }
        return null;
    }

    @Override
    public String delete(Integer id) {
         try {
             con=ConnectionDao.getConnection();
            String query="DELETE FROM etudiant WHERE id=?";
            pst= con.prepareStatement(query);
            pst.setInt(1, id);
            int i=pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());        }
        return "SUPPRESSION REUSSI";
    }

    @Override
    public List<Etudiant> show() {
        List<Etudiant> list=new ArrayList();
        try {
            con=ConnectionDao.getConnection();
            String query="SELECT * FROM etudiant";
            st= con.createStatement();
            rs=st.executeQuery(query);
            
             while(rs.next()){
                 Etudiant e=new Etudiant();
                 e.setNom(rs.getString("nom"));
                 e.setPrenom(rs.getString("prenom"));
                 e.setNiveau(rs.getString("niveau"));
                 Long millis=rs.getLong("datnaiss");
                 e.setDatnaiss(new Date(millis));
                 e.setEmail(rs.getString("email"));
                 e.setFiliere(rs.getString("filiere"));
                 e.setMatricule(rs.getString("matricule"));
                 e.setId(rs.getInt("id"));
                 list.add(e);
             }
             con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        return list;
    }

    @Override
    public Optional<Etudiant> findById(Integer id) {
        List<Etudiant> list=show();
        return list.stream().filter(e->Objects.equals(e.getId(), id)).findFirst();
        
    }
    
}
