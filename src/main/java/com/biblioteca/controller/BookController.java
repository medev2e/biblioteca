package com.biblioteca.controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.biblioteca.model.BookModel;
import com.biblioteca.view.BookView;
import com.biblioteca.view.LibraryView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookController {

    private BookView bookView;
    private BookModel bookModel;

    public BookController() {
    }

    public BookController(BookView bookView, BookModel bookModel) {
        this.bookView = bookView;
        this.bookModel = bookModel;
    }

    public void createUser() {

        bookView.getBtnInsertar().setText("Registrar");
        bookView.setLblTituloDatosLibro("Nuevo libro");
        bookView.setEditableTxtIsbn(true);
        LibraryView.mostrarJPanel(bookView.getPnlDatosLibro());

        bookView.getBtnInsertar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                bookModel.setIsbnNumber(bookView.getTxtIsbn());
                bookModel.setTitle(bookView.getTxtTitulo());
                bookModel.setAuthor(bookView.getTxtAutor());
                bookModel.setPublisher(bookView.getTxtEditorial());
                bookModel.setGenre(bookView.getTxtGenero());
                bookModel.setEdition(bookView.getTxtEdicion());
                bookModel.setAvailable(true);

                bookView.mostrarMensaje(BookModel.createBookInFile(bookModel));

                LibraryView.mostrarJPanel(new BookView().getPnlVerLibro());

                bookView.getBtnInsertar().removeActionListener(this);
            }
        });
    }

    public void updateUser() {

        DefaultTableModel dtm = (DefaultTableModel) bookView.getTblDatos().getModel();
        int row = bookView.getTblDatos().getSelectedRow();

        if (row != -1) {

            bookView.getBtnInsertar().setText("Editar");
            bookView.setLblTituloDatosLibro("Editar libro");
            bookView.setEditableTxtIsbn(false);

            bookView.setTxtIsbn(dtm.getValueAt(row, 0).toString());
            bookView.setTxtTitulo(dtm.getValueAt(row, 1).toString());
            bookView.setTxtAutor(dtm.getValueAt(row, 2).toString());
            bookView.setTxtEditorial(dtm.getValueAt(row, 3).toString());
            bookView.setTxtGenero(dtm.getValueAt(row, 4).toString());
            bookView.setTxtEdicion(dtm.getValueAt(row, 5).toString());

            LibraryView.mostrarJPanel(bookView.getPnlDatosLibro());

            bookView.getBtnInsertar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    bookModel.setIsbnNumber(bookView.getTxtIsbn());
                    bookModel.setTitle(bookView.getTxtTitulo());
                    bookModel.setAuthor(bookView.getTxtAutor());
                    bookModel.setPublisher(bookView.getTxtEditorial());
                    bookModel.setGenre(bookView.getTxtGenero());
                    bookModel.setEdition(bookView.getTxtEdicion());
                    bookModel.setAvailable(Boolean.parseBoolean(dtm.getValueAt(row, 6).toString()));

                    bookView.mostrarMensaje(BookModel.updateBookInFile(bookModel));

                    LibraryView.mostrarJPanel(new BookView().getPnlVerLibro());

                    bookView.getBtnInsertar().removeActionListener(this);
                }
            });
        } else {
            bookView.mostrarMensaje("Seleccione una fila para editar.");
        }
    }

    public void deleteUser() {

        DefaultTableModel dtm = (DefaultTableModel) bookView.getTblDatos().getModel();
        int row = bookView.getTblDatos().getSelectedRow();

        if (row != -1) {
            bookView.mostrarMensaje(BookModel.deleteBookFromFile(dtm.getValueAt(row, 0).toString()));
            loadTable();
        } else {
            bookView.mostrarMensaje("Seleccione una fila para eliminar");
        }
    }

    public void loadTable() {
        List<BookModel> books = BookModel.readFile();
        DefaultTableModel dtm = (DefaultTableModel) bookView.getTblDatos().getModel();
        dtm.setRowCount(0);

        for (BookModel b : books) {
            dtm.addRow(new Object[] {
                    b.getIsbnNumber(),
                    b.getTitle(),
                    b.getAuthor(),
                    b.getPublisher(),
                    b.getGenre(),
                    b.getEdition(),
                    b.getAvailable()
            });
        }
    }
}
