package Conexiones;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
//Librerias que nos proporciona ITEXT
//que son necesarias para crear el pdf


import com.itextpdf.text.DocumentException;//se encarga
//de capturar los posibles errores..

import com.itextpdf.text.Paragraph;//hace referencia a
//un parrafo,

import com.itextpdf.text.pdf.PdfWriter; //contiene el
//codigo necesario para crear un archivo PDF

import com.itextpdf.text.pdf.PdfPTable; //contiene el
import java.util.Date;
//codigo necesario para tabular un archivo PDF


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
        //Metodo que agrega licencia
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
        
        //Metodo que realiza la insercion de los datos en la base de datos
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
        
        //Metodo que realiza la insercion de vehiculos en base de datosz
        public int AgregarVehiculo(int placa,int anioFabricacion,int idEstilo,int idColor,int idMarca,int idSede,int idTransmision,int idEstado,int capacidad,
                int kilometraje,int puertas,int vin,int mpg,int costo_dia,int capacidadMaletas,FileInputStream fotoVehiculo){
            Connection entrada= null;

            String SSQL = "INSERT INTO vehiculo (placa, anioFabricacion, idEstilo, idColor, idMarca, idSede, idTransmision, idEstado, capacidad, kilometraje,"
                    + "puertas, vin, mpg, costo_dia, capacidadMaletas, fotoVehiculo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            int resultado = 0;

            try {
                entrada= conexion.establecerConexion();

                PreparedStatement psql = entrada.prepareStatement(SSQL);
                psql.setInt(1,placa);//
                psql.setInt(2, anioFabricacion);
                psql.setInt(3, idEstilo);
                psql.setInt(4, idColor);
                psql.setInt(5, idMarca);
                psql.setInt(6, idSede);
                psql.setInt(7, idTransmision);
                psql.setInt(8, idEstado);
                psql.setInt(9, capacidad);
                psql.setInt(10, kilometraje);
                psql.setInt(11, puertas);
                psql.setInt(12, vin);
                psql.setInt(13, mpg);
                psql.setInt(14, costo_dia);
                psql.setInt(15, capacidadMaletas);
                psql.setBinaryStream(16, fotoVehiculo);

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
        
        //Metodo que inserta reserva en base de datos
        public int AgregarReserva(int idReserva,int cedula,int placa,int idSedeRecogida,int idSedeEntrega,String fInicio, String fFin, String fSolicitud,
                String usuario,int idWifi,int idAsistencia,int idGPS,int idAsientoNinio,int idDanio){
            Connection entrada= null;

            String SSQL = "INSERT INTO reserva (idReserva,cedula,placa,idSedeRecogida,idSedeEntrega,fInicio,fFin,fSolicitud,usuario,idWifi,idAsistencia,"
                    + "idGPS,idAsientoNinio,idDanio) "+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            int resultado = 0;

            try {
                entrada= conexion.establecerConexion();

                PreparedStatement psql = entrada.prepareStatement(SSQL);
                psql.setInt(1, idReserva);//
                psql.setInt(2, cedula);
                psql.setInt(3, placa);
                psql.setInt(4, idSedeRecogida);
                psql.setInt(5, idSedeEntrega);
                psql.setString(6, fInicio);
                psql.setString(7, fFin);
                psql.setString(8, fSolicitud);
                psql.setString(9, usuario);
                psql.setInt(10, idWifi);
                psql.setInt(11, idAsistencia);
                psql.setInt(12, idGPS);
                psql.setInt(13, idAsientoNinio);
                psql.setInt(14, idDanio);

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
        
    //Metodo que llama a procedimiento para agregar operador a base de datos
        public int AgregarOperador(String usuario,String contrasenia){
            Connection entrada= null;
            
            String SSQL = "INSERT INTO operador (usuario, contrasenia) "
            + "VALUES (?, ?)";
            
            int resultado = 0;
            
            try {
    
                entrada= conexion.establecerConexion();

                PreparedStatement psql = entrada.prepareStatement(SSQL);
                psql.setString(1,usuario);
                psql.setString(2,contrasenia);             

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
        
        // metodo para agregar nuevos operadores a la base de datos
        public int ModificarVehiculo(int placa,int anioFabricacion,int idEstilo,int idColor,int idMarca,int idSede,int idTransmision,int idEstado,int capacidad,
                int kilometraje,int puertas,int vin,int mpg,int costo_dia,int capacidadMaletas,FileInputStream fotoVehiculo){
            Connection entrada= null;

            String SSQL = "UPDATE vehiculo set anioFabricacion="+anioFabricacion+", idEstilo="+idEstilo+", idColor="+idColor+", idMarca="+idMarca
                    +", idSede="+idSede+", idTransmision="+idTransmision+", idEstado="+idEstado+", capacidad="+capacidad+", kilometraje="
                    +kilometraje+", puertas="+puertas+", vin="+vin+", mpg="+mpg+", costo_dia="+costo_dia+", capacidadMaletas="+capacidadMaletas+
                    ", fotoVehiculo='"+fotoVehiculo+"' where placa="+placa;

            int resultado = 0;

            try {
                entrada= conexion.establecerConexion();

                PreparedStatement psql = entrada.prepareStatement(SSQL);

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