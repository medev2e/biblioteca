package com.biblioteca.controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.biblioteca.model.UserModel;
import com.biblioteca.view.UserView;
import static com.biblioteca.view.LibraryView.mostrarJPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserController {

    private UserView userView;
    private UserModel userModel;

    public UserController() {
    }

    public UserController(UserView userView, UserModel userModel) {
        this.userView = userView;
        this.userModel = userModel;
    }

    public void createUser() {

        userView.getBtnInsertar().setText("Registrar");
        userView.setLblTituloDatosUsuario("Nuevo usuario");
        mostrarJPanel(userView.getPnlDatosUsuario());

        userView.getBtnInsertar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                userModel.setNationalId(userView.getTxtIdentificacion());
                userModel.setNames(userView.getTxtNombres());
                userModel.setLastNames(userView.getTxtApellidos());
                userModel.setAddress(userView.getTxtDireccion());
                userModel.setPhoneNumber(userView.getTxtTelefono());
                userModel.setEmail(userView.getTxtCorreo());

                userView.mostrarMensaje(UserModel.createUserInFile(userModel));

                mostrarJPanel(new UserView().getPnlVerUsuario());

                userView.getBtnInsertar().removeActionListener(this);
            }
        });
    }

    public void updateUser() {

        DefaultTableModel dtm = (DefaultTableModel) userView.getTblDatos().getModel();
        int row = userView.getTblDatos().getSelectedRow();

        if (row != -1) {

            userView.getBtnInsertar().setText("Editar");
            userView.setLblTituloDatosUsuario("Editar usuario");
            userView.setEditableTxtIdentificacion(false);

            userView.setTxtIdentificacion(dtm.getValueAt(row, 0).toString());
            userView.setTxtNombres(dtm.getValueAt(row, 1).toString());
            userView.setTxtApellidos(dtm.getValueAt(row, 2).toString());
            userView.setTxtDireccion(dtm.getValueAt(row, 3).toString());
            userView.setTxtTelefono(Long.parseLong(dtm.getValueAt(row, 4).toString()));
            userView.setTxtCorreo(dtm.getValueAt(row, 5).toString());

            mostrarJPanel(userView.getPnlDatosUsuario());

            userView.getBtnInsertar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    userModel.setNationalId(userView.getTxtIdentificacion());
                    userModel.setNames(userView.getTxtNombres());
                    userModel.setLastNames(userView.getTxtApellidos());
                    userModel.setAddress(userView.getTxtDireccion());
                    userModel.setPhoneNumber(userView.getTxtTelefono());
                    userModel.setEmail(userView.getTxtCorreo());

                    userView.mostrarMensaje(UserModel.updateUserInFile(userModel));

                    mostrarJPanel(new UserView().getPnlVerUsuario());

                    userView.getBtnInsertar().removeActionListener(this);
                }
            });
        } else {
            userView.mostrarMensaje("Seleccione una fila para editar.");
        }
    }

    public void deleteUser() {

        DefaultTableModel dtm = (DefaultTableModel) userView.getTblDatos().getModel();
        int row = userView.getTblDatos().getSelectedRow();

        if (row != -1) {
            userView.mostrarMensaje(UserModel.deleteUserFromFile(dtm.getValueAt(row, 0).toString()));
            loadTable();
        } else {
            userView.mostrarMensaje("Seleccione una fila para eliminar.");
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
}
