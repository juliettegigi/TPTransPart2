/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tptranspart2.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author julie
 */
public class Conexion {

    final static String URL = "jdbc:mariadb://localhost/universidadGp8";
    final static String USER = "root";
    final static String PASS = "";

    private static Connection con;

    private Conexion() {

    }

    public static Connection getConexion() {

        if (con == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("me conecté");
            } catch (ClassNotFoundException e1) {
                System.out.println("problema con el driver");
                e1.printStackTrace();
            } catch (SQLException e) {
                System.out.println("error de conexión");
                e.printStackTrace();
            }
        }

        return con;// retorno null si no me conecto 
        // sino la conexión

    }
}
