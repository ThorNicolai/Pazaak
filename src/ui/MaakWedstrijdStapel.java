package ui;

import domein.DomeinController;
import java.util.Scanner;

public class MaakWedstrijdStapel {

    private final DomeinController dc;

    Scanner sc = new Scanner(System.in);

    public MaakWedstrijdStapel(DomeinController dc) {
        this.dc = dc;
    }

    public void maakWedstrijdStapelAan() {

        System.out.println("Kies 6 kaarten uit de stapel om te gebruiken in de wedstrijd!");
        int kaart1 = sc.nextInt();
        int kaart2 = sc.nextInt();
        int kaart3 = sc.nextInt();
        int kaart4 = sc.nextInt();
        int kaart5 = sc.nextInt();
        int kaart6 = sc.nextInt();
    }

}
