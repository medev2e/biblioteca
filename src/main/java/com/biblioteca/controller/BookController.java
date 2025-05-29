package com.biblioteca.controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import com.biblioteca.model.BookModel;
import com.biblioteca.model.LoanModel;
import com.biblioteca.model.UserModel;
import com.biblioteca.view.BookView;
import com.biblioteca.view.LoanView;
import static com.biblioteca.view.LibraryView.mostrarJPanel;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class BookController {

    private LoanView loanView;
    private LoanModel loanModel;
    private BookView bookView;
    private BookModel bookModel;

    public BookController() {

    }

    public BookController(
            BookView bookView,
            BookModel bookModel,
            LoanView loanView,
            LoanModel loanModel) {

        this.bookView = bookView;
        this.bookModel = bookModel;
        this.loanView = loanView;
        this.loanModel = loanModel;

    }

    public void createBook() {

        deleteListeners();
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

                String isbnNumber = bookView.getTxtIsbn();
                String title = bookView.getTxtTitulo();
                String author = bookView.getTxtAutor();
                String publisher = bookView.getTxtEditorial();
                String genre = bookView.getTxtGenero();
                String edition = bookView.getTxtEdicion();

                if (isbnNumber.trim().isEmpty()
                        || title.trim().isEmpty()
                        || author.trim().isEmpty()
                        || publisher.trim().isEmpty()
                        || genre.trim().isEmpty()
                        || edition.trim().isEmpty()) {

                    bookView.mostrarMensaje("Todos los campos deben ser rellenados", 2);

                } else {

                    bookModel.setIsbnNumber(isbnNumber + "-" + bookRef);
                    bookModel.setTitle(title);
                    bookModel.setAuthor(author);
                    bookModel.setPublisher(publisher);
                    bookModel.setGenre(genre);
                    bookModel.setEdition(edition);
                    bookModel.setAvailable(true);

                    bookView.mostrarMensaje(BookModel.createBookInFile(bookModel), 1);

                    bookView.limpiarJTextFields();
                    mostrarJPanel(bookView.getPnlVerLibro());
                    loadTable();

                }
            }
        });

        bookView.getBtnVolver().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                bookView.limpiarJTextFields();
                mostrarJPanel(bookView.getPnlVerLibro());

            }

        });

    }

    public void updateBook() {

        deleteListeners();
        DefaultTableModel dtm = (DefaultTableModel) bookView.getTblDatos().getModel();
        int row = bookView.getTblDatos().getSelectedRow();

        if (row != -1) {

            String isbnNumber = dtm.getValueAt(row, 0).toString();
            String title = dtm.getValueAt(row, 1).toString();
            String author = dtm.getValueAt(row, 2).toString();
            String publisher = dtm.getValueAt(row, 3).toString();
            String genre = dtm.getValueAt(row, 4).toString();
            String edition = dtm.getValueAt(row, 5).toString();

            bookView.getBtnInsertar().setText("Editar");
            bookView.setLblTituloDatosLibro("Editar libro");
            bookView.setEditableTxtIsbn(false);

            bookView.setTxtIsbn(isbnNumber);
            bookView.setTxtTitulo(title);
            bookView.setTxtAutor(author);
            bookView.setTxtEditorial(publisher);
            bookView.setTxtGenero(genre);
            bookView.setTxtEdicion(edition);

            mostrarJPanel(bookView.getPnlDatosLibro());

            bookView.getBtnInsertar().addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {

                    if (bookView.getTxtTitulo().trim().isEmpty()
                            || bookView.getTxtAutor().trim().isEmpty()
                            || bookView.getTxtEditorial().trim().isEmpty()
                            || bookView.getTxtGenero().trim().isEmpty()
                            || bookView.getTxtEdicion().trim().isEmpty()) {

                        bookView.mostrarMensaje("Todos los campos deben ser rellenados", 2);

                    } else {

                        bookModel.setIsbnNumber(bookView.getTxtIsbn());
                        bookModel.setTitle(bookView.getTxtTitulo());
                        bookModel.setAuthor(bookView.getTxtAutor());
                        bookModel.setPublisher(bookView.getTxtEditorial());
                        bookModel.setGenre(bookView.getTxtGenero());
                        bookModel.setEdition(bookView.getTxtEdicion());
                        bookModel.setAvailable(Boolean.parseBoolean(dtm.getValueAt(row, 6).toString()));

                        bookView.mostrarMensaje(BookModel.updateBookInFile(bookModel), 1);

                        bookView.limpiarJTextFields();
                        mostrarJPanel(bookView.getPnlVerLibro());
                        loadTable();

                    }

                }

            });

            bookView.getBtnVolver().addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {

                    bookView.limpiarJTextFields();
                    mostrarJPanel(bookView.getPnlVerLibro());

                }

            });

        } else {

            bookView.mostrarMensaje("Seleccione una fila para editar.", 2);

        }

    }

    public void deleteBook() {

        DefaultTableModel dtm = (DefaultTableModel) bookView.getTblDatos().getModel();
        int row = bookView.getTblDatos().getSelectedRow();

        if (row != -1) {

            bookView.mostrarMensaje(BookModel.deleteBookFromFile(dtm.getValueAt(row, 0).toString()), 1);
            loadTable();

        } else {

            bookView.mostrarMensaje("Seleccione una fila para eliminar.", 2);

        }

    }

    public void loanBook() {

        deleteListeners();
        DefaultTableModel dtm = (DefaultTableModel) bookView.getTblDatos().getModel();
        int row = bookView.getTblDatos().getSelectedRow();

        if (row != -1) {

            if (Boolean.parseBoolean(dtm.getValueAt(row, 6).toString())) {

                loanView.getBtnInsertar().setText("Registrar");
                loanView.setLblTituloDatosPrestamo("Nuevo préstamo");
                loanView.setTxtIsbn(dtm.getValueAt(row, 0).toString());
                loanView.setTxtPrestamo(LocalDate.now().toString());

                mostrarJPanel(loanView.getPnlDatosPrestamo());

                loanView.getBtnInsertar().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {

                        if (loanView.getTxtIdentificacion().trim().isEmpty()
                                || loanView.getTxtEntrega().trim().isEmpty()) {

                            loanView.mostrarMensaje("Todos los campos deben estar llenos.", 2);

                        } else {

                            String nationalId = loanView.getTxtIdentificacion();
                            String returnDate = loanView.getTxtEntrega();

                            loanModel.setIsbnNumber(loanView.getTxtIsbn());
                            loanModel.setLoanDate(LocalDate.parse(loanView.getTxtPrestamo()));

                            List<UserModel> users = UserModel.readFile();
                            boolean userFound = false;

                            for (UserModel u : users) {

                                if (u.getNationalId().replaceAll("[^0-9]", "").equals(nationalId)) {

                                    userFound = true;
                                    nationalId = u.getNationalId();

                                    try {

                                        loanModel.setReturnDate(LocalDate.parse(returnDate));

                                        if (LocalDate.parse(returnDate).isBefore(loanModel.getLoanDate())) {

                                            loanView.mostrarMensaje(
                                                    "La fecha de entrega debe ser mayor a la del préstamo.", 2);

                                        } else {

                                            List<BookModel> books = BookModel.readFile();

                                            for (BookModel b : books) {

                                                if (b.getIsbnNumber().equals(loanModel.getIsbnNumber())) {

                                                    b.setAvailable(false);
                                                    BookModel.writeFile(books);

                                                }

                                            }

                                            loanModel.setNationalId(nationalId);
                                            loanView.limpiarJTextFields();
                                            loanView.mostrarMensaje(LoanModel.createLoanInFile(loanModel), 1);
                                            mostrarJPanel(bookView.getPnlVerLibro());
                                            loadTable();

                                        }

                                    } catch (DateTimeException e) {

                                        loanView.mostrarMensaje(
                                                "La fecha de entrega debe ser válida y con formato AAAA-MM-DD.", 2);

                                    }

                                }

                            }

                            if (!userFound) {

                                loanView.mostrarMensaje("Documento de identidad no encontrado.", 2);

                            }

                        }

                    }

                });

                loanView.getBtnVolver().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {

                        loanView.limpiarJTextFields();
                        mostrarJPanel(bookView.getPnlVerLibro());

                    }

                });

            } else {

                bookView.mostrarMensaje("Libro no disponible.", 2);

            }

        } else {

            bookView.mostrarMensaje("Seleccione un libro para prestar.", 2);

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

    private void deleteListeners() {

        ActionListener[] listeners = loanView.getBtnInsertar().getActionListeners();

        for (ActionListener l : listeners) {

            loanView.getBtnInsertar().removeActionListener(l);

        }

        listeners = loanView.getBtnVolver().getActionListeners();

        for (ActionListener l : listeners) {

            loanView.getBtnVolver().removeActionListener(l);

        }

        listeners = bookView.getBtnInsertar().getActionListeners();

        for (ActionListener l : listeners) {

            bookView.getBtnInsertar().removeActionListener(l);

        }

        listeners = bookView.getBtnVolver().getActionListeners();

        for (ActionListener l : listeners) {

            bookView.getBtnVolver().removeActionListener(l);

        }

    }
}
