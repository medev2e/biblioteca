package com.biblioteca.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserModel extends PersonModel {

    private static final String FILE = "src/main/resources/data/users.txt";

    private String address;
    private long phoneNumber;
    private String email;

    public UserModel() {
        super();
    }

    public UserModel(String nationalId, String names, String lastNames, String address, long phoneNumber,
            String email) {
        super(nationalId, names, lastNames);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static boolean writeFile(List<UserModel> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (UserModel u : users) {
                writer.write(String.format("%s,%s,%s,%s,%d,%s%n", u.getNationalId(), u.getNames(), u.getLastNames(),
                        u.getAddress(), u.getPhoneNumber(), u.getEmail()));
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo [users.txt]: " + e.getMessage());
            return false;
        }
    }

    public static List<UserModel> readFile() {
        List<UserModel> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            for (String line; (line = reader.readLine()) != null;) {
                String[] index = line.split(",");
                if (index.length == 6) {
                    users.add(
                            new UserModel(index[0], index[1], index[2], index[3], Long.parseLong(index[4]), index[5]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo [users.txt]: " + e.getMessage());
        }
        return users;
    }

    public static String createUserInFile(UserModel user) {
        List<UserModel> users = readFile();
        users.add(user);

        if (writeFile(users)) {
            return "Usuario registrado.";
        } else {
            return "No se pudo registrar el usuario.";
        }
    }

    public static String updateUserInFile(UserModel user) {
        List<UserModel> users = readFile();
        for (UserModel u : users) {
            if (u.getNationalId().equals(user.getNationalId())) {
                u.setNames(user.getNames());
                u.setLastNames(user.getLastNames());
                u.setAddress(user.getAddress());
                u.setPhoneNumber(user.getPhoneNumber());
                u.setEmail(user.getEmail());

                if (writeFile(users)) {
                    return "Usuario actualizado.";
                } else {
                    return "No se pudo actualizar el usuario.";
                }
            }
        }
        return "Documento de identidad no encontrado.";
    }

    public static String deleteUserFromFile(String nationalId) {
        List<UserModel> users = readFile();
        for (int u = 0; u < users.size(); u++) {
            if (users.get(u).getNationalId().equals(nationalId)) {
                users.remove(u);

                if (writeFile(users)) {
                    return "Usuario eliminado.";
                } else {
                    return "No se pudo eliminar el usuario.";
                }
            }
        }
        return "Documento de identidad no encontrado.";
    }
}
