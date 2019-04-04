package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class conexion {
    
    static Connection conexion=null;
    
    //Metodo para establecer conexion con la base de datos
    public static Connection establecerConexion(){
       // revisar con el video
       // URL MARIA JOSE: jdbc:sqlserver://DESKTOP-E051GG3\SQLEXPRESS:1433;databaseName=rent_a_car
       // URL DANIEL: jdbc:sqlserver://LAPTOP-VB4EU9DH\\SQLEXPRESS:1433;databaseName=rent_a_car
       String url= "jdbc:sqlserver://DESKTOP-E051GG3\\SQLEXPRESS:1433;databaseName=rent_a_car"; //ESTA ES LA URL DE LA BASE DE DATOS, CAMBIA EN CADA COMPUTADORA
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             System.out.println("HACE EL TRY DE LINEA 21");
        }
        catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"No se pudo realizar conexion, revisar drive" + e.getMessage(),
            "Error de conexion",JOptionPane.ERROR_MESSAGE);
        }
        try{
            conexion= DriverManager.getConnection(url,"sa","sa");// LOS PARAMETROS DE LA getConnection son usuario sa y la contrasenia que hayan puesto
            System.out.println("HACE EL TRY DE LINEA 29");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error" + e.getMessage(),
            "Error de conexion",JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
    
    //Metodo para realizar una consulta a la base de datos
    public static ResultSet Consulta(String consulta){
        Connection conexion=establecerConexion();
        Statement declaracion;
        try{
            System.out.println("HACE EL TRY DE LINEA 43");
            declaracion=conexion.createStatement();
            ResultSet respuesta= declaracion.executeQuery(consulta);
            return respuesta;
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la consulta" + e.getMessage(),
            "Error de conexion",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public conexion(conexion objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //hay que ver si funcion sino se borra

 
    

}
