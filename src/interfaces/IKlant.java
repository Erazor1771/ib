
package interfaces;

import internetbankieren.Bankrekening;
import internetbankieren.Klant;
import java.util.ArrayList;


public interface IKlant {
    
    /**
     * 
     * @param k
     * @return 
     */
    public boolean voegRekeningToe(Klant k);
    
    /**
     * 
     * @return 
     */
    public ArrayList getRekeningen();
    
    public String getName();
    public String getWachtwoord();
    public String getCity();
    public Bankrekening getRekening(int position);
    
}
