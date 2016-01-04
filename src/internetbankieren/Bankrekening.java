
package internetbankieren;

import interfaces.IBankrekening;
import java.util.ArrayList;
import java.util.List;

public class Bankrekening implements IBankrekening{
    
    private int nummer;
    private Klant k;
    private double saldo;
    private double kredietlimiet;
    private int klantID;
    private List<Transactie> transacties;
    private Bank bank;
    

    public Bankrekening(int nummer, Klant k, double saldo, double kredietlimiet) {
        this.nummer = nummer;
        this.k = k;
        this.saldo = saldo;
        this.kredietlimiet = kredietlimiet;
        
    }
    
    //Bankrekening(reknummer, saldo, klantID, kredietLimiet);
    
     public Bankrekening(Bank bank, int nummer, double saldo, int klantID, double kredietlimiet) {
         
        this.nummer = nummer;
        this.klantID = klantID;
        this.saldo = saldo;
        this.kredietlimiet = kredietlimiet;
        this.bank = bank;
        this.transacties = new ArrayList<>();
     
     }

    public List<Transactie> getTransacties() {
        return transacties;
    }
     
     
    
    public int getNummer() {
        return nummer;
    }

    public Klant getK() {
        return k;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getKredietlimiet() {
        return kredietlimiet;
    }

    public int getKlantID() {
        return klantID;
    }
    
    

    @Override
    public boolean afboeken(double bedrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean bijboeken(double bedrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean overschrijven(int vanRekNummer, int naarRekNummer, double bedrag) {
        
       if( bank.transactieUitvoeren(vanRekNummer, naarRekNummer, bedrag))
       {
        
        Transactie transactie = new Transactie(vanRekNummer, naarRekNummer, bedrag);
        transacties.add(transactie);
        
        return true;
       }
       else
       {
           System.out.println("Onvoldoende saldo");
           return false;
       }
        
    }

    @Override
    public String toString() {
        return "Bankrekening{" + "nummer=" + nummer + ", k=" + k + ", saldo=" + saldo + ", kredietlimiet=" + kredietlimiet + '}';
    }
    
    
}
