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
            String isbnNumber,
            String title,
            String author,
            String publisher,
            String genre,
            String edition,
            boolean available) {

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

    public static boolean writeFile(List<BookModel> books) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {

            for (BookModel b : books) {

                writer.write(String.format(
                        "%s,%s,%s,%s,%s,%s,%b%n",
                        b.getIsbnNumber(),
                        b.getTitle(),
                        b.getAuthor(),
                        b.getPublisher(),
                        b.getGenre(),
                        b.getEdition(),
                        b.getAvailable()));

            }

            return true;

        } catch (IOException e) {

            System.err.println("Error al escribir el archivo [books.txt]: " + e.getMessage());
            return false;

        }

    }

    public static List<BookModel> readFile() {

        List<BookModel> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {

            for (String line; (line = reader.readLine()) != null;) {

                String[] index = line.split(",");

                if (index.length == 7) {

                    books.add(new BookModel(
                            index[0],
                            index[1],
                            index[2],
                            index[3],
                            index[4],
                            index[5],
                            Boolean.parseBoolean(index[6])));

                }

            }

        } catch (IOException e) {

            System.err.println("Error al leer el archivo [books.txt]: " + e.getMessage());

        }

        return books;

    }

    public static String createBookInFile(BookModel book) {

        List<BookModel> books = readFile();

        books.add(book);

        if (writeFile(books)) {

            return "Libro registrado";

        } else {

            return "No se pudo registrar el libro";

        }

    }

    public static String updateBookInFile(BookModel book) {

        List<BookModel> books = readFile();

        for (BookModel b : books) {

            if (b.getIsbnNumber().equals(book.getIsbnNumber())) {

                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());
                b.setGenre(book.getGenre());
                b.setEdition(book.getEdition());
                b.setAvailable(book.getAvailable());

                if (writeFile(books)) {

                    return "Libro actualizado.";

                } else {

                    return "No se pudo actualizar el libro.";

                }

            }

        }

        return "Número ISBN no encontrado.";

    }

    public static String deleteBookFromFile(String isbnNumber) {

        List<BookModel> books = readFile();

        for (int b = 0; b < books.size(); b++) {

            if (books.get(b).getIsbnNumber().equals(isbnNumber)) {

                books.remove(b);

                if (writeFile(books)) {

                    return "Libro eliminado.";

                } else {

                    return "No se pudo eliminar el libro.";

                }

            }

        }

        return "Número ISBN no encontrado.";

    }

}
