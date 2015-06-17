package controller;

import internetbankieren.Bank;
import internetbankieren.Bankrekening;
import internetbankieren.Bankrekeningen;
import client.Bankclientcontroller;
import internetbankieren.DBconnector;
import internetbankieren.Klant;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import internetbankieren.Klanten;
import internetbankieren.Sessie;
import internetbankieren.Transactie;
import java.io.IOException;
import java.net.Socket;
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
    private List<Klant> Klantenlijst;
    private List<Bankrekening> rekeningenLijst;
    private Bankclientcontroller bankclientcontroller;

    public void initialize() throws IOException {
        sessionLabel.setText(lc.generateSessionID());
        System.out.println(klanten.getKlanten().size());

        String tempUser = Sessie.getUserName();
        int tempKlantID = Sessie.getKlantID();

        this.loadKlantInformation(tempUser);
        this.loadBankrekeningInformation(tempKlantID);

        // TODO: For Loop voor alle rekeningen bij klant (nu gewoon 1 rekening max tonen)
        this.loadComboBoxItems();
        bank = new Bank("ABN");
        bankclientcontroller = new Bankclientcontroller(this);
        
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

    public void loadBankrekeningInformation(int klantID) {

//////  
//       rekeningenLijst = DBconnector.getAllRekeningen();
////        
//////        DBconnector.getAllRekeningen();
//////        bankclientcontroller.selectRekeningen(klantID);
////
//        for (Bankrekening rek : rekeningenLijst) {
//
//            if (rek.getKlantID() == klantID) {
//
//                rekeningnummer = rek.getNummer();
//                saldoLabel.setText(String.valueOf(rek.getSaldo()));
//                kredietlimietLabel.setText(String.valueOf(rek.getKredietlimiet()));
//
//            }
//
//        }

    }

    /**
     * Get Klant Information for MainViewController
     */
    private void loadKlantInformation(String userName) {

        DBconnector.loadKlantInformation(userName);
        DBconnector.getConnection();
        Klantenlijst = DBconnector.getAllPersoon();

        for (Klant k : Klantenlijst) {
            if (k.getName().equals(userName)) {
                naamLabel.setText(k.getName());
                woonplaatsLabel.setText(k.getCity());
                break;
            }

        }

    }

    public void loadComboBoxItems() {
        // Load ComboBox Rekeningen
        List<Integer> list = new ArrayList<Integer>();

        String user = Sessie.getUserName();

        list = DBconnector.loadCBItems(user);

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

       rekeningenLijst = DBconnector.getAllRekeningen();
        //DBconnector.getAllRekeningen();
        

        for (Bankrekening rek : rekeningenLijst) {

            if (String.valueOf(rek.getNummer()).equals(selected)) {

                saldoLabel.setText(String.valueOf(rek.getSaldo()));
                kredietlimietLabel.setText(String.valueOf(rek.getKredietlimiet()));

            }

        }

    }
    
    public void setRekeningen(Bankrekening rekeningen)
    {
        rekeningenLijst = (List<Bankrekening>) rekeningen;
    }
}
