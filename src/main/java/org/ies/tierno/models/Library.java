package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.ies.tierno.exceptions.BookNotFoundException;
import org.ies.tierno.exceptions.MemberNotFoundException;

import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Data
public class Library {
    private String name;
    private Map<String, Book> books;
    private Map<String, Partner> partners;
    private List<BookLend> bookLends;

    public void showAllBooks(){
        for (var book: books.values()){
            book.showInfo();
        }
    }

    public void showAllPartners(){
        for (var partner: partners.values()){
            partner.showInfo();
        }
    }

    public Book returnBookByIsbn (String isbn) throws BookNotFoundException{
        if (books.containsKey(isbn)){
            return books.get(isbn);
        } else {
            throw new BookNotFoundException(isbn);
        }
    }

    public Partner returnPartnerByNif (String nif) throws MemberNotFoundException {
        if (partners.containsKey(nif)){
            return partners.get(nif);
        } else {
            throw new MemberNotFoundException(nif);
        }
    }

    public boolean PartnerLoanBook (String nif, String isbn)throws BookNotFoundException, MemberNotFoundException{
        returnBookByIsbn(isbn);
        returnPartnerByNif(nif);

        for (var booklend: bookLends){
            if (booklend.getIsbn().equals(isbn)&& booklend.getIsbn().equals(nif)){
                return true;
            }
        }
        return false;
    }
}
