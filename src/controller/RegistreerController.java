/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import internetbankieren.Klant;
import internetbankieren.Klanten;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import controller.LoginManager;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import view.BankView;

/**
 * FXML Controller class
 *
 * @author 310054544
 */
public class RegistreerController implements screenController {
    
    screensController myController;
    
    // STEP 1: JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/internetbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    @FXML
    private Button btnRegistreren;
    @FXML
    private PasswordField txtFieldPassword;
    @FXML
    private TextField txtFieldNaam;
    @FXML
    private TextField txtFieldCity;
    @FXML
    private ComboBox bankKeuzeCombo;
    @FXML
    private Button btnGoBack;

    private LoginManager instance;

    private Klanten gegevens;
    private List<Klant> lijst;
    @FXML
    private TextField txtKlantID;

    public RegistreerController(){
        this.gegevens = new Klanten();
    }
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
            List<String> list = new ArrayList<String>();
            list.add("ABN");
            list.add("ING");
            list.add("PAYPAL");
            ObservableList obList = FXCollections.observableList(list);
            bankKeuzeCombo.getItems().clear();
            bankKeuzeCombo.setItems(obList);
    }

    public void session(final LoginManager loginManager, Klanten gegevens) {

        this.instance = loginManager;
        this.gegevens = gegevens;

    }
    
    @FXML
    public List RegistrerenAction(ActionEvent event) {

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

            String BankID = bankKeuzeCombo.getSelectionModel().getSelectedItem().toString();
            String naam = txtFieldNaam.getText();
            String woonplaats = txtFieldCity.getText();
            String wachtwoord = txtFieldPassword.getText();
            int klantID = Integer.parseInt(txtKlantID.getText());
            
            

            Klant newKlant = new Klant(naam, woonplaats, wachtwoord, klantID, BankID);
            
            if (gegevens.AddCustomer(newKlant)) {
                
                System.out.println("Success");

                Statement statement = conn.createStatement();
                //String testSql = ("INSERT INTO klantgegevens VALUES ('" + name + "', '" + city + "', '" + password + "')");
                statement.executeUpdate("INSERT INTO klant (BankID, Naam, Woonplaats, Wachtwoord) VALUES ('" + BankID + "','" + naam + "','" + woonplaats + "', '" + wachtwoord + "')");

                rs = stmt.executeQuery(sql);
                System.out.println(gegevens.getGegevens().toString());
                
                myController.loadScreen("login", "/view/login.fxml");
                myController.setScreen(BankView.screen1ID);
                
                return gegevens.getGegevens();
                
            } else {
                System.out.println("No Success");
            }

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
        return null;
    }

    @Override
    public void setScreenParent(screensController screenParent) {
        myController = screenParent;
    }

    @FXML
    private void goBackToLogin(ActionEvent event) {

        myController.setScreen(BankView.screen1ID);

    }
    
}
