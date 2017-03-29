package ui;

import domein.DomeinController;
import domein.Taal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OptieMenu {

    private final DomeinController dc;
    Taal taal = null;
    
    Scanner scan = new Scanner(System.in);

    public OptieMenu(DomeinController dc) {
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

}
