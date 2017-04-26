package ui;

import domein.DomeinController;
import domein.Kaart;
import domein.Speler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public void maakWedstrijdStapelAan(String gekozenSpeler,Speler[]gekozen2Spelers) {
        
     dc.maakWedstrijdStapel(gekozenSpeler,gekozen2Spelers);
        
    }

    public String toonKaarten() {

        String overzicht = "";

        for (Kaart kaart : dc.geefKaarten()) {
            overzicht += String.format("%s%n", kaart.toString());
        }

        return overzicht;

    }
    
    public void maakWedstrijd(){
        
    }

}
