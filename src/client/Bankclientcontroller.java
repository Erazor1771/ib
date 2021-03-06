/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import internetbankieren.Bankrekening;
import internetbankieren.Bankrekeningen;
import controller.MainViewController;
import internetbankieren.DBconnector;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 310054544
 */
public class Bankclientcontroller {
    
    MainViewController mainview;
    Bankrekeningen rekeningen;
    Socket s;
    OutputStream outStream;
    InputStream inStream;

    // Let op: volgorde is van belang!
    ObjectOutputStream out;
    ObjectInputStream in;
    

    public Bankclientcontroller(MainViewController mainview) throws IOException {
        
        this.s = new Socket("localhost", 8189);
        this.outStream = s.getOutputStream();
        this.inStream = s.getInputStream();
        this.out = new ObjectOutputStream(outStream);
        this.in = new ObjectInputStream(inStream);
        this.rekeningen = new Bankrekeningen();
        this.mainview = mainview;
    }

    public Socket getS() {
        return s;
    }

    
    
        public void selectRekeningen(int klantID) {
        List<Bankrekening> rekNummers = rekeningen.getAllRekeningen();
        List<Bankrekening> rekKlant = new ArrayList<>();
        Bankrekening rek = null;
            
        
        for (Bankrekening r : rekNummers) {
            
            if(r.getKlantID() == klantID)
            {
               rekKlant.add(r);
               
                rek = r;
                
            }
            
        }
        mainview.setRekeningen(rekKlant);

         try {
           
            String test = rekNummers.toString();
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
