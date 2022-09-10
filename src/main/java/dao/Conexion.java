package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    protected static Connection cnx = null;

    public static Connection conectar() throws Exception {

        try {
            String user = "jeansimon";
            String pwd = "123";
            String driver = "oracle.jdbc.OracleDriver";
            String url = "jdbc:oracle:thin:@localhost:1521/XE";
            Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            System.out.println("Que fue con la ConExi�n" + e.getMessage());
        }
        return cnx;
    }

    public static void cerrarCnx() throws Exception {
        if (Conexion.cnx != null) {
            cnx.close();
        }
    }

    public static void main(String[] args) {
        Conexion cones = new Conexion();
        try {

            cones.conectar();
            if (cones.cnx == null) {
                System.out.println("Apagado");
            } else {
                System.out.println("Encendido");
            }

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
