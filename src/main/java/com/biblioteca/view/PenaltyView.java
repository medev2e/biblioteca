package com.biblioteca.view;

import com.biblioteca.controller.PenaltyController;
import com.biblioteca.model.PenaltyModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class PenaltyView extends javax.swing.JPanel {
    
    private final PenaltyController penaltyController;

    public PenaltyView() {
        
        initComponents();
        penaltyController = new PenaltyController(this, new PenaltyModel());
        penaltyController.loadTable();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVerPenalizacion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblTituloVerPenalizacion = new javax.swing.JLabel();
        btnInfo = new javax.swing.JButton();
        pnlDatosPenalizacion = new javax.swing.JPanel();
        lblTituloDatosPenalizacion = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtAmonestacion = new javax.swing.JTextField();
        lblAmonestacion = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();
        lblRazon = new javax.swing.JLabel();
        lblNota = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRazon = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNota = new javax.swing.JTextArea();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlVerPenalizacion.setBackground(new java.awt.Color(255, 255, 255));
        pnlVerPenalizacion.setPreferredSize(new java.awt.Dimension(830, 450));
        pnlVerPenalizacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDatos.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación del usuario", "Amonestación económica", "Pagado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblDatos);
        tblDatos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblDatos.getColumnModel().getColumnCount() > 0) {
            tblDatos.getColumnModel().getColumn(0).setResizable(false);
            tblDatos.getColumnModel().getColumn(1).setResizable(false);
            tblDatos.getColumnModel().getColumn(2).setResizable(false);
        }

        pnlVerPenalizacion.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 57, 818, 338));

        btnEditar.setBackground(new java.awt.Color(204, 204, 255));
        btnEditar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlVerPenalizacion.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 410, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 255));
        btnEliminar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlVerPenalizacion.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 410, -1, -1));

        btnPagar.setBackground(new java.awt.Color(204, 204, 255));
        btnPagar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setToolTipText("Información sobre penalización del usuario apuntado");
        btnPagar.setBorder(null);
        btnPagar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        pnlVerPenalizacion.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 410, -1, -1));

        txtBuscar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtBuscar.setMinimumSize(new java.awt.Dimension(64, 30));
        txtBuscar.setPreferredSize(new java.awt.Dimension(300, 30));
        pnlVerPenalizacion.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 12, 185, -1));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setPreferredSize(new java.awt.Dimension(90, 30));
        pnlVerPenalizacion.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 12, -1, -1));

        lblTituloVerPenalizacion.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTituloVerPenalizacion.setText("Penalizaciones");
        lblTituloVerPenalizacion.setPreferredSize(new java.awt.Dimension(140, 30));
        pnlVerPenalizacion.add(lblTituloVerPenalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        btnInfo.setBackground(new java.awt.Color(204, 204, 255));
        btnInfo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnInfo.setText("Info");
        btnInfo.setToolTipText("Información sobre penalización del usuario apuntado");
        btnInfo.setBorder(null);
        btnInfo.setPreferredSize(new java.awt.Dimension(90, 30));
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        pnlVerPenalizacion.add(btnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 410, -1, -1));

        add(pnlVerPenalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlDatosPenalizacion.setBackground(new java.awt.Color(255, 255, 255));
        pnlDatosPenalizacion.setPreferredSize(new java.awt.Dimension(830, 450));
        pnlDatosPenalizacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloDatosPenalizacion.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTituloDatosPenalizacion.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlDatosPenalizacion.add(lblTituloDatosPenalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        txtIdentificacion.setEditable(false);
        txtIdentificacion.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtIdentificacion.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosPenalizacion.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        txtAmonestacion.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtAmonestacion.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosPenalizacion.add(txtAmonestacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 110, -1, -1));

        lblAmonestacion.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblAmonestacion.setText("Amonestación económica");
        lblAmonestacion.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosPenalizacion.add(lblAmonestacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 90, -1, -1));

        lblIdentificacion.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblIdentificacion.setText("Documento de identificación");
        lblIdentificacion.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosPenalizacion.add(lblIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        lblRazon.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblRazon.setText("Razón de la amonestación");
        lblRazon.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosPenalizacion.add(lblRazon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        lblNota.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblNota.setText("Nota adiccional");
        lblNota.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosPenalizacion.add(lblNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 160, -1, -1));

        btnInsertar.setBackground(new java.awt.Color(204, 204, 255));
        btnInsertar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnInsertar.setBorder(null);
        btnInsertar.setPreferredSize(new java.awt.Dimension(90, 30));
        pnlDatosPenalizacion.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 345, -1, -1));

        btnVolver.setBackground(new java.awt.Color(204, 204, 255));
        btnVolver.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.setPreferredSize(new java.awt.Dimension(90, 30));
        pnlDatosPenalizacion.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 345, -1, -1));

        txtRazon.setColumns(20);
        txtRazon.setLineWrap(true);
        txtRazon.setRows(5);
        txtRazon.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtRazon);

        pnlDatosPenalizacion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 280, 130));

        txtNota.setColumns(20);
        txtNota.setLineWrap(true);
        txtNota.setRows(5);
        txtNota.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtNota);

        pnlDatosPenalizacion.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 180, 285, 130));

        add(pnlDatosPenalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        penaltyController.updatePenalty();
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        penaltyController.deletePenalty();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed

        penaltyController.showInfo();
        
    }//GEN-LAST:event_btnInfoActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

        penaltyController.payPenalty();
        
    }//GEN-LAST:event_btnPagarActionPerformed

    public JButton getBtnInsertar() {
        
        return btnInsertar;
        
    }
    
    public JButton getBtnVolver() {
        
        return btnVolver;
        
    }

    public void setLblTituloDatosPenalizacion(String titulo) {
        
        lblTituloDatosPenalizacion.setText(titulo);
        
    }

    public JPanel getPnlDatosPenalizacion() {
        
        return pnlDatosPenalizacion;
        
    }

    public JPanel getPnlVerPenalizacion() {
        
        return pnlVerPenalizacion;
        
    }

    public JTable getTblDatos() {
        
        return tblDatos;
        
    }

    public String getTxtAmonestacion() {
        
        return txtAmonestacion.getText();
        
    }

    public void setTxtAmonestacion(String amonestacion) {
        
        txtAmonestacion.setText(amonestacion);
        
    }

    public String getTxtIdentificacion() {
        
        return txtIdentificacion.getText();
        
    }

    public void setTxtIdentificacion(String identificacion) {
        
        txtIdentificacion.setText(identificacion);
        
    }

    public String getTxtNota() {
        
        return txtNota.getText();
        
    }

    public void setTxtNota(String nota) {
        
        txtNota.setText(nota);
        
    }

    public String getTxtRazon() {
        
        return txtRazon.getText();
        
    }

    public void setTxtRazon(String razon) {
        
        txtRazon.setText(razon);
        
    }
    
    public void limpiarJTextFields() {
        
        txtAmonestacion.setText("");
        txtNota.setText("");
        txtRazon.setText("");
        txtIdentificacion.setText("");
        
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAmonestacion;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblRazon;
    private javax.swing.JLabel lblTituloDatosPenalizacion;
    private javax.swing.JLabel lblTituloVerPenalizacion;
    private javax.swing.JPanel pnlDatosPenalizacion;
    private javax.swing.JPanel pnlVerPenalizacion;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtAmonestacion;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextArea txtNota;
    private javax.swing.JTextArea txtRazon;
    // End of variables declaration//GEN-END:variables
}
