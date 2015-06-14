/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import internetbankieren.Klant;
import internetbankieren.Klanten;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    /**
     * Initializes the controller class.
     */
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
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
