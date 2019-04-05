package Interfaz;

import Conexiones.*; 
import static Conexiones.conexion.Consulta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
 

public class VistaPrincipal extends javax.swing.JFrame {
    
    
    static ResultSet res;
  //  conexion Conectar = new conexion();
    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
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
          public void CargarCanton() {
           jComboBoxCatonCliente.removeAllItems();
           jComboBoxCatonEmpresa.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombre_canton from canton");
           try {
               while (res.next()){
                    jComboBoxCatonCliente.addItem(res.getString("nombre_canton"));
                    jComboBoxCatonEmpresa.addItem(res.getString("nombre_canton"));
                }
           }   
                catch (Exception e) {
                   }
           }
          // select nombreDistrito from distrito join provincia on provincia.idProvincia=distrito.idProvincia AND nombreProvincia='San Jose'
          public void CargarDistrito () {
           jComboBoxDistritoCliente.removeAllItems();
           jComboBoxDistritoEmpresa.removeAllItems();
//           String provincia = ((String) jComboBoxtProvinciaEmpresa .getSelectedItem());
//           String distritos;
//           distritos = "select nombreDistrito from distrito join provincia on provincia.idProvincia=distrito.idProvincia AND nombreProvincia="+""+provincia+"";
//           res =Conexiones.conexion.Consulta(distritos);
           res =Conexiones.conexion.Consulta("select nombreDistrito from distrito");
           try {
               while (res.next()){
                    jComboBoxDistritoCliente.addItem(res.getString("nombreDistrito"));
                    jComboBoxDistritoEmpresa.addItem(res.getString("nombreDistrito"));
                }
           }   
                catch (Exception e) {
                   }
           }
          //
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
           res =Conexiones.conexion.Consulta("select nombreEstilo from estilo");
           try {
               while (res.next()){
                    jComboBoxdefEstilo.addItem(res.getString("nombreEstilo"));
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
                      jComboBoxdefColor.addItem(res.getString(" nombreColor"));
                }
           }   
                catch (Exception e) {
                }
        }
          public void CargarSede () {
           jComboBoxdefSede.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombreSede from sede");
           try {
               while (res.next()){
                      jComboBoxdefSede.addItem(res.getString(" nombreSede"));
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
         public void CargarEstado () {
           jComboBoxdefEstado.removeAllItems();
           res =Conexiones.conexion.Consulta("select nombreEstado from estado");
           try {
               while (res.next()){
                     jComboBoxdefEstado.addItem(res.getString("nombreEstado"));
                }
           }   
                catch (Exception e) {
                }
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPanelPrincipal = new javax.swing.JTabbedPane();
        jPanelReservaciones = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTableCarrosDisponibles = new javax.swing.JTable();
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
        lblprecio = new javax.swing.JLabel();
        txtdefprecio = new javax.swing.JTextField();
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
        jComboBoxdefEstado = new javax.swing.JComboBox<String>();
        jComboBoxdefTransmision = new javax.swing.JComboBox<String>();
        lblprecio10 = new javax.swing.JLabel();
        btIngresarImagen = new javax.swing.JButton();
        btRegistrarVehiculo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableCarrosDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(jTableCarrosDisponibles);

        javax.swing.GroupLayout jPanelReservacionesLayout = new javax.swing.GroupLayout(jPanelReservaciones);
        jPanelReservaciones.setLayout(jPanelReservacionesLayout);
        jPanelReservacionesLayout.setHorizontalGroup(
            jPanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservacionesLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanelReservacionesLayout.setVerticalGroup(
            jPanelReservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservacionesLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jTabbedPanelPrincipal.addTab("Reservaciones", jPanelReservaciones);

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

        jComboBoxEscogerPlaca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxtipoMantenimiento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jComboBoxtipoMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jComboBoxEscogerPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                        .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(lblMarca4))
                            .addComponent(jButtonCargarDatos))
                        .addContainerGap(271, Short.MAX_VALUE))
                    .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                        .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprecio12)
                            .addComponent(lblprecio13)
                            .addComponent(lblMarca5)
                            .addComponent(lblMontoMante))
                        .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                                        .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtdefIDMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdefFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdefFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(61, 61, 61)
                                        .addComponent(lblColores1))
                                    .addComponent(txtMontoMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 62, Short.MAX_VALUE))
                            .addGroup(jPanelIngresarVehiculos1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(lblMarca3)
                                .addGap(126, 126, 126)
                                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbltipo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxEscogerEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(88, Short.MAX_VALUE))))))
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
                .addGap(85, 85, 85)
                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltipo1)
                    .addComponent(lblMarca3))
                .addGap(18, 18, 18)
                .addGroup(jPanelIngresarVehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEscogerPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEscogerEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(lblMarca4)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxtipoMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonCargarDatos)
                .addGap(55, 55, 55)
                .addComponent(btRegistrarNuevoMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelNuevosServiciosLayout = new javax.swing.GroupLayout(jPanelNuevosServicios);
        jPanelNuevosServicios.setLayout(jPanelNuevosServiciosLayout);
        jPanelNuevosServiciosLayout.setHorizontalGroup(
            jPanelNuevosServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
            .addGroup(jPanelNuevosServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelIngresarVehiculos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevosServiciosLayout.setVerticalGroup(
            jPanelNuevosServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
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

        jButtonBuscarDistritos.setText("Cargar datos direccion");
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonCargarDireccionLayout.createSequentialGroup()
                        .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addGap(36, 36, 36))
                    .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btRegistrarempresa)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                        .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(0, 139, Short.MAX_VALUE))
                            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonBuscarDistritos)
                                    .addComponent(jComboBoxtProvinciaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(141, 141, 141)
                                .addComponent(jLabel32))
                            .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jComboBoxCatonEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jComboBoxDistritoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))))
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
                .addComponent(jButtonBuscarDistritos)
                .addGap(27, 27, 27)
                .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                        .addGroup(jButtonCargarDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jButtonCargarDireccionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(btRegistrarempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207))))
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
                                        .addGap(0, 36, Short.MAX_VALUE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
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
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttelefono))
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
                                        .addComponent(btImagenLicencia)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btRegistrarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jComboBoxtProvinciaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(17, 17, 17)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(147, 147, 147)
                                        .addComponent(jLabel20)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jComboBoxCatonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jComboBoxDistritoCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))))
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
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(btRegistrarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanelNuevosClientesLayout = new javax.swing.GroupLayout(jPanelNuevosClientes);
        jPanelNuevosClientes.setLayout(jPanelNuevosClientesLayout);
        jPanelNuevosClientesLayout.setHorizontalGroup(
            jPanelNuevosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelNuevosClientesLayout.setVerticalGroup(
            jPanelNuevosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 608, Short.MAX_VALUE)
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

        lblprecio.setText("Precio");

        lblprecio1.setText("Capacidad");

        lblprecio2.setText("Kilometraje");

        lblprecio3.setText("Numero puertas");

        lblprecio4.setText("VIN");

        lblprecio5.setText("MPG");

        lblprecio6.setText("Sede perteneciente");

        lblprecio7.setText("Capacidad maletas");

        lblprecio8.setText("Transmisión");

        lblprecio9.setText("Estado");

        jComboBoxdefSede.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxdefEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        javax.swing.GroupLayout jPanelIngresarVehiculosLayout = new javax.swing.GroupLayout(jPanelIngresarVehiculos);
        jPanelIngresarVehiculos.setLayout(jPanelIngresarVehiculosLayout);
        jPanelIngresarVehiculosLayout.setHorizontalGroup(
            jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngresarVehiculosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarca2)
                    .addComponent(lblMarca)
                    .addComponent(lbltipo)
                    .addComponent(lblColores)
                    .addComponent(lblprecio)
                    .addComponent(lblprecio1)
                    .addComponent(lblMarca1)
                    .addComponent(lblprecio2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdefPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxdefMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdefAnno, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxdefEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtdefCapacidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addComponent(txtdefKilometraje, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtdefprecio, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBoxdefColor, javax.swing.GroupLayout.Alignment.LEADING, 0, 143, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblprecio3)
                    .addComponent(lblprecio4)
                    .addComponent(lblprecio5)
                    .addComponent(lblprecio6)
                    .addComponent(lblprecio7)
                    .addComponent(lblprecio8)
                    .addComponent(lblprecio10)
                    .addComponent(lblprecio9))
                .addGap(27, 27, 27)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxdefEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btIngresarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jComboBoxdefSede, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtdefMPG)
                    .addComponent(txtdefVIN)
                    .addComponent(txtdefNumeroPuertas)
                    .addComponent(txtdefCapMaletas)
                    .addComponent(jComboBoxdefTransmision, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanelIngresarVehiculosLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(btRegistrarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblprecio)
                    .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdefprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblprecio8)
                        .addComponent(jComboBoxdefTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIngresarVehiculosLayout.createSequentialGroup()
                        .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprecio1)
                            .addComponent(txtdefCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxdefEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprecio2)
                            .addComponent(txtdefKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelIngresarVehiculosLayout.createSequentialGroup()
                        .addComponent(lblprecio9)
                        .addGap(15, 15, 15)
                        .addGroup(jPanelIngresarVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btIngresarImagen)
                            .addComponent(lblprecio10))))
                .addGap(27, 27, 27)
                .addComponent(btRegistrarVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(187, 187, 187))
        );

        jTabbedPaneNuevosRegistros.addTab("Ingresar Vehiculos", jPanelIngresarVehiculos);

        jTabbedPanelPrincipal.addTab("Registrar ", jTabbedPaneNuevosRegistros);

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

    private void btRegistrarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarVehiculoActionPerformed
        
    }//GEN-LAST:event_btRegistrarVehiculoActionPerformed

    private void btIngresarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btIngresarImagenActionPerformed
    procedimientos procedimiento= new procedimientos();
    private void btRegistrarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarclienteActionPerformed
        FileInputStream archivofoto;
        try {
            archivofoto = new FileInputStream(txtruta.getText());//Se lee la direccion de la imagen guardada en el campo de texto
            int exito = 0;
            exito= procedimiento.AgregarCliente("Pablo", "Mauricio", "Arrieta", "Parce", 145879, 1, 1, 1051, "hola@gmail.com", 1, archivofoto);
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

    private void btRegistrarempresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarempresaActionPerformed
        int exito=0;
        exito= procedimiento.AgregarEmpresa(txtRazonSocial.getText(),Integer.parseInt(txtcedulaJuridica.getText().toString()), 
                Integer.parseInt(txttelefonoempresa.getText().toString()), 1, 1, 1051, "No disponible");
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
        res =Conexiones.conexion.Consulta("SELECT idTipo FROM tipo WHERE nombreTipo='"+jComboBoxtipoMantenimiento.getSelectedItem().toString()+"'");
        String idTipo;
        try {
            idTipo=res.getString("idTipo");
            System.out.println(idTipo);
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*int exito=0;
        exito= procedimiento.AgregarMantenimiento(Integer.parseInt(jComboBoxEscogerPlaca.getSelectedItem().toString()),
                Integer.parseInt(txtdefIDMantenimiento.getText().toString()),23456,
                1,txtdefFechaInicio.getText(),txtdefFechaFinal.getText(),Integer.parseInt(txtMontoMantenimiento.getText().toString()),
                jTextAreaSennasEmpresa1.getText());
        if(exito>0){
            JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", 
                                          "Éxito en la operación", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Los datos no se pudieron guardar\n"
                                         + "Inténtelo nuevamente", "Error en la operación", JOptionPane.ERROR_MESSAGE); 
        }*/
      
    }//GEN-LAST:event_btRegistrarNuevoMantenimientoActionPerformed

    private void jButtonCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarDatosActionPerformed
         CargarEmpresa ();
         CargarMantenimiento ();
         CargarPlaca ();
         CargarProvincia();
         CargarCanton();
         CargarDistrito();
         CargarMarca () ;
        CargarEstilo ();
        CargarColor ();
        CargarSede ();
        CargarTransmision ();
        CargarEstado ();                         
                
    }//GEN-LAST:event_jButtonCargarDatosActionPerformed

    private void jButtonBuscarDistritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarDistritosActionPerformed
        
    }//GEN-LAST:event_jButtonBuscarDistritosActionPerformed

    private void txtdefPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdefPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdefPlacaActionPerformed

    private void jComboBoxtProvinciaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxtProvinciaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxtProvinciaClienteActionPerformed

    private void txtMontoMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoMantenimientoActionPerformed

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
    private javax.swing.JButton btImagenLicencia;
    private javax.swing.JButton btIngresarImagen;
    private javax.swing.JButton btRegistrarNuevoMantenimiento;
    private javax.swing.JButton btRegistrarVehiculo;
    private javax.swing.JButton btRegistrarcliente;
    private javax.swing.JButton btRegistrarempresa;
    private javax.swing.JButton jButtonBuscarDistritos;
    private javax.swing.JButton jButtonCargarDatos;
    private javax.swing.JPanel jButtonCargarDireccion;
    private javax.swing.JComboBox<String> jComboBoxCatonCliente;
    private javax.swing.JComboBox<String> jComboBoxCatonEmpresa;
    private javax.swing.JComboBox<String> jComboBoxDistritoCliente;
    private javax.swing.JComboBox<String> jComboBoxDistritoEmpresa;
    private javax.swing.JComboBox<String> jComboBoxEscogerEmpresa;
    private javax.swing.JComboBox<String> jComboBoxEscogerPlaca;
    private javax.swing.JComboBox<String> jComboBoxdefColor;
    private javax.swing.JComboBox<String> jComboBoxdefEstado;
    private javax.swing.JComboBox<String> jComboBoxdefEstilo;
    private javax.swing.JComboBox<String> jComboBoxdefMarca;
    private javax.swing.JComboBox<String> jComboBoxdefSede;
    private javax.swing.JComboBox<String> jComboBoxdefTransmision;
    private javax.swing.JComboBox<String> jComboBoxtProvinciaCliente;
    private javax.swing.JComboBox<String> jComboBoxtProvinciaEmpresa;
    private javax.swing.JComboBox<String> jComboBoxtipoMantenimiento;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelIngresarVehiculos;
    private javax.swing.JPanel jPanelIngresarVehiculos1;
    private javax.swing.JPanel jPanelNuevaEmpresa;
    private javax.swing.JPanel jPanelNuevosClientes;
    private javax.swing.JPanel jPanelNuevosServicios;
    private javax.swing.JPanel jPanelReservaciones;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPaneNuevosRegistros;
    private javax.swing.JTabbedPane jTabbedPanelPrincipal;
    private javax.swing.JTable jTableCarrosDisponibles;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextAreaSennasEmpresa;
    private javax.swing.JTextArea jTextAreaSennasEmpresa1;
    private javax.swing.JLabel lblColores;
    private javax.swing.JLabel lblColores1;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMarca1;
    private javax.swing.JLabel lblMarca2;
    private javax.swing.JLabel lblMarca3;
    private javax.swing.JLabel lblMarca4;
    private javax.swing.JLabel lblMarca5;
    private javax.swing.JLabel lblMontoMante;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JLabel lblprecio1;
    private javax.swing.JLabel lblprecio10;
    private javax.swing.JLabel lblprecio12;
    private javax.swing.JLabel lblprecio13;
    private javax.swing.JLabel lblprecio2;
    private javax.swing.JLabel lblprecio3;
    private javax.swing.JLabel lblprecio4;
    private javax.swing.JLabel lblprecio5;
    private javax.swing.JLabel lblprecio6;
    private javax.swing.JLabel lblprecio7;
    private javax.swing.JLabel lblprecio8;
    private javax.swing.JLabel lblprecio9;
    private javax.swing.JLabel lbltipo;
    private javax.swing.JLabel lbltipo1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtFechaEmision;
    private javax.swing.JTextField txtMontoMantenimiento;
    private javax.swing.JTextField txtPrimernombrecliente;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtcedulaJuridica;
    private javax.swing.JTextField txtcedulacliente;
    private javax.swing.JTextField txtcorreocliente;
    private javax.swing.JTextField txtdefAnno;
    private javax.swing.JTextField txtdefCapMaletas;
    private javax.swing.JTextField txtdefCapacidad;
    private javax.swing.JTextField txtdefFechaFinal;
    private javax.swing.JTextField txtdefFechaInicio;
    private javax.swing.JTextField txtdefIDMantenimiento;
    private javax.swing.JTextField txtdefKilometraje;
    private javax.swing.JTextField txtdefMPG;
    private javax.swing.JTextField txtdefNumeroPuertas;
    private javax.swing.JTextField txtdefPlaca;
    private javax.swing.JTextField txtdefVIN;
    private javax.swing.JTextField txtdefprecio;
    private javax.swing.JTextField txtfechaExpiracion;
    private javax.swing.JTextField txtnumeroLicencia;
    private javax.swing.JTextField txtprimerapellidocliente;
    private javax.swing.JTextField txtruta;
    private javax.swing.JTextField txtsegundoapellidocliente;
    private javax.swing.JTextField txtsegundonombrecliente;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttelefonoempresa;
    // End of variables declaration//GEN-END:variables
}
