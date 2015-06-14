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
  
  

  /**
   * Callback method invoked to notify that a user has been authenticated.
   * Will show the main application screen.
   */ 
  public void authenticated(String sessionID) {
    showMainView(sessionID);
  }
  

  /**
   * Callback method invoked to notify that a user has logged out of the main application.
   * Will show the login application screen.
   */ 
  public void logout() {
    showLoginScreen();
  }
  
  public void showLoginScreen() {
    try {
      FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/view/login.fxml")
      );
      scene.setRoot((Parent) loader.load());
      LoginController controller = 
        loader.<LoginController>getController();
      controller.initManager(this, klanten);
    } catch (IOException ex) {
        System.out.println("Show login screen not working...");
    }
  }

  private void showMainView(String sessionID) {
    try {
      FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/view/mainview.fxml")
      );
      scene.setRoot((Parent) loader.load());
      MainViewController controller = 
        loader.<MainViewController>getController();
      controller.initSessionID(this, sessionID);
    } catch (IOException ex) {
        System.out.println("Show main view not working...");
    }
  }
  
    public void showRegistreer() {
    try {
      FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/view/registreer.fxml")
      );
      scene.setRoot((Parent) loader.load());
      RegistreerController controller = 
        loader.<RegistreerController>getController();
      controller.session(this, klanten);
    } catch (IOException ex) {
        System.out.println("Show registreer not working...");
    }
  }
    

}
