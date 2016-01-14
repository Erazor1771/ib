/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetbankieren;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 310054544
 */
public class testLogin {
        
      // STEP 1: JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/internetbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    
    

    public String testLogin(String username, String wachtwoord) {
        Connection conn = null;
        Statement stmt = null;
        String result ="";
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
            //sql = "SELECT name, city, password FROM klantgegevens";
            // ResultSet rs = stmt.executeQuery(sql);

           // Statement statement = conn.createStatement();
            // statement.executeUpdate("INSERT INTO klantgegevens VALUES ('" + name + "', '" + city + "', '" + password + "')");
            //rs = stmt.executeQuery(sql);
            if (username != null && wachtwoord != null) {
                sql = "SELECT * FROM klant WHERE Naam='" + username + "' and Wachtwoord='" + wachtwoord + "'";

                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next() != false) {

                    int klantID = rs.getInt("KlantID");

                    System.out.println("Inlog success ");
                    result = "ok";

                } else {
                    System.out.println("Onjuiste inloginformatie... Probeer opnieuw!");
                    result = "nietok";
                }
            }

//            for (Klant k : gegevens.getGegevens()) {
//                if (username.equals(k.getName()) && ww.equals(k.getWachtwoord())) {
//                    return generateSessionID();
//                }
//            }
        } catch (SQLException | ClassNotFoundException se) {
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
        return result;
    }
}
