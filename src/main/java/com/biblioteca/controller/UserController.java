package com.biblioteca.controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.biblioteca.model.PenaltyModel;
import com.biblioteca.model.UserModel;
import com.biblioteca.view.PenaltyView;
import com.biblioteca.view.UserView;
import static com.biblioteca.view.LibraryView.mostrarJPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserController {

    private PenaltyView penaltyView;
    private PenaltyModel penaltyModel;
    private UserView userView;
    private UserModel userModel;

    public UserController() {

    }

    public UserController(UserView userView, UserModel userModel, PenaltyView penaltyView, PenaltyModel penaltyModel) {

        this.userView = userView;
        this.userModel = userModel;
        this.penaltyView = penaltyView;
        this.penaltyModel = penaltyModel;

    }

    public void createUser() {

        deleteListeners();
        userView.getBtnInsertar().setText("Registrar");
        userView.setLblTituloDatosUsuario("Nuevo usuario");
        mostrarJPanel(userView.getPnlDatosUsuario());

        userView.getBtnInsertar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                String typeNationalId = userView.getCboxTipoIdentificacion();
                String nationalId = userView.getTxtIdentificacion();
                String names = userView.getTxtNombres();
                String lastNames = userView.getTxtApellidos();
                String address = userView.getTxtDireccion();
                String phoneNumber = userView.getTxtTelefono();
                String email = userView.getTxtCorreo();

                if (nationalId.trim().isEmpty() || names.trim().isEmpty() || lastNames.trim().isEmpty()
                        || address.trim().isEmpty() || phoneNumber.trim().isEmpty() || email.trim().isEmpty()) {

                    userView.mostrarMensaje("Todos los campos deben ser rellenados", 2);

                } else if (!nationalId.matches("\\d+")) {

                    userView.mostrarMensaje("El documento de identidad solo debe contener números enteros", 2);

                } else if (validatorNationalId(nationalId)) {

                    userView.mostrarMensaje("El documento ya se encuentra registrado.", 2);

                } else {

                    userModel.setNationalId(typeNationalId + nationalId);
                    userModel.setNames(names);
                    userModel.setLastNames(lastNames);
                    userModel.setAddress(address);
                    userModel.setEmail(email);

                    try {

                        userModel.setPhoneNumber(Long.parseLong(phoneNumber));
                        userView.mostrarMensaje(UserModel.createUserInFile(userModel), 1);
                        userView.limpiarJTextFields();
                        mostrarJPanel(userView.getPnlVerUsuario());
                        loadTable();

                    } catch (NumberFormatException e) {

                        userView.mostrarMensaje("Número de telefono no válido.", 2);

                    }

                }

            }

        });

        userView.getBtnVolver().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                userView.limpiarJTextFields();
                mostrarJPanel(userView.getPnlVerUsuario());

            }

        });

    }

    public void updateUser() {

        deleteListeners();
        DefaultTableModel dtm = (DefaultTableModel) userView.getTblDatos().getModel();
        int row = userView.getTblDatos().getSelectedRow();

        if (row != -1) {

            String typeNationalId = dtm.getValueAt(row, 0).toString().replaceAll("[0-9]", "");
            String nationalId = dtm.getValueAt(row, 0).toString().replaceAll("[^0-9]", "");
            String names = dtm.getValueAt(row, 1).toString();
            String lastNames = dtm.getValueAt(row, 2).toString();
            String address = dtm.getValueAt(row, 3).toString();
            String phoneNumber = dtm.getValueAt(row, 4).toString();
            String email = dtm.getValueAt(row, 5).toString();

            userView.getBtnInsertar().setText("Editar");
            userView.setLblTituloDatosUsuario("Editar usuario");

            userView.setCboxTipoIdentificacion(typeNationalId);
            userView.setTxtIdentificacion(nationalId);
            userView.setTxtNombres(names);
            userView.setTxtApellidos(lastNames);
            userView.setTxtDireccion(address);
            userView.setTxtTelefono(phoneNumber);
            userView.setTxtCorreo(email);

            mostrarJPanel(userView.getPnlDatosUsuario());

            userView.getBtnInsertar().addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {

                    if (userView.getTxtNombres().trim().isEmpty() || userView.getTxtApellidos().trim().isEmpty()
                            || userView.getTxtDireccion().trim().isEmpty() || userView.getTxtTelefono().trim().isEmpty()
                            || userView.getTxtCorreo().trim().isEmpty()) {

                        userView.mostrarMensaje("Todos los campos deben estar llenos.", 2);

                    } else {

                        userModel.setNationalId(userView.getCboxTipoIdentificacion() + userView.getTxtIdentificacion());
                        userModel.setNames(userView.getTxtNombres());
                        userModel.setLastNames(userView.getTxtApellidos());
                        userModel.setAddress(userView.getTxtDireccion());
                        userModel.setEmail(userView.getTxtCorreo());

                        try {

                            userModel.setPhoneNumber(Long.parseLong(userView.getTxtTelefono()));

                            List<UserModel> users = UserModel.readFile();

                            for (UserModel u : users) {

                                if (u.getNationalId().replaceAll("[^0-9]", "")
                                        .equals(nationalId)) {

                                    u.setNationalId(userModel.getNationalId());

                                }

                            }

                            List<PenaltyModel> penalties = PenaltyModel.readFile();

                            for (PenaltyModel p : penalties) {

                                if (p.getNationalId().replaceAll("[^0-9]", "")
                                        .equals(nationalId)) {

                                    p.setNationalId(userModel.getNationalId());

                                }

                            }

                            UserModel.writeFile(users);
                            PenaltyModel.writeFile(penalties);
                            userView.mostrarMensaje(UserModel.updateUserInFile(userModel), 1);

                            userView.limpiarJTextFields();
                            mostrarJPanel(userView.getPnlVerUsuario());
                            loadTable();

                        } catch (NumberFormatException e) {

                            userView.mostrarMensaje("Número de telefono no válido.", 2);

                        }

                    }

                }

            });

            userView.getBtnVolver().addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {

                    userView.limpiarJTextFields();
                    mostrarJPanel(userView.getPnlVerUsuario());

                }

            });

        } else {

            userView.mostrarMensaje("Seleccione una fila para editar.", 2);

        }
    }

    public void deleteUser() {

        DefaultTableModel dtm = (DefaultTableModel) userView.getTblDatos().getModel();
        int row = userView.getTblDatos().getSelectedRow();

        if (row != -1) {

            userView.mostrarMensaje(UserModel.deleteUserFromFile(dtm.getValueAt(row, 0).toString()), 1);
            loadTable();

        } else {

            userView.mostrarMensaje("Seleccione una fila para eliminar.", 2);

        }

    }

    public void penalizeUser() {

        deleteListeners();
        DefaultTableModel dtm = (DefaultTableModel) userView.getTblDatos().getModel();
        int row = userView.getTblDatos().getSelectedRow();

        if (row != -1) {

            penaltyView.getBtnInsertar().setText("Penalizar");
            penaltyView.setLblTituloDatosPenalizacion("Nueva penalización");
            penaltyView.setTxtIdentificacion(dtm.getValueAt(row, 0).toString());

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

                        userView.mostrarMensaje("Todos los campos deben estar llenos.", 2);

                    } else {

                        penaltyModel.setNationalId(nationalId);
                        penaltyModel.setReason(reason);
                        penaltyModel.setAdditionalNotes(additionalNotes);
                        penaltyModel.setIsPaid(false);

                        try {

                            penaltyModel.setPenaltyAmount(Double.parseDouble(penaltyAmount));
                            penaltyView.mostrarMensaje(PenaltyModel.createPenaltyInFile(penaltyModel), 1);
                            penaltyView.limpiarJTextFields();
                            mostrarJPanel(userView.getPnlVerUsuario());

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
                    mostrarJPanel(userView.getPnlVerUsuario());

                }

            });

        } else {

            penaltyView.mostrarMensaje("Seleccione un usuario para penalizar.", 2);

        }

    }

    public void loadTable() {

        List<UserModel> users = UserModel.readFile();
        DefaultTableModel dtm = (DefaultTableModel) userView.getTblDatos().getModel();
        dtm.setRowCount(0);

        for (UserModel u : users) {

            dtm.addRow(new Object[] {

                    u.getNationalId(),
                    u.getNames(),
                    u.getLastNames(),
                    u.getAddress(),
                    u.getPhoneNumber(),
                    u.getEmail()

            });

        }

    }

    private void deleteListeners() {

        ActionListener[] listeners = userView.getBtnInsertar().getActionListeners();

        for (ActionListener l : listeners) {

            userView.getBtnInsertar().removeActionListener(l);

        }

        listeners = userView.getBtnVolver().getActionListeners();

        for (ActionListener l : listeners) {

            userView.getBtnVolver().removeActionListener(l);

        }

        listeners = penaltyView.getBtnInsertar().getActionListeners();

        for (ActionListener l : listeners) {

            penaltyView.getBtnInsertar().removeActionListener(l);

        }

        listeners = penaltyView.getBtnVolver().getActionListeners();

        for (ActionListener l : listeners) {

            penaltyView.getBtnVolver().removeActionListener(l);

        }

    }

    public boolean validatorNationalId(String nationalId) {

        List<UserModel> users = UserModel.readFile();

        for (UserModel user : users) {

            if (user.getNationalId().replaceAll("[^0-9]", "").equals(nationalId)) {

                return true;

            }

        }

        return false;

    }

}
