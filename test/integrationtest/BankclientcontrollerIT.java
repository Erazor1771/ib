/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationtest;

import client.Bankclientcontroller;
import controller.MainViewController;
import internetbankieren.Bankrekeningen;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.channels.SocketChannel;
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
public class BankclientcontrollerIT {

    Bankrekeningen rekeningen;
    Socket s;
    OutputStream outStream;
    InputStream inStream;

    // Let op: volgorde is van belang!
    ObjectOutputStream out;
    ObjectInputStream in;
    MainViewController mvc = new MainViewController();

    public BankclientcontrollerIT() throws IOException {
        
        this.s = new Socket("127.0.0.1", 8189);
        this.outStream = s.getOutputStream();
        this.inStream = s.getInputStream();
        this.out = new ObjectOutputStream(outStream);
        this.in = new ObjectInputStream(inStream);
        this.rekeningen = new Bankrekeningen();
        MainViewController mvc = new MainViewController();
        mvc.loadKlantInformation("session1");
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
     * Test of selectRekeningen method, of class Bankclientcontroller.
     * Returns details of customerID 9
     */
    @Test
    public void testSelectRekeningen() throws IOException {
        System.out.println("selectRekeningen");
        int klantID = 9;
        Bankclientcontroller instance = new Bankclientcontroller(mvc);
        instance.selectRekeningen(klantID);
       ;
    }
    
     /**
     * Test of getS method, of class Bankclientcontroller.
     * check if client connects to the correct ports
     */
    @Test
    public void testGetS() throws IOException {
        System.out.println("getS");
        Bankclientcontroller instance = new Bankclientcontroller(mvc);
        SocketChannel expResult = s.getChannel();
        SocketChannel result = instance.getS().getChannel();
       

    }

}
