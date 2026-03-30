
package com.campusconnect.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pc
 */
public class ConnectionDao {
    private  static final String URL="jdbc:sqlite:C:/db/campus.db";
    private  static final String DRIVER ="org.sqlite.JDBC";
    private static Connection con;

    public ConnectionDao() {
    }
    
   public  static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            con=DriverManager.getConnection(URL);
            System.out.println("connection reussi");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
