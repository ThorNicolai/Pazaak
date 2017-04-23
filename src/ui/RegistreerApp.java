package ui;

import domein.DomeinController;
import domein.Kaart;
import domein.Taal;
import exceptions.NaamInGebruikException;
import java.util.InputMismatchException;
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
        String naam = null;
        int geboortejaar;
        boolean flag1 = true;

        do {

            try {

                System.out.print(Taal.geefVertaling("invoerNaam"));
                naam = input.nextLine();

                System.out.print(Taal.geefVertaling("invoerGeboortejaar"));
                geboortejaar = input.nextInt();

                dc.voegSpelerToe(naam, geboortejaar, 0,null);

                flag1 = false;

            } catch (IllegalArgumentException e) {

                System.out.printf("%s%n%n", e.getMessage());
                input.nextLine();

            } catch (InputMismatchException e) {
                System.out.printf(Taal.geefVertaling("controleerInputRegistreer"));
                input.nextLine();
            } catch (NaamInGebruikException e) {
                System.out.println(Taal.geefVertaling("naamGebruikt"));
                input.nextLine();
            }

        } while (flag1 == true);
        System.out.printf("Speler %s is succesvol geregistreerd, zijn krediet bedraagt momenteel 0 euro.", naam);
        System.out.println(taal.geefVertaling("startStapel"));
    }

}
