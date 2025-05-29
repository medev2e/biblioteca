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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Validación de credenciales");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlVentana.setBackground(new java.awt.Color(191, 230, 255));
        pnlVentana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtUsuario.setBorder(null);
        txtUsuario.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlVentana.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 295, 170, -1));

        txtContraseña.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtContraseña.setBorder(null);
        txtContraseña.setPreferredSize(new java.awt.Dimension(170, 30));
        pnlVentana.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 335, -1, -1));

        btnIniciarSesion.setBackground(new java.awt.Color(143, 211, 255));
        btnIniciarSesion.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        btnIniciarSesion.setText("Iniciar sesión");
        btnIniciarSesion.setBorder(null);
        btnIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnIniciarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnIniciarSesion.setIconTextGap(5);
        btnIniciarSesion.setPreferredSize(new java.awt.Dimension(124, 30));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        pnlVentana.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 380, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employee.png"))); // NOI18N
        pnlVentana.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        jLabel3.setBackground(new java.awt.Color(143, 211, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/username.png"))); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setIconTextGap(0);
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(30, 30));
        pnlVentana.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 295, -1, -1));

        jLabel4.setBackground(new java.awt.Color(143, 211, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setIconTextGap(0);
        jLabel4.setOpaque(true);
        jLabel4.setPreferredSize(new java.awt.Dimension(30, 30));
        pnlVentana.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 335, -1, -1));

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnlVentana;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
