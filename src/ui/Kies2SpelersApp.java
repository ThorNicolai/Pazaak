package ui;

import domein.DomeinController;
import java.util.Scanner;

public class Kies2SpelersApp {
    
    private final DomeinController dc;

    public Kies2SpelersApp(DomeinController dc) {
        this.dc = dc;
    }
    
    public void kies2Spelers(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Kies 2 spelers om het spel mee te spelen!");
        
        int eersteKeuze = sc.nextInt();
        
        int tweedeKeuze = sc.nextInt();
        
        dc.kies2Spelers(eersteKeuze, tweedeKeuze);
    }
    
}
