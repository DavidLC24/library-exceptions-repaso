package org.ies.tierno;

import org.ies.tierno.app.LibraryApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        LibraryApp libraryApp= new LibraryApp(scanner);
        libraryApp.run();
    }
}
