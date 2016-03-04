/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jwieczorek.Model;

import java.util.Date;

/**
 *
 * Generates a unique ID for a database object.
 * Temporary solution until database is based on a text files.
 * 
 * @author Jakub Wieczorek
 * @version 1.0.1
 */
public class IDGenerator {
    
    /**
     * Generates a unique ID for a database object.
     * @return 
     * Returns ID.
     */
    public static String generateID(){
        sufix++;
        StringBuilder id =  new StringBuilder((new Date()).toString() + "_" + sufix);   
        for(int i = 0; i < id.length(); i++){
            if(id.charAt(i) == ' '){
                id.setCharAt(i, '_');
            }
        }
        return id.toString();
    }
    private static int sufix = 0;
}
