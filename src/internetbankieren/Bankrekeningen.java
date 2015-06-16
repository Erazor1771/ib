
package internetbankieren;
 
import java.util.ArrayList;


public class Bankrekeningen {
    
    
    private ArrayList<Bankrekening> bankrekeningen;
    
    public Bankrekeningen() {
        bankrekeningen = new ArrayList();
    }
    
    /**
     * Voeg een Bankrekening object toe aan bankrekeningen (arraylist)
     * @param br een bankrekening Object om toe te voegen aan bankrekeningen (arraylist)
     */
    public void addBankrekening(Bankrekening br)
    {
        bankrekeningen.add(br);
    }
    /**
     * Vraag het aantal elementen uit bankrekeningen op
     * @return het aantal elementen van bankrekeningen (arraylist)
     */
    public int getSize(){
        return bankrekeningen.size();
    }
    /**
     * Vraag een Arraylist van bankrekeningen op 
     * @return bankrekeningen
     */
    public ArrayList getBankrekeningen(){
        return bankrekeningen;
    }
    /**
     * Vraag een bankrekening object op d.m.v. index
     * @param index is een int en geeft de index aan van het object die opgevraagd moet worden
     * @return Bankrekening br object
     */
    public Bankrekening getBankrekening(int index){
        return bankrekeningen.get(index);
    }
    
    /**
     * Maak een bankrekening aan voor een klant
     * Als er velden leeg zijn dan kan er geen bankrekening worden aangemaakt
     * Als het saldo negatief is dan kan er geen bankrekening worden aangemaakt
     * Bankrekeningnummer moet 9 cijfers lang zijn anders kan deze niet worden aangemaakt
     * 
     * @param nummer bankrekeningnummer als een int, deze is altijd uniek en 9 cijfers lang
     * @param k Klant k object, om de bankrekening aan de juiste klant te koppelen
     * @param saldo een double om saldo van de bankrekening bij te houden
     * @param kredietlimiet een double om het kredietlimiet van een klant bij te houden
     * @return true als er een bankrekening succesvol wordt aangemaakt, false als dit niet het geval is
     */
    public boolean maakBankrekening(int nummer, Klant k, double saldo, double kredietlimiet){
        // TODO Add Klant k check
        if(nummer == 0 || saldo == 0 || kredietlimiet == 0){
            System.out.println("Bankrekening kan niet aangemaakt worden, veld(en) zijn leeg.");
            return false;
        }
        if(String.valueOf(nummer).length() != 9){
            System.out.println("Bankrekeningnummer moet 9 cijfers bevatten.");
            return false;
        }
        if(saldo < 0){
            System.out.println("Bankrekening kan niet aangemaakt worden, saldo moet positief zijn of 0.");
            return false; 
        }
        
        Bankrekening br = new Bankrekening(nummer, k, saldo, kredietlimiet);
        addBankrekening(br);
        System.out.println("Bankrekening is aangemaakt: " + br.toString());
        return true;
    }
    
    /**
     * To String methode van bankrekeningen
     * @return string met bankrekeningen gegevens
     */
    @Override
    public String toString() {
        return "Bankrekeningen{" + "bankrekeningen=" + bankrekeningen + '}';
    }
    
}


