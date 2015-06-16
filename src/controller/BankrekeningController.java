/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.RegistreerController.JDBC_DRIVER;
import internetbankieren.Bankrekening;
import internetbankieren.Bankrekeningen;
import internetbankieren.Klant;
import internetbankieren.Klanten;
import internetbankieren.Sessie;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.BankView;

/**
 * FXML Controller class
 *
 * @author lars
 */
public class BankrekeningController implements Initializable, screenController {
    
    screensController myController;
    
    // STEP 1: JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/internetbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    private static int banknummerid = 100000000;
    Bankrekeningen bankrekeningen = new Bankrekeningen();
    private int klantID;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField bankrekeningNummerField;
    @FXML
    private TextField klantField;
    @FXML
    private TextField saldoField;
    @FXML
    private TextField kredietlimietField;
    MainViewController mv = new MainViewController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        banknummerid++;
        String tempUser = Sessie.getUserName();
        bankrekeningNummerField.setText(Integer.toString(banknummerid));
        klantField.setText(tempUser);
    }    

    @FXML
    private void maakBankrekening(ActionEvent event) {
        
        String userName = Sessie.getUserName();
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
            
            int bankrekeningnummer = Integer.parseInt(bankrekeningNummerField.getText());
            Klant k = null;
            int saldo = Integer.parseInt(saldoField.getText());
            int kredietlimiet = Integer.parseInt(kredietlimietField.getText());
            
            
            Bankrekening br = new Bankrekening(bankrekeningnummer, saldo,k, kredietlimiet);
            System.out.println(br.toString());
 
            bankrekeningen.addBankrekening(br);
            
            if (bankrekeningen.getSize() > 0){
                
                System.out.println(bankrekeningen.getBankrekeningen().toString());
                System.out.println("Success");

                stmt = conn.createStatement();
                String sql;


                sql = "SELECT * FROM klant WHERE Naam ='" + userName + "'";
                ResultSet rs;
                Statement statement = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    System.out.println("USERNAME: " + userName);
                    int klantID = rs.getInt("KlantID");
                    System.out.println("KLANT ID: " + klantID);
                    System.out.println("BANKREKENING NR: " + bankrekeningnummer);
                    System.out.println("SALDO: " + saldo);
                    System.out.println("KREDIETLIMIET: " + kredietlimiet);
                    statement = conn.createStatement();
                    //String testSql = ("INSERT INTO klantgegevens VALUES ('" + name + "', '" + city + "', '" + password + "')");
                    statement.executeUpdate("INSERT INTO bankrekening (KlantID, Rekeningnummer, Saldo, Kredietlimiet) VALUES ('" + klantID + "','" + bankrekeningnummer + "','" + saldo + "', '" + kredietlimiet + "')");

                    rs = stmt.executeQuery(sql);
                }
               
                //System.out.println(gegevens.getGegevens().toString());
                
                myController.loadScreen("mainview", "/view/mainview.fxml");
                myController.setScreen(BankView.screen2ID);
                
                
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
    }
    
    @Override
    public void setScreenParent(screensController screenParent) {
        myController = screenParent;
    }
    
    @FXML
    private void goBackToMainView(ActionEvent event) {
        myController.setScreen(BankView.screen2ID);
    }
}
