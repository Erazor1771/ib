
package internetbankieren;

import interfaces.IOverboekcentrale;


public class Overboekcentrale implements IOverboekcentrale{
    private String overboekcentrale;

    public Overboekcentrale(String overboekcentrale) {
        this.overboekcentrale = overboekcentrale;
    }

    public String getOverboekcentrale() {
        return overboekcentrale;
    }

    @Override
    public boolean bankTransactie(int vanRekNum, int naarRekNum, double bedrag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
