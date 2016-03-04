/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jwieczorek.View;

import pl.jwieczorek.Model.CustomExceptions.DataException;
import pl.jwieczorek.Model.Doctor;
import pl.jwieczorek.Model.Patient;
import pl.jwieczorek.Model.TextFileDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 
 * This class contains all methods needed in console user interaction mode.
 * Contains console IO operations and gets data from the user.
 * 
 * @author Jakub Wieczorek
 * @version 1.0.0
 */
public class ConsoleView {
    
    /**
     * Constructor
     * @param database 
     * Parameter is a textFileDatabase object which will be the source of
     * saved data and it will provide logic operations on data.
     */
    public ConsoleView(TextFileDatabase database){
        this.database = database;
        input = new Scanner(System.in);
    }
    
    /**
     * Calls model method to delete all doctors from data file.
     */
    public void deletePatients(){
        try{
            database.deletePatients();
        }
        catch(DataException ex){
            System.out.print(ex.getMessage());
        }
    }
    
    /**
     * Calls model method to delete all doctors from data file.
     */
    public void deleteDoctors(){
        try{
            database.deleteDoctors();
        }
        catch(DataException ex){
            System.out.print(ex.getMessage());
        }
    }
    
    /**
     * Shows information about all the patients in data file.
     */
    public void showPatients(){
        ArrayList<Patient> data = database.getPatients();
                      
        data.stream().forEach((patient) -> {
            System.out.print(patient.toString()+ "\n");
        });
    }
    
    /**
     * Shows information about all the doctors in data file.
     */
    public void showDoctors(){
        ArrayList<Doctor> data = database.getDoctors();
                      
        data.stream().forEach((doctor) -> {
            System.out.print(doctor.toString() + "\n");
        });
    }
      
    /**
     * Provides main menu view. It interacts with user 
     * and lets him choose sub-menu or exit program.
     */
    public void MainMenu(){
        
        boolean properIO;
        boolean exit = false;
        int choice;
        
        while(true){
            
            properIO = true;
            
            // Main menu
            System.out.print("#### Doctor's surgery ####\n");
            System.out.print("1) Patients\n");
            System.out.print("2) Doctors\n");
            System.out.print("3) Exit\n");
      
            // Reading user's input
            choice = input.nextInt();
            
            // If option choice is not proper
            if(choice < 1 || choice > 3){
               properIO = false;
               System.out.print("Option number is wrong\n");
            }
                
            if(properIO){
                String text;
                switch(choice){
                    case 1:{
                       PatientsSubMenu();
                      break;  
                    }
                    case 2:{
                        DoctorsSubMenu();
                      break;  
                    }
                    case 3:{
                      exit = true;
                        break;   
                    }
                    default:{
                    }      
                }
                
                if(exit) break;
                
                System.out.print("Press ENTER to continue...\n");
                try{
                    System.in.read();
                }
                catch(IOException e){
                } 
            }
        }     
    }
    
    /**
     * Provides patients sub-menu view
     */
    private void PatientsSubMenu(){
        
        boolean properIO;
        int choice;
        
        while(true){
            
            properIO = true;
            
            System.out.print("1) Show all\n");
            System.out.print("2) Add new\n");
            System.out.print("3) Delete all\n");
            System.out.print("4) Quit\n");

            // Reading user's input
            choice = input.nextInt();
            
            if(choice < 1 || choice > 4){
                   properIO = false;
                   System.out.print("Option number is wrong\n");
                }
            
            if(properIO){
                switch(choice){
                    case 1:{
                         showPatients();
                      break;  
                    }
                    case 2:{
                        
                      Patient newPatient = new Patient();
                      System.out.print("Name\n");
                      newPatient.setName(input.next());
                      System.out.print("Surname\n");
                      newPatient.setSurname(input.next());
                      
                      try{
                        database.addPatient(newPatient);
                      }
                      catch(DataException ex){
                        System.out.print(ex.getMessage());
                      }
                      break;  
                    }
                    case 3:{
                      deletePatients();
                      break;
                                     
                    }
                    case 4:{
                      return;
                                     
                    }
                    
                    default:{
                  
                    }      
                }
            }   
        }
    }
    
     /**
     * Provides doctors sub-menu view
     */
    private void DoctorsSubMenu(){
        
        boolean properIO;
        int choice;
        
        while(true){
            
            properIO = true;
            
            System.out.print("1) Show all\n");
            System.out.print("2) Add new\n");
            System.out.print("3) Delete all\n");
            System.out.print("4) Quit\n");

            // Reading user's input
            choice = input.nextInt();
            
            if(choice < 1 || choice > 4){
                   properIO = false;
                   System.out.print("Option number is wrong\n");
                }
            
            if(properIO){
                
                switch(choice){
                    case 1:{
                        showDoctors();
                      break;  
                    }
                    case 2:{
                        Doctor newDoctor = new Doctor();
                        System.out.print("Name: ");
                        newDoctor.setName(input.next());
                        System.out.print("Surname: ");
                        newDoctor.setSurname(input.next());
                        System.out.print("Specialization: ");
                        newDoctor.setSpecialization(input.next());
                        System.out.print("Salary: ");
                        try{
                            newDoctor.setSalary(input.next());
                        }
                        catch(NumberFormatException ex){
                            System.out.print("Wrong salary number format\n");
                            break;
                        }
                      
                        try{
                            database.addDoctor(newDoctor);
                        }
                        catch(DataException ex){
                            System.out.print(ex.getMessage());
                        }
                      break;  
                    }
                    case 3:{
                       deleteDoctors();
                      break;
                    }
                    case 4:{
                      return;  
                    }

                    default:{
                  
                    }      
                }
            }   
        }
    }
        
    /**
     * Provides IO contact with user.
     */
    private Scanner input;
    
    /**
     * Database object used to connect and operate on data saved in files.
     */
    private TextFileDatabase database;
    
}
