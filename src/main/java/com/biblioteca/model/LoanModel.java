package com.biblioteca.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanModel {

    private static final String FILE = "src/main/resources/data/loans.txt";

    private String nationalId;
    private String isbnNumber;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public LoanModel() {
    }

    public LoanModel(String nationalId, String isbnNumber, LocalDate loanDate, LocalDate returnDate) {
        this.nationalId = nationalId;
        this.isbnNumber = isbnNumber;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    private static boolean writeFile(List<LoanModel> loans) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (LoanModel l : loans) {
                writer.write(String.format("%s,%s,%s,%s%n", l.getNationalId(), l.getIsbnNumber(),
                        l.getLoanDate().toString(),
                        l.getReturnDate().toString()));
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo [loans.txt]: " + e.getMessage());
            return false;
        }
    }

    public static List<LoanModel> readFile() {
        List<LoanModel> loans = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            for (String line; (line = reader.readLine()) != null;) {
                String[] index = line.split(",");
                if (index.length == 4) {
                    loans.add(
                            new LoanModel(index[0], index[1], LocalDate.parse(index[2]), LocalDate.parse(index[3])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo [loans.txt]: " + e.getMessage());

        }
        return loans;
    }

    public static String createLoanInFile(LoanModel loan) {
        List<LoanModel> loans = readFile();
        loans.add(loan);

        if (writeFile(loans)) {
            return "Préstamo registrado";
        } else {
            return "No se pudo registrar el préstamo";
        }
    }

    public static String updateLoanInFile(LoanModel loan) {
        List<LoanModel> loans = readFile();
        for (LoanModel l : loans) {
            if (l.getNationalId().equals(loan.getNationalId()) && l.getIsbnNumber().equals(loan.getIsbnNumber())) {
                l.setLoanDate(loan.getLoanDate());
                l.setReturnDate(loan.getReturnDate());

                if (writeFile(loans)) {
                    return "Préstamo actualizado";
                } else {
                    return "No se pudo actualizar el préstamo";
                }
            }
        }
        return "Préstamo no encontrado.";
    }

    public static String deleteLoanFromFile(String nationalId, String isbnNumber) {
        List<LoanModel> loans = readFile();
        for (int e = 0; e < loans.size(); e++) {
            if (loans.get(e).getNationalId().equals(nationalId) && loans.get(e).getIsbnNumber().equals(isbnNumber)) {
                loans.remove(e);

                if (writeFile(loans)) {
                    return "Libro entregado";
                } else {
                    return "No se pudo recibir la entrega";
                }
            }
        }
        return "Préstamo no encontrado.";
    }
}
