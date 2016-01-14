/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationtest;

import controller.LoginController;
import controller.MainViewController;
import controller.RegistreerController;
import controller.screensController;
import internetbankieren.Bankrekening;
import internetbankieren.DBconnector;
import internetbankieren.Klanten;
import internetbankieren.Sessie;
import java.sql.SQLException;
import java.util.List;
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
public class MainViewControllerIT {
    
    screensController myController;
    LoginController lc = new LoginController();
    RegistreerController rc = new RegistreerController();
    Klanten klanten = new Klanten();
    Sessie sessie;
    
    private int rekeningnummer;
    
    public MainViewControllerIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
              MainViewController mvc = new MainViewController();
        mvc.loadKlantInformation("session1");
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
         DBconnector db = new DBconnector();
        db.closeConnection();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }





  

    /**
     * Test of loadKlantInformation method, of class MainViewController.
     * Laat gegevens van Klant open zien
     */
    @Test
    public void testLoadKlantInformation() {
        System.out.println("loadKlantInformation");
        String userName = "open";
        MainViewController instance = new MainViewController();
        instance.loadKlantInformation(userName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }



 
    
}
