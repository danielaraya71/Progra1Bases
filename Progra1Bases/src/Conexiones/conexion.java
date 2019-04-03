package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class conexion {
    
    static Connection conexion=null;
    
    public static Connection establecerConexion(){
        String url= "jdbc:sqlserver://LAPTOP-VB4EU9DH\\SQLEXPRESS:1433;databaseName=rent_a_car"; //ESTA ES LA URL DE LA BASE DE DATOS, CAMBIA EN CADA COMPUTADORA
    }
}
