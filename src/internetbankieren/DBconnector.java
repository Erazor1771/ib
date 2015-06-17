/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetbankieren;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 310054544
 */
public class DBconnector {

    // STEP 1: JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/internetbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    private static Connection conn;
    private static Bankrekeningen rekeningen = new Bankrekeningen();

    public Connection getConn() {
        return conn;
    }

    public DBconnector() {
        
        rekeningen = new Bankrekeningen();

        try {
            // laad driver
            //Class.forName("org.apache.derby.jdbc.ClientDriver");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnector.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException ex) {
            Logger.getLogger(DBconnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void loadKlantInformation(String userName) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = DBconnector.getConnection();
            //STEP 2: Register JDBC driver
//            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM klant WHERE Naam ='" + userName + "'";
            rs = stmt.executeQuery(sql);
            Statement statement = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                //Retrieve by column name
                String naam = rs.getString("Naam");
                String woonplaats = rs.getString("Woonplaats");

                //naamLabel.setText(naam);
                //woonplaatsLabel.setText(woonplaats);
            } else {
                System.out.println("Invalid credentials");
            }

//            for (Klant k : gegevens.getGegevens()) {
//                if (username.equals(k.getName()) && ww.equals(k.getWachtwoord())) {
//                    return generateSessionID();
//                }
//            }
        } catch (SQLException se) {
        } finally {
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
            }//end finally try

        }
    }

    public static List<Klant> getAllPersoon() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Klant> lijst = new ArrayList<Klant>();
        try {

            conn = DBconnector.getConnection();
            // haal alle records op

            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM klant";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String naam = rs.getString("Naam");
                String stad = rs.getString("Woonplaats");
                String ww = rs.getString("Wachtwoord");
                int klantID = rs.getInt("KlantID");
                String bankID = rs.getString("KlantID");
                // maak nieuw persoonobject
                Klant newPersoon = new Klant(naam, stad, ww, klantID, bankID);
                // voeg toe aan lijst
                lijst.add(newPersoon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBconnector.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
            }//end finally try

        }
        return lijst;
    }

//    public static List<Bankrekening> getAllRekeningen() {
//        //public static void getAllRekeningen() {
//
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        List<Bankrekening> lijst = new ArrayList<Bankrekening>();
//        try {
//
//            conn = DBconnector.getConnection();
//            // haal alle records op
//
//            stmt = conn.createStatement();
//            String sql;
//
//            sql = "SELECT * FROM bankrekening";
//            rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                int reknummer = rs.getInt("Rekeningnummer");
//                double saldo = rs.getDouble("Saldo");
//                //String ww = rs.getString("Wachtwoord");
//                int klantID = rs.getInt("KlantID");
//                double kredietLimiet = rs.getDouble("Kredietlimiet");
//                // maak nieuw persoonobject
//                Bankrekening newRekening = new Bankrekening(reknummer, saldo, klantID, kredietLimiet);
//                // voeg toe aan lijst
//
//                lijst.add(newRekening);
//                rekeningen.addBankrekening(newRekening);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DBconnector.class.getName()).log(Level.SEVERE, null, ex);
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
//       return lijst;
//    }
//    
    
    
//    public static List loadCBItems(String userName)
//    {
//        List<Integer> list = new ArrayList<Integer>();
//          Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//
//            conn = DBconnector.getConnection();
//
//            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
//
//            stmt = conn.createStatement();
//            String sql;
//
//            sql = "SELECT * FROM klant WHERE Naam ='" + userName + "'";
//
//            Statement statement = conn.createStatement();
//            rs = stmt.executeQuery(sql);
//            if (rs.next()) {
//                System.out.println("USERNAME: " + userName);
//                int klantID = rs.getInt("KlantID");
//                sql = "SELECT * FROM bankrekening WHERE KlantID ='" + klantID + "'";
//                statement = conn.createStatement();
//                rs = stmt.executeQuery(sql);
//
//                while (rs.next()) {
//                    int reknummer = rs.getInt("Rekeningnummer");
//                    System.out.println("REKNUMMERS: " + reknummer);
//                    list.add(reknummer);
//                }
//
//            } else {
//                System.out.println("No Success");
//            }
//
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            //System.out.println(gegevens.getKlanten().toString());
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
//                se.printStackTrace();
//            }//end finally try
//        }
//        
//        return list;
//    }
    
    private static void transactie(double bedrag, int vanRekening, int naarRekening)
    {
        
  

            
        
    }

}
