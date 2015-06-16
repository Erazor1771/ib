
package internetbankieren;

import interfaces.IKlant;
import interfaces.IKlanten;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import view.BankView;

// TODO: Wijzig naar Klant klasse zoals in het klassediagram

public class Klanten implements IKlanten{
    
    
    private ArrayList<IKlant> gegevens;
    // STEP 1: JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/internetbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
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
    
    /**
     * Maak een nieuwe klant aan voor een specifieke bank.
     * De klant wordt uiteindelijk gekoppeld aan een lijst met klanten. (1 lijst voor alle banken?)
     * Als er velden niet ingevuld zijn wordt er false gereturned en geen klant aangemaakt.
     * Als woonplaats een cijfer bevat return false
     * 
     * @param naam is een String en de naam van de klant dit is tevens ook zijn inlognaam
     * @param wachtwoord is het wachtwoord van de klant in String formaat
     * @param woonplaats is de woonplaats van de klant in String formaat
     * @param String bankID
     * 
     * @return true als klant is aangemaakt, false als dit niet is gelukt
     */
    @Override
    public boolean maakKlant(String naam, String wachtwoord, String woonplaats,int KlantID, String bankID) {
        if(naam.isEmpty() || wachtwoord.isEmpty() || woonplaats.isEmpty() || bankID.isEmpty()){
            System.out.println("Klant kan niet aangemaakt worden veld is leeg");
            return false;
        }
        if(woonplaats.matches(".*\\d.*")){
            System.out.println("Klant kan niet aangemaakt worden woonplaats bevat nummer");
            return false;
        }
        
        Klant k = new Klant(naam, wachtwoord, woonplaats, KlantID, bankID);
        System.out.println("Klant aangemaakt: " + k.toString());
        AddCustomer(k);
        
        Connection conn = null;
        Statement stmt = null;

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
            sql = "SELECT * FROM klant";
            ResultSet rs = stmt.executeQuery(sql);
                
                System.out.println("Success");

                Statement statement = conn.createStatement();
                statement.executeUpdate("INSERT INTO klant (BankID, Naam, Woonplaats, Wachtwoord) VALUES ('" + bankID + "','" + naam + "','" + woonplaats + "', '" + wachtwoord + "')");

                rs = stmt.executeQuery(sql);
                System.out.println(gegevens.toString());

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
    public String toString() {
        return "Klanten{" + "gegevens=" + gegevens + '}';
    }
    
    
}
