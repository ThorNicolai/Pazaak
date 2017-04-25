package ui;

import domein.DomeinController;
import domein.Kaart;
import domein.Speler;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import persistentie.KaartMapper;

public class MaakWedstrijdStapel {

    private final DomeinController dc;
    private Speler speler;
    private KaartMapper km;
    private List<Kaart> kaarten;

    Scanner sc = new Scanner(System.in);

    public MaakWedstrijdStapel(DomeinController dc) {
        this.dc = dc;
    }

    public void maakWedstrijdStapelAan(int gekozenSpeler) {
        
        dc.maakWedstrijdStapel(gekozenSpeler);
    }

    public String toonKaarten() {

        String overzicht = "";

        for (String i : dc.toonKaarten()) {
            overzicht += String.format("%s%n", i);
        }

        return overzicht;

    }

}
