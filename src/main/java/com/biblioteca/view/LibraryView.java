package com.biblioteca.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class LibraryView extends javax.swing.JFrame {

    public LibraryView() {
        
        initComponents();
        setLocationRelativeTo(null);
        mostrarJPanel(new WelcomeView());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlOpciones = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnLibros = new javax.swing.JButton();
        btnPrestamos = new javax.swing.JButton();
        btnPenalizaciones = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlContenido = new javax.swing.JPanel();
        pnlBarra = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlOpciones.setBackground(new java.awt.Color(197, 200, 255));
        pnlOpciones.setPreferredSize(new java.awt.Dimension(220, 590));
        pnlOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setBackground(new java.awt.Color(197, 200, 255));
        btnInicio.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setBorder(null);
        btnInicio.setBorderPainted(false);
        btnInicio.setContentAreaFilled(false);
        btnInicio.setFocusPainted(false);
        btnInicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInicio.setIconTextGap(5);
        btnInicio.setOpaque(true);
        btnInicio.setPreferredSize(new java.awt.Dimension(180, 50));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 220, -1));

        btnUsuarios.setBackground(new java.awt.Color(197, 200, 255));
        btnUsuarios.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/users.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBorder(null);
        btnUsuarios.setBorderPainted(false);
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setFocusPainted(false);
        btnUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUsuarios.setIconTextGap(5);
        btnUsuarios.setOpaque(true);
        btnUsuarios.setPreferredSize(new java.awt.Dimension(180, 50));
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 220, -1));

        btnLibros.setBackground(new java.awt.Color(197, 200, 255));
        btnLibros.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/books.png"))); // NOI18N
        btnLibros.setText("Libros");
        btnLibros.setBorder(null);
        btnLibros.setBorderPainted(false);
        btnLibros.setContentAreaFilled(false);
        btnLibros.setFocusPainted(false);
        btnLibros.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLibros.setIconTextGap(5);
        btnLibros.setOpaque(true);
        btnLibros.setPreferredSize(new java.awt.Dimension(180, 50));
        btnLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrosActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 220, -1));

        btnPrestamos.setBackground(new java.awt.Color(197, 200, 255));
        btnPrestamos.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loans.png"))); // NOI18N
        btnPrestamos.setText("Préstamos");
        btnPrestamos.setBorder(null);
        btnPrestamos.setBorderPainted(false);
        btnPrestamos.setContentAreaFilled(false);
        btnPrestamos.setFocusPainted(false);
        btnPrestamos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPrestamos.setIconTextGap(5);
        btnPrestamos.setOpaque(true);
        btnPrestamos.setPreferredSize(new java.awt.Dimension(180, 50));
        btnPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamosActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnPrestamos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 220, -1));

        btnPenalizaciones.setBackground(new java.awt.Color(197, 200, 255));
        btnPenalizaciones.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnPenalizaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/penalties.png"))); // NOI18N
        btnPenalizaciones.setText("Penalizaciones");
        btnPenalizaciones.setBorder(null);
        btnPenalizaciones.setBorderPainted(false);
        btnPenalizaciones.setContentAreaFilled(false);
        btnPenalizaciones.setFocusPainted(false);
        btnPenalizaciones.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPenalizaciones.setIconTextGap(5);
        btnPenalizaciones.setOpaque(true);
        btnPenalizaciones.setPreferredSize(new java.awt.Dimension(180, 50));
        btnPenalizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenalizacionesActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnPenalizaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 220, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setIconTextGap(0);
        pnlOpciones.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 100));

        getContentPane().add(pnlOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlContenido.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenido.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 830, 450));

        pnlBarra.setBackground(new java.awt.Color(191, 230, 255));
        pnlBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrarSesion.setBackground(new java.awt.Color(143, 211, 255));
        btnCerrarSesion.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCerrarSesion.setIconTextGap(5);
        btnCerrarSesion.setPreferredSize(new java.awt.Dimension(124, 30));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        pnlBarra.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 10, -1, -1));

        getContentPane().add(pnlBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 830, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed

        javax.swing.JOptionPane.showMessageDialog(this, "Sesión cerrada.", "._.", 1);
        this.dispose();
        new LoginView().setVisible(true);
        
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUsuariosActionPerformed

        mostrarJPanel(new UserView().getPnlVerUsuario());
        
    }

    private void btnLibrosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLibrosActionPerformed

        mostrarJPanel(new BookView().getPnlVerLibro());
        
    }

    private void btnPrestamosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPrestamosActionPerformed

        mostrarJPanel(new LoanView().getPnlVerPrestamo());
        
    }

    private void btnPenalizacionesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPenalizacionesActionPerformed

        mostrarJPanel(new PenaltyView().getPnlVerPenalizacion());
        
    }

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInicioActionPerformed

        mostrarJPanel(new WelcomeView());
        
    }

    public static void mostrarJPanel(JPanel panel) {
        panel.setSize(830, 450);
        panel.setLocation(0, 0);

        pnlContenido.removeAll();
        pnlContenido.add(panel, BorderLayout.CENTER);
        pnlContenido.revalidate();
        pnlContenido.repaint();
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
            java.util.logging.Logger.getLogger(LibraryView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLibros;
    private javax.swing.JButton btnPenalizaciones;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlBarra;
    private static javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlOpciones;
    // End of variables declaration//GEN-END:variables
}
