package controller;

import internetbankieren.Klant;
import internetbankieren.Klanten;
import internetbankieren.Sessie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import view.BankView;

/**
 * Controls the login screen
 */
public class LoginController implements screenController{

    screensController myController;
    private String sessionID;
    private String username;
    private String wachtwoord;
    private static int generateSessionID = 0;
    private Sessie sessie;
    
    // STEP 1: JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/internetbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    @FXML
    private TextField user;
    @FXML
    private TextField password;

    @FXML
    private TextArea errorTextArea;
    
    @FXML
    private Button btnRegistreer;

    
    Klanten gegevens;

    LoginManager loginManager;
    @FXML
    private Button loginButton;

    public void initialize() {
        
    }

    public LoginController() {
       // this.sessionID = sessionID;
    }

    /**
     * Check authorization credentials.
     *
     * If accepted, return a sessionID for the authorized session otherwise,
     * return null.
     */
    private String authorize() {
        
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
            //sql = "SELECT name, city, password FROM klantgegevens";
           // ResultSet rs = stmt.executeQuery(sql);

            username = user.getText();
            wachtwoord = password.getText();

           // Statement statement = conn.createStatement();
               // statement.executeUpdate("INSERT INTO klantgegevens VALUES ('" + name + "', '" + city + "', '" + password + "')");
            //rs = stmt.executeQuery(sql);

            if (username != null && wachtwoord != null) {
                sql = "SELECT * FROM klant WHERE Naam='" + username + "' and Wachtwoord='" + wachtwoord + "'";

                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next() != false) {
                    sessionID = "succeeded";
                    System.out.println("SESSIE ID: "  + sessionID);
                    
                    sessie = new Sessie(sessionID, username);
                    
                    
                    return sessionID;
                    
                    
                    
                } else {
                    errorTextArea.setText("Onjuiste inloginformatie... Probeer opnieuw!");
                }
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

        return null;

    }

    public String generateSessionID() {
        generateSessionID++;
        
        return "xyzzy - session " + generateSessionID;
    }
    
    @Override
    public void setScreenParent(screensController screenParent) {
        myController = screenParent;
    }
    
    @FXML
    private void RegistreerAction(ActionEvent event) {

         myController.loadScreen(BankView.screen3ID, BankView.screen3File);
         myController.setScreen(BankView.screen3ID);
         
    }
            
    @FXML
    private void LoginAction(ActionEvent event) {

        sessionID = authorize();
        
        if (sessionID.contains("succeeded")) {
            
            myController.loadScreen("mainview", "/view/mainview.fxml");
            myController.setScreen(BankView.screen2ID);

        }

    }

//    public String getSessionID() {
//        System.out.println(sessionID);
//        return sessionID;
//    }


}
