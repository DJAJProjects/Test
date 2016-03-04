/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import pl.jwieczorek.Model.IDGenerator;
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
public class IDGeneratorTest {
    
    /**
     *
     */
    public IDGeneratorTest() {
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
     * Test of generateID method, of class IDGenerator.
     */
    @Test
    public void testGenerateID() {
        System.out.println("generateID");
        String expResult = "";
        String id1 = IDGenerator.generateID();
        String id2 = IDGenerator.generateID();
        String id3 = IDGenerator.generateID();
        
        assertFalse(id1.equals(id2)||id1.equals(id3)||id2.equals(id3));

    }
    
}
