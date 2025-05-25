package com.biblioteca.controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.biblioteca.model.LoanModel;
import static com.biblioteca.view.LibraryView.mostrarJPanel;
import com.biblioteca.view.LoanView;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class LoanController {

    private LoanView loanView;
    private LoanModel loanModel;

    public LoanController() {
    }

    public LoanController(LoanView loanView, LoanModel loanModel) {
        this.loanView = loanView;
        this.loanModel = loanModel;
    }

    public void createLoan() {

        loanView.getBtnInsertar().setText("Registrar");
        loanView.setLblTituloDatosPrestamo("Nuevo préstamo");
        loanView.setTxtPrestamo(LocalDate.now());
        loanView.setEditableTxtPrestamo(false);

        mostrarJPanel(loanView.getPnlDatosPrestamo());

        loanView.getBtnInsertar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                loanModel.setNationalId(loanView.getTxtIdentificacion());
                loanModel.setIsbnNumber(loanView.getTxtIsbn());
                loanModel.setLoanDate(loanView.getTxtPrestamo());
                loanModel.setReturnDate(loanView.getTxtEntrega());

                loanView.mostrarMensaje(LoanModel.createLoanInFile(loanModel));

                mostrarJPanel(new LoanView().getPnlVerPrestamo());

                loanView.getBtnInsertar().removeActionListener(this);
            }
        });
    }

    public void updateLoan() {

        DefaultTableModel dtm = (DefaultTableModel) loanView.getTblDatos().getModel();
        int row = loanView.getTblDatos().getSelectedRow();

        if (row != -1) {

            loanView.getBtnInsertar().setText("Editar");
            loanView.setLblTituloDatosPrestamo("Editar préstamo");
            loanView.setEditableTxtIdentificacion(false);
            loanView.setEditableTxtIsbn(false);
            loanView.setEditableTxtPrestamo(false);

            loanView.setTxtIdentificacion(dtm.getValueAt(row, 0).toString());
            loanView.setTxtIsbn(dtm.getValueAt(row, 1).toString());
            loanView.setTxtPrestamo(LocalDate.parse(dtm.getValueAt(row, 2).toString()));
            loanView.setTxtEntrega(LocalDate.parse(dtm.getValueAt(row, 3).toString()));

            mostrarJPanel(loanView.getPnlDatosPrestamo());

            loanView.getBtnInsertar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    loanModel.setNationalId(loanView.getTxtIdentificacion());
                    loanModel.setIsbnNumber(loanView.getTxtIsbn());
                    loanModel.setLoanDate(loanView.getTxtPrestamo());
                    loanModel.setReturnDate(loanView.getTxtEntrega());

                    loanView.mostrarMensaje(LoanModel.updateLoanInFile(loanModel));

                    mostrarJPanel(new LoanView().getPnlVerPrestamo());

                    loanView.getBtnInsertar().removeActionListener(this);
                }
            });
        } else {
            loanView.mostrarMensaje("Seleccione una fila para editar.");
        }
    }

    public void returnLoan() {

        DefaultTableModel dtm = (DefaultTableModel) loanView.getTblDatos().getModel();
        int row = loanView.getTblDatos().getSelectedRow();

        if (row != -1) {
            loanView.mostrarMensaje(
                    LoanModel.deleteLoanFromFile(dtm.getValueAt(row, 0).toString(), dtm.getValueAt(row, 1).toString()));
            loadTable();
        } else {
            loanView.mostrarMensaje("Seleccione una fila para recibir entrega");
        }
    }

    public void loadTable() {
        List<LoanModel> loans = LoanModel.readFile();
        DefaultTableModel dtm = (DefaultTableModel) loanView.getTblDatos().getModel();
        dtm.setRowCount(0);

        for (LoanModel l : loans) {
            dtm.addRow(new Object[] {
                    l.getNationalId(),
                    l.getIsbnNumber(),
                    l.getLoanDate(),
                    l.getReturnDate()
            });
        }
    }
}
