package com.biblioteca.view;

import com.biblioteca.controller.BookController;
import com.biblioteca.model.BookModel;
import com.biblioteca.model.LoanModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class BookView extends javax.swing.JPanel {
    
    private final BookController bookController;

    public BookView() {
        
        initComponents();
        bookController = new BookController(this, new BookModel(), new LoanView(), new LoanModel());
        bookController.loadTable();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVerLibro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnPrestar = new javax.swing.JButton();
        lblTituloVerLibro = new javax.swing.JLabel();
        pnlDatosLibro = new javax.swing.JPanel();
        lblTituloDatosLibro = new javax.swing.JLabel();
        txtEdicion = new javax.swing.JTextField();
        txtIsbn = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtEditorial = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        lblEditorial = new javax.swing.JLabel();
        lblIsbn = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblEdicion = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlVerLibro.setBackground(new java.awt.Color(255, 255, 255));
        pnlVerLibro.setPreferredSize(new java.awt.Dimension(830, 450));
        pnlVerLibro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDatos.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Título", "Autor", "Editorial", "Género", "Edición", "Disponible"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            tblDatos.getColumnModel().getColumn(6).setResizable(false);
        }

        pnlVerLibro.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 57, 818, 338));

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
        pnlVerLibro.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 410, -1, -1));

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
        pnlVerLibro.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 410, -1, -1));

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
        pnlVerLibro.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 410, -1, -1));

        btnPrestar.setBackground(new java.awt.Color(143, 211, 255));
        btnPrestar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnPrestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loan.png"))); // NOI18N
        btnPrestar.setText("Prestar");
        btnPrestar.setBorder(null);
        btnPrestar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPrestar.setIconTextGap(5);
        btnPrestar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });
        pnlVerLibro.add(btnPrestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 410, -1, -1));

        lblTituloVerLibro.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTituloVerLibro.setText("Libros");
        lblTituloVerLibro.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlVerLibro.add(lblTituloVerLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        add(pnlVerLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlDatosLibro.setBackground(new java.awt.Color(255, 255, 255));
        pnlDatosLibro.setMinimumSize(new java.awt.Dimension(830, 450));
        pnlDatosLibro.setPreferredSize(new java.awt.Dimension(830, 450));
        pnlDatosLibro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloDatosLibro.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTituloDatosLibro.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlDatosLibro.add(lblTituloDatosLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        txtEdicion.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtEdicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtEdicion.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosLibro.add(txtEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 250, -1, -1));

        txtIsbn.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtIsbn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtIsbn.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosLibro.add(txtIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        txtTitulo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtTitulo.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosLibro.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        txtAutor.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtAutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtAutor.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosLibro.add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        txtEditorial.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtEditorial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtEditorial.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosLibro.add(txtEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 110, -1, -1));

        txtGenero.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtGenero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(99, 192, 253)));
        txtGenero.setPreferredSize(new java.awt.Dimension(285, 30));
        pnlDatosLibro.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 180, -1, -1));

        lblEditorial.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblEditorial.setText("Editorial");
        lblEditorial.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosLibro.add(lblEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 90, -1, -1));

        lblIsbn.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblIsbn.setText("Número ISBN");
        lblIsbn.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosLibro.add(lblIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        lblTitulo.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblTitulo.setText("Título del libro");
        lblTitulo.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosLibro.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        lblGenero.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblGenero.setText("Género literario");
        lblGenero.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosLibro.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 160, -1, -1));

        lblEdicion.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblEdicion.setText("Edición del libro");
        lblEdicion.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosLibro.add(lblEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 230, -1, -1));

        lblAutor.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lblAutor.setText("Nombre del autor");
        lblAutor.setPreferredSize(new java.awt.Dimension(285, 15));
        pnlDatosLibro.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        btnInsertar.setBackground(new java.awt.Color(143, 211, 255));
        btnInsertar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnInsertar.setBorder(null);
        btnInsertar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInsertar.setIconTextGap(5);
        btnInsertar.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlDatosLibro.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 345, -1, -1));

        btnVolver.setBackground(new java.awt.Color(143, 211, 255));
        btnVolver.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVolver.setIconTextGap(5);
        btnVolver.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlDatosLibro.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 345, -1, -1));

        add(pnlDatosLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        bookController.createBook();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        bookController.updateBook();
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        bookController.deleteBook();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarActionPerformed

        bookController.loanBook();
        
    }//GEN-LAST:event_btnPrestarActionPerformed

    public JButton getBtnVolver() {
        
        return btnVolver;
        
    }
    
    public JButton getBtnInsertar() {
        
        return btnInsertar;
        
    }

    public void setLblTituloDatosLibro(String titulo) {
        
        lblTituloDatosLibro.setText(titulo);
        
    }

    public JPanel getPnlDatosLibro() {
        
        return pnlDatosLibro;
        
    }

    public JPanel getPnlVerLibro() {
        
        return pnlVerLibro;
        
    }

    public JTable getTblDatos() {
        
        return tblDatos;
        
    }

    public String getTxtAutor() {
        
        return txtAutor.getText();
        
    }

    public void setTxtAutor(String autor) {
        
        txtAutor.setText(autor);
        
    }

    public String getTxtEdicion() {
        
        return txtEdicion.getText();
        
    }

    public void setTxtEdicion(String edicion) {
        
        txtEdicion.setText(edicion);
        
    }

    public String getTxtEditorial() {
        
        return txtEditorial.getText();
        
    }

    public void setTxtEditorial(String editorial) {
        
        txtEditorial.setText(editorial);
        
    }

    public String getTxtGenero() {
        
        return txtGenero.getText();
        
    }

    public void setTxtGenero(String genero) {
        
        txtGenero.setText(genero);
        
    }

    public String getTxtIsbn() {
        
        return txtIsbn.getText();
        
    }

    public void setTxtIsbn(String isbn) {
        
        txtIsbn.setText(isbn);
        
    }
    
    public void setEditableTxtIsbn(boolean opcion) {
        
        txtIsbn.setEditable(opcion);
        
    }

    public String getTxtTitulo() {
        
        return txtTitulo.getText();
        
    }

    public void setTxtTitulo(String titulo) {
        
        txtTitulo.setText(titulo);
        
    }
    
    public void limpiarJTextFields() {
        
        txtIsbn.setText("");
        txtAutor.setText("");
        txtTitulo.setText("");
        txtGenero.setText("");
        txtEditorial.setText("");
        txtEdicion.setText("");
        
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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPrestar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblEdicion;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloDatosLibro;
    private javax.swing.JLabel lblTituloVerLibro;
    private javax.swing.JPanel pnlDatosLibro;
    private javax.swing.JPanel pnlVerLibro;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtEdicion;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
