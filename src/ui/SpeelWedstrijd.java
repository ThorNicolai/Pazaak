package ui;

import domein.DomeinController;
import domein.Kaart;

public class SpeelWedstrijd {
    
    private DomeinController dc;

    public SpeelWedstrijd(DomeinController dc) {
        this.dc = dc;
        
    }
    
    public void speel(){
        
        int aantalSetsSpeler1 = 0, aantalSetsSpeler2 = 0;
        int scoreSpeler1 = 0, scoreSpeler2 = 0;
        
        Kaart[][] speler1bord =  new Kaart[3][3];
        Kaart[][] speler2bord =  new Kaart[3][3];
        
    }
    
    
    
}
