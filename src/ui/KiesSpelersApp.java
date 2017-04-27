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

                String eersteKeuze, tweedeKeuze;

                System.out.printf("%s%n", tslapp.toonSpelersLijst());

                if (dc.geefSpelersLijst().size() < 2) {
                    System.out.println(Taal.geefVertaling("spelerTekort"));
                } else {

                    boolean flag = false;
                    do {

                        System.out.println(Taal.geefVertaling("kiesSpeler"));

                        System.out.print("Speler 1:");
                        eersteKeuze = sc.nextLine();

                        System.out.print("Speler 2:");
                        tweedeKeuze = sc.nextLine();

                        if (eersteKeuze.equals(tweedeKeuze)) {
                            System.out.println(Taal.geefVertaling("verschilSpelers"));
                            System.out.printf("%s%n", tslapp.toonSpelersLijst());
                        } else {
                            flag = true;
                        }

                    } while (flag == false);

                    dc.maakWedstrijd(eersteKeuze, tweedeKeuze);

                    for (int i = 0; i < 1; i++) {
                        for (Speler speler : dc.geefSpelersLijst()) {
                            if (eersteKeuze.equals(speler.getNaam())) {
                                gekozen2Spelers[i] = speler;
                            }
                        }
                    }

                    for (int i = 1; i < 2; i++) {
                        for (Speler speler : dc.geefSpelersLijst()) {
                            if (tweedeKeuze.equals(speler.getNaam())) {
                                gekozen2Spelers[i] = speler;
                            }
                        }
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
        String eersteKeuze = sc.nextLine();

        for (int i = 0; i < gekozen2Spelers.length; i++) {

            if (eersteKeuze.equals(gekozen2Spelers[i].getNaam())) {
                System.out.printf(Taal.geefVertaling("toegekendeWedstrijdStapel"), gekozen2Spelers[i].toString());
            }

        }

        System.out.printf("%s", mws.toonKaarten());
        mws.maakWedstrijdStapelAan(eersteKeuze, gekozen2Spelers);

        System.out.printf("1) %s%n2) %s%n", gekozen2Spelers[0], gekozen2Spelers[1]);
        System.out.print(Taal.geefVertaling("kiesStapelSpeler"));
        String tweedeKeuze = sc.nextLine();

        while (eersteKeuze.endsWith(tweedeKeuze)) {

            System.out.println(Taal.geefVertaling("heeftStapel"));

            System.out.printf("1) %s%n2) %s%n", gekozen2Spelers[0], gekozen2Spelers[1]);
            System.out.print(Taal.geefVertaling("kiesStapelSpeler"));
            tweedeKeuze = sc.nextLine();

        }

        for(int i = 0; i < gekozen2Spelers.length;i++){
            if(tweedeKeuze.equals(gekozen2Spelers[i].getNaam())){
                System.out.printf(Taal.geefVertaling("toegekendeWedstrijdStapel"), gekozen2Spelers[i].toString());
            }
        }
        System.out.printf("%s", mws.toonKaarten());
        mws.maakWedstrijdStapelAan(tweedeKeuze,gekozen2Spelers);

    }

    public void toon2GekozenSpelers() {

        for (int i = 0; i < 2; i++) {
            System.out.printf("%d) %s%n", i + 1, gekozen2Spelers[i]);
        }

    }
}
