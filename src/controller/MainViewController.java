package controller;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import internetbankieren.Klanten;
import java.sql.Connection;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import view.BankView;

/** Controls the main application screen */
public class MainViewController implements screenController {
    
    screensController myController;
    LoginController lc = new LoginController();
    RegistreerController rc = new RegistreerController();
    Klanten klanten = new Klanten();
    
    // STEP 1: JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/internetbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    

    @FXML
    private Button logoutButton;
    @FXML
    private Label  sessionLabel;
    @FXML
    private Label naamLabel;
    @FXML
    private Label woonplaatsLabel;
    @FXML
    private Label saldoLabel;
    @FXML
    private Label kredietlimietLabel;
    @FXML
    private Label lblRekeningNummer;
    @FXML
    private Label lblNaw;
    @FXML
    private Label lblSaldo;
    @FXML
    private TextField txtFieldBedrag;
    @FXML
    private TextField txtFieldTegenRekening;
    @FXML
    private Button btnTransfer;
    @FXML
    private Button btnNewReknummer;
  
  public void initialize() {
      sessionLabel.setText(lc.generateSessionID());
      System.out.println(klanten.getKlanten().size());
      this.loadKlantInformation();
  }

    @Override
    public void setScreenParent(screensController screenParent) {
         myController = screenParent;
    }
  
    @FXML
    private void returnToLoginScreen(ActionEvent event) {

         myController.setScreen(BankView.screen1ID);   
         
    }
    
    @FXML
    private void maakBankrekeningWindow(ActionEvent event) {
       
         myController.setScreen(BankView.screen4ID);

    }
    
     /**
     * Get Klant Information for MainViewController
     */
    private void loadKlantInformation(){
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
            
            sql = "SELECT name, city, password FROM klantgegevens";
            ResultSet rs = stmt.executeQuery(sql);
            Statement statement = conn.createStatement();
            rs = stmt.executeQuery(sql);
                
            if (rs.next()) {
                    //Retrieve by column name
                    String naam = rs.getString("name");
                    String woonplaats = rs.getString("city");
                    
                    naamLabel.setText(naam);
                    woonplaatsLabel.setText(woonplaats);

            } else {
                    System.out.println("Invalid credentials");
            }


//            for (Klant k : gegevens.getGegevens()) {
//                if (username.equals(k.getName()) && ww.equals(k.getWachtwoord())) {
//                    return generateSessionID();
//                }
//            }

        } catch (SQLException | ClassNotFoundException se) {
        } finally {
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
            }//end finally try

        }
    }
    
}