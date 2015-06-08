
package interfaces;


public interface IOverboekcentrale {
    
    /**
     * 
     * @param vanRekNum
     * @param naarRekNum
     * @param bedrag
     * @return 
     */
    public boolean bankTransactie(int vanRekNum, int naarRekNum, double bedrag);
}
