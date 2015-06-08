
package interfaces;

public interface IBankrekening {
    
    /**
     * Afboeken van het saldo van de bankrekening
     * Rekenen: saldo - bedrag =  saldo
     * @param bedrag is het bedrag in euro's wat moet worden afgeboekd. (formaat: 2,30)
     * @return saldo
     */
    public boolean afboeken(double bedrag);
    
    /**
     * Bijboeken van het saldo van de bankrekening
     * Rekenen: saldo + bedrag =  saldo
     * @param bedrag is het bedrag in euro's wat moet worden bijgeboekd. (formaat: 2,30)
     * @return saldo 
     */
    public boolean bijboeken(double bedrag);
    
    /**
     * Verzoek indienen om geld over te maken naar een andere bankrekening
     * True: Geld wordt overgeboekt naar de andere rekening
     * False: Geld wordt niet overgeboekt naar de andere rekening.
     * Redenen False: rekeningnummer bestaat niet, ... , ...
     * Rekenen: saldo - bedrag = saldo
     * @param naarRekNummer rekeningnummer waar het geld naartoe moet worden geboekt
     * @param bedrag het bedrag in euro's wat moet worden overgemaakt (formaat: 2,30)
     * @return true of false
     */
    public boolean overschrijven(int naarRekNummer, double bedrag);
}
