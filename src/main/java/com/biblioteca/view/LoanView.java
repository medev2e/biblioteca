package com.biblioteca.view;

import com.biblioteca.controller.LoanController;
import com.biblioteca.model.LoanModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class LoanView extends javax.swing.JPanel {
    
    private final LoanController loanController;

    public LoanView() {
        
        initComponents();
        loanController = new LoanController(this, new LoanModel());
        loanController.loadTable();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVerPrestamo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEntrega = new javax.swing.JButton();
        lblTituloVerPrestamo = new javax.swing.JLabel();
        pnlDatosPrestamo = new javax.swing.JPanel();
        lblTituloDatosPrestamo = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtPrestamo = new javax.swing.JTextField();
        txtIsbn = new javax.swing.JTextField();
        txtEntrega = new javax.swing.JTextField();
        lblIsbn = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();
        lblPrestamo = new javax.swing.JLabel();
        lblEntregar = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1860, 450));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlVerPrestamo.setBackground(new java.awt.Color(255, 255, 255));
        pnlVerPrestamo.setPreferredSize(new java.awt.Dimension(930, 590));
        pnlVerPrestamo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDatos.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación del usuario", "ISBN prestado", "Fecha de préstamo", "Fecha de entrega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        }

        pnlVerPrestamo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 910, 490));

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
        pnlVerPrestamo.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, -1, -1));

        btnEntrega.setBackground(new java.awt.Color(143, 211, 255));
        btnEntrega.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
        btnEntrega.setText("Entrega");
        btnEntrega.setBorder(null);
        btnEntrega.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEntrega.setIconTextGap(5);
        btnEntrega.setPreferredSize(new java.awt.Dimension(100, 30));
        btnEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregaActionPerformed(evt);
            }
        });
        pnlVerPrestamo.add(btnEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 550, -1, -1));

        lblTituloVerPrestamo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTituloVerPrestamo.setText("Préstamos");
        lblTituloVerPrestamo.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlVerPrestamo.add(lblTituloVerPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        add(pnlVerPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 590));

        pnlDatosPrestamo.setBackground(new java.awt.Color(255, 255, 255));
        pnlDatosPrestamo.setPreferredSize(new java.awt.Dimension(830, 450));
        pnlDatosPrestamo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloDatosPrestamo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTituloDatosPrestamo.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlDatosPrestamo.add(lblTituloDatosPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        txtIdentificacion.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtIdentificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtIdentificacion.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosPrestamo.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        txtPrestamo.setEditable(false);
        txtPrestamo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtPrestamo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtPrestamo.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosPrestamo.add(txtPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        txtIsbn.setEditable(false);
        txtIsbn.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtIsbn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtIsbn.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosPrestamo.add(txtIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, -1));

        txtEntrega.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtEntrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtEntrega.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosPrestamo.add(txtEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));

        lblIsbn.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblIsbn.setText("ISBN del libro");
        lblIsbn.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosPrestamo.add(lblIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, -1, -1));

        lblIdentificacion.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblIdentificacion.setText("Documento del usuario");
        lblIdentificacion.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosPrestamo.add(lblIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        lblPrestamo.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblPrestamo.setText("Fecha de préstamo");
        lblPrestamo.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosPrestamo.add(lblPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        lblEntregar.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblEntregar.setText("Fecha de entrega");
        lblEntregar.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosPrestamo.add(lblEntregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));

        btnInsertar.setBackground(new java.awt.Color(143, 211, 255));
        btnInsertar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnInsertar.setBorder(null);
        btnInsertar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInsertar.setIconTextGap(5);
        btnInsertar.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlDatosPrestamo.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 370, -1, -1));

        btnVolver.setBackground(new java.awt.Color(143, 211, 255));
        btnVolver.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVolver.setIconTextGap(5);
        btnVolver.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlDatosPrestamo.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 370, -1, -1));

        add(pnlDatosPrestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 930, 590));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        loanController.updateLoan();
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregaActionPerformed

        loanController.returnLoan();
        
    }//GEN-LAST:event_btnEntregaActionPerformed

    public JButton getBtnInsertar() {
        
        return btnInsertar;
        
    }
    
    public JButton getBtnVolver() {
        
        return btnVolver;
        
    }

    public void setLblTituloDatosPrestamo(String titulo) {
        
        lblTituloDatosPrestamo.setText(titulo);
        
    }

    public JPanel getPnlDatosPrestamo() {
        
        return pnlDatosPrestamo;
        
    }

    public JPanel getPnlVerPrestamo() {
        
        return pnlVerPrestamo;
        
    }

    public JTable getTblDatos() {
        
        return tblDatos;
        
    }

    public String getTxtEntrega() {
        
        return txtEntrega.getText();
        
    }

    public void setTxtEntrega(String entrega) {
        
        txtEntrega.setText(entrega);
        
    }

    public String getTxtIdentificacion() {
        
        return txtIdentificacion.getText();
        
    }

    public void setTxtIdentificacion(String identificacion) {
        
        txtIdentificacion.setText(identificacion);
        
    }

    public String getTxtIsbn() {
        
        return txtIsbn.getText();
        
    }

    public void setTxtIsbn(String isbn) {
        
        txtIsbn.setText(isbn);
        
    }

    public String getTxtPrestamo() {
        
        return txtPrestamo.getText();
        
    }

    public void setTxtPrestamo(String prestamo) {
        
        txtPrestamo.setText(prestamo);
        
    }
    
    public void setEditableTxtIdentificacion(boolean opcion) {
        
        txtIdentificacion.setEditable(opcion);
        
    }
    
    public void setEditableTxtIsbn(boolean opcion) {
        
        txtIsbn.setEditable(opcion);
        
    }
    
    public void limpiarJTextFields() {
        
        txtIsbn.setText("");
        txtIdentificacion.setText("");
        txtPrestamo.setText("");
        txtEntrega.setText("");
        
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
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEntrega;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEntregar;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JLabel lblPrestamo;
    private javax.swing.JLabel lblTituloDatosPrestamo;
    private javax.swing.JLabel lblTituloVerPrestamo;
    private javax.swing.JPanel pnlDatosPrestamo;
    private javax.swing.JPanel pnlVerPrestamo;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtEntrega;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtPrestamo;
    // End of variables declaration//GEN-END:variables
}
