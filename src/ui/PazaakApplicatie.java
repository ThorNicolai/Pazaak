package ui;

import domein.DomeinController;
import domein.Speler;
import exceptions.NaamInGebruikException;
import java.util.InputMismatchException;
import java.util.Scanner;
import resources.Taal;

public class PazaakApplicatie {

    private final DomeinController dc;
    Taal taal;
    Scanner scan = new Scanner(System.in);

    public PazaakApplicatie(DomeinController dc) {
        this.dc = dc;

    }

    public void registreer() {

        DomeinController dc = new DomeinController();
        Scanner input = new Scanner(System.in);
        String naam;
        int geboortejaar;
        boolean flag1 = true;

        do {

            try {

                System.out.print("Geef uw gebruikersnaam in: ");
                naam = input.nextLine();

                System.out.print("Geef uw geboortejaar in: ");
                geboortejaar = input.nextInt();

                dc.voegSpelerToe(naam, geboortejaar, 0);

                flag1 = false;

            } catch (IllegalArgumentException e) {

                System.out.printf("%s%n%n", e.getMessage());
                input.nextLine();

            } catch (NaamInGebruikException e) {

                System.out.printf("%s%n%n", e.getMessage());
                input.nextLine();
            }

        } while (flag1);
    }

    public Taal kiesTaal() {
        int keuze = 1;
        boolean keuzeBoolean = false;

        do {
            try {
                do {
                    System.out.printf("Kies een taal: %n1)Nederlands %n2)Français%n3)English%n");
                    keuze = scan.nextInt();
                    scan.nextLine();
                } while (keuze != 1 && keuze != 2 && keuze != 3);
                keuzeBoolean = true;
            } catch (InputMismatchException e) {
                System.out.println("De ingevoerde waarde moet 1,2 of 3 zijn.");
                scan.nextLine();
            }
        } while (keuzeBoolean == false);

        taal = new Taal(keuze);

        return taal;
    }

}
