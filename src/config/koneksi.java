package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class koneksi {
    private static Connection connection;
    
    public static Connection getConnection(){
        if (connection==null) {
            try {
                String url = "jdbc:mysql://localhost:3306/siswa";
                String user ="root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);     
            }
        }
        return connection;
    }
}
