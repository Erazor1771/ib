/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetbankieren;

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
public class testLoginIT {
    
    public testLoginIT() {
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
     * Test of testLogin method, of class testLogin.login ok 
     */
    @Test
    public void testTestLogin() {
        System.out.println("testLogin");
        String username = "open";
        String wachtwoord = "sesame";
        testLogin instance = new testLogin();
        String expResult = "ok";
        String result = instance.testLogin(username, wachtwoord);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     /**
     * Test of testLogin method, of class testLogin.login ok 
     */
    @Test
    public void testTestLogin2() {
        System.out.println("testLogin");
        String username = "oen";
        String wachtwoord = "sesame";
        testLogin instance = new testLogin();
        String expResult = "nietok";
        String result = instance.testLogin(username, wachtwoord);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
