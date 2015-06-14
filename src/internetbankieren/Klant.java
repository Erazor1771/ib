
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

    public Klant(String name, String city, String wachtwoord) {
        this.name = name;
        this.city = city;
        this.wachtwoord = wachtwoord;
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
