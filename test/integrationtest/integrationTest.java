/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationtest;

import controller.MainViewController;
import internetbankieren.Bank;
import internetbankieren.DBconnector;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;

/**
 *
 * @author 310054544
 */
public class integrationTest {

    int vanRekNum;
    int naarRekNum;
    int nonExistingvanRekNum;
    int nonExistingnaarRekNum;

    /**
     * Connect to DB and set fictive Session Retrieve all customer information
     * from the database so we can use the current bankaccounts to test with.
     */
    @BeforeClass
    public static void getBankCustomerInformation() {
        MainViewController mvc = new MainViewController();
        mvc.loadKlantInformation("session1");
        
    }

    /**
     * Logging out of the Database
     *
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
        this.vanRekNum = 100000001;
        this.naarRekNum = 100000002;
        this.nonExistingvanRekNum = 123;
        this.nonExistingnaarRekNum = 456;
    }

    /**
     * Reset the rekening numbers after testing
     */
    @After
    public void tearDown() {
        System.out.println("Running: tearDown");
        this.vanRekNum = 0;
        this.naarRekNum = 0;
        this.nonExistingvanRekNum = 0;
        this.nonExistingnaarRekNum = 0;
    }

    /**
     * Test of testTransactieUitvoerenSUCCES method, of class Bank. 50 euro will
     * be transferred from bankaccountnumber vanRekNum to bankaccountnumber
     * naarRekNum
     *
     * The test will pass if instance.transactieUitvoeren will return true
     * Result: In the database 50.0 will be transferred from bankaccount
     * 100000001 to 100000002 Test will pass if database is configured correctly
     * and bankaccounts hold required amount of money
     *
     * Test will fail if bankaccount 100000001 has less than 50.0 on his
     * bankaccount
     */
    @Test
    public void testTransactieUitvoerenSUCCES() {
        System.out.println("transactieUitvoeren: == CORRECT : Transactie succesvol uitgevoerd ==");
        double bedrag = 50.0;
        Bank instance = new Bank("ABN");
        boolean expResult = true;
        boolean result = instance.transactieUitvoeren(vanRekNum, naarRekNum, bedrag);
        assertEquals(expResult, result);
    }
}
