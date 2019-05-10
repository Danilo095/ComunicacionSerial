
package pu.vista;

import pu.controlador.PuertoSerie;
import pu.controlador.SerialArduino;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.UnsupportedCommOperationException;
import javax.swing.ImageIcon;

public class Actuadores extends javax.swing.JFrame {
    private PuertoSerie puerto;
    //private SerialArduino puertoArduino;
    SerialArduino puertoArduino=new SerialArduino();
    public String dato;
    
    public Actuadores() {
        initComponents();
lblRecibirArduino.setText("");       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbPuertoPC = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tglFoco = new javax.swing.JToggleButton();
        tglVentilador = new javax.swing.JToggleButton();
        tglNiquelina = new javax.swing.JToggleButton();
        tglLCD = new javax.swing.JToggleButton();
        lblFoco = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblLCD = new javax.swing.JLabel();
        lblNiquelina = new javax.swing.JLabel();
        lblVentilador = new javax.swing.JLabel();
        lblSnsores = new javax.swing.JLabel();
        btnPC = new javax.swing.JButton();
        cbPuertoArduino = new javax.swing.JComboBox<>();
        lblPuertoArduino = new javax.swing.JLabel();
        btnArduino = new javax.swing.JButton();
        lblRecibir = new javax.swing.JLabel();
        lblRecibirArduino = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbPuertoPC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9" }));
        cbPuertoPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPuertoPCActionPerformed(evt);
            }
        });

        jLabel1.setText("Puertos PC:");

        tglFoco.setBackground(Color.red);
        tglFoco.setText("Apagado");
        tglFoco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglFocoActionPerformed(evt);
            }
        });

        tglVentilador.setBackground(Color.red);
        tglVentilador.setText("Apagado");
        tglVentilador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglVentiladorActionPerformed(evt);
            }
        });

        tglNiquelina.setBackground(Color.red);
        tglNiquelina.setText("Apagado");
        tglNiquelina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglNiquelinaActionPerformed(evt);
            }
        });

        tglLCD.setBackground(Color.red);
        tglLCD.setText("Apagado");
        tglLCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglLCDActionPerformed(evt);
            }
        });

        lblFoco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/foco_apagado.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Foco");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Ventilador");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Niquelina");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("LCD");

        lblLCD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bienv_OFF.png"))); // NOI18N

        lblNiquelina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/niquelina_OFF.png"))); // NOI18N

        lblVentilador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventilador_OFF.png"))); // NOI18N

        lblSnsores.setFont(new java.awt.Font("Castellar", 1, 36)); // NOI18N
        lblSnsores.setText("ACTUADORES");

        btnPC.setText("Activar");
        btnPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPCActionPerformed(evt);
            }
        });

        cbPuertoArduino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9" }));

        lblPuertoArduino.setText("Puertos Arduino:");

        btnArduino.setText("Activar");
        btnArduino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArduinoActionPerformed(evt);
            }
        });

        btnEnviar.setBackground(Color.red);
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFoco)
                        .addGap(34, 34, 34)
                        .addComponent(lblVentilador)
                        .addGap(68, 68, 68)
                        .addComponent(lblNiquelina)
                        .addGap(59, 59, 59)
                        .addComponent(lblLCD)
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(tglFoco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(tglVentilador, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(tglNiquelina, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tglLCD, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel2)
                                .addGap(101, 101, 101)
                                .addComponent(jLabel3)
                                .addGap(115, 115, 115)
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lblSnsores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblRecibirArduino, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnArduino))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblPuertoArduino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbPuertoArduino, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnviar)
                        .addGap(120, 120, 120)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRecibir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPC))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(19, 19, 19)
                                .addComponent(cbPuertoPC, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))))
                    .addComponent(jLabel7))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPuertoArduino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPuertoArduino))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnArduino)
                            .addComponent(lblRecibirArduino, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar)
                        .addGap(86, 86, 86)
                        .addComponent(lblNiquelina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(cbPuertoPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 25, Short.MAX_VALUE)
                                        .addComponent(btnPC)
                                        .addGap(48, 48, 48))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblRecibir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lblSnsores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVentilador, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFoco, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblLCD)
                                .addGap(91, 91, 91)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tglFoco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tglVentilador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tglNiquelina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tglLCD)))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tglFocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglFocoActionPerformed
        // TODO add your handling code here:
        if(tglFoco.isSelected()){
            puerto.tx("0");
            tglFoco.setBackground(Color.green);
            tglFoco.setText("Encendido");
            lblFoco.setIcon(new ImageIcon(getClass().getResource("/Imagenes/foco_prendido.png")));
        }else{
                puerto.tx("1");
            tglFoco.setText("Apagado");
            lblFoco.setIcon(new ImageIcon(getClass().getResource("/Imagenes/foco_apagado.png")));
            tglFoco.setBackground(Color.red);
        }
    }//GEN-LAST:event_tglFocoActionPerformed

    private void tglVentiladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglVentiladorActionPerformed
        // TODO add your handling code here:
               if(tglVentilador.isSelected()){
            
                puerto.tx("2");
            
            tglVentilador.setBackground(Color.green);
            tglVentilador.setText("Encendido");
            lblVentilador.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ventilador.gif")));
        }else{
  
                puerto.tx("3");
            
            tglVentilador.setText("Apagado");
            lblVentilador.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ventilador_OFF.png")));
            tglVentilador.setBackground(Color.red);
        } 
    }//GEN-LAST:event_tglVentiladorActionPerformed

    private void tglNiquelinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglNiquelinaActionPerformed
        // TODO add your handling code here:
                if(tglNiquelina.isSelected()){
           
                puerto.tx("4");
           
            tglNiquelina.setBackground(Color.green);
            tglNiquelina.setText("Encendido");
            lblNiquelina.setIcon(new ImageIcon(getClass().getResource("/Imagenes/niquelina_ON.png")));
        }else{
           
                puerto.tx("5");
            
            tglNiquelina.setText("Apagado");
            lblNiquelina.setIcon(new ImageIcon(getClass().getResource("/Imagenes/niquelina_OFF.png")));
            tglNiquelina.setBackground(Color.red);
        }
    }//GEN-LAST:event_tglNiquelinaActionPerformed

    private void tglLCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglLCDActionPerformed
        // TODO add your handling code here:
                if(tglLCD.isSelected()){
           
                puerto.tx("6");
            
            tglLCD.setBackground(Color.green);
            tglLCD.setText("Encendido");
            lblLCD.setIcon(new ImageIcon(getClass().getResource("/Imagenes/bienvenida.gif")));
        }else{
           
                puerto.tx("7");
            
            tglLCD.setText("Apagado");
            lblLCD.setIcon(new ImageIcon(getClass().getResource("/Imagenes/bienv_OFF.png")));
            tglLCD.setBackground(Color.red);
        }
    }//GEN-LAST:event_tglLCDActionPerformed

    private void cbPuertoPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPuertoPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPuertoPCActionPerformed

    private void btnPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPCActionPerformed
    
        try {
            puerto=new PuertoSerie(String.valueOf(cbPuertoPC.getSelectedItem()));
        } catch (NoSuchPortException ex) {
            Logger.getLogger(Actuadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PortInUseException ex) {
            Logger.getLogger(Actuadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Actuadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedCommOperationException ex) {
            Logger.getLogger(Actuadores.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnPCActionPerformed

    private void btnArduinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArduinoActionPerformed
       
        try {
            puertoArduino.txSerial(lblRecibir.getText(),String.valueOf(cbPuertoArduino.getSelectedItem()));
        } catch (NoSuchPortException ex) {
            Logger.getLogger(Actuadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PortInUseException ex) {
            Logger.getLogger(Actuadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Actuadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedCommOperationException ex) {
            Logger.getLogger(Actuadores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnArduinoActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if(btnEnviar.isSelected()){
           for(int i=0;i<20;i++){
            puerto.tx(lblRecibirArduino.getText());   

           }
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(Actuadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actuadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actuadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actuadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Actuadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArduino;
    private javax.swing.JToggleButton btnEnviar;
    private javax.swing.JButton btnPC;
    private javax.swing.JComboBox<String> cbPuertoArduino;
    private javax.swing.JComboBox<String> cbPuertoPC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblFoco;
    private javax.swing.JLabel lblLCD;
    private javax.swing.JLabel lblNiquelina;
    private javax.swing.JLabel lblPuertoArduino;
    public static javax.swing.JLabel lblRecibir;
    public static javax.swing.JLabel lblRecibirArduino;
    private javax.swing.JLabel lblSnsores;
    private javax.swing.JLabel lblVentilador;
    private javax.swing.JToggleButton tglFoco;
    private javax.swing.JToggleButton tglLCD;
    private javax.swing.JToggleButton tglNiquelina;
    private javax.swing.JToggleButton tglVentilador;
    // End of variables declaration//GEN-END:variables
}
