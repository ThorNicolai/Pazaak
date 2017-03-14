package gui;

import domein.DomeinController;
import domein.Speler;
import java.util.Scanner;

public class StartUp {

    public static void main(String[] args) {

        DomeinController dc = new DomeinController();
        Scanner input = new Scanner(System.in);
        String naam;
        int geboortejaar;
        boolean flag1 = true;
        boolean flag2 = true;

        do {

            try {

                System.out.print("Geef uw gebruikersnaam in: ");
                naam = input.nextLine();

                System.out.print("Geef uw geboortejaar in: ");
                geboortejaar = input.nextInt();

                Speler speler = new Speler(naam, geboortejaar, 0);

                flag1 = false;

            } catch (IllegalArgumentException e) {

                System.out.printf("%s%n%n", e.getMessage());
                input.nextLine();

            }
        } while (flag1);

    }

}
