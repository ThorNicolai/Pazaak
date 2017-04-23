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

    Scanner sc = new Scanner(System.in);

    public MaakWedstrijdStapel(DomeinController dc) {
        this.dc = dc;
    }

    public void maakWedstrijdStapelAan() {

        List<Kaart> kaartenDB = new ArrayList<>();
        kaartenDB = km.geefKaarten();

        Kaart[] gekozenKaarten = new Kaart[6];

        int keuze;

        for (int i = 0; i < gekozenKaarten.length - 1; i++) {
            System.out.print("Kies een kaart: ");
            keuze = sc.nextInt();
            gekozenKaarten[i] = kaartenDB.get(keuze - 1);
        }

        speler.setWedstrijdStapel(gekozenKaarten);

    }

    public String toonKaarten() {

        String overzicht = "";

        for (String i : dc.toonKaarten()) {
            overzicht += String.format("%s%n", i);
        }

        return overzicht;

    }

}
