
package com.campusconnect.metier;

import com.campusconnect.dao.ConnectionDao;
import com.campusconnect.model.Etudiant;
import java.sql.*;
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
            String query="INSERT INTO etudiant(id,nom,prenom,anneeEtude,mail,filiere,matricule,datnaiss) VALUES(?,?,?,?,?,?,?,?)";
            pst= con.prepareStatement(query);
            pst.setInt(0, e.getId());
            pst.setString(1, e.getNom());
            pst.setString(2, e.getPrenom());
            pst.setString(3, e.getAnneeEtude());
            pst.setString(4, e.getEmail());
            pst.setString(5, e.getFiliere());
            pst.setString(6, e.getMatricule());
            pst.setDate(7, (Date) e.getDatnaiss());
            int i=pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantMetierImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    @Override
    public Etudiant modify(Integer id, Etudiant e) {
         
         try {  
             con=ConnectionDao.getConnection();
            String query="UPDATE etudiant SET nom=?,prenom=?,anneeEtude=?,email=?,filiere=?,matricule=?,datnaiss=? WHERE id=?";
            pst= con.prepareStatement(query);
            pst.setInt(7, e.getId());
            pst.setString(0, e.getNom());
            pst.setString(1, e.getPrenom());
            pst.setString(2, e.getAnneeEtude());
            pst.setString(3, e.getEmail());
            pst.setString(4, e.getFiliere());
            pst.setString(5, e.getMatricule());
            pst.setDate(6, (Date) e.getDatnaiss());
            int i=pst.executeUpdate();
            con.close();
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
        return e;
    }

    @Override
    public String delete(Integer id) {
         try {
             con=ConnectionDao.getConnection();
            String query="DELETE FROM etudiant WHERE id=?";
            pst= con.prepareStatement(query);
            pst.setInt(0, id);
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
                 e.setAnneeEtude(rs.getString("anneeEtude"));
                 e.setEmail(rs.getString("email"));
                 e.setFiliere(rs.getString("filiere"));
                 e.setMatricule("matricule");
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
