
package interfaces;

import internetbankieren.Bank;
import internetbankieren.Bankrekening;
import java.util.ArrayList;

public interface IBank {
    
    /**
     * Voegt rekeningnummer toe aan een rekening
     * @return rekeningnummer
     */
    public int voegRekeningNrToe();
    
    /**
     * Bank voert een transactie uit, als naarRekNum bijzelfde bank zit dan true
     * Als dit niet zo is dan false en eventueel doorsturen naar de overboekcentrale
     * @param naarRekNum rekening tegenpartij
     * @param bedrag bedrag in euro's (bijv 2 euro en 13 eurocent : 2,13)
     * @return true of false
     */
    public boolean transactieUitvoeren(int vanRekNum,int naarekNum, double bedrag);
    
    /**
     * Methode om een bankcode te genereren voor een bankrekening, dat dient
     * ter indentificatie van de bankrekening.
     * @param bankcode een String waarvan de eerste 3 karakters letters zijn
     * en de volgende 9 karakters cijfers zijn. (bijv ABN 1234 567 89)
     * @return een bankcode in String formaat
     */
    public Bank getBank(String bankcode);
    
    /**
     * Maak een bankrekening voor een klant bij de desbetreffende bank.
     * Als er true uitkomt dan is er een bankrekening aangemaakt, komt
     * er false uit dan is er geen bankrekening voor de klant aangemaakt.
     * @param nummer bankrekening nummer is uniek en betreft 9 karakters, 
     * van 1 t/m 9, dienen integers te zijn.
     * @param saldo is het bedrag wat op de rekening staat in euro's (formaat voorbeeld: 2,14 euro)
     * @return true of false
     */
    public boolean maakBankrekening(int nummer, double saldo);
    
    /**
     * Voegt een bankrekening toe aan de bankrekeningenlijst.
     * True: Bankrekening is succesvol toegevoegd.
     * False: Bankrekening is niet toegevoegd.
     * @param br een bankrekening object
     * @return true of false
     */
    public boolean addBankrekeningnummer(Bankrekening br);
    
    /**
     * Geeft een bankrekening terug uit de bankrekeningenlijst.
     * @param position is de index uit de bankrekeningenlijst
     * @return Bankrekening br
     */
    public Bankrekening getBankrekeningnummer(int position);
    
    public ArrayList getBankrekeningen();
}
