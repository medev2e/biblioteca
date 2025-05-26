package com.biblioteca.controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.biblioteca.model.BookModel;
import com.biblioteca.model.LoanModel;
import com.biblioteca.view.BookView;
import com.biblioteca.view.LoanView;

import static com.biblioteca.view.LibraryView.mostrarJPanel;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class BookController {

    private LoanView loanView;
    private LoanModel loanModel;
    private BookView bookView;
    private BookModel bookModel;

    public BookController() {
    }

    public BookController(BookView bookView, BookModel bookModel, LoanView loanView, LoanModel loanModel) {
        this.bookView = bookView;
        this.bookModel = bookModel;
        this.loanView = loanView;
        this.loanModel = loanModel;
    }

    public void createBook() {

        bookView.getBtnInsertar().setText("Registrar");
        bookView.setLblTituloDatosLibro("Nuevo libro");
        mostrarJPanel(bookView.getPnlDatosLibro());

        bookView.getBtnInsertar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                int bookRef = 0;

                List<BookModel> books = BookModel.readFile();

                for (BookModel b : books) {
                    if (b.getIsbnNumber().equals(bookView.getTxtIsbn() + "-" + Integer.toString(bookRef))) {
                        bookRef++;
                    }
                }

                String isbnNumber = bookView.getTxtIsbn() + "-" + bookRef;

                bookModel.setIsbnNumber(isbnNumber);
                bookModel.setTitle(bookView.getTxtTitulo());
                bookModel.setAuthor(bookView.getTxtAutor());
                bookModel.setPublisher(bookView.getTxtEditorial());
                bookModel.setGenre(bookView.getTxtGenero());
                bookModel.setEdition(bookView.getTxtEdicion());
                bookModel.setAvailable(true);

                bookView.mostrarMensaje(BookModel.createBookInFile(bookModel));

                mostrarJPanel(new BookView().getPnlVerLibro());

                bookView.getBtnInsertar().removeActionListener(this);
            }
        });
    }

    public void updateBook() {

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

            mostrarJPanel(bookView.getPnlDatosLibro());

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

                    mostrarJPanel(new BookView().getPnlVerLibro());

                    bookView.getBtnInsertar().removeActionListener(this);
                }
            });
        } else {
            bookView.mostrarMensaje("Seleccione una fila para editar.");
        }
    }

    public void deleteBook() {

        DefaultTableModel dtm = (DefaultTableModel) bookView.getTblDatos().getModel();
        int row = bookView.getTblDatos().getSelectedRow();

        if (row != -1) {
            bookView.mostrarMensaje(BookModel.deleteBookFromFile(dtm.getValueAt(row, 0).toString()));
            loadTable();
        } else {
            bookView.mostrarMensaje("Seleccione una fila para eliminar.");
        }
    }

    public void loanBook() {
        DefaultTableModel dtm = (DefaultTableModel) bookView.getTblDatos().getModel();
        int row = bookView.getTblDatos().getSelectedRow();

        if (row != -1) {

            if (Boolean.parseBoolean(dtm.getValueAt(row, 6).toString())) {

                loanView.getBtnInsertar().setText("Registrar");
                loanView.setLblTituloDatosPrestamo("Nuevo préstamo");
                loanView.setTxtIsbn(dtm.getValueAt(row, 0).toString());
                loanView.setTxtPrestamo(LocalDate.now());

                mostrarJPanel(loanView.getPnlDatosPrestamo());

                loanView.getBtnInsertar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {

                        loanModel.setNationalId(loanView.getTxtIdentificacion());
                        loanModel.setIsbnNumber(loanView.getTxtIsbn());
                        loanModel.setLoanDate(loanView.getTxtPrestamo());
                        loanModel.setReturnDate(loanView.getTxtEntrega());

                        loanView.mostrarMensaje(LoanModel.createLoanInFile(loanModel));

                        List<BookModel> books = BookModel.readFile();

                        for (BookModel b : books) {
                            if (b.getIsbnNumber().equals(dtm.getValueAt(row, 0).toString())) {
                                b.setAvailable(false);

                                BookModel.writeFile(books);
                            }
                        }

                        mostrarJPanel(new LoanView().getPnlVerPrestamo());

                        loanView.getBtnInsertar().removeActionListener(this);
                    }
                });
            } else {
                bookView.mostrarMensaje("Libro no disponible.");
            }

        } else {
            bookView.mostrarMensaje("Seleccione un libro para prestar.");
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
