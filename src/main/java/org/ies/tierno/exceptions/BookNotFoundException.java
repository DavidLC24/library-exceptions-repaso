package org.ies.tierno.exceptions;

public class BookNotFoundException extends Exception {
    private final String isbn;

    public BookNotFoundException( String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "BookNotFoundException{" +
                "isbn='" + isbn + '\'' +
                '}';
    }
}
