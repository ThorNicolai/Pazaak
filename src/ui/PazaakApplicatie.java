package ui;

import domein.DomeinController;
import domein.Speler;
import domein.SpelerRepository;
import exceptions.NaamInGebruikException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import persistentie.Connectie;
import domein.Taal;
import java.util.ArrayList;

public class PazaakApplicatie {

    private final DomeinController dc;
    Taal taal = null;

    Scanner scan = new Scanner(System.in);

    public PazaakApplicatie(DomeinController dc) {
        this.dc = dc;

    }

    public int kiesOptie() {

        boolean flag = false;
        int keuze = 0;

        do {

            try {
                do {
                    System.out.printf("1) Maak nieuwe speler%n2) Start nieuwe wedstrijd%n3) Laad bestaande wedstrijd%n");
                    keuze = scan.nextInt();

                    scan.nextLine();
                } while (keuze != 1 && keuze != 2 && keuze != 3);
                flag = true;

            } catch (InputMismatchException e) {

                System.out.println("De waarde moet 1, 2 of 3 zijn.");
                scan.nextLine();

            }

        } while (flag == false);

        return keuze;

    }

    public void registreer() {

        //DomeinController dc = new DomeinController();
        Scanner input = new Scanner(System.in);
        String naam;
        int geboortejaar;
        boolean flag1 = true;

        do {

            try {

                System.out.printf(taal.geefVertaling("invoerNaam"));
                naam = input.nextLine();

                System.out.print(taal.geefVertaling("invoerGeboortejaar"));
                geboortejaar = input.nextInt();

                dc.voegSpelerToe(naam, geboortejaar, 0);

                flag1 = false;

            } catch (IllegalArgumentException e) {

                System.out.printf("%s%n%n", e.getMessage());
                input.nextLine();

            } catch (NaamInGebruikException e) {
                System.out.println("Naam is al in gebruik! kies een andere naam!");
                input.nextLine();
            }

        } while (flag1 == true);
    }

    public Taal kiesTaal() {
        int keuze = 1;
        boolean keuzeBoolean = false;

        do {
            try {
                do {

                    System.out.printf("Choose a language: %n1)Nederlands %n2)Français%n3)English%n");
                    keuze = scan.nextInt();
                    scan.nextLine();
                } while (keuze != 1 && keuze != 2 && keuze != 3);
                keuzeBoolean = true;
            } catch (InputMismatchException e) {
                System.out.println(("The selection must be 1,2 or 3"));
                scan.nextLine();
            }
        } while (keuzeBoolean == false);

        Taal taal = new Taal(keuze);
        System.out.println(taal.geefVertaling("taal"));
        return taal;
    }

    public String toonSpelersLijst() {

        String overzicht = "";
        int teller = 1;
        for (String overloper : dc.geefSpelersLijst()) {
            overzicht += String.format("%d) %s%n", teller, overloper);
            teller++;
        }

        return overzicht;

    }
}
