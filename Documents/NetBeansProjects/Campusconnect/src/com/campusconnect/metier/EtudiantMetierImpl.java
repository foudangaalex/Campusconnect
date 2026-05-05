
package com.campusconnect.metier;

import com.campusconnect.dao.ConnectionDao;
import com.campusconnect.model.Etudiant;
import dtos.EtudiantDTO;
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
            String query="INSERT INTO etudiant(nom,prenom,email,matricule,datnaiss) VALUES(?,?,?,?,?)";
            pst= con.prepareStatement(query);
            pst.setString(1, e.getNom());
            pst.setString(2, e.getPrenom());
            pst.setString(3, e.getEmail());
            pst.setString(4, e.getMatricule());
            pst.setLong(5,   e.getDatnaiss().getTime());
            int i=pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantMetierImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    @Override
    public Etudiant modify(Integer id, Etudiant e) {
         
           Optional <EtudiantDTO> byId=findById(id);
            if(byId.isPresent()){
            try { 
            
             con=ConnectionDao.getConnection();
            String query="UPDATE etudiant SET nom=?,prenom=?,email=?,matricule=?,datnaiss=? WHERE id=?";
            pst= con.prepareStatement(query);
            pst.setInt(6, e.getId());
            pst.setString(1, e.getNom());
            pst.setString(2, e.getPrenom());
            pst.setString(3, e.getEmail());
            pst.setString(4, e.getMatricule());
            pst.setLong(5, e.getDatnaiss().getTime());
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
    public List<EtudiantDTO> show() {
        List<EtudiantDTO> list=new ArrayList();
        try {
            con=ConnectionDao.getConnection();
            //String query="SELECT e.*,fil.nom FROM inscription ins JOIN etudiant e ON e.id=ins.id_et JOIN filiere fil ON ins.id_fil=fil.id JOIN niveau niv ON ins.id_niv=niv.id" ;
            String query="SELECT * FROM etudiant";
            st= con.createStatement();
            rs=st.executeQuery(query);
            
             while(rs.next()){
                 EtudiantDTO e=new EtudiantDTO();
                 e.setId(rs.getInt("id"));
                 e.setNom(rs.getString("nom"));
                 e.setPrenom(rs.getString("prenom"));
                 Long millis=rs.getLong("datnaiss");
                 e.setDatnaiss(new Date(millis));
                 e.setEmail(rs.getString("email"));
                 e.setMatricule(rs.getString("matricule"));
                 list.add(e);
             }
             con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        return list;
    }

    @Override
    public Optional<EtudiantDTO> findById(Integer id) {
        List<EtudiantDTO> list=show();
        return list.stream().filter(e->Objects.equals(e.getId(), id)).findFirst();
        
    }

  

   
    
}
