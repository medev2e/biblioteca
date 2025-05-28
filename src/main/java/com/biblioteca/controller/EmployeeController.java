package com.biblioteca.controller;

import com.biblioteca.model.EmployeeModel;
import com.biblioteca.view.LibraryView;
import com.biblioteca.view.LoginView;

public class EmployeeController {

    private LoginView loginView;

    public EmployeeController() {

    }

    public EmployeeController(LoginView loginView) {

        this.loginView = loginView;

    }

    public void checkEmployee() {

        String username = loginView.getTxtUsuario();
        String password = new String(loginView.getTxtContraseña());

        if (EmployeeModel.checkEmployeeFromFile(username, password)) {

            loginView.mostrarMensaje("Inicio de sesión exitoso", 1);
            loginView.dispose();
            new LibraryView().setVisible(true);

        } else {

            loginView.mostrarMensaje("Usuario o contraseña inválidos", 2);

        }

    }

}
