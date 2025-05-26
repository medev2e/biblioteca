package com.biblioteca.controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.biblioteca.model.PenaltyModel;
import com.biblioteca.view.PenaltyView;
import static com.biblioteca.view.LibraryView.mostrarJPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PenaltyController {

    private PenaltyView penaltyView;
    private PenaltyModel penaltyModel;

    public PenaltyController() {
    }

    public PenaltyController(PenaltyView penaltyView, PenaltyModel penaltyModel) {
        this.penaltyView = penaltyView;
        this.penaltyModel = penaltyModel;
    }

    public void updatePenalty() {

        DefaultTableModel dtm = (DefaultTableModel) penaltyView.getTblDatos().getModel();
        int row = penaltyView.getTblDatos().getSelectedRow();

        if (row != -1) {

            List<PenaltyModel> penalties = PenaltyModel.readFile();

            penaltyView.getBtnInsertar().setText("Editar");
            penaltyView.setLblTituloDatosPenalizacion("Editar penalización");

            penaltyView.setTxtIdentificacion(dtm.getValueAt(row, 0).toString());
            penaltyView.setTxtAmonestacion(Double.parseDouble(dtm.getValueAt(row, 1).toString()));
            penaltyView.setTxtRazon(penalties.get(row).getReason());
            penaltyView.setTxtNota(penalties.get(row).getAdditionalNotes());

            mostrarJPanel(penaltyView.getPnlDatosPenalizacion());

            penaltyView.getBtnInsertar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    penaltyModel.setNationalId(penaltyView.getTxtIdentificacion());
                    penaltyModel.setPenaltyAmount(penaltyView.getTxtAmonestacion());
                    penaltyModel.setReason(penaltyView.getTxtRazon());
                    penaltyModel.setAdditionalNotes(penaltyView.getTxtNota());
                    penaltyModel.setIsPaid(penalties.get(row).getIsPaid());

                    penaltyView.mostrarMensaje(PenaltyModel.updatePenaltyInFile(penaltyModel), 1);

                    mostrarJPanel(new PenaltyView().getPnlVerPenalizacion());

                    penaltyView.getBtnInsertar().removeActionListener(this);
                }
            });
        } else {
            penaltyView.mostrarMensaje("Seleccione una fila para editar.", 2);
        }
    }

    public void deleteBook() {

        DefaultTableModel dtm = (DefaultTableModel) penaltyView.getTblDatos().getModel();
        int row = penaltyView.getTblDatos().getSelectedRow();

        if (row != -1) {
            penaltyView.mostrarMensaje(PenaltyModel.deletePenaltyFromFile(dtm.getValueAt(row, 0).toString()), 1);
            loadTable();
        } else {
            penaltyView.mostrarMensaje("Seleccione una fila para eliminar.", 2);
        }
    }

    public void loadTable() {
        List<PenaltyModel> penalties = PenaltyModel.readFile();
        DefaultTableModel dtm = (DefaultTableModel) penaltyView.getTblDatos().getModel();
        dtm.setRowCount(0);

        for (PenaltyModel p : penalties) {
            dtm.addRow(new Object[] {
                    p.getNationalId(),
                    p.getPenaltyAmount(),
                    p.getIsPaid()
            });
        }
    }

    public void showInfo() {

        int row = penaltyView.getTblDatos().getSelectedRow();

        if (row != -1) {

            List<PenaltyModel> penalties = PenaltyModel.readFile();
        } else {
            penaltyView.mostrarMensaje("Seleccione una fila para mostrar información adicional.", 2);
        }
    }
}
