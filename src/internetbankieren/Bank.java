
package internetbankieren;

import interfaces.IBank;
import interfaces.IBankrekening;
import java.util.ArrayList;
import java.util.List;


public class Bank implements IBank{
    private String bankcode;
    private List<IBankrekening> bankRekeningen;
    private Overboekcentrale centraleBank;

    public Bank(String bankcode) {
        this.bankcode = bankcode;
        centraleBank = new Overboekcentrale(bankcode);
        this.bankRekeningen = new ArrayList<>();
    }

    public String getBankcode() {
        return bankcode;
    }

    @Override
    public int voegRekeningNrToe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean transactieUitvoeren(int naarRekNum, double bedrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bank getBank(String bankcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean maakBankrekening(int nummer, double saldo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addBankrekeningnummer(Bankrekening br) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bankrekening getBankrekeningnummer(int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
