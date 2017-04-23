package domein;

import domein.Taal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import persistentie.KaartMapper;

public class DomeinController {

    private SpelerRepository spelerrepo;
    private Wedstrijd wedstrijd;
    private Taal taal;
    Speler[] spelers = new Speler[2];
    private KaartMapper km;
    private Speler speler;


    Scanner sc = new Scanner(System.in);

    public DomeinController() {
        spelerrepo = new SpelerRepository();
        km = new KaartMapper();

    }

    public void voegSpelerToe(String naam, int geboortejaar, int krediet, Kaart[] wedstrijdStapel) {

        Speler nieuweSpeler = new Speler(naam, geboortejaar, krediet, wedstrijdStapel);
        spelerrepo.voegSpelerToe(nieuweSpeler); //roept methode voegSpelerToe aan uit SpelerRepository(waarin gecontroleerd wordt of naam al bestaat)

    }

    public String[] geefSpelersLijst() {

        String[] spelers = new String[spelerrepo.geefSpelersLijst().size()];
        int index = 0;
        for (Object speler : spelerrepo.geefSpelersLijst()) {
            spelers[index] = speler.toString();
            index++;
        }

        return spelers;

    }

    public Speler[] maakWedstrijd(int eersteKeuze, int tweedeKeuze) {

        List<Speler> alleSpelers = new ArrayList<>();
        alleSpelers = spelerrepo.geefSpelersLijst();

        spelers[0] = alleSpelers.get(eersteKeuze - 1);
        spelers[1] = alleSpelers.get(tweedeKeuze - 1);
        wedstrijd = new Wedstrijd(spelers[0], spelers[1]);

        return spelers;

    }

    public void MaakWedstrijdStapel() {

        Kaart[] gekozenKaarten = new Kaart[6];

        int keuze;

        for (int i = 0; i <= gekozenKaarten.length - 1; i++) {
            System.out.print("Kies een kaart: ");
            keuze = sc.nextInt();
            gekozenKaarten[i] = km.geefKaarten().get(keuze - 1);
            speler.setWedstrijdStapel(gekozenKaarten);
        }
        
        

        
        

    }

    public String[] toonKaarten() {

        String[] kaarten = new String[km.geefKaarten().size()];
        int index = 0;
        for (Object kaart : km.geefKaarten()) {
            kaarten[index] = kaart.toString();
            index++;
        }

        return kaarten;

    }

}
