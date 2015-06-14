package controller;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import view.BankView;

/** Controls the main application screen */
public class MainViewController implements screenController {
    
    screensController myController;
    Scene scene;
    BankrekeningController bc;
    @FXML
  private Button logoutButton;
    @FXML
  private Label  sessionLabel;
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
 
  }
  
  public void initSessionID(final LoginManager loginManager, String sessionID) {
    sessionLabel.setText(sessionID);
    logoutButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        loginManager.logout();
      }
    });
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
    
  
}