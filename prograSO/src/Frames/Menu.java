/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Controlador.Singleton;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ColaMensajes;
import modelo.ColaProcesos;
import modelo.ConfiguracionSistema;
import modelo.Mensaje;
import modelo.Proceso;

/**
 *
 * @author Rigo-PC
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);		
 
        setLocationRelativeTo(null);
        initComponents();
        this.jPanel_create.setVisible(false);
        this.jPanel_receive.setVisible(false);
        this.jPanel_send.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton_create = new javax.swing.JButton();
        jButton_send = new javax.swing.JButton();
        jButton_receive = new javax.swing.JButton();
        jButton_play = new javax.swing.JButton();
        jButton_GuardarDatos = new javax.swing.JButton();
        jPanel_create = new javax.swing.JPanel();
        jButton_ejecutarC = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField_msgContents = new javax.swing.JTextField();
        jPanel_send = new javax.swing.JPanel();
        jButton_ejecutarS = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox_sendDestination = new javax.swing.JComboBox<>();
        jComboBox_sendMsg = new javax.swing.JComboBox<>();
        jPanel_receive = new javax.swing.JPanel();
        jButton_ejecutarR = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox_receiveSource = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBox_receiveMsg = new javax.swing.JComboBox<>();
        jButton_manualUsuario = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(623, 402));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Proyecto #1 Principio de Sistemas Operativos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Establecer configuraciones:");

        jButton1.setText("Ajustar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton_create.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_create.setText("Create()");
        jButton_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_createActionPerformed(evt);
            }
        });

        jButton_send.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_send.setText("Send()");
        jButton_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sendActionPerformed(evt);
            }
        });

        jButton_receive.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton_receive.setText("Receive()");
        jButton_receive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_receiveActionPerformed(evt);
            }
        });

        jButton_play.setText("Display()");
        jButton_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_playActionPerformed(evt);
            }
        });

        jButton_GuardarDatos.setText("Guardar");
        jButton_GuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarDatosActionPerformed(evt);
            }
        });

        jPanel_create.setPreferredSize(new java.awt.Dimension(407, 180));
        //jPanel_create.setVisible(false);

        jButton_ejecutarC.setText("Ejecutar");
        jButton_ejecutarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ejecutarCActionPerformed(evt);
            }
        });

        jLabel3.setText("Create()");

        jLabel10.setText("Contenido:");

        javax.swing.GroupLayout jPanel_createLayout = new javax.swing.GroupLayout(jPanel_create);
        jPanel_create.setLayout(jPanel_createLayout);
        jPanel_createLayout.setHorizontalGroup(
            jPanel_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_createLayout.createSequentialGroup()
                .addGroup(jPanel_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_createLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(jPanel_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jButton_ejecutarC)))
                    .addGroup(jPanel_createLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel10)))
                .addContainerGap(188, Short.MAX_VALUE))
            .addComponent(jTextField_msgContents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );
        jPanel_createLayout.setVerticalGroup(
            jPanel_createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_createLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_msgContents, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_ejecutarC)
                .addGap(18, 18, 18))
        );

        jPanel_send.setVisible(false);

        jButton_ejecutarS.setText("Ejecutar");
        jButton_ejecutarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ejecutarSActionPerformed(evt);
            }
        });

        jLabel4.setText("Send()");

        jLabel11.setText("Destino:");

        jLabel12.setText("Mensaje:");

        jComboBox_sendDestination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox_sendMsg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel_sendLayout = new javax.swing.GroupLayout(jPanel_send);
        jPanel_send.setLayout(jPanel_sendLayout);
        jPanel_sendLayout.setHorizontalGroup(
            jPanel_sendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_sendLayout.createSequentialGroup()
                .addGroup(jPanel_sendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_sendLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel4))
                    .addGroup(jPanel_sendLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton_ejecutarS))
                    .addGroup(jPanel_sendLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel_sendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_sendDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel_sendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_sendMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel_sendLayout.setVerticalGroup(
            jPanel_sendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_sendLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(22, 22, 22)
                .addGroup(jPanel_sendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel_sendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_sendDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_sendMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton_ejecutarS)
                .addContainerGap())
        );

        jPanel_receive.setPreferredSize(new java.awt.Dimension(407, 180));
        jPanel_receive.setRequestFocusEnabled(false);
        jPanel_receive.setVisible(false);

        jButton_ejecutarR.setText("Ejecutar");
        jButton_ejecutarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ejecutarRActionPerformed(evt);
            }
        });

        jLabel5.setText("Receive()");

        jLabel13.setText("Fuente:");

        jComboBox_receiveSource.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Mensaje:");

        jComboBox_receiveMsg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel_receiveLayout = new javax.swing.GroupLayout(jPanel_receive);
        jPanel_receive.setLayout(jPanel_receiveLayout);
        jPanel_receiveLayout.setHorizontalGroup(
            jPanel_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_receiveLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox_receiveSource, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox_receiveMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
            .addGroup(jPanel_receiveLayout.createSequentialGroup()
                .addGroup(jPanel_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_receiveLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel5))
                    .addGroup(jPanel_receiveLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton_ejecutarR)))
                .addGap(138, 138, 138))
        );
        jPanel_receiveLayout.setVerticalGroup(
            jPanel_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_receiveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addGroup(jPanel_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_receiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_receiveSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_receiveMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton_ejecutarR)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_play, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_receive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_GuardarDatos)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jPanel_receive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 50, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(185, 185, 185)
                    .addComponent(jPanel_send, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(33, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(183, 183, 183)
                    .addComponent(jPanel_create, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton_create)
                        .addGap(26, 26, 26)
                        .addComponent(jButton_send)
                        .addGap(34, 34, 34)
                        .addComponent(jButton_receive))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel_receive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_GuardarDatos)
                    .addComponent(jButton_play))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jPanel_send, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(165, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jPanel_create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(183, Short.MAX_VALUE)))
        );

        jButton_manualUsuario.setText("Manual de Usuario");
        jButton_manualUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_manualUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_manualUsuario)
                                .addGap(37, 37, 37)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(jButton_manualUsuario))
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Settings settings = new Settings();
        settings.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void mensajeDialog(String mensaje, String tituloBarra){
        
        JOptionPane.showMessageDialog(null, mensaje, tituloBarra, JOptionPane.INFORMATION_MESSAGE);
    }
    private void jButton_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_createActionPerformed
        // TODO add your handling code here:
        
        
        // Validar Configuracion
        ConfiguracionSistema configuracion = Singleton.getInstance().getControlador().getConfiguracionSistema();
        if(configuracion == null){
            String mensajeError = "Se debe establecer la configuración para crear un mensaje";
            String tituloDeBarra = "Falta Configuración";
            this.mensajeDialog(mensajeError, tituloDeBarra);
            return;
        }
        
        // Configuracion Correcta
        jPanel_create.setVisible(true);
        jPanel_send.setVisible(false);
        jPanel_receive.setVisible(false);

        // Opciones de tipo de Mensaje
        
        // Opciones de Source y Destination
        ColaProcesos colaProceso = Singleton.getInstance().getControlador().getColaProcesos();
        ArrayList<Proceso> listaProcesos = colaProceso.getListaProcesos();

        String identificadorProceso=  "" ;
        
        for(Proceso proceso: listaProcesos){
            
            identificadorProceso = String.valueOf(proceso.getIdentificador());
            
        }

        
        
        
    }//GEN-LAST:event_jButton_createActionPerformed

    private void jButton_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sendActionPerformed
        // TODO add your handling code here:
        
        
        // Validar Configuracion
        ConfiguracionSistema configuracion = Singleton.getInstance().getControlador().getConfiguracionSistema();
        if(configuracion == null){
            String mensajeError = "Se debe establecer la configuración para enviar un mensaje";
            String tituloDeBarra = "Falta Configuración";
            this.mensajeDialog(mensajeError, tituloDeBarra);
            return;
        }
        
        jPanel_send.setVisible(true);
        jPanel_create.setVisible(false);
        jPanel_receive.setVisible(false);

        // Opciones decre sendDestination
        
        boolean direccionamientoDirecto = Singleton.getInstance().
                getControlador().getConfiguracionSistema().
                getDireccionamiento().isDirect();
        
        
        // Direct Send
        if(direccionamientoDirecto){
            
            ColaProcesos colaProceso = Singleton.getInstance().getControlador().getColaProcesos();
            ArrayList<Proceso> listaProcesos = colaProceso.getListaProcesos();
            String identificadorProceso;
            this.jComboBox_sendDestination.removeAllItems();
            for(Proceso proceso : listaProcesos){

                identificadorProceso = String.valueOf(proceso.getIdentificador());
                this.jComboBox_sendDestination.addItem(identificadorProceso);
            }
            
        }
        else{
            this.jComboBox_sendDestination.setVisible(false);
        }

        // Opciones de Mensaje
        ColaMensajes colaMensajes = Singleton.getInstance().getControlador().getColaMensajes();
        ArrayList<Mensaje> listaMensajes = colaMensajes.getListaMensajes();
        String contenidoMensaje;
        
        this.jComboBox_sendMsg.removeAllItems();
        for(Mensaje mensaje: listaMensajes){
            contenidoMensaje = (String)mensaje.getContenido();
            this.jComboBox_sendMsg.addItem(contenidoMensaje);
        }
        
        
        
        
    }//GEN-LAST:event_jButton_sendActionPerformed

    private void jButton_receiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_receiveActionPerformed
        // TODO add your handling code here:
        
        // Validar Configuracion
        ConfiguracionSistema configuracion = Singleton.getInstance().getControlador().getConfiguracionSistema();
        if(configuracion == null){
            String mensajeError = "Se debe establecer la configuración para recibir un mensaje";
            String tituloDeBarra = "Falta Configuración";
            this.mensajeDialog(mensajeError, tituloDeBarra);
            return;
        }
        
        jPanel_receive.setVisible(true);
        jPanel_create.setVisible(false);
        jPanel_send.setVisible(false);
        
        
        
        boolean direccionamientoDirecto = Singleton.getInstance().
                getControlador().getConfiguracionSistema().
                getDireccionamiento().isDirect();
        
        
        // Direct Receive
        if(direccionamientoDirecto){
            
            ColaProcesos colaProceso = Singleton.getInstance().getControlador().getColaProcesos();
            ArrayList<Proceso> listaProcesos = colaProceso.getListaProcesos();
            String identificadorProceso;
            this.jComboBox_receiveSource.removeAllItems();
            for(Proceso proceso : listaProcesos){

                identificadorProceso = String.valueOf(proceso.getIdentificador());
                this.jComboBox_receiveSource.addItem(identificadorProceso);
            }
            
            // Opciones de Mensaje
            ColaMensajes colaMensajes = Singleton.getInstance().getControlador().getColaMensajes();
            ArrayList<Mensaje> listaMensajes = colaMensajes.getListaMensajes();
            String contenidoMensaje;

            this.jComboBox_receiveMsg.removeAllItems();
            for(Mensaje mensaje: listaMensajes){
                contenidoMensaje = (String)mensaje.getContenido();
                this.jComboBox_receiveMsg.addItem(contenidoMensaje);
            }
        
            
        }else{   
                // Opciones de Mensaje
            ColaMensajes colaMensajes = Singleton.getInstance().getControlador().getColaMensajes();
            ArrayList<Mensaje> listaMensajes = colaMensajes.getListaMensajes();
            String contenidoMensaje;

            this.jComboBox_receiveMsg.removeAllItems();
            for(Mensaje mensaje: listaMensajes){
                contenidoMensaje = (String)mensaje.getContenido();
                this.jComboBox_receiveMsg.addItem(contenidoMensaje);
            }
            this.jComboBox_receiveSource.setVisible(false);
        }
  
    }//GEN-LAST:event_jButton_receiveActionPerformed

    private void jButton_ejecutarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ejecutarCActionPerformed
        // TODO add your handling code here:
        
        
        
        String contenido = this.jTextField_msgContents.getText();
        
        
        //Comando Create
        boolean estado = Singleton.getInstance().getControlador().Create(contenido);
        
        if(estado){
            String mensajeDialogoContenido = "Se ha creado el mensaje";
            String tituloDialogoContenido = "Mensaje creado";
            this.mensajeDialog(mensajeDialogoContenido ,tituloDialogoContenido);
        }else{
            String mensajeDialogoContenido = "No se ha creado el mensaje";
            String tituloDialogoContenido = "Mensaje no creado";
            this.mensajeDialog(mensajeDialogoContenido ,tituloDialogoContenido);
        }

        
        
        //Singleton.getInstance().getControlador().getColaMensajes().ImprimirColaMensaje();
        
        
        
        
        
    }//GEN-LAST:event_jButton_ejecutarCActionPerformed

    private void jButton_ejecutarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ejecutarSActionPerformed
        // TODO add your handling code here:
        
        
        String idProcesoDestinoString = (String)this.jComboBox_sendDestination.getSelectedItem();
        int idProcesoDestino;
        try{
            idProcesoDestino = Integer.parseInt(idProcesoDestinoString);
            
        }
        catch(Exception e){
            idProcesoDestino = 0;
            
        }
        
        String contenidoMensaje = (String)this.jComboBox_sendMsg.getSelectedItem();
        
        boolean send = Singleton.getInstance().getControlador().Send(idProcesoDestino, contenidoMensaje);
        
        String contenidoMensajeDialog = "Se ha enviado el mensaje";
        String tituloBarra = "Send";
        
        if(send){
            contenidoMensajeDialog = "Se ha enviado el mensaje";
            this.mensajeDialog(contenidoMensajeDialog, tituloBarra);
            
        }
        else{
            contenidoMensajeDialog = "El mensaje no se pudo enviar";
            this.mensajeDialog(contenidoMensajeDialog, tituloBarra);
        }
        
        
            
            
            
        
        
        
    }//GEN-LAST:event_jButton_ejecutarSActionPerformed

    private void jButton_ejecutarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ejecutarRActionPerformed
        // TODO add your handling code here:
        String idProcesoFuenteString = (String)this.jComboBox_receiveSource.getSelectedItem();
        String contenidoMensaje = (String)this.jComboBox_receiveMsg.getSelectedItem();
        int idProcesoFuente;
        
        try{
            idProcesoFuente = Integer.parseInt(idProcesoFuenteString);
            
        }
        catch(Exception e){
            idProcesoFuente = 0;
            
        }
        
        boolean receive = Singleton.getInstance().getControlador().Receive(idProcesoFuente,contenidoMensaje);
        String contenidoMensajeDialog = "";
        String tituloBarra = "Receive";
        
        if(receive){
            contenidoMensajeDialog = "Receive procesado";
            this.mensajeDialog(contenidoMensajeDialog, tituloBarra);
            
        }
        else{
            contenidoMensajeDialog = "Receive no procesado";
            this.mensajeDialog(contenidoMensajeDialog, tituloBarra);
        }
        
        
    }//GEN-LAST:event_jButton_ejecutarRActionPerformed

    private void jButton_manualUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_manualUsuarioActionPerformed
        // TODO add your handling code here:
        
      if (Desktop.isDesktopSupported()) {
        try {
        File myFile = new File("D:\\Tec\\2 Semestre 2018\\Principios de Sistemas Operativos\\Proyecto 1\\OperativosGit\\Proyecto-1-Operativos\\prograSO\\src\\Frames\\manual.pdf");
        Desktop.getDesktop().open(myFile);
        } 
        catch (IOException ex) {
        // no application registered for PDFs
        }
        }
      
      
    }//GEN-LAST:event_jButton_manualUsuarioActionPerformed

    private void jButton_GuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarDatosActionPerformed
        // TODO add your handling code here:
        System.out.println(""+Singleton.getInstance().getControlador().getListaSolicitudes().getListaSolicitudes().toString());
    }//GEN-LAST:event_jButton_GuardarDatosActionPerformed

    private void jButton_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_playActionPerformed
        // TODO add your handling code here:
        
        Display display = new Display();
        display.show();
    }//GEN-LAST:event_jButton_playActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_GuardarDatos;
    private javax.swing.JButton jButton_create;
    private javax.swing.JButton jButton_ejecutarC;
    private javax.swing.JButton jButton_ejecutarR;
    private javax.swing.JButton jButton_ejecutarS;
    private javax.swing.JButton jButton_manualUsuario;
    private javax.swing.JButton jButton_play;
    private javax.swing.JButton jButton_receive;
    private javax.swing.JButton jButton_send;
    private javax.swing.JComboBox<String> jComboBox_receiveMsg;
    private javax.swing.JComboBox<String> jComboBox_receiveSource;
    private javax.swing.JComboBox<String> jComboBox_sendDestination;
    private javax.swing.JComboBox<String> jComboBox_sendMsg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_create;
    private javax.swing.JPanel jPanel_receive;
    private javax.swing.JPanel jPanel_send;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField jTextField_msgContents;
    // End of variables declaration//GEN-END:variables
}
