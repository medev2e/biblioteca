package com.biblioteca.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PenaltyModel {

    private static final String FILE = "src/main/resources/data/penalties.txt";

    private String nationalId;
    private String reason;
    private String additionalNotes;
    private double penaltyAmount;
    private boolean isPaid;

    public PenaltyModel() {
    }

    public PenaltyModel(String nationalId, String reason, String additionalNotes, double penaltyAmount,
            boolean isPaid) {
        this.nationalId = nationalId;
        this.reason = reason;
        this.additionalNotes = additionalNotes;
        this.penaltyAmount = penaltyAmount;
        this.isPaid = isPaid;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public double getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(double penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean paid) {
        isPaid = paid;
    }

    public static String writeFile(List<PenaltyModel> penalties) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (PenaltyModel p : penalties) {
                writer.write(String.format("%s,%s,%s,%.2f,%b%n", p.getNationalId(), p.getReason(),
                        p.getAdditionalNotes(), p.getPenaltyAmount(), p.getIsPaid()));
            }
            return "Penalización creada";
        } catch (IOException e) {
            return ("Error al escribir el archivo [penalties.txt]: " + e.getMessage());
        }
    }

    public static List<PenaltyModel> readFile() {
        List<PenaltyModel> penalties = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            for (String line; (line = reader.readLine()) != null;) {
                String[] index = line.split(",");
                if (index.length == 5) {
                    penalties.add(
                            new PenaltyModel(index[0], index[1], index[2], Double.parseDouble(index[3]),
                                    Boolean.parseBoolean(index[4])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer las penalizaciones: " + e.getMessage());
        }
        return penalties;
    }

    public static String createLoan(PenaltyModel penalty) {
        List<PenaltyModel> penalties = readFile();
        penalties.add(penalty);
        return writeFile(penalties);
    }

    public static String updateLoan(PenaltyModel penalty) {
        List<PenaltyModel> penalties = readFile();
        for (PenaltyModel p : penalties) {
            if (p.getNationalId().equals(penalty.getNationalId())) {
                p.setReason(penalty.getReason());
                p.setAdditionalNotes(penalty.getAdditionalNotes());
                p.setPenaltyAmount(penalty.getPenaltyAmount());
                p.setIsPaid(penalty.getIsPaid());
                return writeFile(penalties);
            }
        }
        return "Documento de identidad no encontrado.";
    }

    public static String deleteLoan(PenaltyModel penalty) {
        List<PenaltyModel> penalties = readFile();
        for (int e = 0; e < penalties.size(); e++) {
            if (penalties.get(e).getNationalId().equals(penalty.getNationalId())) {
                penalties.remove(e);
                return writeFile(penalties);
            }
        }
        return "Documento de identidad no encontrado.";
    }
}
