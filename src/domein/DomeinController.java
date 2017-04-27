package domein;

import domein.Taal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import persistentie.KaartMapper;

public class DomeinController {

    private SpelerRepository spelerrepo;

    private Taal taal;
    Speler[] spelers = new Speler[2];
    private KaartMapper km;
    private Speler speler;
    private KaartRepository kr;

    Scanner sc = new Scanner(System.in);

    public DomeinController() {
        spelerrepo = new SpelerRepository();
        km = new KaartMapper();

    }

    public void voegSpelerToe(String naam, int geboortejaar, int krediet, Kaart[] wedstrijdStapel) {

        Speler nieuweSpeler = new Speler(naam, geboortejaar, krediet, wedstrijdStapel);
        spelerrepo.voegSpelerToe(nieuweSpeler);

    }

    public List<Speler> geefSpelersLijst() {

        return spelerrepo.geefSpelersLijst();

    }

    public void maakWedstrijd(String eersteKeuze, String tweedeKeuze) {

        Wedstrijd wed = new Wedstrijd(eersteKeuze, tweedeKeuze);

    }

    public void maakWedstrijdStapel(String geselecteerdeSpeler, Speler[] gekozen2Spelers) {

        String keuze;

        Kaart[] gekozenKaarten = new Kaart[6];

        for (int i = 0; i < gekozenKaarten.length; i++) {

            System.out.print(Taal.geefVertaling("Keuze"));
            keuze = sc.nextLine();

            for (Kaart kaart : km.geefKaarten()) {

                if (keuze.equals(kaart.toString())) {

                    gekozenKaarten[i] = kaart;

                }
            }

        }

//        for(Kaart overloper : echteWedStapel){
//            System.out.printf("%s",overloper.toString());
//        }
        for (int j = 0; j < gekozen2Spelers.length; j++) {
            if (geselecteerdeSpeler.equals(gekozen2Spelers[j].getNaam())) {
                gekozen2Spelers[j].setWedstrijdStapel(gekozenKaarten);
            }
        }

        for (int j = 0; j < gekozen2Spelers.length; j++) {
            if (geselecteerdeSpeler.equals(gekozen2Spelers[j].getNaam())) {
                for(int k = 0; k < gekozen2Spelers[j].getWedstrijdStapel().length;k++){
                    System.out.printf(String.format("%s%n",gekozen2Spelers[j].getWedstrijdStapel()[k]));
                }
                
            }
        }
    }

    public List<Kaart> geefKaarten() {

        return km.geefKaarten();

    }
}
