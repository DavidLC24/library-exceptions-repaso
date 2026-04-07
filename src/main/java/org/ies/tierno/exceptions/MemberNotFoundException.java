package org.ies.tierno.exceptions;

public class MemberNotFoundException extends Exception {
    private final String nif;


    public MemberNotFoundException(String nif) {
        super("Socio no encontrado con este NIF: "+nif);
        this.nif= nif;
    }

    public String getNif() {
        return nif;
    }

    @Override
    public String toString() {
        return "MemberNotFoundException{" +
                "nif='" + nif + '\'' +
                '}';
    }
}
