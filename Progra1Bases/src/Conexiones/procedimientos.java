package Conexiones;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class procedimientos {
    
    public static void AgregarCliente(String primerNombre,String segNombre,String primerApellido,String segApellido,int cedula,int idProvincia,int idCanton,int idDistrito,String correo,int telefono,String fotoLicencia)throws SQLException{
        CallableStatement entrada= conexion.establecerConexion().prepareCall("(call AgregarCliente(?,?,?,?,?,?,?,?,?,?,?))");
        entrada.setString(1,primerNombre);//
        entrada.setString(2,segNombre);
        entrada.setString(3,primerApellido);
        entrada.setString(4,segApellido);
        entrada.setInt(5,cedula);
        entrada.setInt(6,idProvincia);
        entrada.setInt(7,idCanton);
        entrada.setInt(8,idDistrito);
        entrada.setString(9,correo);
        entrada.setInt(10,telefono);
        entrada.setString(11,fotoLicencia);
        entrada.execute();
    }
}
