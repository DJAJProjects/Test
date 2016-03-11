/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jwieczorek.Controller;

import java.util.Scanner;
import pl.jwieczorek.Model.CustomExceptions.DataException;
import pl.jwieczorek.Model.TextFileDatabase;
import pl.jwieczorek.View.ConsoleView;
import pl.jwieczorek.View.MainForm;

/**
 *
 * Control class. It contains main method and calls a proper view functions.
 * It initializes basic model objects.
 * 
 * @author Jakub Wieczorek
 * @version 1.0.1
 */
public class PrzychodniaApp { //heheszki

    /**
     * Main program function. 
     * Initializes console view and database manager.
     * Reads program parameters. Calls proper view methods 
     * basing on parameters.
     * @param args the command line arguments
     * If no parameters are passed, then main method calls standard
     * window view. 
     * 
     * If there is one parameter: console, then main method
     * calls standard console view.
     * 
     * If there are 2 parameters, then main method calls console view
     * without user interaction. 
     * First string describes action on database. There are two possible actions:
     * "Show" or "Delete". Parameter delete orders program to delete ALL data file content.
     * Second string gives data table/file name (just name, without file format *txt). 
     * There are currently two possible names: "Doctors" or "Patients".

     */
    public static void main(String[] args) {

        
        Scanner input = new Scanner(System.in); // Only to use in command line arguments case, to stop console from turning off.
          
        if(args.length == 0)
            MainForm.showMainForm();
        else{
             
                // Creating database connection for console view
                TextFileDatabase fileDatabase = null;
                try{
                    fileDatabase = new TextFileDatabase();
                }
                 catch(DataException ex){
                    System.out.print(ex.getMessage());
                    input.next();
                    return;
                }
                  
                // Initializing main console view
                ConsoleView mainInterface = new ConsoleView(fileDatabase);
                    
                if(args.length == 1){
                   if(args[0].equals("console")){
                       mainInterface.MainMenu();

                   }
                   else{
                        System.out.print("Program parameter's content is not proper.\n");
                        input.nextLine();
                        return;
                   }
                }
                else{

                    try{
                        String operation  = args[0];
                        String dataName = args[1];
                    }
                    catch(IndexOutOfBoundsException ex){
                        System.out.print("Program parameters amount is not proper.\n");
                         input.nextLine();
                        return;
                    }

                    if((!"Show".equals(args[0]) && !"Delete".equals(args[0])) || (!"Doctors".equals(args[1]) && !"Patients".equals(args[1]))){
                        System.out.print("Program parameter's content is not proper.\n");
                         input.nextLine();
                        return;
                    }
                    else if("Show".equals(args[0])){
                        if("Doctors".equals(args[1])){
                            mainInterface.showDoctors();
                        }
                        else{
                            mainInterface.showPatients();
                        }
                    }
                    else{
                        if("Doctors".equals(args[1])){
                            mainInterface.deleteDoctors();
                        }
                        else{
                            mainInterface.deletePatients();
                        }
                   } 
                    
                    input.nextLine();
                }  
                 
            }
        
    
        /*TextFileDatabase fileDatabase = null;
        
        // Initializing database 
        try{
            fileDatabase = new TextFileDatabase();
        }
        catch(DataException ex){
             System.out.print(ex.getMessage());
             return;
        }
        
        // Initializing main console view
        ConsoleView mainInterface = new ConsoleView(fileDatabase);
        
        int paramtersNumber = args.length;
        
        //No parameters mode
        if(paramtersNumber == 0){
            mainInterface.MainMenu();
        }
        // Parameters mode
        else{
            try{
                String operation  = args[0];
                String dataName = args[1];
            }
            catch(IndexOutOfBoundsException ex){
                System.out.print("Program parameters amount is not proper.\n");
            }
            
            if((!"Show".equals(args[0]) && !"Delete".equals(args[0])) || (!"Doctors".equals(args[1]) && !"Patients".equals(args[1]))){
                System.out.print("Program parameter's content is not proper.\n");
            }
            else if("show".equals(args[0])){
                if("Doctors".equals(args[1])){
                    mainInterface.showDoctors();
                }
                else{
                    mainInterface.showPatients();
                }
            }
            else{
                if("Doctors".equals(args[1])){
                    mainInterface.deleteDoctors();
                }
                else{
                    mainInterface.deletePatients();
                }
            }  
        }*/
    }
    
}
