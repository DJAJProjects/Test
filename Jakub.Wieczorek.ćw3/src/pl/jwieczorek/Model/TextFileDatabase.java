/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jwieczorek.Model;

import pl.jwieczorek.Model.CustomExceptions.DataException;
import pl.jwieczorek.Services.FilesService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 * Provides a basic contact and operations on data 
 * contained in a simple text files database.
 * 
 * @author Jakub Wieczorek
 * @version 1.0.1
 *
 */
public class TextFileDatabase {
    
    /**
     * Constructor.
     * @throws DataException 
     * Thrown when error occurred while trying to read from database files
     * or when data is corrupted.
     */
    public TextFileDatabase()throws DataException{
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        initialize();
    }
    
    /**
     * Reads all data from files. Initializes all containers with data models.
     * @throws DataException 
     * Thrown when error occurred while trying to read from database files
     * or when data is corrupted.
     */
    public void initialize() throws DataException{
        
        ArrayList<String> doctorsStrList;
        ArrayList<String> patientsStrList;
        
        try{
            doctorsStrList = (ArrayList<String>)FilesService.readFromFile(doctorsFileName);
            patientsStrList = (ArrayList<String>)FilesService.readFromFile(patientsFileName);
        }
        catch(IOException ex){
            throw new DataException("Error while connecting to data files\n");
        }
        
        for(String dataString :doctorsStrList){
            try{
                doctors.add(new Doctor(dataString));   
            }
            catch(Exception ex){
                throw new DataException("Data in doctors table is corrupted\n");
            }
                     
        }
        for(String dataString :patientsStrList){
            try{
                patients.add(new Patient(dataString));
             }
            catch(Exception ex){
                throw new DataException("Data in patients table is corrupted\n");
            }
        }
    }
    
    /**
     *
     * @throws DataException
     */
    public void deleteDoctors() throws DataException{
        try{
            FilesService.eraseFile(doctorsFileName);
        }
        catch(IOException ex){
            throw new DataException("Error while deleting data from file");
        }
        
        doctors.clear();  
    }
    
    /**
     *
     * @throws DataException
     */
    public void deletePatients() throws DataException{
        try{
            FilesService.eraseFile(patientsFileName);
        }
        catch(IOException ex){
            throw new DataException("Error while deleting data from file");
        }
        
        patients.clear();  
    }
    
    /**
     * @return 
     * Returns all the doctor models from current TextFileDatabase instance containers
     */
    public ArrayList<Doctor> getDoctors(){
        return this.doctors;
    }
    
    /**
     * @return 
     * Returns all the doctor models from current TextFileDatabase instance containers
     */
    public ArrayList<Patient> getPatients(){
        return this.patients;
    }
    
    /**
     * Adds given doctor to the doctors container and saves it to the
     * doctors data file.
     * @param doctor
     * Doctor model.
     * @throws DataException 
     * Thrown when an error occurred while saving doctor data to data file.
     */
    public void addDoctor(Doctor doctor) throws DataException{
        
        ArrayList<String> data = new ArrayList<String>();
        data.add(doctor.getDataString());
        try{
            FilesService.writeToFile((List<String>)data, doctorsFileName);
        }
        catch(IOException ex){
             throw new DataException("Error while saving data to file");
        }
        doctors.add(doctor);
    }
    
     /**
     * Adds given patient to the patients container and saves it to the
     * patients data file.
     * @param patient
     * Patient model.
     * @throws DataException 
     * Thrown when an error occurred while saving patient data to data file.
     */
    public void addPatient(Patient patient) throws DataException{
        
        ArrayList<String> data = new ArrayList<>();
        data.add(patient.getDataString());
        try{
            FilesService.writeToFile((List<String>)data, patientsFileName);
        }
        catch(IOException ex){
             throw new DataException("Error while saving data to file");
        }
        patients.add(patient);
    }
    
    /**
     * Name of the file containing doctors data.
     */
    private final String doctorsFileName = "Doctors.txt";
    /**
     * Name of the file containing patients data.
     */
    private final String patientsFileName = "Patients.txt";
    
    /**
     * Container with all the doctors models from data file.
     */
    private ArrayList<Doctor> doctors;
    /**
     * Container with all the parents models from data file.
     */
    private ArrayList<Patient> patients;
}
