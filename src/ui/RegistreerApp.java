package ui;

import domein.DomeinController;
import domein.Taal;
import exceptions.NaamInGebruikException;
import java.util.Scanner;

public class RegistreerApp {
    
    private final DomeinController dc;
    Taal taal = null;
    
    Scanner scan = new Scanner(System.in);

    public RegistreerApp(DomeinController dc) {
        this.dc = dc;
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

}
