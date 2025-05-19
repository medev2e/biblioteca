package com.biblioteca.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel extends PersonModel {

    private static final String FILE = "src/main/resources/data/employees.txt";

    private String username;
    private String password;

    public EmployeeModel() {
        super();
    }

    public EmployeeModel(String nationalId, String names, String lastNames, String username, String password) {
        super(nationalId, names, lastNames);
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String writeFile(List<EmployeeModel> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (EmployeeModel e : employees) {
                writer.write(String.format("%s,%s,%s,%s,%s%n", e.getNationalId(), e.getNames(), e.getLastNames(),
                        e.getUsername(), e.getPassword()));
            }
            return "Empleado creado";
        } catch (IOException e) {
            return ("Error al escribir el archivo [employees.txt]: " + e.getMessage());
        }
    }

    public static List<EmployeeModel> readFile() {
        List<EmployeeModel> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            for (String line; (line = reader.readLine()) != null;) {
                String[] index = line.split(",");
                if (index.length == 5) {
                    employees.add(new EmployeeModel(index[0], index[1], index[2], index[3], index[4]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer los empleados: " + e.getMessage());
        }
        return employees;
    }

    public static boolean checkEmployee(String username, String password) {
        List<EmployeeModel> employees = readFile();
        for (EmployeeModel e : employees) {
            if (e.getUsername().equals(username) && e.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static String createEmployee(EmployeeModel employee) {
        List<EmployeeModel> employees = readFile();
        employees.add(employee);
        return writeFile(employees);
    }

    public static String updateEmployee(EmployeeModel employee) {
        List<EmployeeModel> employees = readFile();
        for (EmployeeModel e : employees) {
            if (e.getNationalId().equals(employee.getNationalId())) {
                e.setNames(employee.getNames());
                e.setLastNames(employee.getLastNames());
                e.setUsername(employee.getUsername());
                e.setPassword(employee.getPassword());
                return writeFile(employees);
            }
        }
        return "Documento de identidad no encontrado.";
    }

    public static String deleteEmployee(EmployeeModel employee) {
        List<EmployeeModel> employees = readFile();
        for (int e = 0; e < employees.size(); e++) {
            if (employees.get(e).getNationalId().equals(employee.getNationalId())) {
                employees.remove(e);
                return writeFile(employees);
            }
        }
        return "Documento de identidad no encontrado";
    }
}
