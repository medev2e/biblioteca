package com.biblioteca.view;

import com.biblioteca.controller.EmployeeController;
import javax.swing.JOptionPane;

public class LoginView extends javax.swing.JFrame {

    private final EmployeeController employeeController;

    public LoginView() {
        
        initComponents();
        setLocationRelativeTo(null);
        employeeController = new EmployeeController(this);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVentana = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Validación de credenciales");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlVentana.setBackground(new java.awt.Color(204, 204, 255));
        pnlVentana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtUsuario.setPreferredSize(new java.awt.Dimension(185, 30));
        pnlVentana.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        txtContraseña.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtContraseña.setPreferredSize(new java.awt.Dimension(185, 30));
        pnlVentana.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 345, -1, -1));

        btnIniciarSesion.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnIniciarSesion.setText("Iniciar sesión");
        btnIniciarSesion.setPreferredSize(new java.awt.Dimension(125, 30));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        pnlVentana.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 405, -1, -1));

        lblUsuario.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("Usuario");
        lblUsuario.setPreferredSize(new java.awt.Dimension(185, 30));
        pnlVentana.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 225, -1, -1));

        lblContraseña.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblContraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContraseña.setText("Contraseña");
        lblContraseña.setPreferredSize(new java.awt.Dimension(185, 30));
        pnlVentana.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, -1));

        getContentPane().add(pnlVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 525, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed

        employeeController.checkEmployee();
        
    }//GEN-LAST:event_btnIniciarSesionActionPerformed
    
    public String getTxtUsuario() {
        
        return txtUsuario.getText();
        
    } 
    
    public char[] getTxtContraseña() {
        
        return txtContraseña.getPassword();
        
    }
    
    public void mostrarMensaje(Object objeto, int tipo) {
        
        if (tipo == JOptionPane.WARNING_MESSAGE) {
            
            javax.swing.JOptionPane.showMessageDialog(this, objeto, "Adventencia", tipo);
            
        } else if (tipo == JOptionPane.INFORMATION_MESSAGE){
            
            javax.swing.JOptionPane.showMessageDialog(this, objeto, "Acción completada", tipo);
            
        } else {
            
            javax.swing.JOptionPane.showMessageDialog(this, objeto, "._.", JOptionPane.DEFAULT_OPTION);
            
        }
        
    }
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlVentana;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
