/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetbankieren;

import categories.makeBankStuff;
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
public class BankrekeningenTest {
    
    int nummer;
    int invalidnummer;
    int saldo;
    double negatiefsaldo;
    double kredietlimiet;
    Klant k;
    
    public BankrekeningenTest() {
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
     * Setting up the rekening numbers
     */
    @Before
    public void setUp() {
       System.out.println("Running: setUp");
       nummer = 100000001;
       invalidnummer = 1000000011;
       saldo = 50;
       negatiefsaldo = -10.00;
       kredietlimiet = 10.00;
       Klant k = new Klant("Lars", "Maastricht","123", 1, "ABN");
    }
    
    /**
     * Reset variables
     */
    @After
    public void tearDown() {
        System.out.println("Running: tearDown");
        nummer = 0;
        invalidnummer = 0;
        saldo = 0;
        kredietlimiet = 0;
        Klant k = null;
    }


    /**
     * Maak succesvol bankrekening / bank account 
     * This result will return true on succes 
     */
    @Test
    @Category(makeBankStuff.class)
    public void testMaakBankrekening() {
        System.out.println("maakBankrekening == SUCCES == ");
   
        Bankrekeningen instance = new Bankrekeningen();
        boolean result = instance.maakBankrekening(nummer, k, saldo, kredietlimiet);
        assertTrue(result);
    }
    
     /**
     * Cijfer / nummer is longer than 9 characters so this will fail, only 9 or less characters allowed
     * assertFalse will succes
     */
    @Test
    @Category(makeBankStuff.class)
    public void testMaakBankrekeningFAIL1() {
        System.out.println("maakBankrekening == FAIL == Nummer more than 9 characters");

        Bankrekeningen instance = new Bankrekeningen();
        boolean expResult = false;
        boolean result = instance.maakBankrekening(invalidnummer, k, saldo, kredietlimiet);
        assertFalse(result);
    }

    /**
     * Saldo negative so this test will return false
     */
    @Test
    @Category(makeBankStuff.class)
    public void testMaakBankrekeningFAIL2() {
        System.out.println("maakBankrekening == FAIL == Saldo negative");

        Bankrekeningen instance = new Bankrekeningen();
        boolean expResult = false;
        boolean result = instance.maakBankrekening(nummer, k, negatiefsaldo, kredietlimiet);
        assertEquals(expResult, result);
    }
}
