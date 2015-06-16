
package interfaces;

import internetbankieren.Bank;
import internetbankieren.Klant;
import internetbankieren.Klanten;
import java.util.ArrayList;
import java.util.List;


public interface IKlanten {
    
    public void addKlant(IKlant k);
    /**
     * 
     * @return 
     */
    public boolean AddCustomer(IKlant klant);
     
    /**
     * 
     * @return 
     */
    public IKlant getKlant(int index);
    
    /**
     * 
     * @return 
     */
    public String toString();
    
    /**
     * 
     * @return 
     */
    public List getKlanten();
    
    public int getSize();
    
    /**
     * 
     * @param wachtwoord
     * @param naam
     * @param woonplaats
     * @param b
     * @return 
     */
    public boolean maakKlant(String naam, String wachtwoord, String woonplaats, int KlantID, String bankID);
}

