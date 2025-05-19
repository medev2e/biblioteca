package com.biblioteca.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookModel {

    private static final String FILE = "src/main/resources/data/books.txt";

    private String isbnNumber;
    private String title;
    private String author;
    private String publisher;
    private String genre;
    private String edition;
    private boolean available;

    public BookModel() {
    }

    public BookModel(
            String isbnNumber, String title, String author, String publisher,
            String genre,
            String edition, boolean available) {
        this.isbnNumber = isbnNumber;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.edition = edition;
        this.available = available;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static String writeFile(List<BookModel> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (BookModel b : books) {
                writer.write(String.format("%s,%s,%s,%s,%s,%b%n", b.getIsbnNumber(), b.getTitle(), b.getAuthor(),
                        b.getPublisher(), b.getGenre(), b.getEdition(), b.getAvailable()));
            }
            return "Libro creado";
        } catch (IOException e) {
            return ("Error al escribir el archivo [books.txt]: " + e.getMessage());
        }
    }

    public static List<BookModel> readFile() {
        List<BookModel> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            for (String line; (line = reader.readLine()) != null;) {
                String[] index = line.split(",");
                if (index.length == 5) {
                    books.add(
                            new BookModel(index[0], index[1], index[2], index[3], index[4], index[5],
                                    Boolean.parseBoolean(index[6])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer los libros: " + e.getMessage());
        }
        return books;
    }

    public static String createBook(BookModel book) {
        List<BookModel> books = readFile();
        books.add(book);
        return writeFile(books);
    }

    public static String updateBook(BookModel book) {
        List<BookModel> books = readFile();
        for (BookModel b : books) {
            if (b.getIsbnNumber().equals(book.getIsbnNumber())) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());
                b.setGenre(book.getGenre());
                b.setEdition(book.getEdition());
                b.setAvailable(book.getAvailable());
                return writeFile(books);
            }
        }
        return "Número ISBN no encontrado.";
    }

    public static String deleteBook(BookModel book) {
        List<BookModel> books = readFile();
        for (int e = 0; e < books.size(); e++) {
            if (books.get(e).getIsbnNumber().equals(book.getIsbnNumber())) {
                books.remove(e);
                return writeFile(books);
            }
        }
        return "Número ISBN no encontrado.";
    }
}
