
package internetbankieren;

import controller.MainViewController;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lars
 */
public class BankTest {

    int vanRekNum;
    int naarRekNum;
    int nonExistingvanRekNum;
    int nonExistingnaarRekNum;
    
    public BankTest() {
        
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
     * Test of testTransactieUitvoerenSUCCES method, of class Bank.
     * 50 euro will be transferred from bankaccountnumber vanRekNum to bankaccountnumber naarRekNum
     * 
     * The test will pass if instance.transactieUitvoeren will return true
     * Result: In the database 50.0 will be transferred from bankaccount 100000001 to 100000002
     * Test will pass if database is configured correctly and bankaccounts hold required amount of money
     * 
     * Test will fail if bankaccount 100000001 has less than 50.0 on his bankaccount
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
    
        
     /**
     * Test of testTransactieUitvoerenFAIL method, of class Bank.
     * 5000 euro will be transferred from bankaccountnumber vanRekNum to bankaccountnumber naarRekNum
     * 
     * The test will pass if instance.transactieUitvoeren will return false in this instance
     * Result: In the database 5000.0 can't be transferred from bankaccount 100000001 to 100000002
     * Test will pass if database is configured correctly and bankaccounts don't hold required amount of money
     * 
     * Test will pass if bankaccount 100000001 has less than 5000.0 on his bankaccount
     */
    @Test
        public void testTransactieUitvoerenFAIL() {
        System.out.println("transactieUitvoeren: == FAIL : Onvoldoende Saldo ==");
        double bedrag = 50000.0;
        Bank instance = new Bank("ABN");
        boolean expResult = false;
        boolean result = instance.transactieUitvoeren(vanRekNum, naarRekNum, bedrag);
        assertEquals(expResult, result);
    }
        
     /**
     * Test of testTransactieUitvoerenFAIL2 method, of class Bank.
     * 50 euro will be transferred from bankaccountnumber vanRekNum to bankaccountnumber naarRekNum
     * 
     * The test will fail because the bankaccountnumber nonExistingvanRekNum, it doesn't exist.
     * If the bankaccount number: nonExistingvanRekNum, was stored in the database it wouldn't pass this test.
     */
    @Test
        public void testTransactieUitvoerenFAIL2() {
        System.out.println("transactieUitvoeren: == FAIL : Bankrekening bestaat niet ==");
        double bedrag = 50.0;
        Bank instance = new Bank("ABN");
        boolean expResult = false;
        boolean result = instance.transactieUitvoeren(nonExistingvanRekNum, nonExistingnaarRekNum, bedrag);
        assertEquals(expResult, result);
    }
        

        
      

   
    
}
