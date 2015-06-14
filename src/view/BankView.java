package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.*;
import internetbankieren.Klanten;
import javafx.scene.Group;

/** Main application class for the login demo application */
public class BankView extends Application {
    
    public static String screen1ID = "login";
    public static String screen1File = "/view/login.fxml";
    public static String screen2ID = "mainview";
    public static String screen2File = "/view/mainview.fxml";
    public static String screen3ID = "registreer";
    public static String screen3File = "/view/registreer.fxml";
    public static String screen4ID = "bankrekening";
    public static String screen4File = "/view/bankrekening.fxml";

  
  
    @Override public void start(Stage primaryStage) throws IOException {
          screensController mainContainer = new screensController();
          
          mainContainer.loadScreen(BankView.screen1ID, BankView.screen1File);
          //mainContainer.loadScreen(BankView.screen2ID, BankView.screen2File);
          mainContainer.loadScreen(BankView.screen3ID, BankView.screen3File);
          mainContainer.loadScreen(BankView.screen4ID, BankView.screen4File);

          mainContainer.setScreen(BankView.screen1ID);

          Group root = new Group();
          root.getChildren().addAll(mainContainer);
          Scene scene = new Scene(root);
          primaryStage.setScene(scene);
          primaryStage.show();  

    }

    /**
       * The main() method is ignored in correctly deployed JavaFX application.
       * main() serves only as fallback in case the application can not be
       * launched through deployment artifacts, e.g., in IDEs with limited FX
       * support. NetBeans ignores main().
       *
       * @param args the command line arguments
       */
    public static void main(String[] args) { 

          launch(args); 

       }
}