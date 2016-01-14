/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationtest;

import internetbankieren.testLogin;
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
     * Test of testLogin method, of class testLogin. With correct details
     */
    @Test
    public void testTestLogin() {
        System.out.println("testLogin");
        String username = "open";
        String wachtwoord = "sesame";
        testLogin instance = new testLogin();
        instance.testLogin(username, wachtwoord);
     
        assertEquals(instance, this);

    }
    
      @Test
    public void testTestLogin2() {
        System.out.println("testLogin");
        String username = "opn";
        String wachtwoord = "sesame";
        testLogin instance = new testLogin();
        instance.testLogin(username, wachtwoord);
  

    }
    
}
