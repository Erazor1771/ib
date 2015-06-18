
package internetbankieren;


public class Transactie {
    
    private double bedrag;
    private String datum;
    private String omschrijving;
    private int vanBank;
    private int naarBank;

    public Transactie(int vanBank, int naarBank, double bedrag) {
        this.bedrag = bedrag;

        this.vanBank = vanBank;
        this.naarBank = naarBank;
    }

    public double getBedrag() {
        return bedrag;
    }

    public String getDatum() {
        return datum;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public int getVanBank() {
        return vanBank;
    }

    public int getNaarBank() {
        return naarBank;
    }

    @Override
    public String toString() {
        
        String result = "Van: " + vanBank + " - naar: " + naarBank + " - Bedrag " + bedrag + " Euro";
        
        return result;
    }


               
}
