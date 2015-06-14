
package internetbankieren;

import interfaces.IKlant;
import interfaces.IKlanten;
import java.util.ArrayList;
import java.util.List;

// TODO: Wijzig naar Klant klasse zoals in het klassediagram

public class Klanten implements IKlanten{
    
    
    private ArrayList<IKlant> gegevens;
    
    public Klanten() {
        gegevens = new ArrayList();
    }
    
    @Override
    public void addKlant(IKlant k)
    {
        gegevens.add(k);
    }
    
    public boolean AddCustomer(IKlant klant)
    {
         boolean succes = true;
         
         for(IKlant k: gegevens)
         {
             if(k.getName().equals(klant.getName()) && k.getCity().equals(klant.getCity()))
             {
                 succes = false;
             }
                 
         }
         
         if(succes)
         {
             this.addKlant(klant);
             System.out.println(this.getKlanten().size());
         }
         return succes;
    }

    @Override
    public boolean add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IKlant getKlant(int index) {
        return gegevens.get(index);
    }

    @Override
    public List getKlanten() {
        return gegevens;
    }

    @Override
    public int getSize(){
        return gegevens.size();
    }
    
    public List<IKlant> getGegevens() {
        return gegevens;
    }
    
    @Override
    public boolean maakKlant(String inlognaam, String wachtwoord, String naam, String woonplaats, Bank b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Klanten{" + "gegevens=" + gegevens + '}';
    }
    
    
}
