/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import pl.jwieczorek.Model.TextFileDatabase;
import pl.jwieczorek.Model.Patient;
import pl.jwieczorek.Model.Doctor;
import pl.jwieczorek.Model.CustomExceptions.DataException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jakub Wieczorek
 * @version 1.0.0
 */
public class TextFileDatabaseTest {
    
    /**
     *
     */
    public TextFileDatabaseTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }


    /**
     * Test of addDoctor method, of class TextFileDatabase.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddDoctor() throws Exception {
        System.out.println("addDoctor");
        Doctor doctor = new Doctor();
        TextFileDatabase instance = new TextFileDatabase();
        instance.addDoctor(doctor);
        assertTrue(instance.getDoctors().contains(doctor));
    }

    /**
     * Test of addPatient method, of class TextFileDatabase.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddPatient() throws Exception {
        System.out.println("addPatient");
        Patient patient = new Patient();
        TextFileDatabase instance = new TextFileDatabase();
        instance.addPatient(patient);
        assertTrue(instance.getPatients().contains(patient));
    }

    /**
     * Test of deleteDoctors method, of class TextFileDatabase.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteDoctors() throws Exception {
        System.out.println("deleteDoctors");
        TextFileDatabase instance = new TextFileDatabase();
        for(int i = 0; i < 10; i++){
            Doctor doctor = new Doctor();
            instance.addDoctor(doctor);
        }
        instance.deleteDoctors();
        assertFalse(instance.getDoctors().size() > 0);
    }

    /**
     * Test of deletePatients method, of class TextFileDatabase.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeletePatients() throws Exception {
        System.out.println("deletePatients");
        TextFileDatabase instance = new TextFileDatabase();
          for(int i = 0; i < 10; i++){
            Patient patient = new Patient();
            instance.addPatient(patient);
        }
        instance.deletePatients();
        
        assertFalse(instance.getPatients().size() > 0);
    }
    
}
