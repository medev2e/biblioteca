package com.biblioteca.view;

import com.biblioteca.controller.UserController;
import com.biblioteca.model.PenaltyModel;
import com.biblioteca.model.UserModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class UserView extends javax.swing.JPanel {
    
    private final UserController userController;

    public UserView() {
        
        initComponents();
        userController = new UserController(this, new UserModel(), new PenaltyView(), new PenaltyModel());
        userController.loadTable();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVerUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblTituloVerUsuario = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnPenalizar = new javax.swing.JButton();
        pnlDatosUsuario = new javax.swing.JPanel();
        lblTituloDatosUsuario = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtIdentificacion = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        cboxTipoIdentificacion = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlVerUsuario.setBackground(new java.awt.Color(255, 255, 255));
        pnlVerUsuario.setPreferredSize(new java.awt.Dimension(830, 450));
        pnlVerUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDatos.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación", "Nombres", "Apellidos", "Dirección", "Teléfono", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDatos.setFillsViewportHeight(true);
        tblDatos.setGridColor(new java.awt.Color(153, 153, 153));
        tblDatos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblDatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDatos.setShowGrid(true);
        tblDatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDatos);
        if (tblDatos.getColumnModel().getColumnCount() > 0) {
            tblDatos.getColumnModel().getColumn(0).setResizable(false);
            tblDatos.getColumnModel().getColumn(1).setResizable(false);
            tblDatos.getColumnModel().getColumn(2).setResizable(false);
            tblDatos.getColumnModel().getColumn(3).setResizable(false);
            tblDatos.getColumnModel().getColumn(4).setResizable(false);
            tblDatos.getColumnModel().getColumn(5).setResizable(false);
        }

        pnlVerUsuario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 57, 818, 338));

        btnEditar.setBackground(new java.awt.Color(143, 211, 255));
        btnEditar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.setIconTextGap(5);
        btnEditar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlVerUsuario.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 410, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(143, 211, 255));
        btnEliminar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEliminar.setIconTextGap(5);
        btnEliminar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlVerUsuario.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 410, -1, -1));

        lblTituloVerUsuario.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTituloVerUsuario.setText("Usuarios");
        lblTituloVerUsuario.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlVerUsuario.add(lblTituloVerUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        btnNuevo.setBackground(new java.awt.Color(143, 211, 255));
        btnNuevo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNuevo.setIconTextGap(5);
        btnNuevo.setPreferredSize(new java.awt.Dimension(100, 30));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlVerUsuario.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 410, -1, -1));

        btnPenalizar.setBackground(new java.awt.Color(143, 211, 255));
        btnPenalizar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnPenalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/penalties.png"))); // NOI18N
        btnPenalizar.setText("Penalizar");
        btnPenalizar.setBorder(null);
        btnPenalizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPenalizar.setIconTextGap(5);
        btnPenalizar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnPenalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenalizarActionPerformed(evt);
            }
        });
        pnlVerUsuario.add(btnPenalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 410, -1, -1));

        add(pnlVerUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlDatosUsuario.setBackground(new java.awt.Color(255, 255, 255));
        pnlDatosUsuario.setPreferredSize(new java.awt.Dimension(830, 450));
        pnlDatosUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloDatosUsuario.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTituloDatosUsuario.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlDatosUsuario.add(lblTituloDatosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        txtDireccion.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtDireccion.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosUsuario.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 250, -1, -1));

        txtIdentificacion.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtIdentificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtIdentificacion.setPreferredSize(new java.awt.Dimension(210, 30));
        pnlDatosUsuario.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        txtNombres.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtNombres.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosUsuario.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        txtApellidos.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtApellidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtApellidos.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosUsuario.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        txtCorreo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtCorreo.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosUsuario.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 110, -1, -1));

        txtTelefono.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtTelefono.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosUsuario.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 180, -1, -1));

        lblCorreo.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblCorreo.setText("Correo electrónico");
        lblCorreo.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosUsuario.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 90, -1, -1));

        lblIdentificacion.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblIdentificacion.setText("Documento de identificación");
        lblIdentificacion.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosUsuario.add(lblIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        lblNombres.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblNombres.setText("Nombres");
        lblNombres.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosUsuario.add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        lblTelefono.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblTelefono.setText("Número de teléfono");
        lblTelefono.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosUsuario.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 160, -1, -1));

        lblDireccion.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblDireccion.setText("Dirección");
        lblDireccion.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosUsuario.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 230, -1, -1));

        lblApellido.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblApellido.setText("Apellidos");
        lblApellido.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosUsuario.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        btnInsertar.setBackground(new java.awt.Color(143, 211, 255));
        btnInsertar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnInsertar.setBorder(null);
        btnInsertar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInsertar.setIconTextGap(5);
        btnInsertar.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlDatosUsuario.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 345, -1, -1));

        btnVolver.setBackground(new java.awt.Color(143, 211, 255));
        btnVolver.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVolver.setIconTextGap(5);
        btnVolver.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlDatosUsuario.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 345, -1, -1));

        cboxTipoIdentificacion.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        cboxTipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C.C.", "T.I.", "C.E.", "P.P.", "NIT", "R.C." }));
        cboxTipoIdentificacion.setBorder(null);
        cboxTipoIdentificacion.setPreferredSize(new java.awt.Dimension(95, 30));
        pnlDatosUsuario.add(cboxTipoIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 110, 70, -1));

        add(pnlDatosUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        userController.updateUser();
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        userController.deleteUser();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        userController.createUser();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnPenalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenalizarActionPerformed

        userController.penalizeUser();
        
    }//GEN-LAST:event_btnPenalizarActionPerformed

    public void setTxtIdentificacion(String identificacion) {
        
        txtIdentificacion.setText(identificacion);
        
    }

    public void setTxtNombres(String nombres) {
        
        txtNombres.setText(nombres);
        
    }

    public void setTxtApellidos(String apellidos) {
        
        txtApellidos.setText(apellidos);
        
    }

    public void setTxtCorreo(String correo) {
        
        txtCorreo.setText(correo);
        
    }

    public void setTxtTelefono(String telefono) {
        
        txtTelefono.setText(telefono);
        
    }

    public void setTxtDireccion(String direccion) {
        
        txtDireccion.setText(direccion);
        
    }
    
    public String getTxtIdentificacion() {
        
        return txtIdentificacion.getText();
        
    }

    public String getTxtNombres() {
        
        return txtNombres.getText();
        
    }

    public String getTxtApellidos() {
        
        return txtApellidos.getText();
        
    }

    public String getTxtCorreo() {
        
        return txtCorreo.getText();
        
    }

    public String getTxtTelefono() {
        
        return txtTelefono.getText();
        
    }

    public String getTxtDireccion() {
        
        return txtDireccion.getText();
        
    }
    
    public void setLblTituloDatosUsuario(String titulo) {
        
        lblTituloDatosUsuario.setText(titulo);
        
    }
    
    public JPanel getPnlVerUsuario() {
        
        return pnlVerUsuario;
        
    }
    
    public JPanel getPnlDatosUsuario() {
        
        return pnlDatosUsuario;
        
    }
    
    public JTable getTblDatos() {
        
        return tblDatos;    
        
    }
    
    public JButton getBtnInsertar() {
        
        return btnInsertar;
        
    }
    
    public JButton getBtnVolver() {
        
        return btnVolver;
        
    }
    
    public void setCboxTipoIdentificacion(String selectedItem) {
        
        cboxTipoIdentificacion.setSelectedItem(selectedItem);
        
    }
    
    public String getCboxTipoIdentificacion() {
        
        return cboxTipoIdentificacion.getSelectedItem().toString();
        
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
    
    public void limpiarJTextFields() {
        
        txtNombres.setText("");
        txtApellidos.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtIdentificacion.setText("");
        txtTelefono.setText("");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPenalizar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cboxTipoIdentificacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTituloDatosUsuario;
    private javax.swing.JLabel lblTituloVerUsuario;
    private javax.swing.JPanel pnlDatosUsuario;
    private javax.swing.JPanel pnlVerUsuario;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
