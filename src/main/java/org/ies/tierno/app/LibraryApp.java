package org.ies.tierno.app;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ies.tierno.exceptions.BookNotFoundException;
import org.ies.tierno.exceptions.MemberNotFoundException;
import org.ies.tierno.models.Book;
import org.ies.tierno.models.BookLend;
import org.ies.tierno.models.Library;
import org.ies.tierno.models.Partner;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@AllArgsConstructor
public class LibraryApp {
    private final Scanner scanner;

    public void run(){
        var library= createLibrary();
        int opt;

        do {
            opt = chooseOption();

            if (opt==1){
                library.showAllBooks();
            } else if (opt==2) {
                library.showAllPartners();
            } else if (opt==3) {
                long isbn = askIsbn();
                try {
                    var book= library.returnBookByIsbn(isbn);
                    book.showInfo();
                } catch (BookNotFoundException e) {
                    log.error(e.getMessage());
                }

            }else if (opt==4) {
                log.info("Escribe el nif del libro: ");
                String nif= scanner.nextLine();
                try {
                    var partner= library.returnPartnerByNif(nif);
                    partner.showInfo();
                } catch (MemberNotFoundException e) {
                    log.error(e.getMessage());
                }

            }else if (opt==5) {
                long isbn = askIsbn();
                log.info("NIF del Socio: ");
                String nif= scanner.nextLine();
                try {
                    var lent= library.partnerLoanBook(nif, isbn);
                    if (lent){
                        log.info("lo ha tomado prestado");
                    } else {
                        log.info("No lo ha tomado prestado");
                    }
                } catch (BookNotFoundException e) {
                    log.error(e.getMessage());
                } catch (MemberNotFoundException e) {
                    log.error(e.getMessage());
                }
            }else if (opt==6){
                log.info("Saliendo...");
            } else {
                log.info("Opción inválida");
            }
        }while (opt!=6);
    }

    private Library createLibrary() {
        List<String> genres1= new ArrayList<>();
        genres1.add("hola");
        genres1.add("adios");
        genres1.add("ficción");

        List<String> genres2= new ArrayList<>();
        genres2.add("futurista");
        genres2.add("pasado");

        Map<Long, Book> books= new HashMap<>();

        books.put(9781234567890L, new Book(9781234567890L, "Hola", "Antonio", genres1));
        books.put(54321121L, new Book(54321121L, "Adiós", "Marta", genres2));

        Map<String, Partner> partners = new HashMap<>();
        partners.put("76854967F", new Partner("76854967F","Raúl", "Girón", 43, 24040));
        partners.put("954554963D", new Partner("954554963D","Manolo", "Peréz", 22, 27090));

        List<BookLend> booksLends= new ArrayList<>();
        booksLends.add(new BookLend(54321121L, LocalDate.now(), "76854967F", LocalDate.of(2025, 12, 1)));
        booksLends.add(new BookLend(9781234567890L, LocalDate.now(), "954554963D", LocalDate.of(2025, 12, 7)));


        return new Library("LibreLeo", books, partners, booksLends);
    }

    private long askIsbn() {
        Long isbn= null;
        do {
            try {
                log.info("Introduce el isbn: ");
                isbn= scanner.nextLong();
            } catch (InputMismatchException e) {
                log.error("EL ISBN debe ser un número");
            }finally {
                scanner.nextLine();
            }
        }while (isbn==null);
        return isbn;
    }

    private int chooseOption() {
        Integer opt= null;
        do {
            log.info("//Menú Biblioteca//");
            log.info("1. Mostrar los libros");
            log.info("2. Mostrar socios");
            log.info("3. Ver libro");
            log.info("4. Ver socio");
            log.info("5. Existe préstamo");
            log.info("6. Salir");
            try {
                opt= scanner.nextInt();
            } catch (InputMismatchException e) {
                log.error("Opción inválida, debe ser un número entero");
            } finally {
                scanner.nextLine();
            }
        } while (opt==null);

        return opt;
    }
}
