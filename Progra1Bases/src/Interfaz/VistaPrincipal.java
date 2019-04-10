package Interfaz;

import Conexiones.*; 
import static Conexiones.conexion.Consulta;
import Extras.SendEmail;
import Objetos.*;
import java.io.*;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;//contiene opciones para formato de nuestro documento como el tamaño de la pagina entre otras.
import com.itextpdf.text.DocumentException; //se encarga de capturar los posibles errores..
import com.itextpdf.text.pdf.PdfPTable; //contiene el codigo necesario para tabular un archivo PDF
import com.itextpdf.text.pdf.PdfWriter; // //contiene el codigo necesario para crear un archivo PDF
import java.awt.HeadlessException;
import java.util.Random;


public class VistaPrincipal extends javax.swing.JFrame {
    
    
    static ResultSet res;

    public VistaPrincipal() {
        initComponents();
    }
        public void CargarTipoLicencia () {
           jComboBoxTipoLicencia.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombreTipoLicencia from tipoLicencia");
           try {
               while (res.next()){
                    jComboBoxTipoLicencia.addItem(res.getString("nombreTipoLicencia"));
                }
           }   
                catch (Exception e) {
                   }
           }
              
       public void CargarEmpresa () {
           jComboBoxEscogerEmpresa.removeAllItems();
           res =Conexiones.conexion.Consulta("select razonSocial from empresa");
           try {
               while (res.next()){
                    jComboBoxEscogerEmpresa.addItem(res.getString("razonSocial"));
                }
           }   
                catch (Exception e) {
                   }
           }
       
        public void CargarPlaca () {
           jComboBoxEscogerPlaca.removeAllItems();
           res =Conexiones.conexion.Consulta("select placa from vehiculo");
           try {
               while (res.next()){
                    jComboBoxEscogerPlaca.addItem(res.getString("placa"));
                }
           }   
                catch (Exception e) {
                }
        }
        
         public void CargarMantenimiento () {
           jComboBoxtipoMantenimiento.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombreTipo from tipo");
           try {
               while (res.next()){
                    jComboBoxtipoMantenimiento.addItem(res.getString("nombreTipo"));
                }
           }   
                catch (Exception e) {
                   }
           }
         
          public void CargarProvincia () {
           jComboBoxtProvinciaEmpresa.removeAllItems();
           jComboBoxtProvinciaCliente.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombreProvincia from provincia");
           try {
               while (res.next()){
                    jComboBoxtProvinciaEmpresa.addItem(res.getString("nombreProvincia"));
                    jComboBoxtProvinciaCliente.addItem(res.getString("nombreProvincia"));
                }
               
           }   
                catch (Exception e) {
                   }
           }
          
          //Metodo que carga el canton correspondiente en el registro de la empresa
           public void CargarCantonE() {
           jComboBoxCatonEmpresa.removeAllItems();
           String provincia = (jComboBoxtProvinciaEmpresa .getSelectedItem().toString());
           String cantones;
           cantones = "select nombre_canton from provincia join canton on "
                    + "provincia.idProvincia=canton.idProvincia AND nombreProvincia='"+provincia+"'";
           res =Conexiones.conexion.Consulta(cantones);
           
           try {
               while (res.next()){
         
                    jComboBoxCatonEmpresa.addItem(res.getString("nombre_canton"));
                }
           }   
                catch (Exception e) {
                   }
           }
           
           //Metodo que carga el canton correspondiente en el registro del cliente
          public void CargarCantonC() {
           jComboBoxCatonCliente.removeAllItems();
           String provincia = (jComboBoxtProvinciaCliente .getSelectedItem().toString());
           String cantones;
           cantones = "select nombre_canton from provincia join canton on "
                    + "provincia.idProvincia=canton.idProvincia AND nombreProvincia='"+provincia+"'";
           res =Conexiones.conexion.Consulta(cantones);
           try {
               while (res.next()){
                    jComboBoxCatonCliente.addItem(res.getString("nombre_canton"));
               
                }
           }   
                catch (Exception e) {
                   }
           }
          
         //Metodo que carga el distrito correspondiente en el registro de la empresa
          public void CargarDistritoE () {
           jComboBoxDistritoEmpresa.removeAllItems();
           String canton = (jComboBoxCatonEmpresa .getSelectedItem().toString());
           String distritos;
           distritos = "select nombreDistrito from distrito join canton on "
                    + "canton.idCanton=distrito.idCanton AND nombre_canton='"+canton+"'";
           res =Conexiones.conexion.Consulta(distritos);
           try {
               while (res.next()){
                    jComboBoxDistritoEmpresa.addItem(res.getString("nombreDistrito"));
                }
           }   
                catch (Exception e) {
                   }
           }
          
          //Metodo que carga el distrito correspondiente en el registro del cliente
          public void CargarDistritoC () {
           jComboBoxDistritoCliente.removeAllItems();
           String canton = (jComboBoxCatonCliente.getSelectedItem().toString());
           String distritos;
           distritos = "select nombreDistrito from distrito join canton on "
                    + "canton.idCanton=distrito.idCanton AND nombre_canton='"+canton+"'";
            res =Conexiones.conexion.Consulta(distritos);
            try {
               while (res.next()){
                    jComboBoxDistritoCliente.addItem(res.getString("nombreDistrito"));
                }
            }   
                catch (Exception e) {
                   }
            }
          
          public void CargarMarca () {
           jComboBoxdefMarca.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombreMarca from marca");
           try {
               while (res.next()){
                    jComboBoxdefMarca.addItem(res.getString("nombreMarca"));
                }
           }   
                catch (Exception e) {
                }
        }
          
          public void CargarEstilo () {
           jComboBoxdefEstilo.removeAllItems();
           jComboBoxTipoFiltro.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombreEstilo from estilo");
           try {
               while (res.next()){
                    jComboBoxdefEstilo.addItem(res.getString("nombreEstilo"));
                    jComboBoxTipoFiltro.addItem(res.getString("nombreEstilo"));
                }
           }   
                catch (Exception e) {
                }
        }
          
          public void CargarColor () {
           jComboBoxdefColor.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombreColor from color");
           try {
               while (res.next()){
                      jComboBoxdefColor.addItem(res.getString("nombreColor"));
                }
           }   
                catch (Exception e) {
                }
        }
          
        public void CargarSede () {
           jComboBoxdefSede.removeAllItems();
           jComboBoxSedeRecoReserva.removeAllItems();
           jComboBoxSedeEntregaReserva.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombreSede from sede");
           try {
               while (res.next()){
                      jComboBoxdefSede.addItem(res.getString("nombreSede"));
                      jComboBoxSedeRecoReserva.addItem(res.getString("nombreSede"));
                      jComboBoxSedeEntregaReserva.addItem(res.getString("nombreSede"));
                }
           }   
                catch (Exception e) {
                }
        }  
        
