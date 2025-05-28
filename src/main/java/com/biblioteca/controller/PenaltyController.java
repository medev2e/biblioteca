package com.biblioteca.controller;

import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import com.biblioteca.model.PenaltyModel;
import com.biblioteca.view.PenaltyView;
import static com.biblioteca.view.LibraryView.mostrarJPanel;
import java.awt.event.ActionListener;
import java.awt.Dimension;
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

        deleteListeners();
        DefaultTableModel dtm = (DefaultTableModel) penaltyView.getTblDatos().getModel();
        int row = penaltyView.getTblDatos().getSelectedRow();

        if (row != -1) {

            List<PenaltyModel> penalties = PenaltyModel.readFile();
            penaltyView.getBtnInsertar().setText("Editar");
            penaltyView.setLblTituloDatosPenalizacion("Editar penalización");

            penaltyView.setTxtIdentificacion(dtm.getValueAt(row, 0).toString());
            penaltyView.setTxtAmonestacion(dtm.getValueAt(row, 1).toString());
            penaltyView.setTxtRazon(penalties.get(row).getReason());
            penaltyView.setTxtNota(penalties.get(row).getAdditionalNotes());

            mostrarJPanel(penaltyView.getPnlDatosPenalizacion());

            penaltyView.getBtnInsertar().addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {

                    String nationalId = penaltyView.getTxtIdentificacion();
                    String penaltyAmount = penaltyView.getTxtAmonestacion();
                    String reason = penaltyView.getTxtRazon();
                    String additionalNotes = penaltyView.getTxtNota();

                    if (penaltyAmount.trim().isEmpty() || reason.trim().isEmpty()
                            || additionalNotes.trim().isEmpty()) {

                        penaltyView.mostrarMensaje("Todos los campos deben estar llenos.", 2);

                    } else {

                        penaltyModel.setNationalId(nationalId);
                        penaltyModel.setReason(reason);
                        penaltyModel.setAdditionalNotes(additionalNotes);
                        penaltyModel.setIsPaid(penalties.get(row).getIsPaid());

                        try {

                            penaltyModel.setPenaltyAmount(Double.parseDouble(penaltyAmount));
                            penaltyView.mostrarMensaje(PenaltyModel.updatePenaltyInFile(penaltyModel), 1);
                            mostrarJPanel(penaltyView.getPnlVerPenalizacion());

                        } catch (NumberFormatException e) {

                            penaltyView.mostrarMensaje("Monto de penalización debe ser de tipo numérico.", 2);

                        }

                    }

                }

            });

            penaltyView.getBtnVolver().addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {

                    penaltyView.limpiarJTextFields();
                    mostrarJPanel(penaltyView.getPnlVerPenalizacion());

                }

            });

        } else {

            penaltyView.mostrarMensaje("Seleccione una fila para editar.", 2);

        }

    }

    public void deletePenalty() {

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

            JTextArea reasonArea = new JTextArea(penalties.get(row).getReason());
            reasonArea.setEditable(false);
            reasonArea.setLineWrap(true);
            reasonArea.setWrapStyleWord(true);

            JTextArea notesArea = new JTextArea(penalties.get(row).getAdditionalNotes());
            notesArea.setEditable(false);
            notesArea.setLineWrap(true);
            notesArea.setWrapStyleWord(true);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("Razón de la amonestación:"));
            panel.add(new JScrollPane(reasonArea));
            panel.add(new JLabel("Notas adicionales:"));
            panel.add(new JScrollPane(notesArea));

            reasonArea.setPreferredSize(new Dimension(300, 80));
            notesArea.setPreferredSize(new Dimension(300, 80));

            penaltyView.mostrarMensaje(panel, 0);

        } else {

            penaltyView.mostrarMensaje("Seleccione una fila para mostrar información adicional.", 2);

        }

    }

    public void payPenalty() {

        int row = penaltyView.getTblDatos().getSelectedRow();

        List<PenaltyModel> penalties = PenaltyModel.readFile();

        if (row != -1) {

            penalties.get(row).setIsPaid(true);

            if (PenaltyModel.writeFile(penalties)) {

                penaltyView.mostrarMensaje("Amonestación pagada.", 1);
                loadTable();

            } else {

                penaltyView.mostrarMensaje("No pudo ser pagada la amonestación.", 2);

            }

        } else {

            penaltyView.mostrarMensaje("Seleccione una fila para pagar penalización.", 2);

        }

    }

    private void deleteListeners() {

        ActionListener[] listeners = penaltyView.getBtnInsertar().getActionListeners();

        for (ActionListener l : listeners) {

            penaltyView.getBtnInsertar().removeActionListener(l);

        }

        listeners = penaltyView.getBtnVolver().getActionListeners();

        for (ActionListener l : listeners) {

            penaltyView.getBtnVolver().removeActionListener(l);

        }

    }

}
