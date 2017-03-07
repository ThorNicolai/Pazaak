package gui;

import domein.DomeinController;
import java.util.Scanner;

public class StartUp {
    
    public static void main(String[] args) {
        
        DomeinController dc = new DomeinController();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Geef uw gebruikersnaam in:");
        String naam = input.next();
        
        dc.voegSpelerToe(naam, 2000); //roept methode voegSpelerToe aan uit DC
        
    }
}
