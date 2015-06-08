
package internetbankieren;

import java.util.ArrayList;
import java.util.List;

// TODO: Wijzig naar Klant klasse zoals in het klassediagram

public class Klanten {
    
    
    private List<Klant> gegevens;

    public  List<Klant> getGegevens() {
        return gegevens;
    }

    public Klanten() {
        gegevens = new ArrayList();
    }
    
    
    
    public void addKlant(Klant k)
    {
        gegevens.add(k);
    }
    
    public boolean AddCustomer(Klant klant)
    {
         boolean succes = true;
         
         for(Klant k: gegevens)
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
}
