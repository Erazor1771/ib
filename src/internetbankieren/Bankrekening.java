
package internetbankieren;

import interfaces.IBankrekening;

public class Bankrekening implements IBankrekening{
    
    private int nummer;
    private Klant k;
    private double saldo;
    private double kredietlimiet;

    public Bankrekening(int nummer, Klant k, double saldo, double kredietlimiet) {
        this.nummer = nummer;
        this.k = k;
        this.saldo = saldo;
        this.kredietlimiet = kredietlimiet;
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

    @Override
    public boolean afboeken(double bedrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean bijboeken(double bedrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean overschrijven(int naarRekNummer, double bedrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
