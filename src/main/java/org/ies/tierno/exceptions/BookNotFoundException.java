package org.ies.tierno.exceptions;

public class BookNotFoundException extends Exception {
    private final long isbn;

    public BookNotFoundException( long isbn) {
        super("No se ha encontrado el libro con isbn: "+isbn);
        this.isbn = isbn;
    }

    public long getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "BookNotFoundException{" +
                "isbn='" + isbn + '\'' +
                '}';
    }
}
