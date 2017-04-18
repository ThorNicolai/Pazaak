package ui;

import domein.DomeinController;
import domein.Taal;
import java.util.Scanner;

public class ToonSpelerLijstApp {

    private final DomeinController dc;
    Taal taal = null;

    Scanner scan = new Scanner(System.in);

    public ToonSpelerLijstApp(DomeinController dc) {
        this.dc = dc;
    }

    public String toonSpelersLijst() {

        String overzicht = "";
        int teller = 1;
        for (String speler : dc.geefSpelersLijst()) {
            overzicht += String.format("%d) %s%n", teller, speler);
            teller++;
        }

        return overzicht;

    }

}
