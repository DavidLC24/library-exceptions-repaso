package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Data
public class BookLend {
    private long isbn;
    private LocalDate date;
    private String nif;
    private LocalDate devolution;
}
