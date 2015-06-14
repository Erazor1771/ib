package controller;

import controller.RegistreerController;
import controller.MainViewController;
import controller.LoginController;
import internetbankieren.Klant;
import internetbankieren.Klanten;
import java.io.IOException;
import java.util.logging.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.Pane;

/** Manages control flow for logins */
public class LoginManager {
  private Scene scene;
  private static LoginManager instance;
  private Klanten klanten;

  public LoginManager(Scene scene) {
    this.scene = scene;
    this.klanten = new Klanten();
    
    Klant tarkan = new Klant("tarkan", "boz", "123");
    klanten.addKlant(tarkan);
    
   
  }

    public static LoginManager getInstance() {
        return instance;
    }
  
 
}
