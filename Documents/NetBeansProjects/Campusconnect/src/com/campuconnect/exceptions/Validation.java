/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.campuconnect.exceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



/**
 *
 * @author pc
 */
public class Validation {
    static final String PATTERN_EMAIL="^[a-zA-Z0-9+_.-]+@(.+)$";
    
    public static String verifierEmail(String email){
       if(email==null || email.equals("")) return "l'email ne peut pas etre vide";
        if(!email.matches(PATTERN_EMAIL))return Message.ERR_EMAIL;
        return null;
    }
public static String verifierEntier(String valeur,String champ){
   
    try{
        Integer.parseInt(valeur);
    }catch(Exception e){
        return Message.ERR_INT;
    }
    return null;
}   

public static String verrifierDate(String datasaisie){
    DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-dd-MM");
    try{
        LocalDate.parse(datasaisie, format);
    }catch(Exception e){
        return Message.ERR_DATE;
    }
    return null;
}
}
