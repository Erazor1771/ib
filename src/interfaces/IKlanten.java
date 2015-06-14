
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
    public boolean add();
    
    /**
     * 
     * @return 
     */
    public boolean remove();
    
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
     * @param inlognaam
     * @param wachtwoord
     * @param naam
     * @param woonplaats
     * @param b
     * @return 
     */
    public boolean maakKlant(String inlognaam, String wachtwoord, String naam, String woonplaats, Bank b);
}

