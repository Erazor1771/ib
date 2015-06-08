
package interfaces;

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
    
    
}
