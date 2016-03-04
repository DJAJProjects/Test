/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jwieczorek.Model;

import java.util.Date;

/**
 * 
 * Represents a row from patients table.
 * Contains info about patient.
 *
 * @author Jakub Wieczorek
 * @version 1.0.1
 * 
 */
public class Patient {
    
     /**
     * Constructor. Creates a new database object. 
     * It automatically generates its own ID.
     */
    public Patient(){
        this.id = IDGenerator.generateID();
    }
    
     /**
      * Constructor. Generates a database object basing on a given info. 
      * 
      * @param dataString
      * String with information about columns content. Needed to initialize
      * object's fields.
      * 
      * @throws IndexOutOfBoundsException 
      * Thrown when given string parameter contains wrong amount of data 
      * split by '#' character.
      */
    public Patient(String dataString)
            throws IndexOutOfBoundsException
    {
        String[] strArr = dataString.split("#");
        setID(strArr[0]);
        setName(strArr[1]);
        setSurname(strArr[2]);    
    }
   
    /**
      * Generates string which is ready to be saved in database text file. 
      * This string represents current patient object in database.
      * @return 
      * Returns string containing information about all object's fields - columns.
      */
    public String getDataString(){
        return id + "#" + name + "#" + surname;
    }  
    
      /**
     * Generates string that describes current object.
     * @return 
     * Returns a string that contains a name and content of all the column-fields of
     * current object.
     */
    @Override
    public String toString(){
        return "[id]: " + id + " [name]: " + name + " [surname]: " + surname;
    }
    
    /**
     * @return 
     * Returns string representing Name field-column.
     */
    public String getName(){return this.name;}
    /**
     * @return 
     * Returns string representing Surname field-column.
     */
    public String getSurname(){return this.surname;}
    /**
     * @return 
     * Returns string representing ID field-column.
     */
    public String getID(){return this.id;}
    
    /**
     * Sets name field-column
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Sets surname field-column 
     * @param surname
     */
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    /**
     * Sets id field-column 
     */
    private void setID(String id){this.id = id;};
    
    /**
     * id field-column 
     */
    private String id;
    /**
     * name field-column 
     */
    private String name;
    /**
     * surname field-column 
     */
    private String surname;
}
