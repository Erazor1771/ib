
package internetbankieren;
 
import java.util.ArrayList;


public class Bankrekeningen {
    
    
    private ArrayList<Bankrekening> bankrekeningen;
    
    public Bankrekeningen() {
        bankrekeningen = new ArrayList();
    }
    

    public void addBankrekening(Bankrekening br)
    {
        bankrekeningen.add(br);
    }
    public int getSize(){
        return bankrekeningen.size();
    }
    public ArrayList getBankrekeningen(){
        return bankrekeningen;
    }
    public Bankrekening getBankrekening(int index){
        return bankrekeningen.get(index);
    }

    @Override
    public String toString() {
        return "Bankrekeningen{" + "bankrekeningen=" + bankrekeningen + '}';
    }
    
}


