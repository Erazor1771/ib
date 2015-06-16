package controller;

import internetbankieren.Bank;
import internetbankieren.DBconnector;
import internetbankieren.Klant;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import internetbankieren.Klanten;
import internetbankieren.Sessie;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import view.BankView;

/**
 * Controls the main application screen
 */
public class MainViewController implements screenController {

    screensController myController;
    LoginController lc = new LoginController();
    RegistreerController rc = new RegistreerController();
    Klanten klanten = new Klanten();
    Sessie sessie;

    // STEP 1: JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/internetbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    private int rekeningnummer;

    @FXML
    private Button logoutButton;
    @FXML
    private Label sessionLabel;
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
    @FXML
    private ComboBox rekeningenCombo;

    private Bank bank;
    private DBconnector dbconnector;
    private List<Klant> lijst;

    public void initialize() {
        sessionLabel.setText(lc.generateSessionID());
        System.out.println(klanten.getKlanten().size());

        String tempUser = Sessie.getUserName();

        this.loadKlantInformation(tempUser);
        this.loadBankrekeningInformation(tempUser);

        // TODO: For Loop voor alle rekeningen bij klant (nu gewoon 1 rekening max tonen)
        this.loadComboBoxItems();
        bank = new Bank("ABN");

       


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

        myController.loadScreen(BankView.screen4ID, BankView.screen4File);
        myController.setScreen(BankView.screen4ID);

    }

    public void loadBankrekeningInformation(String userName) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

      

            conn = DBconnector.getConnection();
            
            lijst = DBconnector.getAllPersoon();
            
                   for (Klant k : lijst) {
            if (k.getName().equals(userName)) {
                
       
            }

        }
            
            
            
            //STEP 2: Register JDBC driver
//            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;

//            sql = "SELECT * FROM klant WHERE Naam ='" + userName + "'";

//            Statement statement = conn.createStatement();
//            rs = stmt.executeQuery(sql);
//            if (rs.next()) {
//                System.out.println("USERNAME: " + userName);
//                int klantID = rs.getInt("KlantID");
//                System.out.println("KLANT ID: " + klantID);
//
//                sql = "SELECT * FROM bankrekening WHERE KlantID ='" + klantID + "'";
//                rs = stmt.executeQuery(sql);
//                statement = conn.createStatement();
//                rs = stmt.executeQuery(sql);

//                if (rs.next()) {
//                    //Retrieve by column name
//                    String saldo = rs.getString("Saldo");
//                    String kredietlimiet = rs.getString("Kredietlimiet");
//                    int reknummer = rs.getInt("Rekeningnummer");
//
//                    rekeningnummer = reknummer;
//                    System.out.println("REKENING NUMMER: " + reknummer);
//
//                    saldoLabel.setText(saldo);
//                    kredietlimietLabel.setText(kredietlimiet);
//
//                } else {
//                    System.out.println("Invalid credentials");
//                }
//            }
//        } catch (SQLException se) {
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }//end finally try
//
//        }
    }

    /**
     * Get Klant Information for MainViewController
     */
    private void loadKlantInformation(String userName) {

        //DBconnector.loadKlantInformation(userName);
        DBconnector.getConnection();

        lijst = DBconnector.getAllPersoon();

        for (Klant k : lijst) {
            if (k.getName().equals(userName)) {
                naamLabel.setText(k.getName());
                woonplaatsLabel.setText(k.getCity());
                break;
            }

        }

//          Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        try {
//
//            conn = DBconnector.getConnection();
//            //STEP 2: Register JDBC driver
////            Class.forName(JDBC_DRIVER);
//
//            //STEP 3: Open a connection
////            System.out.println("Connecting to database...");
////            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//
//            sql = "SELECT * FROM klant WHERE Naam ='" + userName + "'";
//            rs = stmt.executeQuery(sql);
//            Statement statement = conn.createStatement();
//            rs = stmt.executeQuery(sql);
//
//            if (rs.next()) {
//                //Retrieve by column name
//                String naam = rs.getString("Naam");
//                String woonplaats = rs.getString("Woonplaats");
//
//                naamLabel.setText(naam);
//                woonplaatsLabel.setText(woonplaats);
//
//            } else {
//                System.out.println("Invalid credentials");
//            }
//
////            for (Klant k : gegevens.getGegevens()) {
////                if (username.equals(k.getName()) && ww.equals(k.getWachtwoord())) {
////                    return generateSessionID();
////                }
////            }
//        } catch (SQLException se) {
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }//end finally try
//        }
    }

    public void loadComboBoxItems() {
        // Load ComboBox Rekeningen
        List<Integer> list = new ArrayList<Integer>();

        String userName = Sessie.getUserName();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //STEP 2: Register JDBC driver
            //Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            //System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn = DBconnector.getConnection();

            //STEP 4: Execute a query
            System.out.println("Creating statement...");

            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM klant WHERE Naam ='" + userName + "'";

            Statement statement = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println("USERNAME: " + userName);
                int klantID = rs.getInt("KlantID");
                sql = "SELECT * FROM bankrekening WHERE KlantID ='" + klantID + "'";
                statement = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int reknummer = rs.getInt("Rekeningnummer");
                    System.out.println("REKNUMMERS: " + reknummer);
                    list.add(reknummer);
                }

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

        ObservableList obList = FXCollections.observableList(list);
        rekeningenCombo.getItems().clear();
        rekeningenCombo.setItems(obList);
        rekeningenCombo.getSelectionModel().selectFirst();
    }

    @FXML
    private void cbRekeningenAction(ActionEvent event) {

        getCBValue();

    }

    @FXML
    private void btnTransferAction(ActionEvent event) {

        double bedrag = Double.parseDouble(txtFieldBedrag.getText());

        int naarRekening = Integer.parseInt(txtFieldTegenRekening.getText());
        int vanRekening = Integer.parseInt(rekeningenCombo.getSelectionModel().getSelectedItem().toString());

        bank.transactieUitvoeren(vanRekening, naarRekening, bedrag);

        getCBValue();

    }

    private void getCBValue() {

        String selected = rekeningenCombo.getSelectionModel().getSelectedItem().toString();

        updateSaldo(selected);
    }

    private void updateSaldo(String selected) {

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

            sql = "SELECT * FROM bankrekening WHERE Rekeningnummer ='" + selected + "'";
            ResultSet rs;
            Statement statement = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {

                String saldo = rs.getString("Saldo");
                String kredietlimiet = rs.getString("Kredietlimiet");

                saldoLabel.setText(saldo);
                kredietlimietLabel.setText(kredietlimiet);

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

}
