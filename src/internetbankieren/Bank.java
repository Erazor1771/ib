package internetbankieren;

import interfaces.IBank;
import interfaces.IBankrekening;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {

    private String bankcode;
    //private List<IBankrekening> bankRekeningen;
    private Bankrekeningen bankrekeningen;
    private Overboekcentrale centraleBank;

    // STEP 1: JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/internetbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public Bank(String bankcode) {
        this.bankcode = bankcode;
        centraleBank = new Overboekcentrale(bankcode);
        this.bankrekeningen = bankrekeningen;
    }

    public String getBankcode() {
        return bankcode;
    }

    @Override
    public int voegRekeningNrToe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean transactieUitvoeren(int vanRekNum, int naarRekNum, double bedrag) {
        
        Connection conn = null;
        Statement stmt = null;
        String saldoNaar = "";
        String saldoVan = "";

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql;

            sql = "SELECT Saldo FROM bankrekening WHERE Rekeningnummer = '" + naarRekNum + "'";

            ResultSet rs;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {

                saldoNaar = rs.getString("Saldo");

            } else {
                System.out.println("No Success");
            }

            sql = "SELECT Saldo FROM bankrekening WHERE Rekeningnummer = '" + vanRekNum + "'";

            rs = stmt.executeQuery(sql);
            if (rs.next()) {

                saldoVan = rs.getString("Saldo");

            } else {
                System.out.println("No Success");
            }

            Double eindsaldoNaar = bedrag + Double.parseDouble(saldoNaar);
            Double eindsaldoVan = Double.parseDouble(saldoVan) - bedrag;

            sql = "UPDATE bankrekening SET Saldo = '" + eindsaldoNaar + "' WHERE Rekeningnummer = '" + naarRekNum + "'";

            stmt.executeUpdate(sql);

            sql = "UPDATE bankrekening SET Saldo = '" + eindsaldoVan+ "' WHERE Rekeningnummer = '" + vanRekNum + "'";

            stmt.executeUpdate(sql);
            
            

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //System.out.println(gegevens.getKlanten().toString());
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }

        return true;
    }

    @Override
    public Bank getBank(String bankcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean maakBankrekening(int nummer, double saldo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addBankrekeningnummer(Bankrekening br) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bankrekening getBankrekeningnummer(int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getBankrekeningen() {
        return bankrekeningen.getBankrekeningen();
    }

}
