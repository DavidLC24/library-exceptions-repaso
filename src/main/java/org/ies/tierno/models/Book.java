package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Data
public class Book {
    private long isbn;
    private String title;
    private String author;
    private List<String> genres;

    public void showInfo(){
        log.info("//Libro//");
        log.info("Isbn: "+isbn +". Título: "+title+". Autor: "+author+". Generos: "+genres+".");
    }
}
