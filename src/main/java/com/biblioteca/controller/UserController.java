package com.biblioteca.controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.biblioteca.model.UserModel;
import com.biblioteca.view.UserView;
import com.biblioteca.view.InsertUserView;
import com.biblioteca.view.LibraryView;

public class UserController {

    private UserView userView;
    private InsertUserView insertUserView;
    private UserModel userModel;

    public UserController() {
    }

    public UserController(UserView userView, InsertUserView insertUserView, UserModel userModel) {
        this.userView = userView;
        this.insertUserView = insertUserView;
        this.userModel = userModel;

        initInsertUserListeners();
    }

    public void createUser() {

        userModel.setNationalId(insertUserView.getTxtIdentificacion());
        userModel.setNames(insertUserView.getTxtNombres());
        userModel.setLastNames(insertUserView.getTxtApellidos());
        userModel.setAddress(insertUserView.getTxtDireccion());
        userModel.setPhoneNumber(insertUserView.getTxtTelefono());
        userModel.setEmail(insertUserView.getTxtCorreo());

        userView.mostrarMensaje(UserModel.createUserInFile(userModel)); // "Cambio escrito";
    }

    public void updateUser() {

        userModel.setNationalId(insertUserView.getTxtIdentificacion());
        userModel.setNames(insertUserView.getTxtNombres());
        userModel.setLastNames(insertUserView.getTxtApellidos());
        userModel.setAddress(insertUserView.getTxtDireccion());
        userModel.setPhoneNumber(insertUserView.getTxtTelefono());
        userModel.setEmail(insertUserView.getTxtCorreo());

        userView.mostrarMensaje(UserModel.updateUserInFile(userModel));
    }

    public void deleteUser() {

        DefaultTableModel dtm = (DefaultTableModel) userView.getTblDatos().getModel();
        int row = userView.getTblDatos().getSelectedRow();

        if (row != -1) {
            userView.mostrarMensaje(UserModel.deleteUserFromFile(dtm.getValueAt(row, 0).toString()));
            loadTable();
        } else {
            userView.mostrarMensaje("Seleccione una fila para eliminar");
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

    public void initInsertUserListeners() {
        insertUserView.getBtnInsertar().addActionListener(e -> {
            if ("Editar usuario".equals(insertUserView.getLblTituloDePagina())) {
                updateUser();
            } else {
                createUser();
            }
            insertUserView.setEditableTxtIdentificacion(true);
            insertUserView.clearJTextFields();
            LibraryView.mostrarJPanel(userView);
            loadTable();
        });

        insertUserView.getBtnDescartar().addActionListener(e -> {
            insertUserView.setEditableTxtIdentificacion(true);
            insertUserView.clearJTextFields();
            LibraryView.mostrarJPanel(userView);
        });
    }
}
