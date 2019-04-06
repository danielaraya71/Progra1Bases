package Conexiones;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class procedimientos {
    
    //Metodo que llama a procedimiento para agregar cliente a base de datos
        public int AgregarCliente(String primerNombre,String segNombre,String primerApellido,String segApellido,int cedula,int idProvincia,int idCanton,int idDistrito,String correo,int telefono,FileInputStream fotoLicencia){
            Connection entrada= null;
            
            String SSQL = "INSERT INTO cliente (primerNombre, segNombre, primerApellido, segApellido, cedula, idProvincia, idCanton, idDistrito, correo, telefono, fotoLicencia) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            int resultado = 0;
            
            try {
    
                entrada= conexion.establecerConexion();

                PreparedStatement psql = entrada.prepareStatement(SSQL);
                psql.setString(1,primerNombre);
                psql.setString(2,segNombre);
                psql.setString(3,primerApellido);
                psql.setString(4,segApellido);
                psql.setInt(5,cedula);
                psql.setInt(6,idProvincia);
                psql.setInt(7,idCanton);
                psql.setInt(8,idDistrito);
                psql.setString(9,correo);
                psql.setInt(10,telefono);
                psql.setBinaryStream(11,fotoLicencia);               

                resultado = psql.executeUpdate();

                psql.close();

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información:\n"
                                             + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);

            }finally{

                try {

                    if(entrada!=null){

                        entrada.close();

                    }

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                                             + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);

                }
            }
            return resultado;
    }
        
        public int AgregarLicencia(int numeroLicencia,int cedula,int idTipoLicencia,String fEmision,String fExpiracion,FileInputStream fotoLicencia){
            Connection entrada= null;
            
            String SSQL = "INSERT INTO licencia (numeroLicencia, cedula, idTipoLicencia, fEmision, fExpiracion, imagen) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
            
            int resultado = 0;
            
            try {
    
                entrada= conexion.establecerConexion();

                PreparedStatement psql = entrada.prepareStatement(SSQL);
                psql.setInt(1,numeroLicencia);
                psql.setInt(2,cedula);
                psql.setInt(3,idTipoLicencia);
                psql.setString(4,fEmision);
                psql.setString(5,fExpiracion);
                psql.setBinaryStream(6,fotoLicencia);               

                resultado = psql.executeUpdate();

                psql.close();

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información:\n"
                                             + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);

            }finally{

                try {

                    if(entrada!=null){

                        entrada.close();

                    }

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                                             + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);

                }
            }
            return resultado;
        }
        
        //Metodo que hace la insercion de una empresa en SQL
        public int AgregarEmpresa(String razonSocial,int cedulaJuridica,int telefono,int idProvincia,int idCanton,int idDistrito,String senias){
            Connection entrada= null;

            String SSQL = "INSERT INTO empresa (razonSocial, cedulaJuridica, telefono, idProvincia, idCanton, idDistrito, senias) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            int resultado = 0;

            try {
                entrada= conexion.establecerConexion();

                PreparedStatement psql = entrada.prepareStatement(SSQL);
                psql.setString(1,razonSocial);//
                psql.setInt(2,cedulaJuridica);
                psql.setInt(3,telefono);
                psql.setInt(4,idProvincia);
                psql.setInt(5,idCanton);
                psql.setInt(6,idDistrito);
                psql.setString(7,senias);          

                resultado = psql.executeUpdate();

                psql.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información:\n"
                                             + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }finally{

                try {

                    if(entrada!=null){

                        entrada.close();

                    }

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                                             + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
                }
            }
            return resultado;
        }

        public int AgregarMantenimiento(int placa,int idServicio,int cedulaJuridica,int idTipo,String fInicio,String fFinal,int monto,String detalle){
            Connection entrada= null;

            String SSQL = "INSERT INTO mantenimiento (placa, idServicio, cedulaJuridica, idTipo,fInicio, fFinal, monto, detalle) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            int resultado = 0;

            try {
                entrada= conexion.establecerConexion();

                PreparedStatement psql = entrada.prepareStatement(SSQL);
                psql.setInt(1,placa);//
                psql.setInt(2,idServicio);
                psql.setInt(3,cedulaJuridica);
                psql.setInt(4,idTipo);
                psql.setString(5,fInicio);
                psql.setString(6,fFinal);
                psql.setInt(7,monto); 
                psql.setString(8, detalle);

                resultado = psql.executeUpdate();

                psql.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información:\n"
                                             + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }finally{

                try {

                    if(entrada!=null){

                        entrada.close();

                    }

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                                             + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
                }
            }
            return resultado;
    }
}