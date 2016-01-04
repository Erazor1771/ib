/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetbankieren;

import categories.makeCustomerStuff;
import controller.MainViewController;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

/**
 *
 * @author lars
 */
public class KlantenTest {
    
    String naam;
    String emptyName;
    String wachtwoord;
    String woonplaats;
    String woonplaatsNumbers;
    int KlantID;
    String bankID;
    Klant k;
    Klant k2;
    
    public KlantenTest() {
    }
    
    /**
     *  Connect to DB and set fictive Session
     *  Retrieve all customer information from the database so 
     *  we can use the current bankaccounts to test with.
     */
    @BeforeClass
    public static void getBankCustomerInformation() {
        MainViewController mvc = new MainViewController();
        mvc.loadKlantInformation("session1");
    }

    /**
     * Logging out of the Database
     * @throws SQLException if something went wrong with the DB / query
     */
    @AfterClass
    public static void logoutDB() throws SQLException {
        DBconnector db = new DBconnector();
        db.closeConnection();
    }
    
    /**
     * Set up some variables to test Klanten Methods
     */
    @Before
    public void setUp() {
        naam = "Lars";
        emptyName = "";
        wachtwoord = "123";
        woonplaats = "Maastricht";
        woonplaatsNumbers = "1324FRotterdam";
        KlantID = 1;
        bankID = "ABN";
        Klant k = new Klant("Lars", "Maastricht","123", 1, "ABN");
        Klant k2 = new Klant("Lars", "Maastricht","123", 1, "ABN");
    }
    
    /**
     * Reset all tested variables
     */
    @After
    public void tearDown() {
        naam = null;
        emptyName = null;
        wachtwoord = null;
        woonplaats = null;
        woonplaatsNumbers = null;
        KlantID = 0;
        bankID = null;
    }
   
    /**
     * Here we test method MaakKlant
     * 
     * If a klant / customer is made it will return success
     * In this instance we expect it to be true
     */
    @Test
    @Category(makeCustomerStuff.class)
    public void testMaakKlant() {
        System.out.println("maakKlant == SUCCES ==");
        Klanten instance = new Klanten();
        
        boolean expResult = true;
        boolean result = instance.maakKlant(naam, wachtwoord, woonplaats, KlantID, bankID);
        assertEquals(expResult, result);
    }

    /**
     * Klant / Customer test will fail because woonplaats is not allowed to contain numbers
     * We expect test to be false so this test will return succesfully
     */
    @Test
    @Category(makeCustomerStuff.class)
    public void testMaakKlantFAIL() {
        System.out.println("maakKlant == FAIL == Woonplaats : contains numbers");
        Klanten instance = new Klanten();
        
        boolean expResult = false;
        boolean result = instance.maakKlant(naam, wachtwoord, woonplaatsNumbers, KlantID, bankID);
        assertEquals(expResult, result);
    }
    
    /**
     * Klant / Customers can't be made because naam is empty and not allowed
     * We expect result to be false so this test will return succesfully
     */
    @Test
    @Category(makeCustomerStuff.class)
    public void testMaakKlantFAIL2() {
        System.out.println("Maak klant == FAIL == Name : EMPTY ");
        Klanten instance = new Klanten();
     
        boolean expResult = false;
        boolean result = instance.maakKlant(emptyName, wachtwoord, woonplaats, KlantID, bankID);
        assertEquals(expResult, result);
    }
    
    /**
     * Klant / Customer don't exist on this index in Klanten array 
     * so this will return a IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void getKlant() {
        Klanten klanten = new Klanten();
        klanten.getKlant(353805);   
    }
    
    /**
     * This will add a customer succesfully to the klanten array
     * Result will be true and matches the assertEquals
     */
    @Test
    public void testAddCustomer(){
        System.out.println("Add Customer == Succes == Added to Array ");
        Klanten instance = new Klanten();
     
        boolean expResult = true;
        boolean result = instance.AddCustomer(k);
        assertEquals(expResult, result);
    }
    
    /**
     * Trying to add a second customer to the klanten array
     * This will fail and end up in a NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testAddCustomerFAIL(){
        System.out.println("Add Customer == FAIL == Customer with this name and living place already exist in array ");
        Klanten instance = new Klanten();
        instance.AddCustomer(k2);
        boolean result = instance.AddCustomer(k);
    }
    
    
}
