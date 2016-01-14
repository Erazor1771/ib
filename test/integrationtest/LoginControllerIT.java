/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationtest;

import controller.LoginController;
import controller.screensController;
import internetbankieren.Sessie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.jar.Pack200.Packer.PASS;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 310054544
 */
public class LoginControllerIT {

    
    public LoginControllerIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class LoginController.
     */
    @Test
    public void testInitialize() {
        
        
    }
    

    

    /**
     * Test of generateSessionID method, of class LoginController.
     */
    @Test
    public void testGenerateSessionID() {
        System.out.println("generateSessionID");
        LoginController instance = new LoginController();
        String expResult = "xyzzy - session 1";
        String result = instance.generateSessionID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    
}
