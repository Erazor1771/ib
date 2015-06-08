
package internetbankieren;


public class Transactie {
    
    private double bedrag;
    private String datum;
    private String omschrijving;
    private int vanBank;
    private int naarBank;

    public Transactie(double bedrag, String datum, String omschrijving, int vanBank, int naarBank) {
        this.bedrag = bedrag;
        this.datum = datum;
        this.omschrijving = omschrijving;
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
               
}
