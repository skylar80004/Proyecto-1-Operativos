/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author curso
 */
public class Settings extends javax.swing.JFrame {

    /**
     * Creates new form Settings
     */
    public Settings() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_title = new javax.swing.JLabel();
        jTabbedPane_tabs = new javax.swing.JTabbedPane();
        javax.swing.JPanel jPanel_formato = new javax.swing.JPanel();
        jComboBox_format = new javax.swing.JComboBox<>();
        jPanel_disciplinaManejoColas = new javax.swing.JPanel();
        jComboBox_manejoDeColas = new javax.swing.JComboBox<>();
        jPanel_synchronization = new javax.swing.JPanel();
        jLabel_syncSend = new javax.swing.JLabel();
        jlabel_syncReceive = new javax.swing.JLabel();
        jComboBox_sendParameters = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jComboBox_receiveParameters = new javax.swing.JComboBox<>();
        jPanel_direccionamiento = new javax.swing.JPanel();
        jComboBox_adressingType = new javax.swing.JComboBox<>();
        jComboBox_addresingSubType = new javax.swing.JComboBox<>();
        jPanel_general = new javax.swing.JPanel();
        jLabel_numberOfProcesses = new javax.swing.JLabel();
        jTextField_numberOfProcesses = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField_sizeOfQueue = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 800));
        setResizable(false);

        label_title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        label_title.setText("Configuración del Sistema");

        jTabbedPane_tabs.setToolTipText("sdgsd");

        jComboBox_format.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_format.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contenido", "Largo Fijo", "Largo Variable" }));

        javax.swing.GroupLayout jPanel_formatoLayout = new javax.swing.GroupLayout(jPanel_formato);
        jPanel_formato.setLayout(jPanel_formatoLayout);
        jPanel_formatoLayout.setHorizontalGroup(
            jPanel_formatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_formatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox_format, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1298, Short.MAX_VALUE))
        );
        jPanel_formatoLayout.setVerticalGroup(
            jPanel_formatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_formatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox_format, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(547, Short.MAX_VALUE))
        );

        jTabbedPane_tabs.addTab("Formato", jPanel_formato);

        jComboBox_manejoDeColas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_manejoDeColas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIFO", "Prioridad" }));

        javax.swing.GroupLayout jPanel_disciplinaManejoColasLayout = new javax.swing.GroupLayout(jPanel_disciplinaManejoColas);
        jPanel_disciplinaManejoColas.setLayout(jPanel_disciplinaManejoColasLayout);
        jPanel_disciplinaManejoColasLayout.setHorizontalGroup(
            jPanel_disciplinaManejoColasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_disciplinaManejoColasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox_manejoDeColas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1341, Short.MAX_VALUE))
        );
        jPanel_disciplinaManejoColasLayout.setVerticalGroup(
            jPanel_disciplinaManejoColasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_disciplinaManejoColasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox_manejoDeColas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(547, Short.MAX_VALUE))
        );

        jTabbedPane_tabs.addTab("Disciplinas de Manejo de Colas", jPanel_disciplinaManejoColas);

        jLabel_syncSend.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_syncSend.setText("Send");

        jlabel_syncReceive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlabel_syncReceive.setText("Receive");

        jComboBox_sendParameters.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_sendParameters.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blocking", "Nonblocking" }));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        jComboBox_receiveParameters.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_receiveParameters.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blocking", "NonBlocking", "Prueba de Llegada" }));

        javax.swing.GroupLayout jPanel_synchronizationLayout = new javax.swing.GroupLayout(jPanel_synchronization);
        jPanel_synchronization.setLayout(jPanel_synchronizationLayout);
        jPanel_synchronizationLayout.setHorizontalGroup(
            jPanel_synchronizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_synchronizationLayout.createSequentialGroup()
                .addGroup(jPanel_synchronizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_synchronizationLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_synchronizationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel_synchronizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_syncSend)
                            .addComponent(jComboBox_sendParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(146, 146, 146)
                        .addGroup(jPanel_synchronizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_receiveParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabel_syncReceive, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(549, Short.MAX_VALUE))
        );
        jPanel_synchronizationLayout.setVerticalGroup(
            jPanel_synchronizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_synchronizationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_synchronizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_syncSend)
                    .addComponent(jlabel_syncReceive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_synchronizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_sendParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_receiveParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(125, 125, 125))
        );

        jTabbedPane_tabs.addTab("Sincronización", jPanel_synchronization);

        jComboBox_adressingType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_adressingType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Directo", "Indirecto" }));
        jComboBox_adressingType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_adressingTypeItemStateChanged(evt);
            }
        });

        jComboBox_addresingSubType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_addresingSubType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Send", "Receive Explícito", "Receive Implícito" }));

        javax.swing.GroupLayout jPanel_direccionamientoLayout = new javax.swing.GroupLayout(jPanel_direccionamiento);
        jPanel_direccionamiento.setLayout(jPanel_direccionamientoLayout);
        jPanel_direccionamientoLayout.setHorizontalGroup(
            jPanel_direccionamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_direccionamientoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_direccionamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_adressingType, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_addresingSubType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1277, Short.MAX_VALUE))
        );
        jPanel_direccionamientoLayout.setVerticalGroup(
            jPanel_direccionamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_direccionamientoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox_adressingType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox_addresingSubType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(501, Short.MAX_VALUE))
        );

        jTabbedPane_tabs.addTab("Direccionamiento", jPanel_direccionamiento);

        jLabel_numberOfProcesses.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_numberOfProcesses.setText("Número de Procesos:");
        jLabel_numberOfProcesses.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("<html>Tamaño de la<br/>Cola de Mensajes:</html>");

        jTextField_sizeOfQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_sizeOfQueueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_generalLayout = new javax.swing.GroupLayout(jPanel_general);
        jPanel_general.setLayout(jPanel_generalLayout);
        jPanel_generalLayout.setHorizontalGroup(
            jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_generalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_generalLayout.createSequentialGroup()
                        .addComponent(jLabel_numberOfProcesses)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_numberOfProcesses, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_generalLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_sizeOfQueue, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1088, Short.MAX_VALUE))
        );
        jPanel_generalLayout.setVerticalGroup(
            jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_generalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_numberOfProcesses)
                    .addComponent(jTextField_numberOfProcesses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_sizeOfQueue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(502, Short.MAX_VALUE))
        );

        jTabbedPane_tabs.addTab("General", jPanel_general);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane_tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane_tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_adressingTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_adressingTypeItemStateChanged
        // TODO add your handling code here:
        
        
        String addresingParameter = (String)this.jComboBox_adressingType.getSelectedItem();
        System.out.println(addresingParameter);
        
        if (addresingParameter.equals("Directo")){
            
            this.jComboBox_addresingSubType.removeAllItems();
            this.jComboBox_addresingSubType.addItem("Send");
            this.jComboBox_addresingSubType.addItem("Receive Explícito");
            this.jComboBox_addresingSubType.addItem("Receive Implícito");
            
            
        }
        else{
            
            this.jComboBox_addresingSubType.removeAllItems();
            this.jComboBox_addresingSubType.addItem("Estático");
            this.jComboBox_addresingSubType.addItem("Dinámico");
            
        }
                
    }//GEN-LAST:event_jComboBox_adressingTypeItemStateChanged

    private void jTextField_sizeOfQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_sizeOfQueueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_sizeOfQueueActionPerformed

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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox_addresingSubType;
    private javax.swing.JComboBox<String> jComboBox_adressingType;
    private javax.swing.JComboBox<String> jComboBox_format;
    private javax.swing.JComboBox<String> jComboBox_manejoDeColas;
    private javax.swing.JComboBox<String> jComboBox_receiveParameters;
    private javax.swing.JComboBox<String> jComboBox_sendParameters;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_numberOfProcesses;
    private javax.swing.JLabel jLabel_syncSend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_direccionamiento;
    private javax.swing.JPanel jPanel_disciplinaManejoColas;
    private javax.swing.JPanel jPanel_general;
    private javax.swing.JPanel jPanel_synchronization;
    private javax.swing.JTabbedPane jTabbedPane_tabs;
    private javax.swing.JTextField jTextField_numberOfProcesses;
    private javax.swing.JTextField jTextField_sizeOfQueue;
    private javax.swing.JLabel jlabel_syncReceive;
    private javax.swing.JLabel label_title;
    // End of variables declaration//GEN-END:variables
}
