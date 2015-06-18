/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import internetbankieren.Bankrekening;
import internetbankieren.Bankrekeningen;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 310054544
 */
public class ClientConnectionHandler implements Runnable {

    Socket s;
    Bankrekeningen rekeningen;
    List<Bankrekening> rekNummers;
    
        OutputStream outStream;
    InputStream inStream;

    // Let op: volgorde is van belang!
    ObjectOutputStream out;
    ObjectInputStream in;
    Bankclientcontroller bc;

    public ClientConnectionHandler(Socket s, Bankclientcontroller bc) throws IOException {

        this.s = s;
        this.rekeningen = new Bankrekeningen();
               this.outStream = s.getOutputStream();
        this.inStream = s.getInputStream();
        this.out = new ObjectOutputStream(outStream);
        this.in = new ObjectInputStream(inStream);
        this.bc = bc;

    }

    public List<Bankrekening> getRekNummers() {
        return rekNummers;
    }


    
    

    @Override
    public void run() {

        try {
            this.s = new Socket("localhost", 8189);
        } catch (IOException ex) {
            Logger.getLogger(ClientConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Bankrekening> rekNummers = rekeningen.getAllRekeningen();
        
       
        

//        for (Bankrekening r : rekNummers) {
//
//
//                rek = r;
//
//        }
        //mainview.setRekeningen(rekKlant);

        try {

            String test = rekeningen.toString();
            System.out.println("sending mb: " + test);
            out.writeObject(test);
            out.flush();

            String result = (String) in.readObject();
            System.out.println("get mb: " + result.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("catched");
        } catch (ClassNotFoundException nfe) {
            nfe.printStackTrace();
        }

    }

}
