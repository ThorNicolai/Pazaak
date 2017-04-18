package ui;

import domein.DomeinController;
import domein.Speler;
import java.util.Scanner;

public class Kies2SpelersApp {
    
    private final DomeinController dc;
    Speler[] gekozen2Spelers = new Speler[2];

    public Kies2SpelersApp(DomeinController dc) {
        this.dc = dc;
    }
    
    public void kies2Spelers(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Kies 2 spelers om het spel mee te spelen!");
        
        int eersteKeuze = sc.nextInt();
        
        int tweedeKeuze = sc.nextInt();
        
        gekozen2Spelers = dc.kies2Spelers(eersteKeuze, tweedeKeuze);
        
        System.out.printf("speler 1 : %s%nspeler 2 : %s%n",gekozen2Spelers[0].toString(),gekozen2Spelers[1].toString());
        
        System.out.println("Bevestig de wedstrijd fucktard");
        System.out.printf("1) Ja%n2) Neen%n");
        int keuze = sc.nextInt();
        
        switch(keuze){
            case 1 : System.out.println("Bedankt! u kan verder!");break;
            case 2 : System.out.println("Oei, wilt u annuleren?");break;
            default: System.out.println("Er staat 1 of 2 stomme mongool, kunt gij ni lezen ofwa? geef een geldig nummer in!");
        }
        
        
        
        
    }
    
}