         public void CargarTransmision () {
           jComboBoxdefTransmision.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombreTransmision from transmision");
           try {
               while (res.next()){
                      jComboBoxdefTransmision.addItem(res.getString("nombreTransmision"));
                }
           }   
                catch (Exception e) {
                }
        }
         /*public void CargarEstado () {
           jComboBoxdefEstado.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombreEstado from estado");
           try {
               while (res.next()){
                     jComboBoxdefEstado.addItem(res.getString("nombreEstado"));
                }
           }   
                catch (Exception e) {
                }
        }*/
         // select placa , capacidad, puertas, costo_dia, capacidadMaletas, nombreEstilo 
         //from vehiculo join estilo on vehiculo.idEstilo=estilo.idEstilo AND capacidad >= 300;
           public void CargarVehiculos () {
               DefaultTableModel modelo = (DefaultTableModel) jTableVehiculosDispo.getModel();
               modelo.setRowCount(0);
               String Estilo = (jComboBoxTipoFiltro .getSelectedItem().toString());
               String Sede = (jComboBoxSedeRecoReserva .getSelectedItem().toString());
               int Capacidad = Integer.parseInt(this.jTextFieldCapFiltro.getText().toString());
           res =Conexiones.conexion.Consulta ("select placa , capacidad, puertas, costo_dia, capacidadMaletas, nombreEstilo"
                   + " from vehiculo join estilo on vehiculo.idEstilo=estilo.idEstilo AND nombreEstilo='"+Estilo+"' AND "
                   + "capacidad >="+Capacidad+" INNER JOIN sede on vehiculo.idSede=sede.idSede AND nombreSede='"+Sede+"'");  
           try {
               while (res.next()){
                     Vector vec = new Vector();
                     vec.add(res.getInt(1));
                     vec.add(res.getInt(2));
                     vec.add(res.getInt(3));
                     vec.add(res.getInt(4));
                     vec.add(res.getInt(5));
                     vec.add(res.getString(6));
                     modelo.addRow(vec);
                     jTableVehiculosDispo.setModel(modelo);
                }
           }   
                catch (Exception e) {
                }
        }
        public void CargarClientes () {
               DefaultTableModel modelo = (DefaultTableModel) jTableClientes.getModel();
               modelo.setRowCount(0);
           res =Conexiones.conexion.Consulta("select primerNombre , primerApellido, cedula, correo, telefono from cliente" );
           try {
               while (res.next()){
                     Vector vec = new Vector();
                     vec.add(res.getString(1));
                     vec.add(res.getString(2));
                     vec.add(res.getInt(3));
                     vec.add(res.getString(4));
                     vec.add(res.getInt(5));
                     modelo.addRow(vec);
                     jTableClientes.setModel(modelo);
                }
           }   
                catch (Exception e) {
                }
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPanelPrincipal = new javax.swing.JTabbedPane();
        jTabbedPaneNuevosRegistros = new javax.swing.JTabbedPane();
        jPanelNuevosServicios = new javax.swing.JPanel();
        jPanelIngresarVehiculos1 = new javax.swing.JPanel();
        lblMarca3 = new javax.swing.JLabel();
        lblMarca4 = new javax.swing.JLabel();
        lblMarca5 = new javax.swing.JLabel();
        txtdefFechaInicio = new javax.swing.JTextField();
        lbltipo1 = new javax.swing.JLabel();
        lblColores1 = new javax.swing.JLabel();
        lblprecio12 = new javax.swing.JLabel();
        lblprecio13 = new javax.swing.JLabel();
        txtdefFechaFinal = new javax.swing.JTextField();
        txtdefIDMantenimiento = new javax.swing.JTextField();
        btRegistrarNuevoMantenimiento = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextAreaSennasEmpresa1 = new javax.swing.JTextArea();
        jButtonCargarDatos = new javax.swing.JButton();
        jComboBoxEscogerEmpresa = new javax.swing.JComboBox<String>();
        jComboBoxEscogerPlaca = new javax.swing.JComboBox<String>();
        jComboBoxtipoMantenimiento = new javax.swing.JComboBox<String>();
        lblMontoMante = new javax.swing.JLabel();
        txtMontoMantenimiento = new javax.swing.JTextField();
        jPanelNuevaEmpresa = new javax.swing.JPanel();
        jButtonCargarDireccion = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtcedulaJuridica = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        txttelefonoempresa = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextAreaSennasEmpresa = new javax.swing.JTextArea();
        btRegistrarempresa = new javax.swing.JButton();
        jComboBoxtProvinciaEmpresa = new javax.swing.JComboBox<String>();
        jComboBoxCatonEmpresa = new javax.swing.JComboBox<String>();
        jComboBoxDistritoEmpresa = new javax.swing.JComboBox<String>();
        jButtonBuscarCantones = new javax.swing.JButton();
        jButtonBuscarDistritos = new javax.swing.JButton();
        jPanelNuevosClientes = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtcedulacliente = new javax.swing.JTextField();
        txtPrimernombrecliente = new javax.swing.JTextField();
        txtcorreocliente = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtsegundonombrecliente = new javax.swing.JTextField();
        txtsegundoapellidocliente = new javax.swing.JTextField();
        txtprimerapellidocliente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtnumeroLicencia = new javax.swing.JTextField();
        txtFechaEmision = new javax.swing.JTextField();
        txtfechaExpiracion = new javax.swing.JTextField();
        btImagenLicencia = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btRegistrarcliente = new javax.swing.JButton();
        jComboBoxtProvinciaCliente = new javax.swing.JComboBox<String>();
        jComboBoxCatonCliente = new javax.swing.JComboBox<String>();
        jComboBoxDistritoCliente = new javax.swing.JComboBox<String>();
        txtruta = new javax.swing.JTextField();
        jButtonBuscarCantonesC = new javax.swing.JButton();
        jButtonBuscarDistritosC = new javax.swing.JButton();
        jlblTipoLicencia = new javax.swing.JLabel();
        jComboBoxTipoLicencia = new javax.swing.JComboBox();
        jPanelIngresarVehiculos = new javax.swing.JPanel();
        lblMarca1 = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        txtdefPlaca = new javax.swing.JTextField();
        lblMarca2 = new javax.swing.JLabel();
        txtdefAnno = new javax.swing.JTextField();
        lbltipo = new javax.swing.JLabel();
        jComboBoxdefEstilo = new javax.swing.JComboBox<String>();
        jComboBoxdefMarca = new javax.swing.JComboBox<String>();
        lblColores = new javax.swing.JLabel();
        jComboBoxdefColor = new javax.swing.JComboBox<String>();
        lblprecio1 = new javax.swing.JLabel();
        lblprecio2 = new javax.swing.JLabel();
        lblprecio3 = new javax.swing.JLabel();
        lblprecio4 = new javax.swing.JLabel();
        lblprecio5 = new javax.swing.JLabel();
        lblprecio6 = new javax.swing.JLabel();
        lblprecio7 = new javax.swing.JLabel();
        lblprecio8 = new javax.swing.JLabel();
        lblprecio9 = new javax.swing.JLabel();
        txtdefCapacidad = new javax.swing.JTextField();
        txtdefKilometraje = new javax.swing.JTextField();
        txtdefNumeroPuertas = new javax.swing.JTextField();
        txtdefVIN = new javax.swing.JTextField();
        txtdefMPG = new javax.swing.JTextField();
        jComboBoxdefSede = new javax.swing.JComboBox<String>();
        txtdefCapMaletas = new javax.swing.JTextField();
        jComboBoxdefTransmision = new javax.swing.JComboBox<String>();
        lblprecio10 = new javax.swing.JLabel();
        btIngresarImagen = new javax.swing.JButton();
        btRegistrarVehiculo = new javax.swing.JButton();
        txtrutaVeh = new javax.swing.JTextField();
        jTextCosto = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreoUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonEviarCorreoOperador = new javax.swing.JButton();
        jTabbedPaneReservas = new javax.swing.JTabbedPane();
        jPanelRealizarResserva = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jFormattedTextFieldFIR = new javax.swing.JFormattedTextField();
        jFormattedTextFieldFFR = new javax.swing.JFormattedTextField();
        jFormattedTextFieldFAR = new javax.swing.JFormattedTextField();
        jComboBoxSedeRecoReserva = new javax.swing.JComboBox<String>();
        jComboBoxSedeEntregaReserva = new javax.swing.JComboBox<String>();
        jRadioButtonWIFI = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonASIS = new javax.swing.JRadioButton();
        jRadioButtonASIENTO = new javax.swing.JRadioButton();
        jRadioButtonGPS = new javax.swing.JRadioButton();
        jRadioButtonDano = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jComboBoxTipoFiltro = new javax.swing.JComboBox<String>();
        jTextFieldCapFiltro = new javax.swing.JTextField();
        btBuscarVehiculos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVehiculosDispo = new javax.swing.JTable();
        btRentarVehiculo = new javax.swing.JButton();
        btRealizarReserva = new javax.swing.JButton();
        btAbrirImagenVehi1 = new javax.swing.JButton();
        jPanelConsultarReserva = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTabbedPaneEditar = new javax.swing.JTabbedPane();
        jPanelEditarVehi = new javax.swing.JPanel();
        jPanelIngresarVehiculos2 = new javax.swing.JPanel();
        lblMarca7 = new javax.swing.JLabel();
        lblMarca8 = new javax.swing.JLabel();
        txtdefAnno1 = new javax.swing.JTextField();
        lbltipo2 = new javax.swing.JLabel();
        jComboBoxdefEstilo1 = new javax.swing.JComboBox<String>();
        jComboBoxdefMarca1 = new javax.swing.JComboBox<String>();
        lblColores2 = new javax.swing.JLabel();
        jComboBoxdefColor1 = new javax.swing.JComboBox<String>();
        lblprecio11 = new javax.swing.JLabel();
        lblprecio14 = new javax.swing.JLabel();
        lblprecio15 = new javax.swing.JLabel();
        lblprecio16 = new javax.swing.JLabel();
        lblprecio17 = new javax.swing.JLabel();
        lblprecio18 = new javax.swing.JLabel();
        lblprecio19 = new javax.swing.JLabel();
        lblprecio20 = new javax.swing.JLabel();
        lblprecio21 = new javax.swing.JLabel();
        txtdefCapacidad1 = new javax.swing.JTextField();
        txtdefKilometraje1 = new javax.swing.JTextField();
        txtdefNumeroPuertas1 = new javax.swing.JTextField();
        txtdefVIN1 = new javax.swing.JTextField();
        txtdefMPG1 = new javax.swing.JTextField();
        jComboBoxdefSede1 = new javax.swing.JComboBox<String>();
        txtdefCapMaletas1 = new javax.swing.JTextField();
        jComboBoxdefTransmision1 = new javax.swing.JComboBox<String>();
        lblprecio22 = new javax.swing.JLabel();
        btIngresarImagen1 = new javax.swing.JButton();
        btRegistrarVehiculo1 = new javax.swing.JButton();
        txtrutaVeh1 = new javax.swing.JTextField();
        jTextCosto1 = new javax.swing.JTextField();
        lblMarca6 = new javax.swing.JLabel();
        jComboBoxEscogerPlaca1 = new javax.swing.JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPaneNuevosRegistros.setBackground(new java.awt.Color(255, 255, 255));

        jPanelIngresarVehiculos1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelIngresarVehiculos1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 0, 0)));

        lblMarca3.setText("Placa del auto");

        lblMarca4.setText("Tipo de mantenimiento ");

        lblMarca5.setText("Fecha inicio");

        lbltipo1.setText("Empresa que brinda el mantenimiento");

        lblColores1.setText("Detalle");

        lblprecio12.setText("Fecha Final");

        lblprecio13.setText("ID ");

        btRegistrarNuevoMantenimiento.setBackground(new java.awt.Color(255, 153, 0));
        btRegistrarNuevoMantenimiento.setText("Registrar nuevo Mantenimiento");
        btRegistrarNuevoMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarNuevoMantenimientoActionPerformed(evt);
            }
        });

        jTextAreaSennasEmpresa1.setColumns(20);
        jTextAreaSennasEmpresa1.setRows(5);
        jScrollPane10.setViewportView(jTextAreaSennasEmpresa1);

        jButtonCargarDatos.setText("Cargar Datos");
        jButtonCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarDatosActionPerformed(evt);
            }
        });

        jComboBoxEscogerEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEscogerEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEscogerEmpresaActionPerformed(evt);
            }
        });

        jComboBoxEscogerPlaca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxtipoMantenimiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxtipoMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxtipoMantenimientoActionPerformed(evt);
            }
        });

        lblMontoMante.setText("Monto");

        txtMontoMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoMantenimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelIngresarVehiculos1Layout = new javax.swing.GroupLayout(jPanelIngresarVehiculos1);
        jPanelIngresarVehiculos1.setLayout(jPanelIngresarVehiculos1Layout);
        jPanelIngresarVehiculos1Layout.setHorizontalGroup(
            jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIngresarVehiculos1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btRegistrarNuevoMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
            .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                        .addComponent(jButtonCargarDatos)
                        .addContainerGap(532, Short.MAX_VALUE))
                    .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                        .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblprecio12)
                                    .addComponent(lblprecio13)
                                    .addComponent(lblMarca5)
                                    .addComponent(lblMontoMante))
                                .addGap(53, 53, 53)
                                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                                        .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtdefIDMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdefFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdefFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(61, 61, 61)
                                        .addComponent(lblColores1))
                                    .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBoxEscogerPlaca, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMontoMantenimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblMarca3)
                            .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltipo1)
                                    .addComponent(lblMarca4))
                                .addGap(46, 46, 46)
                                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxEscogerEmpresa, 0, 179, Short.MAX_VALUE)
                                    .addComponent(jComboBoxtipoMantenimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelIngresarVehiculos1Layout.setVerticalGroup(
            jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                        .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblprecio13)
                            .addComponent(txtdefIDMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtdefFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMarca5)))
                            .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(lblColores1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprecio12)
                            .addComponent(txtdefFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMontoMante)
                            .addComponent(txtMontoMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca3)
                    .addComponent(jComboBoxEscogerPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltipo1)
                    .addComponent(jComboBoxEscogerEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca4)
                    .addComponent(jComboBoxtipoMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
                .addComponent(jButtonCargarDatos)
                .addGap(43, 43, 43)
                .addComponent(btRegistrarNuevoMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNuevosServiciosLayout = new javax.swing.GroupLayout(jPanelNuevosServicios);
        jPanelNuevosServicios.setLayout(jPanelNuevosServiciosLayout);
        jPanelNuevosServiciosLayout.setHorizontalGroup(
            jPanelNuevosServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
            .addGroup(jPanelNuevosServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelIngresarVehiculos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevosServiciosLayout.setVerticalGroup(
            jPanelNuevosServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
            .addGroup(jPanelNuevosServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelNuevosServiciosLayout.createSequentialGroup()
                    .addComponent(jPanelIngresarVehiculos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPaneNuevosRegistros.addTab("Servicios de mantenimiento", jPanelNuevosServicios);

        jButtonCargarDireccion.setBackground(new java.awt.Color(204, 0, 0));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Cédula Juridica");

        jLabel22.setForeground(new java.awt.Color(240, 240, 240));
        jLabel22.setText("Razon Social");

        jLabel24.setForeground(new java.awt.Color(240, 240, 240));
        jLabel24.setText("Teléfono");

        txtcedulaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaJuridicaActionPerformed(evt);
            }
        });

        txttelefonoempresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoempresaActionPerformed(evt);
            }
        });

        jLabel30.setForeground(new java.awt.Color(240, 240, 240));
        jLabel30.setText("Provincia");

        jLabel31.setForeground(new java.awt.Color(240, 240, 240));
        jLabel31.setText("Cantón");

        jLabel32.setForeground(new java.awt.Color(240, 240, 240));
        jLabel32.setText("Distrito");

        jLabel33.setForeground(new java.awt.Color(240, 240, 240));
        jLabel33.setText("Señas");

        jTextAreaSennasEmpresa.setColumns(20);
        jTextAreaSennasEmpresa.setRows(5);
        jScrollPane8.setViewportView(jTextAreaSennasEmpresa);

        btRegistrarempresa.setBackground(new java.awt.Color(255, 153, 0));
        btRegistrarempresa.setText("Registrar Empresa de mantenimiento");
        btRegistrarempresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarempresaActionPerformed(evt);
            }
        });

        jComboBoxtProvinciaEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxCatonEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxDistritoEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonBuscarCantones.setText("Mostrar Cantones");
        jButtonBuscarCantones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarCantonesActionPerformed(evt);
            }
        });

        jButtonBuscarDistritos.setText("Mostrar distritos");
        jButtonBuscarDistritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarDistritosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jButtonCargarDireccionLayout = new javax.swing.GroupLayout(jButtonCargarDireccion);
        jButtonCargarDireccion.setLayout(jButtonCargarDireccionLayout);
        jButtonCargarDireccionLayout.setHorizontalGroup(
            jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                        .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(0, 139, Short.MAX_VALUE))
                            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonBuscarCantones)
                                    .addComponent(jComboBoxtProvinciaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(141, 141, 141)
                                .addComponent(jLabel32))
                            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonBuscarDistritos)
                                    .addComponent(jComboBoxCatonEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jComboBoxDistritoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonCargarDireccionLayout.createSequentialGroup()
                        .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btRegistrarempresa))
                            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jButtonCargarDireccionLayout.createSequentialGroup()
                                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcedulaJuridica, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                    .addComponent(txttelefonoempresa)
                                    .addComponent(txtRazonSocial))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(36, 36, 36))))
        );
        jButtonCargarDireccionLayout.setVerticalGroup(
            jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtcedulaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txttelefonoempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonCargarDireccionLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxtProvinciaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxDistritoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxCatonEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                        .addComponent(jButtonBuscarCantones)
                        .addGap(27, 27, 27)
                        .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(btRegistrarempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonBuscarDistritos))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNuevaEmpresaLayout = new javax.swing.GroupLayout(jPanelNuevaEmpresa);
        jPanelNuevaEmpresa.setLayout(jPanelNuevaEmpresaLayout);
        jPanelNuevaEmpresaLayout.setHorizontalGroup(
            jPanelNuevaEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonCargarDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelNuevaEmpresaLayout.setVerticalGroup(
            jPanelNuevaEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonCargarDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPaneNuevosRegistros.addTab("Ingresar Empresa", jPanelNuevaEmpresa);

        panel.setBackground(new java.awt.Color(204, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Cédula");

        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Nombre");

        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Correo");

        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Teléfono");

        txtcedulacliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaclienteActionPerformed(evt);
            }
        });

        txtcorreocliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoclienteActionPerformed(evt);
            }
        });

        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("Apellido");

        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("Numero de licencia");

        jLabel15.setForeground(new java.awt.Color(240, 240, 240));
        jLabel15.setText("Fecha de emisión");

        jLabel16.setForeground(new java.awt.Color(240, 240, 240));
        jLabel16.setText("Fecha de expiración");

        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText("Foto de licencia");

        txtnumeroLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroLicenciaActionPerformed(evt);
            }
        });

        txtFechaEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaEmisionActionPerformed(evt);
            }
        });

        txtfechaExpiracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaExpiracionActionPerformed(evt);
            }
        });

        btImagenLicencia.setBackground(new java.awt.Color(255, 255, 255));
        btImagenLicencia.setText("Seleccionar Imagen");
        btImagenLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImagenLicenciaActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        jLabel18.setText("Provincia");

        jLabel19.setForeground(new java.awt.Color(240, 240, 240));
        jLabel19.setText("Cantón");

        jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        jLabel20.setText("Distrito");

        jLabel21.setForeground(new java.awt.Color(240, 240, 240));
        jLabel21.setText("Señas");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane5.setViewportView(jTextArea2);

        btRegistrarcliente.setBackground(new java.awt.Color(255, 153, 0));
        btRegistrarcliente.setText("Registrar Cliente");
        btRegistrarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarclienteActionPerformed(evt);
            }
        });

        jComboBoxtProvinciaCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxtProvinciaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxtProvinciaClienteActionPerformed(evt);
            }
        });

        jComboBoxCatonCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxDistritoCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonBuscarCantonesC.setText("Mostrar Cantones");
        jButtonBuscarCantonesC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarCantonesCActionPerformed(evt);
            }
        });

        jButtonBuscarDistritosC.setText("Mostrar distritos");
        jButtonBuscarDistritosC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarDistritosCActionPerformed(evt);
            }
        });

        jlblTipoLicencia.setForeground(new java.awt.Color(255, 255, 255));
        jlblTipoLicencia.setText("Tipo Licencia");

        jComboBoxTipoLicencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcorreocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtprimerapellidocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtsegundoapellidocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcedulacliente)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(txtPrimernombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtsegundonombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 60, Short.MAX_VALUE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnumeroLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtfechaExpiracion, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxTipoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btImagenLicencia))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttelefono))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonBuscarCantonesC)
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18)
                                        .addGroup(panelLayout.createSequentialGroup()
                                            .addGap(27, 27, 27)
                                            .addComponent(jComboBoxtProvinciaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(17, 17, 17)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(147, 147, 147)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btRegistrarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20))
                                        .addGap(0, 40, Short.MAX_VALUE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButtonBuscarDistritosC)
                                            .addComponent(jComboBoxCatonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(38, 38, 38)
                                        .addComponent(jComboBoxDistritoCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(34, 34, 34))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jlblTipoLicencia)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtcedulacliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrimernombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsegundonombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprimerapellidocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsegundoapellidocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtcorreocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtnumeroLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtfechaExpiracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(btImagenLicencia)
                    .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jlblTipoLicencia)
                        .addGap(47, 47, 47)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxtProvinciaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxDistritoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCatonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jButtonBuscarCantonesC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btRegistrarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(57, Short.MAX_VALUE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jButtonBuscarDistritosC)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jComboBoxTipoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanelNuevosClientesLayout = new javax.swing.GroupLayout(jPanelNuevosClientes);
        jPanelNuevosClientes.setLayout(jPanelNuevosClientesLayout);
        jPanelNuevosClientesLayout.setHorizontalGroup(
            jPanelNuevosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelNuevosClientesLayout.setVerticalGroup(
            jPanelNuevosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPaneNuevosRegistros.addTab("Registrar Clientes", jPanelNuevosClientes);

        jPanelIngresarVehiculos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelIngresarVehiculos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 0, 0)));

        lblMarca1.setText("Placa");

        lblMarca.setText("Marca");

        txtdefPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdefPlacaActionPerformed(evt);
            }
        });

        lblMarca2.setText("Año de fabricación ");

        lbltipo.setText("Estilo");

        jComboBoxdefEstilo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxdefMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblColores.setText("Color");

        jComboBoxdefColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblprecio1.setText("Capacidad");

        lblprecio2.setText("Kilometraje");

        lblprecio3.setText("Numero puertas");

        lblprecio4.setText("VIN");

        lblprecio5.setText("MPG");

        lblprecio6.setText("Sede perteneciente");

        lblprecio7.setText("Capacidad maletas");

        lblprecio8.setText("Transmisión");

        lblprecio9.setText("Costo");

        jComboBoxdefSede.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxdefTransmision.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblprecio10.setText("Imagen");

        btIngresarImagen.setBackground(new java.awt.Color(240, 0, 0));
        btIngresarImagen.setForeground(new java.awt.Color(255, 255, 255));
        btIngresarImagen.setText("Seleccionar Imagen");
        btIngresarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarImagenActionPerformed(evt);
            }
        });

        btRegistrarVehiculo.setBackground(new java.awt.Color(255, 153, 0));
        btRegistrarVehiculo.setText("Registrar vehiculo");
        btRegistrarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarVehiculoActionPerformed(evt);
            }
        });

        jTextCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCostoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelIngresarVehiculosLayout = new javax.swing.GroupLayout(jPanelIngresarVehiculos);
        jPanelIngresarVehiculos.setLayout(jPanelIngresarVehiculosLayout);
        jPanelIngresarVehiculosLayout.setHorizontalGroup(
            jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIngresarVehiculosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarca2)
                    .addComponent(lblMarca)
                    .addComponent(lbltipo)
                    .addComponent(lblColores)
                    .addComponent(lblprecio1)
                    .addComponent(lblMarca1)
                    .addComponent(lblprecio2)
                    .addComponent(lblprecio10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdefPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxdefMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdefAnno, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxdefEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtdefCapacidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addComponent(txtdefKilometraje, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jComboBoxdefColor, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btIngresarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIngresarVehiculosLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprecio3)
                            .addComponent(lblprecio4)
                            .addComponent(lblprecio5)
                            .addComponent(lblprecio6)
                            .addComponent(lblprecio7)
                            .addComponent(lblprecio8)
                            .addComponent(lblprecio9))
                        .addGap(27, 27, 27)
                        .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxdefSede, 0, 146, Short.MAX_VALUE)
                            .addComponent(txtdefMPG)
                            .addComponent(txtdefVIN)
                            .addComponent(txtdefNumeroPuertas)
                            .addComponent(txtdefCapMaletas)
                            .addComponent(jComboBoxdefTransmision, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextCosto)))
                    .addGroup(jPanelIngresarVehiculosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtrutaVeh, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanelIngresarVehiculosLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(btRegistrarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelIngresarVehiculosLayout.setVerticalGroup(
            jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngresarVehiculosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca1)
                    .addComponent(txtdefPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio3)
                    .addComponent(txtdefNumeroPuertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca2)
                    .addComponent(txtdefAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdefVIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(jComboBoxdefMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio5)
                    .addComponent(txtdefMPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltipo)
                    .addComponent(jComboBoxdefEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio6)
                    .addComponent(jComboBoxdefSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColores)
                    .addComponent(jComboBoxdefColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio7)
                    .addComponent(txtdefCapMaletas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprecio8)
                    .addComponent(jComboBoxdefTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio1)
                    .addComponent(txtdefCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprecio9)
                    .addComponent(jTextCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdefKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprecio10)
                    .addComponent(btIngresarImagen)
                    .addComponent(txtrutaVeh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btRegistrarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );

        jTabbedPaneNuevosRegistros.addTab("Ingresar Vehiculos", jPanelIngresarVehiculos);

        jPanel5.setBackground(new java.awt.Color(204, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Correo: ");

        jButtonEviarCorreoOperador.setBackground(new java.awt.Color(255, 153, 51));
        jButtonEviarCorreoOperador.setText("Enviar ");
        jButtonEviarCorreoOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEviarCorreoOperadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(43, 43, 43)
                        .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(jButtonEviarCorreoOperador)
                        .addGap(71, 71, 71))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEviarCorreoOperador))
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addContainerGap(493, Short.MAX_VALUE))
        );

        jTabbedPaneNuevosRegistros.addTab("Registrar Operador ", jPanel5);

        jTabbedPanelPrincipal.addTab("Registrar ", jTabbedPaneNuevosRegistros);

        jPanelRealizarResserva.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));

        jLabel23.setForeground(new java.awt.Color(240, 240, 240));
        jLabel23.setText("Sede recogida");

        jLabel25.setForeground(new java.awt.Color(240, 240, 240));
        jLabel25.setText("Sede entrega");

        jLabel26.setForeground(new java.awt.Color(240, 240, 240));
        jLabel26.setText("Fecha Inicio");

        jLabel27.setForeground(new java.awt.Color(240, 240, 240));
        jLabel27.setText("Fecha final");

        jLabel28.setForeground(new java.awt.Color(240, 240, 240));
        jLabel28.setText("Fecha actual");

        jFormattedTextFieldFIR.setText("mes/dia/año");
        jFormattedTextFieldFIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldFIRActionPerformed(evt);
            }
        });

        jFormattedTextFieldFFR.setText("mes/dia/año");

        jFormattedTextFieldFAR.setText("mes/dia/año");

        jComboBoxSedeRecoReserva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxSedeEntregaReserva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jRadioButtonWIFI.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonWIFI.setText("WIFI");
        jRadioButtonWIFI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonWIFIActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EXTRAS");

        jRadioButtonASIS.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonASIS.setText("Asis. carretera");

        jRadioButtonASIENTO.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonASIENTO.setText("Asiento niño");

        jRadioButtonGPS.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonGPS.setText("GPS");

        jRadioButtonDano.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonDano.setText("Daños ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jFormattedTextFieldFAR, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxSedeRecoReserva, 0, 109, Short.MAX_VALUE)
                                    .addComponent(jComboBoxSedeEntregaReserva, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18))
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButtonASIS)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonASIENTO))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButtonWIFI)
                                .addGap(30, 30, 30)
                                .addComponent(jRadioButtonGPS)
                                .addGap(46, 46, 46)
                                .addComponent(jRadioButtonDano)))
                        .addContainerGap(72, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFormattedTextFieldFIR)
                            .addComponent(jFormattedTextFieldFFR))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxSedeRecoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)
                        .addComponent(jFormattedTextFieldFIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextFieldFFR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonWIFI)
                            .addComponent(jRadioButtonGPS)
                            .addComponent(jRadioButtonDano))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonASIENTO)
                            .addComponent(jRadioButtonASIS)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jComboBoxSedeEntregaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel27)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(jFormattedTextFieldFAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)))))
                .addGap(9, 9, 9))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Datos Cliente ");

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Cédula", "Correo", "Teléfono"
            }
        ));
        jScrollPane1.setViewportView(jTableClientes);

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Filtros");

        jLabel29.setForeground(new java.awt.Color(240, 240, 240));
        jLabel29.setText("Estilo");

        jLabel34.setForeground(new java.awt.Color(240, 240, 240));
        jLabel34.setText("Precio");

        jLabel35.setForeground(new java.awt.Color(240, 240, 240));
        jLabel35.setText("Capacidad");

        jComboBoxTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btBuscarVehiculos.setBackground(new java.awt.Color(255, 153, 0));
        btBuscarVehiculos.setText("Buscar");
        btBuscarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarVehiculosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldCapFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(btBuscarVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel29)
                    .addComponent(jLabel35)
                    .addComponent(jComboBoxTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jTextFieldCapFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarVehiculos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableVehiculosDispo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Placa", "Capacidad", "# Puertas", "Costo DIA", "# Maletas", "Estilo"
            }
        ));
        jScrollPane2.setViewportView(jTableVehiculosDispo);

        btRentarVehiculo.setBackground(new java.awt.Color(255, 153, 0));
        btRentarVehiculo.setText("Rentar vehiculo seleccionado");
        btRentarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRentarVehiculoActionPerformed(evt);
            }
        });

        btRealizarReserva.setBackground(new java.awt.Color(255, 153, 0));
        btRealizarReserva.setText("Realizar reserva");
        btRealizarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRealizarReservaActionPerformed(evt);
            }
        });

        btAbrirImagenVehi1.setBackground(new java.awt.Color(255, 153, 0));
        btAbrirImagenVehi1.setText("Abrir Imagen del vehiculo");
        btAbrirImagenVehi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirImagenVehi1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btRealizarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAbrirImagenVehi1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btRentarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRealizarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAbrirImagenVehi1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(btRentarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanelRealizarResservaLayout = new javax.swing.GroupLayout(jPanelRealizarResserva);
        jPanelRealizarResserva.setLayout(jPanelRealizarResservaLayout);
        jPanelRealizarResservaLayout.setHorizontalGroup(
            jPanelRealizarResservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelRealizarResservaLayout.setVerticalGroup(
            jPanelRealizarResservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRealizarResservaLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPaneReservas.addTab("Realizar Reserva", jPanelRealizarResserva);

        jButton1.setText("Generar reserva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsultarReservaLayout = new javax.swing.GroupLayout(jPanelConsultarReserva);
        jPanelConsultarReserva.setLayout(jPanelConsultarReservaLayout);
        jPanelConsultarReservaLayout.setHorizontalGroup(
            jPanelConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultarReservaLayout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jButton1)
                .addContainerGap(330, Short.MAX_VALUE))
        );
        jPanelConsultarReservaLayout.setVerticalGroup(
            jPanelConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultarReservaLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jButton1)
                .addContainerGap(423, Short.MAX_VALUE))
        );

        jTabbedPaneReservas.addTab("ConsultarReserva", jPanelConsultarReserva);

        jTabbedPanelPrincipal.addTab("Reservas", jTabbedPaneReservas);

        jPanelEditarVehi.setBackground(new java.awt.Color(204, 0, 0));

        jPanelIngresarVehiculos2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelIngresarVehiculos2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 0, 0)));

        lblMarca7.setText("Marca");

        lblMarca8.setText("Año de fabricación ");

        lbltipo2.setText("Estilo");

        jComboBoxdefEstilo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxdefMarca1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblColores2.setText("Color");

        jComboBoxdefColor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblprecio11.setText("Capacidad");

        lblprecio14.setText("Kilometraje");

        lblprecio15.setText("Numero puertas");

        lblprecio16.setText("VIN");

        lblprecio17.setText("MPG");

        lblprecio18.setText("Sede perteneciente");

        lblprecio19.setText("Capacidad maletas");

        lblprecio20.setText("Transmisión");

        lblprecio21.setText("Costo");

        jComboBoxdefSede1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxdefTransmision1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblprecio22.setText("Imagen");

        btIngresarImagen1.setBackground(new java.awt.Color(240, 0, 0));
        btIngresarImagen1.setForeground(new java.awt.Color(255, 255, 255));
        btIngresarImagen1.setText("Seleccionar Imagen");
        btIngresarImagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarImagen1ActionPerformed(evt);
            }
        });

        btRegistrarVehiculo1.setBackground(new java.awt.Color(255, 153, 0));
        btRegistrarVehiculo1.setText("Registrar vehiculo");
        btRegistrarVehiculo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarVehiculo1ActionPerformed(evt);
            }
        });

        jTextCosto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCosto1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelIngresarVehiculos2Layout = new javax.swing.GroupLayout(jPanelIngresarVehiculos2);
        jPanelIngresarVehiculos2.setLayout(jPanelIngresarVehiculos2Layout);
        jPanelIngresarVehiculos2Layout.setHorizontalGroup(
            jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIngresarVehiculos2Layout.createSequentialGroup()
                .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelIngresarVehiculos2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRegistrarVehiculo1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelIngresarVehiculos2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMarca8)
                            .addComponent(lblMarca7)
                            .addComponent(lbltipo2)
                            .addComponent(lblColores2)
                            .addComponent(lblprecio11)
                            .addComponent(lblprecio14)
                            .addComponent(lblprecio22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxdefMarca1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdefAnno1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxdefEstilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxdefColor1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btIngresarImagen1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(txtdefCapacidad1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtdefKilometraje1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(19, 19, 19)
                        .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelIngresarVehiculos2Layout.createSequentialGroup()
                                .addGap(0, 94, Short.MAX_VALUE)
                                .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblprecio15)
                                    .addComponent(lblprecio16)
                                    .addComponent(lblprecio17)
                                    .addComponent(lblprecio18)
                                    .addComponent(lblprecio19)
                                    .addComponent(lblprecio20)
                                    .addComponent(lblprecio21))
                                .addGap(27, 27, 27)
                                .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxdefSede1, 0, 146, Short.MAX_VALUE)
                                    .addComponent(txtdefMPG1)
                                    .addComponent(txtdefVIN1)
                                    .addComponent(txtdefNumeroPuertas1)
                                    .addComponent(txtdefCapMaletas1)
                                    .addComponent(jComboBoxdefTransmision1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextCosto1)))
                            .addComponent(txtrutaVeh1))))
                .addContainerGap())
        );
        jPanelIngresarVehiculos2Layout.setVerticalGroup(
            jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngresarVehiculos2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprecio15)
                    .addComponent(txtdefNumeroPuertas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca8)
                    .addComponent(txtdefAnno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdefVIN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca7)
                    .addComponent(jComboBoxdefMarca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio17)
                    .addComponent(txtdefMPG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltipo2)
                    .addComponent(jComboBoxdefEstilo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio18)
                    .addComponent(jComboBoxdefSede1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColores2)
                    .addComponent(jComboBoxdefColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio19)
                    .addComponent(txtdefCapMaletas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprecio20)
                    .addComponent(jComboBoxdefTransmision1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio11)
                    .addComponent(txtdefCapacidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprecio21)
                    .addComponent(jTextCosto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdefKilometraje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblprecio14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresarVehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprecio22)
                    .addComponent(btIngresarImagen1)
                    .addComponent(txtrutaVeh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btRegistrarVehiculo1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        lblMarca6.setForeground(new java.awt.Color(255, 255, 255));
        lblMarca6.setText("Placa de los vehiculos que se encuentran activos:");

        jComboBoxEscogerPlaca1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelEditarVehiLayout = new javax.swing.GroupLayout(jPanelEditarVehi);
        jPanelEditarVehi.setLayout(jPanelEditarVehiLayout);
        jPanelEditarVehiLayout.setHorizontalGroup(
            jPanelEditarVehiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelIngresarVehiculos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelEditarVehiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMarca6)
                .addGap(44, 44, 44)
                .addComponent(jComboBoxEscogerPlaca1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEditarVehiLayout.setVerticalGroup(
            jPanelEditarVehiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditarVehiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEditarVehiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca6)
                    .addComponent(jComboBoxEscogerPlaca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanelIngresarVehiculos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );

        jTabbedPaneEditar.addTab("Editar Vehiculo", jPanelEditarVehi);

        jTabbedPanelPrincipal.addTab("Editar", jTabbedPaneEditar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanelPrincipal)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 668, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        vehiculo vehiculo= new vehiculo();
    private void btRegistrarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarVehiculoActionPerformed
        vehiculo.setPlaca(Integer.parseInt(txtdefPlaca.getText().toString()));
        vehiculo.setAnioFabricacion(Integer.parseInt(txtdefAnno.getText().toString()));
        vehiculo.setCapacidad(Integer.parseInt(txtdefCapacidad.getText().toString()));
        vehiculo.setKilometraje(Integer.parseInt(txtdefKilometraje.getText().toString()));
        vehiculo.setPuertas(Integer.parseInt(txtdefNumeroPuertas.getText().toString()));
        vehiculo.setVin(Integer.parseInt(txtdefVIN.getText().toString()));
        vehiculo.setMpg(Integer.parseInt(txtdefMPG.getText().toString()));
        vehiculo.setCosto_dia(Integer.parseInt(jTextCosto.getText().toString()));
        vehiculo.setCapacidadMaletas(Integer.parseInt(txtdefCapMaletas.getText().toString()));
        vehiculo.setIdEstado(1);
        
        res =Conexiones.conexion.Consulta("SELECT idMarca FROM marca WHERE nombreMarca='"+jComboBoxdefMarca.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                vehiculo.setIdMarca(res.getInt("idMarca"));
            }
        }   
        catch (Exception e) {
        }
        
        res =Conexiones.conexion.Consulta("SELECT idEstilo FROM estilo WHERE nombreEstilo='"+jComboBoxdefEstilo.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                vehiculo.setIdEstilo(res.getInt("idEstilo"));
            }
        }   
        catch (Exception e) {
        }
        
        res =Conexiones.conexion.Consulta("SELECT idColor FROM color WHERE nombreColor='"+jComboBoxdefColor.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                vehiculo.setIdColor(res.getInt("idColor"));
            }
        }   
        catch (Exception e) {
        }
        
        res =Conexiones.conexion.Consulta("SELECT idSede FROM sede WHERE nombreSede='"+jComboBoxdefSede.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                vehiculo.setIdSede(res.getInt("idSede"));
            }
        }   
        catch (Exception e) {
        }
        
        res =Conexiones.conexion.Consulta("SELECT idTransmision FROM transmision WHERE nombreTransmision='"+jComboBoxdefTransmision.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                vehiculo.setIdTransmision(res.getInt("idTransmision"));
            }
        }   
        catch (Exception e) {
        }
        
        FileInputStream archivofoto;
        try {
            archivofoto = new FileInputStream(txtrutaVeh.getText());//Se lee la direccion de la imagen guardada en el campo de texto
            vehiculo.setFotoVehiculo(archivofoto);
            
            //Se hace la insercion en la tabla vehiculo
            int exito = 0;
            exito= procedimiento.AgregarVehiculo(vehiculo.getPlaca(), vehiculo.getAnioFabricacion(), vehiculo.getIdEstilo(), vehiculo.getIdColor(),
                    vehiculo.getIdMarca(), vehiculo.getIdSede(), vehiculo.getIdTransmision(), vehiculo.getIdEstado(), vehiculo.getCapacidad(),
                    vehiculo.getKilometraje(), vehiculo.getPuertas(), vehiculo.getVin(), vehiculo.getMpg(), vehiculo.getCosto_dia(),
                    vehiculo.getCapacidadMaletas(), vehiculo.getFotoVehiculo());
            if(exito>0){
                JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", 
                                              "Éxito en la operación", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Los datos no se pudieron guardar\n"
                                             + "Inténtelo nuevamente", "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btRegistrarVehiculoActionPerformed

    private void btIngresarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarImagenActionPerformed
        //Abriendo ventana para seleccionar imagen
        FileNameExtensionFilter filtro= new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        JFileChooser foto= new JFileChooser();
        foto.addChoosableFileFilter(filtro);
        foto.setDialogTitle("Seleccionar archivo");
        int ventana= foto.showOpenDialog(null);
        //Se selecciona la imagen
        if(ventana == JFileChooser.APPROVE_OPTION){
            File file= foto.getSelectedFile();
            txtrutaVeh.setText(file.toString());
        }
    }//GEN-LAST:event_btIngresarImagenActionPerformed
        procedimientos procedimiento= new procedimientos();
        cliente cliente= new cliente();
        licencia licencia= new licencia();
    private void btRegistrarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarclienteActionPerformed
        cliente.setPrimerNombre(txtPrimernombrecliente.getText());
        cliente.setSegundoNombre(txtsegundonombrecliente.getText());
        cliente.setPrimerApellido(txtprimerapellidocliente.getText());
        cliente.setSegundoApellido(txtsegundoapellidocliente.getText());
        cliente.setCedulaCliente(Integer.parseInt(txtcedulacliente.getText().toString()));
        cliente.setCorreoCliente(txtcorreocliente.getText());
        cliente.setTelefonoCliente(Integer.parseInt(txttelefono.getText().toString()));
        
        //Se asigna el id de la provincia de acuerdo a lo que este en el comboBox
        
        res =Conexiones.conexion.Consulta("SELECT idProvincia FROM provincia WHERE nombreProvincia='"+jComboBoxtProvinciaCliente.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                cliente.setIdProvinciaCliente(res.getInt("idProvincia"));
            }
        }   
        catch (Exception e) {
        }
        
        //Se asigna el id del canton de acuerdo a lo que este en el comboBox
        res =Conexiones.conexion.Consulta("SELECT idCanton FROM canton WHERE nombre_canton='"+jComboBoxCatonCliente.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                cliente.setIdCantonCliente(res.getInt("idCanton"));
            }
        }   
        catch (Exception e) {
        }
        
        //Se asigna el id del distrito de acuerdo a lo que este en el comboBox
        res =Conexiones.conexion.Consulta("SELECT idDistrito FROM distrito WHERE nombreDistrito='"+jComboBoxDistritoCliente.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                cliente.setIdDistritoCliente(res.getInt("idDistrito"));
            }
        }   
        catch (Exception e) {
        }
        
        licencia.setNumeroLicencia(Integer.parseInt(txtnumeroLicencia.getText().toString()));
        licencia.setCedula(cliente.getCedulaCliente());
        licencia.setfEmision(txtFechaEmision.getText());
        licencia.setfExpiracion(txtfechaExpiracion.getText());
        
        //Se asigna el id del tipo de licencia de acuerdo a lo que este en el comboBox
        res =Conexiones.conexion.Consulta("SELECT idTipoLicencia FROM tipoLicencia WHERE nombreTipoLicencia='"+jComboBoxTipoLicencia.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                licencia.setIdTipoLicencia(res.getInt("idTipoLicencia"));
            }
        }   
        catch (Exception e) {
        }
        
        FileInputStream archivofoto;
        try {
            archivofoto = new FileInputStream(txtruta.getText());//Se lee la direccion de la imagen guardada en el campo de texto
            cliente.setFotoLicencia(archivofoto);
            licencia.setFotoLicencia(archivofoto);
            
            //Se hace la insercion en la tabla cliente
            int exito = 0;
            exito= procedimiento.AgregarCliente(cliente.getPrimerNombre(),cliente.getSegundoNombre(),cliente.getPrimerApellido()
                    ,cliente.getSegundoApellido(),cliente.getCedulaCliente(), cliente.getIdProvinciaCliente(), cliente.getIdCantonCliente()
                    ,cliente.getIdDistritoCliente(),cliente.getCorreoCliente()
                    ,Integer.parseInt(txttelefono.getText().toString()), cliente.getFotoLicencia());
            if(exito>0){
                JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", 
                                              "Éxito en la operación", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Los datos no se pudieron guardar\n"
                                             + "Inténtelo nuevamente", "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
            
            //Se hace la insercion en la tabla licencia
            exito=0;
            exito= procedimiento.AgregarLicencia(licencia.getNumeroLicencia(),licencia.getCedula(),licencia.getIdTipoLicencia(),
                    licencia.getfEmision(), licencia.getfExpiracion(), licencia.getFotoLicencia());
            if(exito>0){
                JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", 
                                              "Éxito en la operación", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Los datos no se pudieron guardar\n"
                                             + "Inténtelo nuevamente", "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }//GEN-LAST:event_btRegistrarclienteActionPerformed

    private void btImagenLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImagenLicenciaActionPerformed
        //Abriendo ventana para seleccionar imagen
        FileNameExtensionFilter filtro= new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        JFileChooser foto= new JFileChooser();
        foto.addChoosableFileFilter(filtro);
        foto.setDialogTitle("Seleccionar archivo");
        int ventana= foto.showOpenDialog(null);
        //Se selecciona la imagen
        if(ventana == JFileChooser.APPROVE_OPTION){
            File file= foto.getSelectedFile();
            txtruta.setText(file.toString());
        }
    }//GEN-LAST:event_btImagenLicenciaActionPerformed

    private void txtfechaExpiracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaExpiracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaExpiracionActionPerformed

    private void txtFechaEmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaEmisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaEmisionActionPerformed

    private void txtnumeroLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroLicenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroLicenciaActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtcorreoclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoclienteActionPerformed

    private void txtcedulaclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaclienteActionPerformed
        empresa empresa= new empresa();
    private void btRegistrarempresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarempresaActionPerformed
        
        empresa.setRazonSocial(txtRazonSocial.getText());
        empresa.setCedulaJuridica(Integer.parseInt(txtcedulaJuridica.getText().toString()));
        empresa.setTelefono(Integer.parseInt(txttelefonoempresa.getText().toString()));
        empresa.setSenias(jTextAreaSennasEmpresa.getText());
        
        //Se asigna el id de la provincia de acuerdo a lo que este en el comboBox
        res =Conexiones.conexion.Consulta("SELECT idProvincia FROM provincia WHERE nombreProvincia='"+jComboBoxtProvinciaEmpresa.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                empresa.setIdProvincia(res.getInt("idProvincia"));
            }
        }   
        catch (Exception e) {
        }
        
        //Se asigna el id del canton de acuerdo a lo que este en el comboBox
        res =Conexiones.conexion.Consulta("SELECT idCanton FROM canton WHERE nombre_canton='"+jComboBoxCatonEmpresa.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                empresa.setIdCanton(res.getInt("idCanton"));
            }
        }   
        catch (Exception e) {
        }
        
        //Se asigna el id del distrito de acuerdo a lo que este en el comboBox
        res =Conexiones.conexion.Consulta("SELECT idDistrito FROM distrito WHERE nombreDistrito='"+jComboBoxDistritoEmpresa.getSelectedItem().toString()+"'");
        try {
            while(res.next()){
                empresa.setIdDistrito(res.getInt("idDistrito"));
            }
        }   
        catch (Exception e) {
        }
        
        //Se insertan los valores en la tabla empresa
        int exito=0;
        exito= procedimiento.AgregarEmpresa(empresa.getRazonSocial(),empresa.getCedulaJuridica(), empresa.getTelefono(),empresa.getIdProvincia(),
                empresa.getIdCanton(),empresa.getIdDistrito(), jTextAreaSennasEmpresa.getText());
        if(exito>0){
            JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", 
                                          "Éxito en la operación", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Los datos no se pudieron guardar\n"
                                         + "Inténtelo nuevamente", "Error en la operación", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_btRegistrarempresaActionPerformed

    private void txttelefonoempresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoempresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoempresaActionPerformed

    private void txtcedulaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaJuridicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaJuridicaActionPerformed

    private void btRegistrarNuevoMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarNuevoMantenimientoActionPerformed
        
        //Asocia valor del comboBox de tipo del mantenimiento con su respectivo id
        res =Conexiones.conexion.Consulta("SELECT idTipo FROM tipo WHERE nombreTipo='"+jComboBoxtipoMantenimiento.getSelectedItem().toString()+"'");
        int idTipo = 0;
        try {
            while(res.next()){
                idTipo=res.getInt("idTipo");
            }
       }   
            catch (Exception e) {
               }
        
        //La misma asociacion anterior solo que en este caso entre razon social de empresa y cedula juridica
        res =Conexiones.conexion.Consulta("SELECT cedulaJuridica FROM empresa WHERE razonSocial='"+jComboBoxEscogerEmpresa.getSelectedItem().toString()+"'");
        int cedulaJuridica = 0;
        try {
            while(res.next()){
                cedulaJuridica=res.getInt("cedulaJuridica");
                System.out.println(cedulaJuridica);
            }
       }   
            catch (Exception e) {
               }
        
        //Se hace la insercion del mantenimiento en la base de datos
        int exito=0;
        exito= procedimiento.AgregarMantenimiento(Integer.parseInt(jComboBoxEscogerPlaca.getSelectedItem().toString()),
                Integer.parseInt(txtdefIDMantenimiento.getText().toString()),cedulaJuridica,
                idTipo,txtdefFechaInicio.getText(),txtdefFechaFinal.getText(),Integer.parseInt(txtMontoMantenimiento.getText().toString()),
                jTextAreaSennasEmpresa1.getText());
        if(exito>0){
            JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", 
                                          "Éxito en la operación", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Los datos no se pudieron guardar\n"
                                         + "Inténtelo nuevamente", "Error en la operación", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_btRegistrarNuevoMantenimientoActionPerformed

    private void jButtonCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarDatosActionPerformed
        CargarEmpresa ();
        CargarMantenimiento ();
        CargarPlaca ();
        CargarProvincia();
        CargarMarca () ;
        CargarEstilo ();
        CargarColor ();
        CargarSede ();
        CargarTransmision ();
        //CargarEstado ();
        CargarTipoLicencia();
        CargarClientes() ;
                
    }//GEN-LAST:event_jButtonCargarDatosActionPerformed

    private void txtdefPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdefPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdefPlacaActionPerformed

    private void jComboBoxtProvinciaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxtProvinciaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxtProvinciaClienteActionPerformed

    private void txtMontoMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoMantenimientoActionPerformed

    private void jFormattedTextFieldFIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldFIRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldFIRActionPerformed

    private void jRadioButtonWIFIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonWIFIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonWIFIActionPerformed

    private void btBuscarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarVehiculosActionPerformed
       CargarVehiculos ();
        CargarClientes ();
    }//GEN-LAST:event_btBuscarVehiculosActionPerformed

    private void btRentarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRentarVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRentarVehiculoActionPerformed

    private void jButtonBuscarCantonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCantonesActionPerformed
        CargarCantonE();
    }//GEN-LAST:event_jButtonBuscarCantonesActionPerformed

    private void jButtonBuscarDistritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarDistritosActionPerformed
        CargarDistritoE ();
    }//GEN-LAST:event_jButtonBuscarDistritosActionPerformed

    private void jButtonBuscarCantonesCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCantonesCActionPerformed
        CargarCantonC();
    }//GEN-LAST:event_jButtonBuscarCantonesCActionPerformed

    private void jButtonBuscarDistritosCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarDistritosCActionPerformed
        CargarDistritoC ();
    }//GEN-LAST:event_jButtonBuscarDistritosCActionPerformed

    private void jComboBoxEscogerEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEscogerEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEscogerEmpresaActionPerformed

    private void jComboBoxtipoMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxtipoMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxtipoMantenimientoActionPerformed

    private void jTextCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCostoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     /*   Document documento = new Document(); // se crea un nuevo documento
        
        
        try {
            String ruta = System.getProperty("users.home") ; //es la ruta que da acceso a la carpeta en la que se guarda el documento
            PdfWriter.getInstance(documento,new FileOutputStream(ruta + "/Desktop/Informe de la Reserva.pdf")); //se indica que el pdf se guardara en el escritorio y el nombre bajo el que se guardara
            documento.open(); 
            
            PdfPTable tabla = new PdfPTable(3);//se indica que se crea una table dentro del pdf *3 numero de columnas
            tabla.addCell("Cliente"); //permite insertar texto en las celdas de la tabla
            tabla.addCell("Sede de Recepcion");
            tabla.addCell("Sede de devolucion");
            tabla.addCell("Marca");
            
            try {
                 res =Conexiones.conexion.Consulta("");
                 
                if(res.next()){
                    
                    do{
                        tabla.addCell(res.getString(1));
                        tabla.addCell(res.getString(2));
                        tabla.addCell(res.getString(3));
                    }while (res.next());
                    
                    documento.add(tabla);
                }
                
            } catch (DocumentException | SQLException e) {
                
             documento.close();
             JOptionPane.showMessageDialog(null, "Pdf reserva generado");
            }
        } catch (DocumentException | HeadlessException | FileNotFoundException e){
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed
    reserva reserva= new reserva();
    private void jButtonGenerarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarReservaActionPerformed
//        reserva.setIdReserva(Integer.parseInt(txtIDreserva.getText().toString()));
//        reserva.setCedula(Integer.parseInt(txtCedulaReserva.getText().toString()));
        
    }//GEN-LAST:event_jButtonGenerarReservaActionPerformed

    private void btIngresarImagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarImagen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btIngresarImagen1ActionPerformed

    private void btRegistrarVehiculo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarVehiculo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRegistrarVehiculo1ActionPerformed

    private void jTextCosto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCosto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCosto1ActionPerformed

    private void btRealizarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRealizarReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRealizarReservaActionPerformed

    private void btAbrirImagenVehi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirImagenVehi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAbrirImagenVehi1ActionPerformed
            Operador operador= new Operador();
            SendEmail correo= new SendEmail();
    private void jButtonEviarCorreoOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEviarCorreoOperadorActionPerformed
           res =Conexiones.conexion.Consulta("select usuario from operador where usuario='"+txtCorreoUsuario.getText()+"'");
           int contador=0;
           try {
               //Se verifica que el usuario no exista en la base de datos
               if (res.next()){
                   contador++;
                   JOptionPane.showMessageDialog(null,"Ya existe este usuario", "Usuario", JOptionPane.INFORMATION_MESSAGE);
                }
               //Creacion de la contrasena aleatoria
                if(contador==0){
                   String contrasenia = "";
                   
                   //Caracteres que se utilizan para crear la contrasena
                   String[] abecedario= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
                   String[] especiales={"!","@","#","$","%","^","&"};
                   String[] numeros={"1","2","3","4","5","6","7","8","9","0"};
                   
                   //Creacion de la contrasena
                   contrasenia += especiales[(int) (7 * Math.random())];
                   contrasenia += abecedario[(int) (26 * Math.random())];
                   contrasenia += abecedario[(int) (26 * Math.random())].toUpperCase();
                   contrasenia += abecedario[(int) (26 * Math.random())];
                   contrasenia += abecedario[(int) (26 * Math.random())].toUpperCase();
                   contrasenia += abecedario[(int) (26 * Math.random())];
                   contrasenia += abecedario[(int) (26 * Math.random())].toUpperCase();
                   contrasenia += numeros[(int) (10 * Math.random())];
                   
                   operador.setUsuario(txtCorreoUsuario.getText());
                   operador.setContrasenia(contrasenia);
                   
                   //Se agrega operador a base de datos
                   int exito=0;
                   exito= procedimiento.AgregarOperador(operador.getUsuario(),operador.getContrasenia());
                   if(exito>0){
                       JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", 
                                                      "Éxito en la operación", JOptionPane.INFORMATION_MESSAGE);
                   }else{
                       JOptionPane.showMessageDialog(null, "Los datos no se pudieron guardar\n"
                                                     + "Inténtelo nuevamente", "Error en la operación", JOptionPane.ERROR_MESSAGE); 
                   }
                   
                   String mensaje= "Saludos! \n \nSu usuario es: "+operador.getUsuario()+"\nSu contrasena es: "+operador.getContrasenia();
                   correo.SendEmail(operador.getUsuario(),mensaje,"Datos operador");
               }
           }   
            catch (Exception e) {
               }
    }//GEN-LAST:event_jButtonEviarCorreoOperadorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrirImagenVehi1;
    private javax.swing.JButton btBuscarVehiculos;
    private javax.swing.JButton btImagenLicencia;
    private javax.swing.JButton btIngresarImagen;
    private javax.swing.JButton btIngresarImagen1;
    private javax.swing.JButton btRealizarReserva;
    private javax.swing.JButton btRegistrarNuevoMantenimiento;
    private javax.swing.JButton btRegistrarVehiculo;
    private javax.swing.JButton btRegistrarVehiculo1;
    private javax.swing.JButton btRegistrarcliente;
    private javax.swing.JButton btRegistrarempresa;
    private javax.swing.JButton btRentarVehiculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuscarCantones;
    private javax.swing.JButton jButtonBuscarCantonesC;
    private javax.swing.JButton jButtonBuscarDistritos;
    private javax.swing.JButton jButtonBuscarDistritosC;
    private javax.swing.JButton jButtonCargarDatos;
    private javax.swing.JPanel jButtonCargarDireccion;
    private javax.swing.JButton jButtonEviarCorreoOperador;
    private javax.swing.JComboBox<String> jComboBoxCatonCliente;
    private javax.swing.JComboBox<String> jComboBoxCatonEmpresa;
    private javax.swing.JComboBox<String> jComboBoxDistritoCliente;
    private javax.swing.JComboBox<String> jComboBoxDistritoEmpresa;
    private javax.swing.JComboBox<String> jComboBoxEscogerEmpresa;
    private javax.swing.JComboBox<String> jComboBoxEscogerPlaca;
    private javax.swing.JComboBox<String> jComboBoxEscogerPlaca1;
    private javax.swing.JComboBox<String> jComboBoxSedeEntregaReserva;
    private javax.swing.JComboBox<String> jComboBoxSedeRecoReserva;
    private javax.swing.JComboBox<String> jComboBoxTipoFiltro;
    private javax.swing.JComboBox jComboBoxTipoLicencia;
    private javax.swing.JComboBox<String> jComboBoxdefColor;
    private javax.swing.JComboBox<String> jComboBoxdefColor1;
    private javax.swing.JComboBox<String> jComboBoxdefEstilo;
    private javax.swing.JComboBox<String> jComboBoxdefEstilo1;
    private javax.swing.JComboBox<String> jComboBoxdefMarca;
    private javax.swing.JComboBox<String> jComboBoxdefMarca1;
    private javax.swing.JComboBox<String> jComboBoxdefSede;
    private javax.swing.JComboBox<String> jComboBoxdefSede1;
    private javax.swing.JComboBox<String> jComboBoxdefTransmision;
    private javax.swing.JComboBox<String> jComboBoxdefTransmision1;
    private javax.swing.JComboBox<String> jComboBoxtProvinciaCliente;
    private javax.swing.JComboBox<String> jComboBoxtProvinciaEmpresa;
    private javax.swing.JComboBox<String> jComboBoxtipoMantenimiento;
    private javax.swing.JFormattedTextField jFormattedTextFieldFAR;
    private javax.swing.JFormattedTextField jFormattedTextFieldFFR;
    private javax.swing.JFormattedTextField jFormattedTextFieldFIR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelConsultarReserva;
    private javax.swing.JPanel jPanelEditarVehi;
    private javax.swing.JPanel jPanelIngresarVehiculos;
    private javax.swing.JPanel jPanelIngresarVehiculos1;
    private javax.swing.JPanel jPanelIngresarVehiculos2;
    private javax.swing.JPanel jPanelNuevaEmpresa;
    private javax.swing.JPanel jPanelNuevosClientes;
    private javax.swing.JPanel jPanelNuevosServicios;
    private javax.swing.JPanel jPanelRealizarResserva;
    private javax.swing.JRadioButton jRadioButtonASIENTO;
    private javax.swing.JRadioButton jRadioButtonASIS;
    private javax.swing.JRadioButton jRadioButtonDano;
    private javax.swing.JRadioButton jRadioButtonGPS;
    private javax.swing.JRadioButton jRadioButtonWIFI;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPaneEditar;
    private javax.swing.JTabbedPane jTabbedPaneNuevosRegistros;
    private javax.swing.JTabbedPane jTabbedPaneReservas;
    private javax.swing.JTabbedPane jTabbedPanelPrincipal;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTable jTableVehiculosDispo;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextAreaSennasEmpresa;
    private javax.swing.JTextArea jTextAreaSennasEmpresa1;
    private javax.swing.JTextField jTextCosto;
    private javax.swing.JTextField jTextCosto1;
    private javax.swing.JTextField jTextFieldCapFiltro;
    private javax.swing.JLabel jlblTipoLicencia;
    private javax.swing.JLabel lblColores;
    private javax.swing.JLabel lblColores1;
    private javax.swing.JLabel lblColores2;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarca1;
    private javax.swing.JLabel lblMarca2;
    private javax.swing.JLabel lblMarca3;
    private javax.swing.JLabel lblMarca4;
    private javax.swing.JLabel lblMarca5;
    private javax.swing.JLabel lblMarca6;
    private javax.swing.JLabel lblMarca7;
    private javax.swing.JLabel lblMarca8;
    private javax.swing.JLabel lblMontoMante;
    private javax.swing.JLabel lblprecio1;
    private javax.swing.JLabel lblprecio10;
    private javax.swing.JLabel lblprecio11;
    private javax.swing.JLabel lblprecio12;
    private javax.swing.JLabel lblprecio13;
    private javax.swing.JLabel lblprecio14;
    private javax.swing.JLabel lblprecio15;
    private javax.swing.JLabel lblprecio16;
    private javax.swing.JLabel lblprecio17;
    private javax.swing.JLabel lblprecio18;
    private javax.swing.JLabel lblprecio19;
    private javax.swing.JLabel lblprecio2;
    private javax.swing.JLabel lblprecio20;
    private javax.swing.JLabel lblprecio21;
    private javax.swing.JLabel lblprecio22;
    private javax.swing.JLabel lblprecio3;
    private javax.swing.JLabel lblprecio4;
    private javax.swing.JLabel lblprecio5;
    private javax.swing.JLabel lblprecio6;
    private javax.swing.JLabel lblprecio7;
    private javax.swing.JLabel lblprecio8;
    private javax.swing.JLabel lblprecio9;
    private javax.swing.JLabel lbltipo;
    private javax.swing.JLabel lbltipo1;
    private javax.swing.JLabel lbltipo2;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtCorreoUsuario;
    private javax.swing.JTextField txtFechaEmision;
    private javax.swing.JTextField txtMontoMantenimiento;
    private javax.swing.JTextField txtPrimernombrecliente;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtcedulaJuridica;
    private javax.swing.JTextField txtcedulacliente;
    private javax.swing.JTextField txtcorreocliente;
    private javax.swing.JTextField txtdefAnno;
    private javax.swing.JTextField txtdefAnno1;
    private javax.swing.JTextField txtdefCapMaletas;
    private javax.swing.JTextField txtdefCapMaletas1;
    private javax.swing.JTextField txtdefCapacidad;
    private javax.swing.JTextField txtdefCapacidad1;
    private javax.swing.JTextField txtdefFechaFinal;
    private javax.swing.JTextField txtdefFechaInicio;
    private javax.swing.JTextField txtdefIDMantenimiento;
    private javax.swing.JTextField txtdefKilometraje;
    private javax.swing.JTextField txtdefKilometraje1;
    private javax.swing.JTextField txtdefMPG;
    private javax.swing.JTextField txtdefMPG1;
    private javax.swing.JTextField txtdefNumeroPuertas;
    private javax.swing.JTextField txtdefNumeroPuertas1;
    private javax.swing.JTextField txtdefPlaca;
    private javax.swing.JTextField txtdefVIN;
    private javax.swing.JTextField txtdefVIN1;
    private javax.swing.JTextField txtfechaExpiracion;
    private javax.swing.JTextField txtnumeroLicencia;
    private javax.swing.JTextField txtprimerapellidocliente;
    private javax.swing.JTextField txtruta;
    private javax.swing.JTextField txtrutaVeh;
    private javax.swing.JTextField txtrutaVeh1;
    private javax.swing.JTextField txtsegundoapellidocliente;
    private javax.swing.JTextField txtsegundonombrecliente;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttelefonoempresa;
    // End of variables declaration//GEN-END:variables
}
