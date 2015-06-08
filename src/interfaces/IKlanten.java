
package interfaces;

import internetbankieren.Bank;
import internetbankieren.Klant;
import internetbankieren.Klanten;


public interface IKlanten {
    
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
    public Klant getKlant();
    
    /**
     * 
     * @return 
     */
    public String toString();
    
    /**
     * 
     * @return 
     */
    public Klanten getKlanten();
    
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

