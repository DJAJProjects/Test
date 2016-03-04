/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jwieczorek.Model.CustomExceptions;

/**
 * Custom exception. It is thrown when operations on data from 
 * database or connecting with database files caused an error.
 * 
 * 
 * @author Jakub Wieczorek
 * @version 1.0.1
 * 
 */
public class DataException extends Exception{
    
    /**
     * Constructor
     * @param message 
     * Message describing the error.
     */
      public DataException(String message) {
        super(message);
    }
}
