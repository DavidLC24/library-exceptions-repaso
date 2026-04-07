package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class BookLend {
    private String isbn;
    private Date date;
    private String nif;
    private Date devolution;
}
