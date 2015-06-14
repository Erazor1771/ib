/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetbankieren;

import interfaces.ISessie;
import java.sql.Time;

/**
 *
 * @author lars
 */
public class Sessie implements ISessie{
    
    private String sessieID;
    private static String userName;

    public Sessie(String sessieID, String userName) {
        this.sessieID = sessieID;
        this.userName = userName;
    }

    public String getSessieID() {
        return sessieID;
    }

    public static String getUserName() {
        return userName;
    }
    
    

    @Override
    public boolean maakOver(double bedrag, int rekeningNummer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bankrekening nieuwRekening() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean toonTransacties() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Time getTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
