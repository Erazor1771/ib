package controller;

import internetbankieren.Klant;
import internetbankieren.Klanten;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import controller.LoginManager;
import static controller.RegistreerController.JDBC_DRIVER;

/**
 * Controls the login screen
 */
public class LoginController {

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
    private Button btnRegistreer;

    Klanten gegevens;

    LoginManager loginManager;
    @FXML
    private Button loginButton;

    public void initialize() {

    }

    public void initManager(final LoginManager loginManager, Klanten gegevens) {
        this.loginManager = loginManager;
        this.gegevens = gegevens;

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

            String username = user.getText();
            String ww = password.getText();

           // Statement statement = conn.createStatement();
               // statement.executeUpdate("INSERT INTO klantgegevens VALUES ('" + name + "', '" + city + "', '" + password + "')");
            //rs = stmt.executeQuery(sql);

            if (user != null && ww != null) {
                sql = "Select * from klantgegevens Where name ='" + username + "' and password='" + ww + "'";

                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    return generateSessionID();
                } else {
                    System.out.println("Invalid credentials");
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

    private static int sessionID = 0;

    private String generateSessionID() {
        sessionID++;
        return "xyzzy - session " + sessionID;
    }

    @FXML
    private void RegistreerAction(ActionEvent event) {

        this.loginManager.showRegistreer();

    }

    @FXML
    private void LoginAction(ActionEvent event) {

        String sessionID = authorize();

        if (sessionID != null) {
            this.loginManager.authenticated(sessionID);
        }

    }
}
