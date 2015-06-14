
package internetbankieren;

import interfaces.IKlant;
import interfaces.IKlanten;
import java.util.ArrayList;
import java.util.List;

// TODO: Wijzig naar Klant klasse zoals in het klassediagram

public class Klanten implements IKlanten{
    
    
    private List<IKlant> gegevens;
    

    public  List<IKlant> getGegevens() {
        return gegevens;
    }

    public Klanten() {
        gegevens = new ArrayList();
    }
    
    
    
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
             gegevens.add(klant);
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
    public Klant getKlant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Klanten getKlanten() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean maakKlant(String inlognaam, String wachtwoord, String naam, String woonplaats, Bank b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
