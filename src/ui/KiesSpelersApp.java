package ui;

import domein.DomeinController;
import domein.Speler;
import domein.Taal;
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
                    System.out.println(Taal.geefVertaling("spelerTekort"));
                } else {

                    boolean flag = false;
                    do {

                        System.out.println(Taal.geefVertaling("kiesSpeler"));

                        System.out.print("Speler 1:");
                        eersteKeuze = sc.nextInt();

                        System.out.print("Speler 2:");
                        tweedeKeuze = sc.nextInt();

                        if (eersteKeuze != tweedeKeuze) {
                            flag = true;
                        } else {
                            System.out.println(Taal.geefVertaling("verschilSpelers"));
                            System.out.printf("%s%n", tslapp.toonSpelersLijst());
                        }

                    } while (flag == false);

                    gekozen2Spelers = dc.maakWedstrijd(eersteKeuze, tweedeKeuze);

                    System.out.printf("speler 1 : %s%nspeler 2 : %s%n", gekozen2Spelers[0].toString(), gekozen2Spelers[1].toString());

                    System.out.println(Taal.geefVertaling("bevestig"));
                    System.out.printf("1) Ja%n2) Neen%n");
                    int keuze = sc.nextInt();

                    switch (keuze) {
                        case 1:
                            System.out.println(Taal.geefVertaling("bedankt"));
                            break;
                        case 2:
                            System.out.println(Taal.geefVertaling("annulatie"));
                            break;
                        default:
                            System.out.println(Taal.geefVertaling("onbestaand"));
                    }

                }

                flag2 = true;

            } catch (IndexOutOfBoundsException e) {
                System.out.println(Taal.geefVertaling("1onbestaand"));
            }
        } while (flag2 == false);

    }

    public void kies1Speler() {
        
        MaakWedstrijdStapel mws = new MaakWedstrijdStapel(dc);

        System.out.printf("1) %s%n2) %s%n", gekozen2Spelers[0], gekozen2Spelers[1]);
        System.out.print(Taal.geefVertaling("spelerToevoegen"));
        int eersteKeuze = sc.nextInt();

        System.out.printf(Taal.geefVertaling("toegekendeWedstrijdStapel"), gekozen2Spelers[eersteKeuze - 1].toString());
        
        
        System.out.printf("%s",mws.toonKaarten());
        mws.maakWedstrijdStapelAan(eersteKeuze - 1);
        
        System.out.printf("1) %s%n2) %s%n", gekozen2Spelers[0], gekozen2Spelers[1]);
        System.out.print(Taal.geefVertaling("kiesStapelSpeler"));
        int tweedeKeuze = sc.nextInt();

        while (eersteKeuze == tweedeKeuze) {

            System.out.println(Taal.geefVertaling("heeftStapel"));

            System.out.printf("1) %s%n2) %s%n", gekozen2Spelers[0], gekozen2Spelers[1]);
            System.out.print(Taal.geefVertaling("kiesStapelSpeler"));
            tweedeKeuze = sc.nextInt();

        } 

        System.out.printf(Taal.geefVertaling("toegekendeWedstrijdStapel"), gekozen2Spelers[tweedeKeuze - 1].toString());
        System.out.printf("%s",mws.toonKaarten());
        mws.maakWedstrijdStapelAan(tweedeKeuze - 1);

    }
}
