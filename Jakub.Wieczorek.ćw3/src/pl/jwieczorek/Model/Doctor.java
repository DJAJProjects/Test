/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jwieczorek.Model;


import pl.jwieczorek.Model.CustomExceptions.DataException;
import pl.jwieczorek.Model.IDGenerator;
import java.util.Date;

/**
 *
 * 
 * Represents a row from doctors table.
 * Contains info about doctor.
 * 
 * @author Jakub Wieczorek
 * @version 1.0.1
 * 
 */
public class Doctor {
    
    /**
     * Constructor. Creates a new database object. 
     * It automatically generates its own ID.
     */
     public Doctor(){
        this.id = IDGenerator.generateID();
    }
    
     /**
      * Constructor. Generates a database object basing on a given info. 
      * 
      * @param dataString
      * String with information about columns content. Needed to initialize
      * object's fields.
      * 
      * @throws NumberFormatException
      * Thrown when salary value is not an integer
      * 
      * @throws IndexOutOfBoundsException 
      * Thrown when given string parameter contains wrong amount of data 
      * split by '#' character.
      */
     public Doctor(String dataString)
            throws NumberFormatException, IndexOutOfBoundsException
    {
        String[] strArr = dataString.split("#");
        
        setID(strArr[0]);
        setName(strArr[1]);
        setSurname(strArr[2]);
        setSpecialization(strArr[3]);
        setSalary(strArr[4]);
    }
   
     /**
      * Generates string which is ready to be saved in database text file. 
      * This string represents current doctor object in database.
      * @return 
      * Returns string containing information about all object's fields - columns.
      */
    public String getDataString(){
        return id + "#" + name + "#" + surname + "#" + specialization + "#" + salary;
    }
    
    /**
     * Generates string that describes current object.
     * @return 
     * Returns a string that contains a name and content of all the column-fields of
     * current object.
     */
    @Override
    public String toString(){
        return "[id]: " + id + " [name]: " + name + " [surname]: " + surname
                + " [specialization]: " + specialization + " [salary]: " + salary;
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
     * Returns string representing Specialization field-column.
     */
    public String getSpecialization(){return this.specialization;}
      /**
     * @return 
     * Returns string representing ID field-column.
     */
    public String getID(){return this.id;}
      /**
     * @return 
     * Returns string representing Salary field-column.
     */
    public int getSalary(){return this.salary;}
    
    /**
     * Sets name field-column
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Sets Specialization field-column
     * @param specialization
     */
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    /**
     * Sets Surname field-column
     * @param surname
     */
    public void setSurname(String surname){
        this.surname = surname;
    }
    /**
     * Sets Salary field-column
     * @param salary
     */
    public void setSalary(int salary){
        this.salary = salary;
    }
    /**
     * 
     * Sets Salary field-column.
     * @param salary
     * @throws NumberFormatException 
     * Thrown, when given string does not represent an integer.
     */
    public void setSalary(String salary)throws NumberFormatException{
       this.salary = Integer.parseInt(salary);
    }
    /**
     * Sets ID field-column
     */
    private void setID(String id){this.id = id;}; 
 
    /**
     * ID field-column
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
    /**
     * specialization field-column
     */
    private String specialization;
    /**
     * salary field-column
     */
    private int salary;
}
