
package internetbankieren;

public class Bankrekening {
    
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
    
    
}
