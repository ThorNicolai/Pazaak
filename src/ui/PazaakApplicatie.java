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
    private List<Speler> lijstVanSpelers; 

    Scanner scan = new Scanner(System.in);

    public PazaakApplicatie(DomeinController dc) {
        this.dc = dc;
        
        

    }

    public int kiesOptie() {

        boolean flag = false;
        int keuze = 0;

        do {

            try {
                System.out.printf("1) Maak nieuwe speler%n2) Nieuwe wedstrijd starten%n3) Bestaande wedstrijd laden%n");
                keuze = scan.nextInt();

                scan.nextLine();

                flag = true;

            } catch (InputMismatchException e) {

                System.out.println("De waarde moet 1, 2 of 3 zijn.");
                scan.nextLine();

            }

        } while (flag = false);

        return keuze;

    }

    public void registreer() {

        DomeinController dc = new DomeinController();
        Scanner input = new Scanner(System.in);
        String naam;
        int geboortejaar;
        boolean flag1 = true;

        do {

            try {

                System.out.printf(taal.geefVertaling("invoerNaam"));
                naam = input.nextLine();

                System.out.print("Geef een geboortejaar in: ");
                geboortejaar = input.nextInt();

                dc.voegSpelerToe(naam, geboortejaar, 0);
                
                

                flag1 = false;

            } catch (IllegalArgumentException e) {

                System.out.printf("%s%n%n", e.getMessage());
                input.nextLine();
                
            } catch (Exception e) {
                System.out.println("Naam is al in gebruik! Kies een andere naam.");
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

                    System.out.printf("Kies een taal: %n1)Nederlands %n2)Français%n3)English%n");
                    keuze = scan.nextInt();
                    scan.nextLine();
                } while (keuze != 1 && keuze != 2 && keuze != 3);
                keuzeBoolean = true;
            } catch (ExceptionInInitializerError e) {
                System.out.println("De ingevoerde waarde moet 1,2 of 3 zijn.");
                scan.nextLine();
            }
        } while (keuzeBoolean == false);

        Taal taal = new Taal(keuze);

        return taal;
    }
    
    public String geefSpelers() {

        lijstVanSpelers = dc.geefSpelers();
        String lijst ="";
        int teller = 1;
        
        for(Speler overloper : lijstVanSpelers){
            
            lijst += String.format("%d) %s%n",teller,overloper.getNaam());
            
        }
        
        return lijst;

    }
    
  

}
