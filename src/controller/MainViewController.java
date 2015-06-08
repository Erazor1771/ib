package controller;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import controller.LoginManager;

/** Controls the main application screen */
public class MainViewController {
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
}