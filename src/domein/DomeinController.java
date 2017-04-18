package domein;

import domein.Taal;
import java.util.ArrayList;
import java.util.List;


public class DomeinController {

    private SpelerRepository spelerrepo;
    private Wedstrijd wedstrijd;
    private Taal taal;
    
    

    public DomeinController() {
        spelerrepo = new SpelerRepository();
        wedstrijd = new Wedstrijd();
        
        
    }

    public void voegSpelerToe(String naam, int geboortejaar, int krediet) {

        Speler nieuweSpeler = new Speler(naam, geboortejaar, krediet);
        spelerrepo.voegSpelerToe(nieuweSpeler); //roept methode voegSpelerToe aan uit SpelerRepository(waarin gecontroleerd wordt of naam al bestaat)

    }

    public String[] geefSpelersLijst() {
        
        
        String[] spelers = new String[spelerrepo.geefSpelersLijst().size()];
        int index = 0;
        for(Object speler : spelerrepo.geefSpelersLijst()){
            spelers[index] = speler.toString();
            index++;
        }
        
        return spelers;


    }
    
    public Speler[] kies2Spelers(int eersteKeuze, int tweedeKeuze){
        
        Speler[] spelers = new Speler[2];
        List <Speler> alleSpelers = new ArrayList<>();
        alleSpelers = spelerrepo.geefSpelersLijst();
        
        
            spelers[0] = alleSpelers.get(eersteKeuze - 1);
            spelers[1] = alleSpelers.get(tweedeKeuze - 1);
        
        return spelers;
        
    }

    
}
