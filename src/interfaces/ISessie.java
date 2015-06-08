
package interfaces;

import internetbankieren.Bankrekening;
import java.sql.Time;


public interface ISessie {
    
    /**
     * 
     * @param bedrag
     * @param rekeningNummer
     * @return 
     */
    public boolean maakOver(double bedrag, int rekeningNummer);
    
    /**
     * 
     * @return 
     */
    public Bankrekening nieuwRekening();
    
    /**
     * 
     * @return 
     */
    public boolean toonTransacties();
    
    /**
     * 
     * @return 
     */
    public Time getTime();
}
