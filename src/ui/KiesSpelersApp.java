package ui;

import domein.DomeinController;
import domein.Speler;
import java.util.Scanner;

public class KiesSpelersApp {

    private final DomeinController dc;
    Speler[] gekozen2Spelers = new Speler[2];

    Scanner sc = new Scanner(System.in);

    public KiesSpelersApp(DomeinController dc) {
        this.dc = dc;
    }

    public void kies2Spelers() {

        ToonSpelerLijstApp tslapp = new ToonSpelerLijstApp(dc);

        boolean flag2 = false;

        do {
            try {

                int eersteKeuze;
                int tweedeKeuze;

                System.out.printf("%s%n", tslapp.toonSpelersLijst());

                if (dc.geefSpelersLijst().length < 2) {
                    System.out.println("Er zijn te weinig spelers om een wedstrijd te starten! Onze excuses voor het ongemak!");
                } else {

                    boolean flag = false;
                    do {

                        System.out.println("Kies een speler om het spel mee te spelen!");

                        System.out.print("Speler 1:");
                        eersteKeuze = sc.nextInt();

                        System.out.print("Speler 2:");
                        tweedeKeuze = sc.nextInt();

                        if (eersteKeuze != tweedeKeuze) {
                            flag = true;
                        } else {
                            System.out.println("Je moet 2 verschillende spelers kiezen!");
                            System.out.printf("%s%n", tslapp.toonSpelersLijst());
                        }

                    } while (flag == false);

                    gekozen2Spelers = dc.maakWedstrijd(eersteKeuze, tweedeKeuze);

                    System.out.printf("speler 1 : %s%nspeler 2 : %s%n", gekozen2Spelers[0].toString(), gekozen2Spelers[1].toString());

                    System.out.println("Bevestig de wedstrijd!");
                    System.out.printf("1) Ja%n2) Neen%n");
                    int keuze = sc.nextInt();

                    switch (keuze) {
                        case 1:
                            System.out.println("Bedankt! u kan verder!");
                            break;
                        case 2:
                            System.out.println("Oei, wilt u annuleren?");
                            break;
                        default:
                            System.out.println("Deze speler bestaat niet!");
                    }

                }

                flag2 = true;

            } catch (IndexOutOfBoundsException e) {
                System.out.println("1 of beide spelers bestaan niet! ");
            }
        } while (flag2 == false);

    }

    public void kies1Speler() {
        
        MaakWedstrijdStapel mws = new MaakWedstrijdStapel(dc);

        System.out.printf("1) %s%n2) %s%n", gekozen2Spelers[0], gekozen2Spelers[1]);
        System.out.print("Kies een speler om een wedstrijdstapel aan toe te voegen: ");
        int eersteKeuze = sc.nextInt();

        System.out.printf("Speler die een wedstrijdstapel wordt toegekend: %s%n", gekozen2Spelers[eersteKeuze - 1].toString());
        
        
        System.out.printf("%s",mws.toonKaarten());
        mws.maakWedstrijdStapelAan();
        
        System.out.printf("1) %s%n2) %s%n", gekozen2Spelers[0], gekozen2Spelers[1]);
        System.out.print("Kies een speler om een wedstrijdstapel aan toe te voegen: ");
        int tweedeKeuze = sc.nextInt();

        while (eersteKeuze == tweedeKeuze) {

            System.out.println("De speler heeft al een wedstrijdstapel! kies een andere alstublieft.");

            System.out.printf("1) %s%n2) %s%n", gekozen2Spelers[0], gekozen2Spelers[1]);
            System.out.print("Kies een speler om een wedstrijdstapel aan toe te voegen: ");
            tweedeKeuze = sc.nextInt();

        } 

        System.out.printf("Speler die een wedstrijdstapel wordt toegekend: %s%n", gekozen2Spelers[tweedeKeuze - 1].toString());
        System.out.printf("%s",mws.toonKaarten());
        mws.maakWedstrijdStapelAan();

    }
}
