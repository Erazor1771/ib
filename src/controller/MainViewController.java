package controller;

import internetbankieren.Klanten;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import view.BankView;

/** Controls the main application screen */
public class MainViewController implements screenController {
    
    screensController myController;
    LoginController lc = new LoginController();
    

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
        naamLabel.setText("<Naam>");
        woonplaatsLabel.setText("<Woonplaats>");
        saldoLabel.setText("<Saldo>");
        kredietlimietLabel.setText("<Kredietlimiet>");
    }
    
}