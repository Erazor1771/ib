
package interfaces;


public interface ITransactie {
    
    /**
     * 
     * @param bedrag
     * @param datum
     * @param omschrijving
     * @param vanBank
     * @param naarBank
     * @return 
     */
    public boolean Transactie(double bedrag, String datum, String omschrijving, int vanBank, int naarBank);
    
}
