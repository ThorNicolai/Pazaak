package domein;

import domein.Taal;
import java.util.List;
import ui.PazaakApplicatie;

public class DomeinController {

    private SpelerRepository spelerrepo;
    private Wedstrijd wedstrijd;
    private Taal taal;

    public DomeinController() {
        spelerrepo = new SpelerRepository();
        wedstrijd = new Wedstrijd();
    }

    public void voegSpelerToe(String naam, int geboortejaar, int krediet){
        
        Speler nieuweSpeler = new Speler(naam,geboortejaar,krediet);
        spelerrepo.voegSpelerToe(nieuweSpeler); //roept methode voegSpelerToe aan uit SpelerRepository(waarin gecontroleerd wordt of naam al bestaat)
        
    }
    
    public List<Speler> geefSpelers() {

        return spelerrepo.geefSpelers();

    }
    
    

}
