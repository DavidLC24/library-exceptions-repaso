package org.ies.tierno.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Data
public class Partner {
    private String nif;
    private String name;
    private String surname;
    private int number;
    private int zipCode;

    public void showInfo(){
        log.info("//Departamento//");
        log.info("Nif: "+nif+". Nombre: "+name+". Apellido: "+surname+". Número: "+number+". Código postal: "+zipCode+".");
    }
}
