
package internetbankieren;

// TODO: Wijzig naar Klant klasse zoals in het klassediagram

import interfaces.IKlant;
import interfaces.ISessie;
import java.util.ArrayList;


public class Klant implements IKlant{
    private String name;
    private String city;
    private String wachtwoord;
    private ISessie sessie;
    private int klantID;
    private String bankID;

    public Klant(String name, String city, String wachtwoord, int klantID, String bankID) {
        this.name = name;
        this.city = city;
        this.wachtwoord = wachtwoord;
        this.klantID = klantID;
        this.bankID = bankID;
        //this.sessie = new Sessie();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getWachtwoord() {
        return wachtwoord;
    }

    @Override
    public String getCity() {
        return city;
    }

    public int getKlantID() {
        return klantID;
    }

    public String getBankID() {
        return bankID;
    }

    @Override
    public boolean voegRekeningToe(Klant k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getRekeningen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Klant{" + "name=" + name + ", city=" + city + ", wachtwoord=" + wachtwoord + ", sessie=" + sessie + '}';
    }
    
    
}
